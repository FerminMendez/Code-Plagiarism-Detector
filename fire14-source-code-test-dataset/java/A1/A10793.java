import java.io.*;
import java.math.*;
import java.util.*;
import java.text.*;

public class b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));

        int T = sc.nextInt();

        for (int casenumber = 1; casenumber <= T; ++casenumber) {

            int n = sc.nextInt();
            int s = sc.nextInt();
            int p = sc.nextInt();

            int[] ts = new int[n];
            for (int i = 0; i < n; ++i)
                ts[i] = sc.nextInt();

            int thresh1 = (p == 1 ? 1 : (3 * p - 4));
            int thresh2 = (3 * p - 2);

            int count1 = 0, count2 = 0;

            for (int i = 0; i < n; ++i) {
                if (ts[i] >= thresh2) {
                    ++count2;
                    continue;
                }
                if (ts[i] >= thresh1) {
                    ++count1;
                }
            }

            if (count1 > s) {
                count1 = s;
            }

            System.out.format("Case #%d: %d%n", casenumber, count1 + count2);
        }
    }
}
