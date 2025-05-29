/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gcj.b;

import java.util.Scanner;

/**
 *
 * @author S_Malindi
 */
public class B {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        
        int T = in.nextInt();

        for (int z = 1; z <= T; z++) {

            int N = in.nextInt();
            int S = in.nextInt();
            int P = in.nextInt();

            int t = 0;
            int ans = 0;
            int mscore = (P * 3);

            for (int i = 1; i <= N; i++) {
               
                t = in.nextInt();

                if (t >= (mscore - 2)) {

                    ans++;

                } else if (t >= (mscore - 4)) {
                    if ((S > 0 )&& ( t > 0) ) {

                        S--;
                        ans++;
                    }

                }

            }

            System.out.format("Case #%d: %d\n", z, ans);

        }

    }
}
