/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jam2;

import java.util.Scanner;

/**
 *
 * @author clary35
 */
public class Jam2 {

    Jam2() {

        int[] totals = new int[10000];

        System.out.println("Input:");
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        for (int i = 0; i < cases; i++) {
            // Read case data
            int N = scan.nextInt();
            int S = scan.nextInt();
            int p = scan.nextInt();
            for (int k = 0; k < N; k++) {
                int temp = scan.nextInt();
                totals[k] = temp;
            }

            // Process case
            int overs = 0;
            for (int k = 0; k < N; k++) {
                int themant = (int) Math.floor(totals[k] / 3);
                double thefrac = totals[k] / 3.0 - themant;
//                System.out.println("Mant: " + themant);
//                System.out.println("Frac: " + thefrac);
                if(p == 0 && totals[k] == 0){
                    overs++;
                }
                if (totals[k] > 0.9999999) {
                    if (thefrac < 0.000000001) {
                        if (themant >= (p)) {
                            overs++;
                        } else {
                            if (themant >= (p - 1) && S > 0) {
                                overs++;
                                S = S - 1;
                            }
                        }
                    } else {
                        // Inte heltalsmedel
                        if (thefrac * 3 > 1.99999999) {
                            // Increase one without special, increase two with special
                            if (themant >= p) {
                                overs++;
                            } else {
                                if (themant >= (p - 1)) {
                                    overs++;
                                } else {
                                    if (themant >= (p - 2) && S > 0) {
                                        overs++;
                                        S = S - 1;
                                    }
                                }
                            }
                        } else {
                            // Increase with with special only
                            if (themant >= p) {
                                overs++;
                            } else {
                                if (themant >= (p - 1)) {
                                    overs++;
                                }
                            }
                        }
                    }
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + overs);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Jam2 jm = new Jam2();
    }
}
