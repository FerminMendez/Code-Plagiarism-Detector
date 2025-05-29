package qualification;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DancingWithTheGooglers {
    static int T;
    static int[] result;

    public static void main(String[] args) throws IOException {
        System.out.println(new File("prd.txt").getAbsolutePath());
        read();
        write();
    }

    static void read() throws IOException {
        File input = new File("input.txt");
        Scanner scanner = new Scanner(input);
        T = scanner.nextInt();
        result = new int[T];
        for (int t=0; t<T; t++) {
            int N = scanner.nextInt();
            int S = scanner.nextInt();
            int p = scanner.nextInt();
            int r = 0;
            for (int i=0; i<N; i++) {
                int score = scanner.nextInt();
                if (score >= 3*p-2) {
                    r++;
                } else if ((score >= 3*p-4) && (S > 0) && (p >= 2)) {
                    r++;
                    S--;
                }
            }
            result[t] = r;
        }
    }

    static void write() throws IOException {
        File output = new File("output.txt");
        PrintWriter pw = new PrintWriter(output);

        for (int t=0; t<T; t++) {
            pw.println("Case #"+(t+1)+": "+result[t]);
        }

        pw.close();
    }

}
