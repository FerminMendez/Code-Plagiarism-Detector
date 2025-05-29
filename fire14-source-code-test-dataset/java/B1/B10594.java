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
import java.util.HashSet;
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
        String s;
        
        for (int t = 1; t<=T; t++){
            
            bw.write("Case #" + String.valueOf(t) + ": ");
            
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            long d = 0;
            
            for (int i = a; i<=b; i++)
                for (int j = i+1; j<=b; j++){
                    String s1 = String.valueOf(i);
                    String s2 = String.valueOf(j);
                    
                    
                    for (int k = 0; k<10; k++){
                        if (s1.equals(s2)) {d++; break;}
                        s2 = s2.substring(1, s2.length()) + s2.substring(0, 1);
                    }
                }
            
            bw.write(String.valueOf(d));
            
            bw.newLine();
        }
        
        br.close();
        bw.close();
    }
}
