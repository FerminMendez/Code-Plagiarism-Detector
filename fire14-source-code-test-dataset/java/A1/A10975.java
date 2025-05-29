/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package codejam.B2012;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class B2012 {
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("C:/docs/codejam/2012/B-small-attempt7.in"));
        PrintWriter output = new PrintWriter(new File("C:/docs/codejam/2012/___B_small_out_7.txt"));
        
        int T = scanner.nextInt();
        for (int i = 1; i < T + 1; i++) {
            int N = scanner.nextInt();
            int S = scanner.nextInt();
            int p = scanner.nextInt();
            
            System.out.println("N = " + N + " | S = " + S + " | p = " + p);
            
            int c = 0;
            int mp = 3 * p - 2;
            int smp = 3 * p - 4;
            for (int j = 0; j < N; j++) {
                int tp = scanner.nextInt();
                System.out.print(tp + " ");
                if (tp >= mp) {
                    c++;
                } else if (tp >= smp && S > 0 && smp >= 0) {
                    c++;
                    S--;
                }
            }
            System.out.println();
            System.out.println("c = " + c);
            System.out.println("--------------");
            output.println("Case #" + i + ": " + c);
        }
        
        scanner.close();
        output.close();
    }

}
