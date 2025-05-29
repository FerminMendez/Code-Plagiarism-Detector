
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PC {

    private static int[] div = {10, 100, 1000, 10000, 100000, 1000000};

    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 1) {
            System.exit(1);
        }
        File inFile = new File(args[0]);
        Scanner sc = new Scanner(inFile);
        int T = sc.nextInt();
        try (PrintWriter out = new PrintWriter("out.txt")) {
            for (int i = 1; i <= T; i++) {
                int A = sc.nextInt(), B = sc.nextInt(), count = 0, maxPow = 0;
                for (int j = 0; j < 6; j++) {
                    if (A / div[j] == 0) {
                        maxPow = j - 1;
                        break;
                    }
                }
                int[] prevFound = new int[2000000];
                for (int j = A; j <= B; j++) {
                    int pow = 0;
                    while (true) {
                        int numFront = j / div[pow];
                        if (numFront == 0) {
                            break;
                        }
                        int numBack = j % div[pow];
                        int newNum = numBack * div[maxPow - pow] + numFront;
                        if (j < newNum && A <= newNum && newNum <= B && prevFound[newNum - 1] < j) {
                            prevFound[newNum - 1] = j;
                            count++;
                        }
                        pow++;
                    }
                }
                out.println("Case #" + i + ": " + count);
            }
        }
        System.out.println("Completed!");
    }
}