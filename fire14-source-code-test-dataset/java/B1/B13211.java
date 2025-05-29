
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.StringTokenizer;

public class C {

    String PATH = "C:\\Users\\XiaoweiChen\\Desktop\\Jam\\";
    String inPath = PATH + "C-small-attempt0.in";
    String outPath = PATH + "C-small-attempt0.out";
    BufferedReader reader = null;
    BufferedWriter writer = null;
    StringTokenizer tokenizer = null;

    int ni() throws IOException {
        return Integer.parseInt(ns());
    }

    long nl() throws IOException {
        return Long.parseLong(ns());
    }

    double nd() throws IOException {
        return Double.parseDouble(ns());
    }

    String ns() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    String nline() throws IOException {
        tokenizer = null;
        return reader.readLine();
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        new C().solve();
    }

    public C() throws FileNotFoundException, IOException {
        reader = new BufferedReader(new FileReader(inPath));
        writer = new BufferedWriter(new FileWriter(outPath));
    }

    public void solve() throws IOException {
        int round = ni();
        for (int ccase = 1; ccase <= round; ccase++) {
            long A = nl();
            long B = nl();
            long count = 0;

            HashSet pair = new HashSet();

            for (long m = A; m <= B; m++) {
                String rep = Long.toString(m);
                int length = rep.length();
                for (int i = 1; i < length; i++) {
                    long n = Long.parseLong(rep.substring(length - i) + rep.substring(0, length - i));
                    if (n < m && n <= B && n >= A) {
                        if (!pair.contains(n + " < " + m)) {
                            pair.add(n + " < " + m);
                            count++;
                        }
                    }
                }
            }
            String print = "Case #" + ccase + ": " + count + "\n";
            System.out.print(print);
            writer.write(print, 0, print.length());
        }
        writer.close();
    }
}
