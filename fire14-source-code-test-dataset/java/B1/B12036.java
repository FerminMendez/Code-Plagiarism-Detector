import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Nikita Beloglazov
 *         Date: May 22, 2010
 */
public class Solution {

    private Map root;

    private int res;

    private void createDirectory(String[] dirs) {
        Map cur = root;
        for (String dir : dirs) {
            if (cur.get(dir) == null) {
                res++;
                cur.put(dir, new HashMap());
            }
            cur = (Map)cur.get(dir);
        }
    }

    private void solve() throws IOException {
        Scanner sc = new Scanner(new File("input.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));
        int tt = sc.nextInt();
        for (int t = 1; t <= tt; t++) {
            int n = sc.nextInt(), m = sc.nextInt();
            root = new HashMap();
            root.put("",new HashMap());
            for (int i = 0; i < n; i++) {
                createDirectory(sc.next().split("/"));
            }
            res = 0;
            for (int i = 0; i < m; i++) {
                createDirectory(sc.next().split("/"));
            }
            pw.printf("Case #%d: %d\n", t, res);
        }
        pw.close();
    }

    public static void main(String[] args) throws IOException {
        new Solution().solve();
    }
}
