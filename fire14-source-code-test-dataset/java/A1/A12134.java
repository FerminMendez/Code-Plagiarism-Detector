package dance;

import java.util.Scanner;

public class Dance {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();//the number of test cases
        int[] y = new int[t];

        for (int i = 0; i < t; i++) {
            int n, s, p;
            y[i] = 0;
            n = scanner.nextInt();//the number of Googlers
            int[] tp = new int[n];//the total points of the Googlers.
            s = scanner.nextInt();//the number of surprising triplets of scores
            p = scanner.nextInt();// a best result of at least p
            for (int j = 0; j < n; j++) {
                tp[j] = scanner.nextInt();
                if (((tp[j] + 2) / 3) >= p) {
                    y[i]++;
                } else if (((tp[j] + 4) / 3) >= p & s > 0&tp[j]>=2) {
                    y[i]++;
                    s--;
                }
            }

        }
        for (int i = 0; i < t; i++) {
            System.out.println("Case #"+(i+1)+": "+y[i]);
        }

    }
}
