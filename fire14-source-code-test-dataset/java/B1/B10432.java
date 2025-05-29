package codejam;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

public class C {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader("file.in"));
        PrintStream out = new PrintStream(new FileOutputStream("file.out"));

        int nLines = Integer.parseInt(in.readLine());

        String[] s;

        for (int i = 1; i <= nLines; i++) {
            s = in.readLine().split(" ");

            int nA = Integer.valueOf(s[0]);

            int nB = Integer.valueOf(s[1]);

            int result = 0;

            Set<String> set = new HashSet<String>();

            if (nB > 10) {

                int start = Math.max(nA, 11);

                for (int j = start; j <= nB; j++) {

                    String st = String.valueOf(j);

                    for (int k = 1; k < st.length(); k++) {

                        String res = st.substring(k) + st.substring(0, k);
                        if (!res.startsWith("0") && !st.equals(res)
                                && st.length() == res.length()) {

                            int v = Integer.valueOf(res);

                            if (v <= nB && j < v) {
                                set.add(st + "," + res);
                            }

                        }

                    }

                }

            }
            result = set.size();

            out.println("Case #" + i + ": " + result);
        }

        in.close();
        out.close();
    }
}
