import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class B {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("b.in")));
        PrintStream out = new PrintStream(new FileOutputStream("b.out"));
        long count = readInt(in);
        for (int i = 0; i < count; i++) {
            String[] data = in.readLine().split(" ");
            int n = Integer.parseInt(data[0]);
            int s = Integer.parseInt(data[1]);
            int p = Integer.parseInt(data[2]);
            int goodLimit = 3 * p - 2;
            if (p == 0) {
                goodLimit = 0;
            }
            int sLimit = 3 * p - 4;
            if (p == 1) {
                sLimit = 1;
            }
            System.out.println(goodLimit + " " + sLimit);
            int  good = 0;
            int sur = 0;
            for (int j = 0; j < n; j++) {
                int v = Integer.parseInt(data[3 + j]);
                if (v >= goodLimit) {
                    good++;
                } else if (v >= sLimit) {
                    sur++;
                }
            }

            System.out.println(good + " " + sur);
            out.println("Case #" + (i + 1) + ": " + (good + Math.min(s, sur)));
        }
        out.flush();
        out.close();

    }

    private static long readInt(BufferedReader in) {
        try {
            return Long.parseLong(in.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }    

    private static void loadCode(String s1, String t1, Map<Character, Character> m) {
        for (int i = 0; i < s1.length(); i++) {
            m.put(s1.charAt(i), t1.charAt(i));
        }
    }
}
