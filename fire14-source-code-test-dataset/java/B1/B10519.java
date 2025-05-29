import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 * User: akim
 * Date: 4/14/12
 * Time: 7:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class C {

    String makeHash(int a) {
        String t = Integer.toString(a);
        String ans = t;
        for (int i = 0; i < t.length(); ++i) {
            t = t.substring(1)+t.charAt(0);
            if (ans.compareTo(t) > 0) ans = t;
        }
//        System.out.println(a + " - " + ans);
        return ans;
    }

    void solve() throws FileNotFoundException {
        PrintWriter out = new PrintWriter(new FileOutputStream("output.txt"));
        Scanner in = new Scanner(new FileInputStream("input.txt"));
        int t = Integer.parseInt(in.nextLine());
        System.err.println(t);
        TreeMap<String, Long> ans = new TreeMap<String, Long>();
        for (int i = 0; i < t; ++i) {
            ans.clear();
            int A = in.nextInt();
            int B = in.nextInt();
            for (int qqq = A; qqq <= B; ++qqq) {
                String hash = makeHash(qqq);
                if (!ans.containsKey(hash)) ans.put(hash, 0L);
                long tmp = ans.get(hash);
                ans.put(hash, tmp + 1);
            }
            long rrr = 0;
            /*for (int a = A; a <= B; ++a)
                for (int b = a + 1; b <= B; ++b)
                    if (makeHash(a).equals(makeHash(b))) --rrr;*/
            for (String h : ans.keySet()) {
                long tmp = ans.get(h);
                rrr += tmp * (tmp - 1) / 2;
            }
            out.println("Case #" + (i + 1) + ": " + rrr);
            System.err.println((i + 1) + " " + rrr);
        }
        out.flush();
        out.close();
    }


    public static void main(String[] args) throws FileNotFoundException {
        new C().solve();
    }
}
