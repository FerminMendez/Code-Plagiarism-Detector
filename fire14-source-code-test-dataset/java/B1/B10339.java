/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ex3;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Jean-Nicolas
 */
public class Ex3 {

    public static String readFile(File file) {

        String result = "";
        try {
            InputStream ips = new FileInputStream(file);
            InputStreamReader ipsr = new InputStreamReader(ips);
            BufferedReader br = new BufferedReader(ipsr);
            String line;
            while ((line = br.readLine()) != null) {
                result += line + "\n";
            }
            br.close();
            result.substring(0, Math.max(0, result.length() - 1)); // Deletion of the last \n
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return result;
    }

    public static void writeFile(File file, String data) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(file));
            out.write(data);
            out.close();
        } catch (IOException ex) {
            System.out.println("Exception ");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here


        String data = readFile(new File("data.txt"));
        String[] lines = data.split("\n");
        String resultStr = "";

        ArrayList<Integer> results = new ArrayList<>();

        for (int i = 1; i < lines.length; i++) {
            String[] values = lines[i].split(" ");

            int A = Integer.parseInt(values[0]);
            int B = Integer.parseInt(values[1]);

            HashMap<Pair, Boolean> alreadyUsed = new HashMap<>();


            for (int n = A; n <= B; n++) {
                String nStr = String.valueOf(n);

                for (int j = 0; j < nStr.length(); j++) {
                    String nStr2 = nStr.substring(j) + nStr.substring(0, j);
                    int m = Integer.parseInt(nStr2);

                    Pair pair = new Pair(n, m);
                    
                    if (alreadyUsed.get(pair) == null && (A <= n && n < m && m <= B)) {
                        alreadyUsed.put(pair, true);
                    }
                }

            }

            resultStr += "Case #" + i + ": " + alreadyUsed.size() + "\n";
        }

        resultStr = resultStr.substring(0, resultStr.length() - 1);
        System.out.println(resultStr);
        writeFile(new File("result.txt"), resultStr);
    }
}
