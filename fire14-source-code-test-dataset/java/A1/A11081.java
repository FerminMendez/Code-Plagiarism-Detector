package codejam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Second {

    public static void main(String[] args) throws FileNotFoundException {
        String path = ClassLoader.getSystemClassLoader().getResource("codejam/").getPath();
        Second worker = new Second();

        worker.scan(new File(path, "second-s.in"), new File(path, "second-s.out"));
//        worker.scan(new File(path, "second-x.in"), new File(path, "second-x.out"));
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
        String[] tokens = line.split(" ");
        int n = Integer.parseInt(tokens[0]);
        int s = Integer.parseInt(tokens[1]);
        int p = Integer.parseInt(tokens[2]);
        int[] points = new int[n];
        for (int i = 0; i < points.length; i++) {
            points[i] = Integer.parseInt(tokens[3 + i]);
        }

        int result = 0;
        for (int pc : points) {
            int r = solve(pc, p);
            if (r == 3 && s > 0) {
                result++;
                s--;
            } else if (r == 1 || r == 2) {
                result++;
            }
        }
        return "" + result;
    }

    public int solve(int pc, int p) {
        if (pc == 0) {
            return p == 0 ? 1 : 0;
        }
        int m = pc / 3;
        while ( m < p) m++;

        int k = 0;
        do {
            k = 3 * m;
            if (k == pc || k - 1 == pc) {
                return 1;
            }
            if (k - 2 == pc) {
                return 2;
            }
            if (k - 3 == pc || k - 4 == pc) {
                return 3;
            }
            m++;
        } while (k - pc <= 4);
        return 0;
    }
}
