
package example2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class dance {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nocases = Integer.parseInt(br.readLine());
        int arr[];
        int ans[] = new int[nocases];
        for (int i = 0; i < nocases; i++) {
            String token[] = br.readLine().split(" ");
            int N = Integer.parseInt(token[0]);
            int S = Integer.parseInt(token[1]);
            int P = Integer.parseInt(token[2]);
            arr=new int[N];
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(token[j + 3]);
            }
            ans[i]=method(arr, N, P, S);
        }
        for (int i = 0; i < nocases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + ans[i]);
        }
    }
    private static int method(int[] arr, int N, int P, int S) {
        int c1 = 0, c2 = 0;
        for (int j = 0; j < N; j++) {
            if (arr[j] >= P) {
                int diff = (int) (arr[j] - P);
                if (((2 * P) - diff) <= 2) {
                    c1++;
                } else if ((((2 * P) - diff) <= 4) && (((2 * P) - diff) > 2)) {
                    c2++;
                }
            }
        }
        if (c2 > S) {
            c1 = c1 + S;
        } else {
            c1 = c1 + c2;
        }
        return c1;
    }
}
