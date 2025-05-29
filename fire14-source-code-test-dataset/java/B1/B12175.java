/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codejam;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Aymen
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        int[] v = new int[1000];
        String outputFile = System.getenv("USERPROFILE") + "\\Documents\\C-small.out";
        String inputFile = System.getenv("USERPROFILE") + "\\Documents\\C-small.in";
        //String outputFile = System.getenv("USERPROFILE") + "\\Documents\\output.txt";
        //String inputFile = System.getenv("USERPROFILE") + "\\Documents\\input.txt";

        BufferedWriter os = new BufferedWriter(new FileWriter(outputFile));
        DataInputStream is = new DataInputStream(new FileInputStream(inputFile));

        int T = Integer.valueOf(is.readLine());

        System.out.println("T " + T);

        for (int i = 0; i < T; i++) {
            String list = is.readLine();
            list += " ";
            int l = list.substring(0, list.indexOf(" ")).length();
            int A = Integer.valueOf(list.substring(0, list.indexOf(" ")));
            list = list.substring(list.indexOf(" ") + 1);
            int B = Integer.valueOf(list.substring(0, list.indexOf(" ")));
            list = list.substring(list.indexOf(" ") + 1);

            boolean exist = false;
            int num, result = 0;
            String numString, numRotate;
            v[0] = 0;
            for (int j = A; j <= B; j++) {
                num = j;
                for (int n = 0; n < result; n++) {
                    if (num == v[n]) {                                                
                    }
                }
                numString = String.valueOf(num);
                numRotate = numString;
                numRotate = numRotate.substring(l - 1) + numRotate.substring(0, l - 1);
                num = Integer.valueOf(numRotate);
                while (numRotate.substring(0, 1).equals("0")) {
                    numRotate = numRotate.substring(l - 1) + numRotate.substring(0, l - 1);
                }
                num = Integer.valueOf(numRotate);
                while ((num < A) || (num > B)) {
                    numRotate = numRotate.substring(l - 1) + numRotate.substring(0, l - 1);
                    num = Integer.valueOf(numRotate);
                }

                while (num != j) {
                    if ((!exist) && (num != j)) {
                        for (int m = j + 1; m <= B; m++) {                            
                            if (m == num) {
                                v[result] = m;
                                result++;
                            }
                        }
                    }                    
                    numRotate = numRotate.substring(l - 1) + numRotate.substring(0, l - 1);
                    num = Integer.valueOf(numRotate);
                    while (numRotate.substring(0, 1).equals("0")) {
                        numRotate = numRotate.substring(l - 1) + numRotate.substring(0, l - 1);
                    }
                    num = Integer.valueOf(numRotate);
                    while ((num < A) || (num > B)) {
                        numRotate = numRotate.substring(l - 1) + numRotate.substring(0, l - 1);
                        num = Integer.valueOf(numRotate);
                    }
                    
                }
            }

            int m = i + 1;
            os.write("Case #" + m + ": " + result);
            os.newLine();
        }
        is.close();
        os.close();
    }
}
