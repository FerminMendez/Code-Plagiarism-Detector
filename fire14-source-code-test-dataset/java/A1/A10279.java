
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class DancingWiththeGooglers {

    public static void main(String[] args) throws Exception {

        File inp = new File("B-small-attempt0.in");
        Scanner sc = new Scanner(inp);

        int T = sc.nextInt();


        int result, n, s, p;

        for (int i = 0; i < T; i++) {

            n = sc.nextInt();
            s = sc.nextInt();
            p = sc.nextInt();

            int[] q = new int[n];

            for (int lop = 0; lop < n; lop++) {
                q[lop] = sc.nextInt();
            }


            result = dowork(n, s, p, q);

            System.out.println("Case #" + (i + 1) + ": " + result);



        }




    }

    private static int dowork(int n, int s, int p, int[] q) {
        int r = 0;

        Arrays.sort(q);

        int minSumWithoutSur = p * 3 - 2;
        int minSumWithSur = p * 3 - 4;
        
        minSumWithSur = (minSumWithSur >= 0)? minSumWithSur : 0 ;
        

        for (int i = q.length - 1; i >= 0; i--) {
            if (q[i] >= minSumWithoutSur) {
                r++;
            } else if ((q[i] >= minSumWithSur) && (q[i] != 0) && (s > 0)) {
                r++;
                s--;
            }
        }


        return r;
    }
}
