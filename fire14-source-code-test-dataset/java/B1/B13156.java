import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Recycled {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            for (int i = 0; i < t; i++) {
                String[] str = br.readLine().split(" ");
                int a = Integer.parseInt(str[0]);
                int b = Integer.parseInt(str[1]);
                System.out.println("Case #" + (i + 1) + ": " + find(a, b));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int find(int a, int b) {
        HashSet<Long> used = new HashSet<Long>();
        int digits = String.valueOf(a).length();
        if (digits == 1) return 0;
        for (int i = a; i <= b; i++) {
            int s = 10;
            int m = (int) Math.pow(10, digits-1);
            for (int j = 0; j < digits-1; j++) {
                int r = i % s;
                if (r < s/10) continue;
                int q = i / s;
                int rn = r * m + q;
                s *= 10; m /= 10;
                if (i != rn && rn >= a && rn <= b) {
                    long pp;
                    if (rn < i) pp = (long)rn << 30 | i;
                    else pp = (long)i << 30 | rn;
                    if (!used.contains(pp)) {
                        used.add(pp);
                    }
                }
            }
        }
        return used.size();
    }
}
