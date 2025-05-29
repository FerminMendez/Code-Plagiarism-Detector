import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int length, a, b;
    static int count = 0;

    public static int len(int a) {
        int l = 0;
        while (a > 0) {
            a = a / 10;
            l++;
        }
        return l;
    }

    public static int calc(int m) {
        if (length == 1) {
            return 1;
        } else {
            for (int j = 0; j < length - 1; j++) {
                int x = 1, y = 1;
                for (int q = 1; q <= j + 1; q++) {
                    x *= 10;
                }
                for (int q = 1; q < length - j; q++) {
                    y *= 10;
                }
                int lastd = (m % x);
                int num = (m / x) +(lastd * y);
                if ((num >= a) && (num <= b) && (num != m)) {
                    count++;
                    
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                StringTokenizer tok = new StringTokenizer(str, " ");
                a = Integer.parseInt(tok.nextToken());
                b = Integer.parseInt(tok.nextToken());
                System.out.print("Case #" + (i + 1) + ": ");
                count = 0;
                length = len(a);
                for (int k = a; k <= b; k++) {
                    calc(k);

                }
                System.out.print(count / 2);
                if (i != (n - 1)) {
                    System.out.print("\n");
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}