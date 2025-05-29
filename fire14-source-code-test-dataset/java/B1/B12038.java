import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.ibm.db2.jcc.am.s;


public class C {
    private static final String INPUT_FILE = "d:/C-small-attempt0.in";
    private static final String OUTPUT_FILE = "d:/result.txt";
    private static final int MAX_VALUE = 2000000;
    private static int T;
    static int[] d = new int[1 + MAX_VALUE];
    static int a, b;
    static long[] result;
    
    static void init() {
        for (int i = 1; i <= MAX_VALUE; ++i) {
            if (d[i] != 0) {
                continue;
            }
            d[i] = i;
            String s = "" + i;
            for (int j = 0; j < s.length(); ++j) {
                s = s.substring(1) + s.charAt(0);
                if (s.charAt(0) != '0') {
                    int v = Integer.parseInt(s);
                    if (v > MAX_VALUE) continue;
                    d[Integer.parseInt(s)] = i;
                }
            }
        }
    }
    
    static void Input() throws Exception {
        InputStream in = new FileInputStream(INPUT_FILE);
//        InputStream in = System.in;
        Scanner scanner = new Scanner(in);
        T = scanner.nextInt();
        result = new long[T + 1];

        for (int i = 0; i < T; ++i) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            solve(i, a, b);
        }
    }
    
    static void solve(int c, int a, int b) {
        long rst = 0;
        int[] map = new int[MAX_VALUE + 1];
        for (int i = a; i <= b; ++i) {
            ++map[d[i]];
        }
        for (int i = a; i <= b; ++i) {
            if (map[d[i]] > 0) {
                int v = map[d[i]];
                rst += 1L * v * (v - 1) / 2;
                map[d[i]] = 0;
            }
        }
        result[c] = rst;
    }
    
    static void Output() throws Exception {
        FileWriter writer = new FileWriter(new File(OUTPUT_FILE));
        for (int i = 0; i < T; ++i) {
            String rs = "Case #" + (i + 1) + ": " + (result[i]) + "\n";
            writer.write(rs);
            System.out.println(rs);
        }
        writer.close();
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        init();
//        System.out.println(System.currentTimeMillis() - start);
        Input();
        Output();
    }
}
