import java.util.Scanner;


public class B {

    static int[][] dp; // dp[i][j]: i人目まで終わった・あとj個surprize
    static void solve(int casee, Scanner sc) {
        int n = sc.nextInt();
        int s = sc.nextInt();
        int p = sc.nextInt();
        int[] t = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
        }
        dp = new int[n+1][s+1];
        for (int i = 0; i < n; i++) {
            boolean alwaysGood = (t[i] + 2) / 3 >= p;
            boolean goodWhenSurprizing = p == 0 || t[i] >= 2 && (t[i] + 4) / 3 >= p;
            if (alwaysGood) {
                for (int j = s; j >= 0; j--) {
                    dp[i+1][j] = dp[i][j] + 1;
                }
            }
            else if (goodWhenSurprizing) {
                for (int j = s; j >= 0; j--) {
                    dp[i+1][j] = dp[i][j];
                }
                for (int j = s; j >= 1; j--) {
                    dp[i+1][j-1] = Math.max(dp[i+1][j-1], dp[i][j] + 1);
                }
            }
            else {
                for (int j = s; j >= 0; j--) {
                    dp[i+1][j] = dp[i][j];
                }
            }
        }
        int max = 0;
        for (int i = 0; i <= s; i++) {
            max = Math.max(max, dp[n][i]);
        }
        System.out.println("Case #" + (casee+1) + ": " + max);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            solve(i, sc);
        }
        
    }

}
