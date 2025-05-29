/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qualb;

import java.util.Scanner;

/**
 *
 * @author marcin
 */
public class QualB {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = Integer.parseInt(in.nextLine());
        for (int ci = 1; ci <= T; ++ci) {
            int N = in.nextInt();
            int S = in.nextInt();
            int p = in.nextInt();
            int certains = 0;
            int possibles = 0;
            for (int i = 0; i < N; ++i) {
                int total = in.nextInt();
                int temp = total - (3 * p);
                if (temp >= 0) {
                    ++certains;
                }
                else {
                    if ((p - 1 >= 0) && (temp >= -2)) {
                        ++certains;
                    }
                    else if ((p - 2 >= 0) && (temp >= -4)) {
                        ++possibles;
                    }
                }
            }
            int optional = S > possibles ? possibles : S;
            int answer = certains + optional;
            System.out.println("Case #" + ci + ": " + answer);
        }
    }
}
