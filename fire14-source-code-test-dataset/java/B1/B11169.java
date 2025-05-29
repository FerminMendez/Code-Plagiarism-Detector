import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class C {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("c.in")));
        PrintStream out = new PrintStream(new FileOutputStream("c.out"));
        long count = readInt(in);
        for (int i = 0; i < count; i++) {
            String[] data = in.readLine().split(" ");
            int a = Integer.parseInt(data[0]);
            int b = Integer.parseInt(data[1]);
            int ans = 0;
            HashSet<String> st = new HashSet(); 
            for (int k = a; k<=b ; k++) {
                String s = "" + k;
                for (int p = 1; p < s.length(); p++) {
                    if (s.charAt(p) != '0') {
                        int t = Integer.parseInt(s.substring(p) + s.substring(0, p));
                        if (t > k && a<= t && t <=b) {
                            String key = s + t;
                            if (!st.contains(key)) {
                                ans++;
                                System.out.println(k + " " + t);
                                st.add(key);
                            }
                        }
                    }
                }
                        
            }
            out.println("Case #" + (i + 1) + ": " + ans);
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

}
