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
import java.util.StringTokenizer;

/**
 *
 * @author massimo
 */
public class ProblemB {

    //It can be proven that b=min{10,2+floor((totalPoints-2)/3)),totalPoints} if the best possibile result.
    //The triple must be surprising iff totalPoints<=3*(b-1).
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader in = new BufferedReader(new FileReader("in.in"));
        PrintWriter out = new PrintWriter("out.out");
        int t = Integer.parseInt(in.readLine());
        for (int i = 1; i <= t; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int res = 0, surprising = 0;
            for (int j = 0; j < n; j++) {
                int totalPoints = Integer.parseInt(st.nextToken());
                int b = Math.min(Math.min(totalPoints, 10), 2 + (totalPoints - 2) / 3);
                if (b > p) {
                    res++;
                } else if (b == p) {
                    if (totalPoints>3*(b-1)) {
                        res++;
                    } else if (surprising<s) {
                        res++;
                        surprising++;
                    }
                }
            }
            out.println("Case #"+i+": "+res);
        }
        out.close();
    }
}
