import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 */

/**
 * @author antonio081014
 * @time: Apr 13, 2012, 5:01:31 PM
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.run();
        System.exit(0);
    }

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("input.in"));
        BufferedWriter out = new BufferedWriter(new FileWriter("output.out"));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            out.write("Case #" + Integer.toString(t) + ": ");
            String[] strs = br.readLine().split("\\s");
            int A = Integer.parseInt(strs[0]);
            int B = Integer.parseInt(strs[1]);

            Set<Integer> set;

            int count = 0;
            for (int n = A; n <= B; n++) {
                String tmp = Integer.toString(n);
                set = new HashSet<Integer>();
                for (int i = 0; i < tmp.length(); i++) {
                    String a = tmp.substring(i) + tmp.substring(0, i);
                    int m = Integer.parseInt(a);
                    if (m > n && m <= B) {
                        set.add(m);
                    }
                }
                count += set.size();
            }
            out.write(Integer.toString(count) + "\n");
        }
        out.close();
    }
}