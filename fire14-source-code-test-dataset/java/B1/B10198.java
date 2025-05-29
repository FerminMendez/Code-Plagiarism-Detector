/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Scanner;

/**
 *
 * @author yondaime
 */
public class JavaApplication3 {

    static int A = 1111;
    static int B = 2222;

    public static int[] permute(int n) {

        String chaine = n + "";
        int tailleChaine = chaine.length();
        int nombre;
        String g = "";
        for (int i = 0; i < tailleChaine; i++) {
            g += "1";
        }
        nombre = Integer.parseInt(g);
        if (chaine.length() < 1 || n % nombre == 0) {
            int[] t = new int[1];
            t[0] = n;
            return t;
        }
        int table[] = new int[10];

        for (int i = 0; i < tailleChaine - 1; i++) {
            String t = "";
            t = chaine.substring(i + 1);
            t += chaine.substring(0, i + 1);
            int m = Integer.parseInt(t);
            if (m > n && n >= A && m <= B) {
                table[i] = m;
//                System.out.println(table[i]);
            }
        }

//        System.out.println("end");
//
        int m = Integer.parseInt(chaine);

        return table;
    }
    static int count;

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("C-small-attempt1.in"));
        PrintWriter out = new PrintWriter(new File("C-small-attempt1.out"));
        sc.next();
        int kl=0;
        while (sc.hasNext()) {
            
            A = sc.nextInt();
            B = sc.nextInt();
            out.print("Case #"+(++kl)+":");
//            out.print(" "+B);
            for (int n = A; n < B; n++) {
                int mm[] = permute(n);
                for (int k = 0; k < mm.length; k++) {
                    int m = mm[k];
                    // n doit etre < à m
                    //n doit etre > à A et m doit etre inferieur à B
                    // A <= n < m <= B
                    if (n >= m || A > n || m > B) {
                        continue;
                    }
                    count++;
//                    out.print("n = " + n + " m = " + m);
                }


            }
            out.println(" " + count);
            count=0;

        }
        out.close();
        sc.close();
    }
}
