/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codejam;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author Ostap
 */
public class CodeJam {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

       
       BufferedReader bf = new BufferedReader(new FileReader("B-small-attempt0.in"));
       int n = Integer.parseInt(bf.readLine());
       PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));
       
       for (int i = 0;i < n;i++){
           int count = 0;
           int uses = 0;
           String[] s = bf.readLine().split(" ");
           int N = Integer.parseInt(s[0]);
           int S = Integer.parseInt(s[1]);
           int p = Integer.parseInt(s[2]);
           
           for (int j = 0; j < N; j++) {
               int v = Integer.parseInt(s[j+3]);
               
               int a[] = new int[3];
               
               for (int k = 0; k < 2; k++) {
                   a[k] = v/(3-k);
                   v-=a[k];
               }
               
               a[2] = v;
               
               Arrays.sort(a);
               
               if (a[2] >= p){
                   count++;
                   continue;
               }
               
               if (uses < S){
                   if (a[2] == a[1] && a[1] !=0)
                       if (a[2]+1 >= p){
                           count++;
                           uses++;
                       }
                   
               }

               }
           
           pw.println("Case #"+(i+1)+": "+count);
           }
           
       
       
       pw.flush();;
       pw.close();
       
       
    }
}
