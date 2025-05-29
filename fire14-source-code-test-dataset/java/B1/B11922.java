/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 14.04.12
 * Time: 11:17
 */
package codejam.codejam2012;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ashevenkov
 */
public class QualificationC {

    public static void main(String[] args) throws Exception {
        new QualificationC().calculate(
                "/home/ashevenkov/projects/codejam/C-small-attempt0.in",
                "/home/ashevenkov/projects/codejam/C-small-attempt0.out");
    }

    public void calculate(String in, String out) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(in));
        FileWriter fw = new FileWriter(out);
        String line = br.readLine();
        int cases = Integer.parseInt(line);
        for(int i = 0; i < cases; i++) {
            line = br.readLine();
            String[] parts = line.split(" ");
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);
            String result = recycle(a, b);
            System.out.println("Case #" + (i + 1) + ": " + result);
            fw.write("Case #" + (i + 1) + ": " + result);
            fw.write("\n");
        }
        fw.flush();
        fw.close();
    }

    private String recycle(int a, int b) {
        int result = 0;
        for(int i = a; i <= b; i++) {
            String s = Integer.toString(i);
            String s1 = s+s;
            Set<Integer> set = new HashSet<Integer>();
            for(int j = 1; j < s.length(); j++) {
                int k = Integer.parseInt(s1.substring(j, j + s.length()));
                set.add(k);
            }
            for(Integer k : set) {
                if(a <= k && k <= b && i < k) {
                    result++;
                }
            }
        }
        return Integer.toString(result);
    }

}
