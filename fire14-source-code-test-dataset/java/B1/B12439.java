
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eunice
 */
public class Recycled_Numbers {

    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out;

    public static void main(String[] args) {

        try {
             out = new PrintWriter(new FileWriter("C:\\Users\\Eunice\\Desktop\\Code Jam\\CodeJam Outputs\\Recycled_Numbers.txt" ));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        int noTestCases = scanner.nextInt();
        for(int i = 0; i < noTestCases; i++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            int noRecycledPairs = 0;
            String valueOfA = String.valueOf(A);
            String valueOfB = String.valueOf(B);
            int noDigits = valueOfA.length();
            int[] possible = new int[(B - (A - 1))];
            for(int j = 0; j < (B - (A - 1)); j++) {
                possible[j] = A + j;
            }
            int n = 0;
            int m = 0;
            String valueOfn;
            String valueOfm;
            for(int l = 0; l < possible.length; l++) {
                n = possible[l];
                valueOfn = String.valueOf(n);
                for(int k = 0; k < possible.length; k++) {
                    m = possible[k];
                    valueOfm = String.valueOf(m);
                    if(k != l) {
                        if((A <= n) && (n < m) && (m <= B)) {
                            String s = valueOfn;
                            for(int p = 0; p < noDigits; p++) {
                                
                                s = s.charAt(s.length() - 1) + s.substring(0, (s.length() - 1));
                                if(s.equals(valueOfm)) {
                                    noRecycledPairs++;
                                    p = noDigits;
                                }
                            }
                        }
                    }
                }
            }
            
            System.out.println("Case #" + (i + 1) + ": " + noRecycledPairs);
//            out.close();
        }
    }
}
