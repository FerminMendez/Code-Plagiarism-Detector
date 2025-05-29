import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Scanner;

public class DancingWithGooglers {

    public static void main(String[] args) throws Exception {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/home/xnike/Downloads/B-small-attempt0.out"));
        Scanner scanner = new Scanner(new File("/home/xnike/Downloads/B-small-attempt0.in"));

        int t = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt(), s = scanner.nextInt(), p = scanner.nextInt();
            int[] ti = new int[n];

            for (int j = 0; j < n; j++) {
                ti[j] = scanner.nextInt();
            }
            scanner.nextLine();

            Arrays.sort(ti);

            int num = 0;
            for (int k = ti.length - 1; k > -1; k--) {
                int min = ti[k] / 3, max = ti[k] - 2 * (ti[k] / 3);

                if (0 == max - min && 2 < ti[k]) {
                    max++;
                    min--;
                }

                if (max >= p) {
                    if (max == p && (2 == max - min)) {
                        if (0 < s) {
                            s--;
                            num++;
                        }
                    } else {
                    num++;
                    }
                }
            }

            bufferedWriter.write("Case #" + (i + 1)  + ": " + num + "\n");
        }

        bufferedWriter.flush();
    }
}
