/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codejam;

import java.io.*;
import java.util.*;

/**
 *
 * @author jgao
 */
public class CodeJam {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String file = "B-small-attempt1.in";
        List<String> input;
        try {
            input = readFile(file);
        } catch(Exception e) {
            return;
        }
        
        for (int i=1; i<input.size(); i++) {
            System.out.print("Case #"+i+": ");
            
            String[] strs = input.get(i).split(" ");
            int N = Integer.parseInt(strs[0]);
            int S = Integer.parseInt(strs[1]);
            int p = Integer.parseInt(strs[2]);
            
            if (p==0) {
                System.out.println(N);
                continue;
            }
            
            int[] scores = new int[N];
            for (int j=0; j<N; j++) {
                scores[j] = Integer.parseInt(strs[j+3]);
            }
            
            int go=0, sgo=0;
            int thgo=p*3-2, thsgo=thgo-2;
          
            for (int score : scores) {
                if (score>=thgo) {
                    go++;
                } else if (score>=thsgo) {
                    sgo++;
                }
            }
            
            System.out.println(go+(p==1?0:Math.min(sgo,S)));
        }
    }
    
    public static List<String> readFile(String file) throws Exception {
        List<String> content = new ArrayList<String>();
        BufferedReader in = new BufferedReader(new FileReader(file));
        for (String line=in.readLine(); line!=null; line=in.readLine()) {
            content.add(line);
        }
        in.close();
        return content;
    }
}
