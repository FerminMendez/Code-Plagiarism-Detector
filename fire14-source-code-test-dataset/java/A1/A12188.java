/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dancingwiththegooglers;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 *
 * @author Кирилл и Папа
 */
public class DancingWithTheGooglers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.in")));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output.txt")));
            int numOfTestCases = Integer.parseInt(br.readLine());
            for (int testCaseI = 0; testCaseI < numOfTestCases; testCaseI++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                int[] t = new int[n];
                for (int i = 0; i < n; i++) {
                    t[i] = Integer.parseInt(st.nextToken());
                }
                int res = 0;
                int availableSurp = s;
                for (int i = 0; i < t.length; i++) {
                    int bestRes = (t[i] + 2) / 3;
                    if ((bestRes < p) && (availableSurp > 0) && (t[i] >= 2)) {
                        int r = (t[i] + 4) / 3;
                        if (r >= p) {
                            bestRes = r;
                            availableSurp--;
                        }
                    }
                    res += ((bestRes >= p) ? 1 : 0);
                }
                bw.write("Case #" + (testCaseI + 1) + ": " + res);
                bw.newLine();
            }
            br.close();
            bw.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
