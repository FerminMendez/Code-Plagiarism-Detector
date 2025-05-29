/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qualc;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author marcin
 */
public class QualC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int ci = 1; ci <= T; ++ci) {
            int A = in.nextInt();
            int B = in.nextInt();
            int result = 0;
            int len =  Integer.toString(A).length();
            char[] arrB = new char[len];
            Set<Integer> prevShift = new HashSet<Integer>();
            for (int n = A; n < B; ++n) {
                String strN = Integer.toString(n);
                for (int i = 1; i < len; ++i) {
                    if (strN.charAt(i) != '0') {
                        strN.getChars(i, len, arrB, 0);
                        strN.getChars(0, i, arrB, len-i);
                        int m = Integer.parseInt(new String(arrB));
                        if ((m <= B) && (m > n) && !prevShift.contains(m)) {
                            prevShift.add(m);
                            ++result;
                        }
                    }
                }
                prevShift.clear();
            }
            System.out.println("Case #" + ci + ": " + result);
        }
    }
}
