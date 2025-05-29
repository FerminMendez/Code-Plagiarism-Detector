/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package googlecodejam;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 *
 * @author massimo
 */
public class ProblemC {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader in = new BufferedReader(new FileReader("in.in"));
        PrintWriter out = new PrintWriter("out.out");
        int t = Integer.parseInt(in.readLine());
        for (int i = 1; i <= t; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());            
            HashSet<String> res=new HashSet<String>();
            for (int j=a; j<=b; j++) {                
                String s=Integer.toString(j);
                for (int k=0; k<s.length()-1; k++) {
                    s=s.charAt(s.length()-1)+s.substring(0, s.length()-1);
                    if (s.charAt(0)!='0') {
                        int j2=Integer.parseInt(s);
                        if (j2<=b && j2>=a && j!=j2) {
                            if (j<j2) {
                                if (res.add(j+","+j2)) {
                                }
                            } else {
                                res.add(j2+","+j);
                            }
                        }
                    }
                }                
            }
            out.println("Case #"+i+": "+res.size());
        }
        out.close();
    }
}
