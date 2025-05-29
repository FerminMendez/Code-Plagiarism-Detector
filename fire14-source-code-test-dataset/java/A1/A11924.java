import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: Linkov Mikl
 * Date: 15.04.12
 * Time: 2:51
 * To change this template use File | Settings | File Templates.
 */
public class ProblemB {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);

        int testCount = scanner.nextInt();

        for (int i = 0; i < testCount; i++) {
            int n = scanner.nextInt();
            int s = scanner.nextInt();
            int p = scanner.nextInt();
            int answer = 0;
            for (int j = 0; j < n; j++) {
                int point = scanner.nextInt();
                int flag = 0;
                int max1 = -1;
                int max2 = -1;
                for (int k1 = 0; k1 < 11; k1++) {
                    for (int k2 = 0; k2 < 11; k2++) {
                        for (int k3 = 0; k3 < 11; k3++) {
                            if (k3 + k2 + k1 == point) {
                                if ((Math.abs(k3 - k2) < 3) && (Math.abs(k1 - k2) < 3) && (Math.abs(k3 - k1) < 3)) {

                                    if ((Math.abs(k3 - k2) == 2) || (Math.abs(k2 - k1) == 2) || (Math.abs(k3 - k1) == 2)) {
                                        flag = 1;
                                        max1 = Math.max(k1, max1);
                                        max1 = Math.max(k2, max1);
                                        max1 = Math.max(k3, max1);
                                    } else {
                                        max2 = Math.max(k1, max2);
                                        max2 = Math.max(k2, max2);
                                        max2 = Math.max(k3, max2);
                                    }
                                }
                            }
                        }
                    }
                }

                if (max2 >= p) {
                    answer++;
                } else {
                    if (s > 0) {
                        if (max1 >= p) {
                            answer++;
                            s--;
                        }
                    }
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + answer);
        }
    }
}
