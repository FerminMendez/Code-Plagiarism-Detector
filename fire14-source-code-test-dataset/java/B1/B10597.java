/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codejam;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 *
 * @author cristian
 */
public class CodeJam {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        StringBuffer sb;
        Boolean firstLine = true;

        try {
            // Open the file that is the first 
            // command line parameter
            FileInputStream fstream = new FileInputStream("/tmp/problemB.txt");
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            //Read File Line By Line
            int line = 1;
            while ((strLine = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                sb = new StringBuffer();
                // Print the content on the console
                int A = Integer.parseInt(strLine.split(" ")[0]);
                int B = Integer.parseInt(strLine.split(" ")[1]);
                int n = A;
                int m;
                int recycled = 0;
                while (n < B) {
                    recycled += moveLast(n, B);
                    n++;
                }

                System.out.println("Case #" + line + ": " + recycled);
                line++;
            }
            //Close the input stream
            in.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    private static int moveLast(int n, int B) {
        int recycled = 0;
        int tmpN = n;
        int m;

        StringBuffer sb;

        for (int i = 0; i < (n + "").length() - 1; i++) {
            sb = new StringBuffer();
            sb.append((tmpN + "").charAt((tmpN + "").length() - 1));
            if ((tmpN + "").length() < (n + "").length()) {
                sb.append("0");
            }
            sb.append((tmpN + "").substring(0, (tmpN + "").length() - 1));

            m = Integer.parseInt(sb.toString());

            //A ≤ n < m ≤ B
            if ((n < m) && (m <= B)) {
                recycled++;
            }
            tmpN = m;

        }

        return recycled;
    }
}

