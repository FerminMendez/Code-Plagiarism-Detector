package numbers;

import java.util.*;
import java.io.*;

public class Numbers {
     public static void main(String[] args) throws Exception {
       Scanner br = new Scanner(new FileReader("C-small-attempt0.in"));
       BufferedWriter bw = new BufferedWriter(new FileWriter("out.txt"));
       
       int T = br.nextInt();
       
       for(int t = 1; t<=T; t++){
           int A = br.nextInt();
           int B = br.nextInt();
           
           int sum = 0;
           for(int i = A; i < B; i++){
                 sum += pcount(i, B);
           }
           bw.write("Case #"+t+": "+sum);
           bw.newLine();
       }
                
       br.close();
       bw.close();
    }
     
    private static int pcount(int n, int max){
        if(n<10) return 0;
        
        int sum = 0;
        String r = rev(Integer.toString(n));
        String sn = Integer.toString(n);
        
        while(!r.equals(sn)){
            int ir = Integer.parseInt(r);
            if(ir>n && ir<=max){
                sum++;
            }
            r = rev(r);
        }
        return sum;
    }
    
    private static String rev(String n){
        if(n.length()<2) return n;

        StringBuilder sb = new StringBuilder();
        sb.append(n.charAt(n.length()-1));
        for(int i = 0; i< n.length()-1; i++){
            sb.append(n.charAt(i));
        }        

        return sb.toString();
    } 
}
