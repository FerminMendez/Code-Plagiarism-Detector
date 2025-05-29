package quialification;

import base.Base;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: babulya
 * Date: 14.04.12
 * Time: 19:10
 * To change this template use File | Settings | File Templates.
 */
public class B extends Base {

    private static int maxNoSurprising(int googler) {
        switch (googler % 3) {
            case 0: return googler / 3;
            case 1: return googler / 3 + 1;
            case 2: return googler / 3 + 1;
        }
        throw new RuntimeException("AAA");
    }

    private static int maxSurprising(int googler) {
        switch (googler % 3) {
            case 0: return googler > 0 ? googler / 3 + 1 : 0;
            case 1: return googler / 3 + 1;
            case 2: return googler / 3 + 2;
        }
        throw new RuntimeException("AAA");
    }

    @Override
    protected void solve(Scanner in, PrintStream out) {
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int N = in.nextInt();
            int S = in.nextInt();
            int p = in.nextInt();
            int[] googlers = new int[N];
            for (int j = 0; j < N; j++) {
                googlers[j] = in.nextInt();
            }
            //
            int answer = 0;
            for (int googler : googlers) {
                if (maxNoSurprising(googler) >= p) {
                    answer++;
                } else if (maxSurprising(googler) >= p && S > 0) {
                    answer++;
                    S--;
                }
            }
            //
            out.println(String.format("Case #%d: %d", (i+1), answer));
        }
    }

    public static void main(String[] args) {
        new B();
    }
}
