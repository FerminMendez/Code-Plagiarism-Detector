import sun.reflect.generics.tree.Tree;

import java.io.*;
import java.util.TreeSet;

/**
 * User: Andrii Baranov
 * Date: 14.04.12
 * Time: 14:11
 */
public class RecycledNumbers {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("in/C/C-small-attempt0.in"));
        int testCases = Integer.parseInt(br.readLine());
        int results[] = new int[testCases];

        for(int i = 0; i < testCases; i++){
            String paramsStr = br.readLine();
            String[] params = paramsStr.split(" ");
            results[i] = countRecycled(Integer.parseInt(params[0]), Integer.parseInt(params[1]));
        }
        br.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter("in/C/small-out.txt"));
        for(int i = 0; i < testCases; i++){
            bw.write("Case #" + (i + 1) + ": " + results[i]);
            if (i + 1 < testCases) {
                bw.write("\n");
            }
        }
        bw.close();

    }

    static int countRecycled(int A, int B) {
        String rep;
        int res = 0;
        for (int first = A; first < B; first++) {
            rep = Integer.toString(first);
            TreeSet<Integer> recNumbers = new TreeSet<Integer>();
            for (int j = rep.length() - 1; j > 0; j--) {
                if (rep.charAt(j) != '0') {
                    String replaced = rep.substring(j) + rep.substring(0, j);
                    Integer num = new Integer(replaced);
                    if (num.intValue() <= B && num.intValue() > first) {
                        recNumbers.add(num);
                    }
                }
            }
            res += recNumbers.size();
        }
        return res;
    }
}
