import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

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
            String[] str = br.readLine().split("\\s");
            int surprising = 0;
            int partial = 0;
            int sum = 0;
            int N = Integer.parseInt(str[0]);
            int S = Integer.parseInt(str[1]);
            int p = Integer.parseInt(str[2]);
            for (int i = 0; i < N; i++) {
                int a = Integer.parseInt(str[i + 3]);
                if ((a == 3 * p - 4 || a == 3 * p - 3) && p >= 2) {
                    surprising++;
                    sum++;
                }
                else if (a >= 3 * p - 2) {
                    sum++;
                    partial++;
                }
            }
            // System.out.println();
            // System.out.println(sum);
            // System.out.println(surprising);
            // System.out.println(partial);
            if (surprising >= S) {
                out.write(Integer.toString(sum + S - surprising));
                // System.out.println(sum + S - surprising);
            }
            else {
                // if (surprising + partial >= S) {
                out.write(Integer.toString(sum));
                // System.out.println(sum);
                // }
                // else {
                // // System.out.println(0);
                // out.write("0");
                // }
            }
            out.write("\n");
        }
        out.close();
    }
}