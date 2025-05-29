import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Set;

public class G3 {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader("d:\\C-small-attempt0.in"));
        int n = Integer.parseInt(in.readLine());
        BufferedWriter out = new BufferedWriter(new FileWriter("d:\\g3o.txt"));
        int from, to;
        for (int i = 1; i <= n; i++) {
            String[] s = in.readLine().split(" ");
            from = Integer.parseInt(s[0]);
            to = Integer.parseInt(s[1]);
            int answer = solve(from, to);
            System.out.println("Case #" + i + ": " + answer);
            out.write("Case #" + i + ": " + answer);
            out.newLine();
        }
        out.close();
    }

    private static int solve(int from, int to) {
        int result = 0;
        int digits = (int) Math.floor(Math.log10(from));
        Set<String> set = new HashSet<String>();
        for (int i = from; i <= to; i++) {
            int base10 = 10;
            int baseBig10 = (int) Math.pow(10., digits);
            for (int l = 0; l < digits; l++) {
                int cycled = baseBig10 * (i % base10) + (i/base10);
                if (cycled != i && cycled>=from && cycled <= to) {
                    result++;
                    if (!set.add(String.valueOf(i)+" "+cycled))
                    System.err.println(i +" <->"+cycled);
                }
                base10 *= 10;
                baseBig10 /= 10;
            }
        }
        return set.size()/2;
    }
}
