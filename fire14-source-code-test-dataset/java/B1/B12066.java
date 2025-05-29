package codeJam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Iterator;

/**
 * http://code.google.com/codejam/contest/1460488/dashboard#s=p2
 * @author Weiwei Cheng
 */
public class RecycledNumbers {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("_input.in"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("_output.in"));
        
        br.readLine();
        
        String line = null;
        int count = 0;
        
        while((line=br.readLine())!=null){
            int num = 0;
            String[] input = line.split(" ");
            int low = Integer.parseInt(input[0]);
            int high = Integer.parseInt(input[1]);
            
            for(int i=low; i<high; i++){
                int[] recnums = getRecycledNumbers(i);
                for(int j : recnums){
                    if(j<=high && j>=low && j>i){
                        num++;
                    }
                }
            }
            
            bw.append("Case #" + ++count + ": " + num);
            bw.newLine();
        }
        
        br.close();
        bw.close();

    }

    public static int[] getRecycledNumbers(int num){
        
        String str = Integer.toString(num);
        
        HashSet<Integer> set = new HashSet<Integer>();
        
        for(int i=0; i<str.length()-1; i++){
            int j = num / (int)(Math.pow(10, i+1));
            String s = str.subSequence(str.length()-i-1, str.length()) + "" + j;
            set.add(Integer.parseInt(s));
        }
        
        int[] ans = new int[set.size()];
        
        Iterator<Integer> itr = set.iterator();
        int i=0;
        while(itr.hasNext()){
            ans[i++] = itr.next();
        }
        
        return ans;
    }
    
}
