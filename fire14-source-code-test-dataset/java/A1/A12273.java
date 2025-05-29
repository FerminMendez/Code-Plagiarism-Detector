/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Dancing
 * Jason Bradley Nel
 * 16287398
 */
import java.io.*;

public class Dancing {

    public static void main(String[] args) {

        In input = new In("input.txt");
        int T = Integer.parseInt(input.readLine());

        for (int i = 0; i < T; i++) {
            System.out.printf("Case #%d: ", i + 1);
            int N = input.readInt();
            int s = input.readInt();
            int p = input.readInt();
            int c = 0;//counter for >=p cases
            //System.out.printf("N: %d, S: %d, P: %d, R: ", N, s, p);
            
            for (int j = 0; j < N; j++) {
                
                int score = input.readInt();
                int q = score / 3;
                int m = score % 3;
                //System.out.printf("%2d (%d, %d) ", scores[j], q, m);
                                
                switch (m) {
                    case 0:
                        if (q >= p) {
                            c++;
                        } else if (((q + 1) == p) && (s > 0) && (q != 0)) {
                            c++;
                            s--;
                        }
                        break;
                    case 1:
                        if (q >= p) {
                            c++;
                        } else if ((q + 1) == p) {
                            c++;
                        }
                        break;
                    case 2:
                        if (q >= p) {
                            c++;
                        } else if ((q + 1) == p) {
                            c++;
                        } else if (((q + 2) == p) && (s > 0)) {
                            c++;
                            s--;
                        }
                        break;
                }
            }
            //System.out.printf("Best result of %d or higher: ", p);
            System.out.println(c);
        }


    }
}
