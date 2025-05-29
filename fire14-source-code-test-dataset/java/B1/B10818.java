import java.io.*;
import java.math.*;
import java.util.*;
import java.text.*;

public class c {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));

        int[] next = new int[10000000];
        int low = 1;
        int high = 10;
        for (int digits = 1; digits <= 7; ++digits) {
            for (int i = low; i < high; ++i) {
                int a = 0;
                int b = i;
                while (a == 0) {
                    a = b % 10;
                    b = b / 10;
                }

                next[i] = low * a + b;
            }
            low = low * 10;
            high = high * 10;
        }

        int T = sc.nextInt();

        for (int casenumber = 1; casenumber <= T; ++casenumber) {

            int a = sc.nextInt();
            int b = sc.nextInt();

            int count = 0;

            for (int i = a; i <= b; ++i) {
                int count0 = 1;
                int j = next[i];
                while (j != i) {
                    if (j >= a && j <= b)
                        ++count0;
                    j = next[j];
                }

                count += (count0 - 1);

            }
            
            count /= 2;

            System.out.format("Case #%d: %d%n", casenumber, count);
        }
    }
}
