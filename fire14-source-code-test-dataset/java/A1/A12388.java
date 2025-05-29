package the2012;

import java.io.*;
import java.util.Scanner;

public class DancingWithTheGooglers {


    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedInputStream(new FileInputStream("/Users/taobo2/Downloads/B-small-attempt0.in.txt")));
        Writer output = new BufferedWriter(new FileWriter("B-small-attempt0.output-b.txt"));

        int T = scanner.nextInt();
        for (int i = 1; i <= T; ++i) {
            int N = scanner.nextInt();
            int[] total = new int[N];
            int s = scanner.nextInt();
            int p = scanner.nextInt();
            for (int j = 0; j < N; ++j) {
                total[j] = scanner.nextInt();
            }
            output.write("Case #" + i + ": " + sovle(total, p, s));
            output.write(System.getProperty("line.separator"));
        }
        output.close();
        scanner.close();
    }


    public static int sovle(int[] total, int p, int s) {
        int ret = 0;
        for (int t : total) {
            int mod = t % 3;
            switch (mod) {
                case 0:
                    if (t / 3 >= p) ret++;
                    else if (s > 0) {
                        int smallest = (t - 3) / 3;
                        if (smallest < 0) {
                            break;
                        }
                        if (smallest + 2 >= p) {
                            s--;
                            ret++;
                        }
                    }
                    break;

                case 1:
                    if ((t - 1) / 3 + 1 >= p) ret++;
                    else if (s > 0) {
                        int smallest = (t - 4) / 3;
                        if (smallest < 0) {
                            break;
                        }
                        if (smallest + 2 >= p) {
                            ret++;
                            s--;
                        }
                    }
                    break;

                case 2:
                    if ((t - 2) / 3 + 1 >= p) ret++;
                    else if (s > 0) {
                        int smallest = (t - 2) / 3;
                        if (smallest < 0) {
                            break;
                        }

                        if (smallest + 2 >= p) {
                            ret++;
                            s--;
                        }
                    }
                    break;
            }
        }
        return ret;
    }
}
