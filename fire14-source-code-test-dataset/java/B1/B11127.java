package codejam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Third {

    public static void main(String[] args) throws FileNotFoundException {
        String path = ClassLoader.getSystemClassLoader().getResource("codejam/").getPath();
        Third worker = new Third();

        worker.scan(new File(path, "third-s.in"), new File(path, "third-s.out"));
//        worker.scan(new File(path, "third-x.in"), new File(path, "third-x.out"));
    }

    private void scan(File input, File output) throws FileNotFoundException {
        Scanner in = new Scanner(input);
        PrintWriter out = new PrintWriter(output);

        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            out.printf("Case #%d: %s\n", i + 1, solve(in.nextLine()));
        }

        out.flush();
        out.close();
        in.close();
    }

    public String solve(String line) {
        String[] splited = line.split(" ");

        return "" + solve(Integer.parseInt(splited[0]), Integer.parseInt(splited[1]));
    }

    public int solve(int a, int b) {
        if (a < 10 || a == b) {
            return 0;
        }

        int shiftCount = String.valueOf(a).length() - 1;
        int counter = 0;
        Map<String, Boolean> duplicate = new HashMap<String, Boolean>(shiftCount);

        for (int n = a; n <= b; n++) {
            duplicate.clear();
            for (int i = 1; i <= shiftCount; i++) {
                int m = shift(n, i);
                if (m < a || m > b || m == n || m > n) {
                    continue;
                }
                String key = "" + n + ":" + m;
                if (!duplicate.containsKey(key)) {
                    counter++;
                    duplicate.put(key, Boolean.TRUE);
                }
                //System.out.println("(" + n + ", " + m + ") ");
                //System.out.print("\'" + n + ":" + m + "\', ");

            }
        }
        return counter;
    }

    private int shift(int a, int n) {
        String s = String.valueOf(a);
        String head = s.substring(0, s.length() - n);
        String tail = s.substring(s.length() - n);
        return Integer.parseInt(tail + head);
    }
}
