import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Created by IntelliJ IDEA.
 * User: 875k
 * Date: 4/14/12
 * Time: 12:08 AM
 * To change this template use File | Settings | File Templates.
 */
public class prQB {
    public static boolean notSurprising(int a, int b, int c) {
        return Math.abs(a - b) <= 1 && Math.abs(a - c) <= 1 && Math.abs(b - c) <= 1;
    }
    public static boolean surprising(int a, int b, int c) {
        return !notSurprising(a, b, c) && Math.abs(a - b) <= 2 && Math.abs(a - c) <= 2 && Math.abs(b - c) <= 2;
    }
    public static int[] points;
    public static int[] surpriseMax;
    public static int[] normalMax;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("prQB.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("prQB.out")));
        points = new int[101];
        surpriseMax = new int[101];
        normalMax = new int[101];
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            Arrays.fill(points, -1);
            Arrays.fill(surpriseMax, -1);
            Arrays.fill(normalMax, -1);
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            for(int j = 0; j < N; j++) {
                points[j] = Integer.parseInt(st.nextToken());
                boolean found = false, founds = false;
                for(int a = Math.min(10, points[j]); a >= 0 && !(found && founds); a--) {
                    for(int b = Math.max(0, points[j] - a); b >= 0; b--) {
                        int c = points[j] - a - b;
                        if(notSurprising(a, b, c) && a >= normalMax[j]) {
                            found = true;
                            normalMax[j] = a;
                        }
                        if(surprising(a, b, c) && a >= surpriseMax[j]) {
                            founds = true;
                            surpriseMax[j] = a;
                        }
                    }
                }
            }
            //for(int j = 0; j < N; j++) { System.out.print(points[j] + "-" + normalMax[j] + "-" + surpriseMax[j] + ", "); } System.out.println();
            HashSet<Integer> hs = new HashSet<Integer>();
            for(int j = 0; j < N && S > 0; j++) {
                if(surpriseMax[j] >= p && normalMax[j] < p) {
                    hs.add(j);
                    S--;
                }
            }
            int c = hs.size();
            for(int j = 0; j < N; j++) {
                if(normalMax[j] >= p && !hs.contains(j)) c++;
            }
            out.println("Case #" + (i + 1) + ": " + c);
        }
        out.close();
        System.exit(0);
    }
}
