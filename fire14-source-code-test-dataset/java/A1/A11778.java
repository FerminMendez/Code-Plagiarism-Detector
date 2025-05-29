/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Competitiopn;

import java.util.Scanner;

/**
 *
 * @author vidz
 */
public class DancingWithTheGooglers {

    public void solve() {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int i = 0, j = 0;
        int N = 0;//number of googlers
        int S = 0, s = 0;//suprise
        int p = 0;//limit to pass
        int count = 0;
        while (i < T) {
            N = sc.nextInt();
            s = S = sc.nextInt();
            p = sc.nextInt();
            j = 0;
            count = 0;
            while (j < N) {
                int temp = sc.nextInt();


                if (temp >= (3 * p - 2) ) {
                    count++;
                } else if (temp == (3 * p - 3) && s > 0 && (3 * p - 3) > 0) {
                    count++;
                    s--;
                } else if (temp == (3 * p - 4) && s > 0 && (3 * p - 4) > 0) {
                    count++;
                    s--;
                }


                ++j;
            }

            System.out.println("Case #" + (i + 1) + ": " + count);

            ++i;
        }


    }

    public static void main(String[] args) {
        new DancingWithTheGooglers().solve();
    }
}
