package dancing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Dance {
    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new FileReader("B-small-attempt0.in"));
       BufferedWriter bw = new BufferedWriter(new FileWriter("out.txt"));
       
       int T = Integer.parseInt(br.readLine().trim());
       
       for(int t = 1; t<=T; t++){
           String[] s = br.readLine().trim().split(" ");
           int N = Integer.parseInt(s[0]);
           int S = Integer.parseInt(s[1]);
           int P = Integer.parseInt(s[2]);
           int[] ps = new int[N];
           for(int i = 3; i < s.length; i++){
               ps[i-3] = Integer.parseInt(s[i]);
           }
           List<Integer[]> l = new ArrayList<Integer[]>();
           int res = 0;
           for(int p : ps){
               if(p == 0){
                   l.add(new Integer[]{0, 0, 0});
                   continue;
               }
               if(p%3 == 0){
                   if(p/3 >= P || p/3<=(P-2) || S<=0){
                        l.add(new Integer[]{p/3, p/3, p/3});
                   }else{
                       l.add(new Integer[]{p/3, p/3-1, p/3+1});
                       S--;
                   }
               }else if(p%3 == 1){
                   l.add(new Integer[]{p/3, p/3, p/3+1});
               }else{
                   if(p/3 == 9){
                       l.add(new Integer[]{p/3+1, p/3+1, p/3});
                   }else{
                       if(p/3 >= P || p/3<(P-2)){
                           l.add(new Integer[]{p/3+1, p/3+1, p/3});
                       }else{
                           if (S<=0){
                              l.add(new Integer[]{p/3+1, p/3+1, p/3});
                           }else{
                              l.add(new Integer[]{p/3, p/3, p/3+2});
                              S--;
                           }
                       }
                   }
               }
           }
//           
//           for(Integer[] arr: l) System.out.println(Arrays.toString(arr));
//           System.out.println("");
           
           for(Integer[] arr: l){
               if(arr[0]>=P || arr[1]>=P || arr[2]>=P){
                   res++;
               }
           }
           bw.write("Case #"+t+": "+res);
           bw.newLine();
       }
       
       br.close();
       bw.close();
    }
}
