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
public class RecycledNumbers {

    public void solve() {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int i = 0, j = 0, k = 0;
        int count = 0;
        int A = 0, B = 0, n = 0, m = 0, a = 0, b = 0;//A ≤ n < m ≤ B
        String nn = "";
        String mm = "";
        while (i < T) {
            // System.out.println("a");
            n = A = sc.nextInt();
            m = B = sc.nextInt();
            count = 0;

            while (n <= B) {
               // System.out.println("a");
                while (m >= A && m > n) {
                  //  System.out.println("b");
                    nn = String.valueOf(n);
                    mm = "[" + String.valueOf(m) + "]";
                   // System.out.println("nn == : " + nn + "  mm == : " + mm);
                    if (nn.length()==(mm.length()-2) && nn.replaceAll(mm, "").equals("")    ) {
                     //   System.out.println("ccc");
                        if (isCorrect(n, m)) {
                            count++;
                        }
                    }

                    --m;
                }
                m = B;
                ++n;
            }
            System.out.println("Case #"+(i+1)+": " + count);

            ++i;
        }

    }
    // length n == lengt m

    public boolean isCorrect(int n, int m) {

        String nn = String.valueOf(n);
        String mm = String.valueOf(m);
        int len = nn.length();
        int i = 0;
        if (nn.equals(mm) && len > 1) {
            return true;
        } else {
            i = 1;
            while (i < len) {

                if (nn.charAt(i) == mm.charAt(0) && nn.charAt(i - 1) == mm.charAt(len - 1)) {
                    String tem = nn.substring(i, len) + nn.substring(0, i);
                    if (tem.equals(mm)) {
                        return true;
                    }
                }
                ++i;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        new RecycledNumbers().solve();


        /*
         * String s = "12345"; String tem = s.substring(2, s.length()) +
         * s.substring(0, 2); System.out.println(tem); String a = "21345";
         * String ss = "[" + a + "]"; //String e = s.replaceAll(ss, "");
         * //System.out.println("e is = " + e);
         *
         * if(s.replaceAll(ss, "").equals("")){
         * System.out.println("aaaaaaaaaaaaaa"); }else{
         * System.out.println("bbbbbbbbbbbbb"); }
         */
    }
}
