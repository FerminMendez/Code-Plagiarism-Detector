import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Dance {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            for (int i = 0; i < t; i++) {
                String[] str = br.readLine().split(" ");
                int n = Integer.parseInt(str[0]);
                int s = Integer.parseInt(str[1]);
                int p = Integer.parseInt(str[2]);
                int[] tis = new int[n];
                for (int j = 0; j < tis.length; j++) {
                    tis[j] = Integer.parseInt(str[3+j]);
                }

                System.out.println("Case #" + (i + 1) + ": " + find(n,s,p,tis));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int find(int n, int s, int p, int[] tis) {
        Arrays.sort(tis);
        int normalScore = Math.max(3*p-2, 0);
        int surpriseScore = 3*p-4;
        if (surpriseScore < 0) surpriseScore = normalScore;
        int ind = tis.length-1;
        for (; ind >= 0 && tis[ind] >= normalScore; ind--);
        for (int i=0; ind >= 0 && i < s && tis[ind] >= surpriseScore; ind--, i++);
        return n-ind-1;
    }
}
