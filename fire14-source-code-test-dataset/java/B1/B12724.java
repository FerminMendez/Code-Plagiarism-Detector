import java.util.Scanner;


public class C {

    public static void main(String[] args) {
        boolean[][] isPairs = new boolean[1001][1001];
        for (int i = 1; i < 1000; i++) {
            for (int j = i+1; j < 1001; j++) {
                isPairs[i][j] = isPair(i, j);
            }
        }
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int count = 0;
            for (int j = a; j < b; j++) {
                for (int k = j+1; k <= b; k++) {
                    if (isPairs[j][k]) {
                        count++;
                    }
                }
            }
            System.out.println("Case #" + (i+1) + ": " + count);
            
        }
    }

    private static boolean isPair(int i, int j) {
        int digits = 0;
        int max = 1;
        int ac = i;
        while(ac > 0) {
            ac /= 10;
            digits++;
            max *= 10;
        }
        int min = max / 10;
        for (int k = 0; k < digits; k++) {
            int msb = i / min;
            i = i % min * 10 + msb;
            if (i == j) {
                return true;
            }
        }
        return false;
    }

}
