/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package example2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class recycle{

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nocases = Integer.parseInt(br.readLine());
        long ans[] = new long[nocases];
        for (int i = 0; i < nocases; i++) {
            String token[] = br.readLine().split(" ");
            long A = Integer.parseInt(token[0]);
            long B = Integer.parseInt(token[1]);
            ans[i] = method(A, B);
        }
        for (int i = 0; i < nocases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + ans[i]);
        }
    }

    private static int circularshift(char[] c, long n, long B) {
        int i = 0;
        long m = 0, m1 = 0;
        int ct = 0;
        int len = c.length;
        for (int k = 0; k < len; k++) {
            char temp = c[0];
            for (i = 1; i < len; i++) {
                c[i - 1] = c[i];
            }
            c[i - 1] = temp;
            String s = String.valueOf(c);
            m = Integer.parseInt(s);
            if (m <= B) {
                if (m1 != m) {
                    if (n < m) {
                        ct++;
                        m1 = m;
                    }
                }
            }
        }
        return ct;
    }

    private static long method(long A, long B) {
        long count = 0;
        for (long i = A; i <= B; i++) {
            long n = i;
            int ct = 0;
            String s = String.valueOf(n);
            char c1[] = s.toCharArray();
            ct = circularshift(c1, n, B);
            count = count + (long) ct;
        }
        return count;
    }
}
