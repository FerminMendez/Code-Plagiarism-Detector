/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recyclednumbers;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 *
 * @author Кирилл и Папа
 */
public class RecycledNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.in")));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output.txt")));
            int n = Integer.parseInt(br.readLine());
            for (int testCaseI = 0; testCaseI < n; testCaseI++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String aStr = st.nextToken();
                String bStr = st.nextToken();
                int a = Integer.parseInt(aStr);
                int b = Integer.parseInt(bStr);
                int res = 0;
                for (int currA = a; currA <= b; currA++) {
                    String currAStr = Integer.toString(currA);
                    HashSet<String> hashRes = new HashSet<String>();
                    for (int p = 1; p < aStr.length(); p++) {
                        String moved = currAStr.substring(p) + currAStr.substring(0, p);
                        if ((moved.compareTo(bStr) <= 0) && (moved.compareTo(currAStr) > 0)) {
                            hashRes.add(moved);
                        }
                    }
                    res += hashRes.size();
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
