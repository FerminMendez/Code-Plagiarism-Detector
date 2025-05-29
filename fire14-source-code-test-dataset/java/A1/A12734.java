
import java.util.Arrays;
import java.util.Scanner;

public class B {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int s = in.nextInt();
            int p = in.nextInt();
            int ans = 0;

            int a[] = new int[n];
            int b[] = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = in.nextInt();
                if (a[j] % 3 == 0) {
                    b[j] = a[j] / 3;
                } else if ((a[j] > 0) && (a[j] - 1) % 3 == 0) {
                    b[j] = (a[j] - 1) / 3 + 1;
                } else if ((a[j] > 1) && (a[j] - 2) % 3 == 0) {
                    b[j] = (a[j] - 2) / 3 + 1;
                }
            }
            for (int j = 0; j < n && s > 0; j++) {
                if (a[j] >= 0 && b[j] < p) {
                    int x = -1;
                    if ((a[j] > 1) && (a[j] - 2) % 3 == 0) {
                        x = (a[j] - 2) / 3 + 2;
                    } else if ((a[j] > 2) && (a[j] - 3) % 3 == 0) {
                        x = (a[j] - 3) / 3 + 2;
                    } else if ((a[j] > 3) && (a[j] - 4) % 3 == 0) {
                        x = (a[j] - 4) / 3 + 2;
                    }
                    if (x >= p) {
                        ans++;
                        a[j] = -1;
                        s--;
                    }
                }
            }
            for (int j = 0; j < n && s > 0; j++) {
                if (a[j] >= 0 && b[j] < p) {
                    int x = -1;
                    if ((a[j] > 1) && (a[j] - 2) % 3 == 0) {
                        x = (a[j] - 2) / 3 + 2;
                    } else if ((a[j] > 2) && (a[j] - 3) % 3 == 0) {
                        x = (a[j] - 3) / 3 + 2;
                    } else if ((a[j] > 3) && (a[j] - 4) % 3 == 0) {
                        x = (a[j] - 4) / 3 + 2;
                    }
                    if (x != -1) {
                        a[j] = -1;
                        s--;
                    }
                }
            }
            for (int j = 0; j < n && s > 0; j++) {
                if (a[j] >= 0 && b[j] >= p) {
                    int x = -1;
                    if ((a[j] > 1) && (a[j] - 2) % 3 == 0) {
                        x = (a[j] - 2) / 3 + 2;
                    } else if ((a[j] > 2) && (a[j] - 3) % 3 == 0) {
                        x = (a[j] - 3) / 3 + 2;
                    } else if ((a[j] > 3) && (a[j] - 4) % 3 == 0) {
                        x = (a[j] - 4) / 3 + 2;
                    }
                    if (x >= p) {
                        ans++;
                        a[j] = -1;
                        s--;
                    }
                }
            }

            for (int j = 0; j < n && s > 0; j++) {
                if (a[j] >= 0 && b[j] >= p) {
                    int x = -1;
                    if ((a[j] > 1) && (a[j] - 2) % 3 == 0) {
                        x = (a[j] - 2) / 3 + 2;
                    } else if ((a[j] > 2) && (a[j] - 3) % 3 == 0) {
                        x = (a[j] - 3) / 3 + 2;
                    } else if ((a[j] > 3) && (a[j] - 4) % 3 == 0) {
                        x = (a[j] - 4) / 3 + 2;
                    }
                    if (x != -1) {
                        ans--;
                        a[j] = -1;
                        s--;
                    }
                }
            }
            for (int j = 0; j < n; j++) {
                if (a[j] >= 0 && b[j] >= p) {
                    ans++;
                }
            }
            System.out.println("Case #"+(i+1)+": "+ans);
        }
    }
}
