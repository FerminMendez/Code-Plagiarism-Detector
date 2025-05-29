/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 *
 * @author parusnik
 */
public class Codejam {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        for (int t = 1; t<=T; t++){
            bw.write("Case #" + String.valueOf(t) + ": ");
            st = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            
            int k = 0;
            int d = 0;
            
            for (int i = 0; i<n; i++){
                int a = Integer.parseInt(st.nextToken());
                a-=p;
                if (a>=0){
                    a/=2;
                    if (a==p-2) k++;
                    else if (a>p-2) d++;
                }
            }
            
            d += Math.min(k, s);
            bw.write(String.valueOf(d));
            
            bw.newLine();
        }
        
        br.close();
        bw.close();
    }
    
}
