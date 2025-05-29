/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jam3;

import java.util.Scanner;

/**
 *
 * @author clary35
 */
public class Jam3 {

    Jam3() {
        System.out.println("Input:");
        Scanner scan = new Scanner(System.in);
        String T = scan.nextLine();
        int cases = Integer.parseInt(T);
        for (int i = 0; i < cases; i++) {
            int A = scan.nextInt();
            int B = scan.nextInt();
            int recycled = 0;
            for (int n = A; n < B; n++) {
                for (int m = n + 1; m <= B; m++) {
                    boolean flag = false;
                    String nstr = Integer.toString(n);
                    String mstr = Integer.toString(m);
 //                   System.out.println("start: "+nstr+" "+mstr);
                    int len = nstr.length();
                    char[] mstrArr = mstr.toCharArray();
                    for (int j = 0; j < (len - 1); j++) {
                        char tmp = mstrArr[len - 1];
                        // one rotation
                        for (int k = (len - 1); k > 0; k--) {
                            mstrArr[k] = mstrArr[k - 1];
                        }
                        mstrArr[0] = tmp;
                        String s = new String(mstrArr);
//                        System.out.print(s + ", ");
                        if (s.equals(nstr)) {
                            flag = true;
//                            System.out.println(recycled+" "+nstr + " " + mstr + " "+s+" "+len);
//                            System.out.println("");
                        }
                    }
//                    System.out.println("");
                    if (flag == true) {
                        recycled++;
                    }
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + recycled);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Jam3 jm = new Jam3();
    }
}
