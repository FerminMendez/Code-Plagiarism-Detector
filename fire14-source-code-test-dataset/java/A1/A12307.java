import java.io.File;
import java.io.PrintWriter;
import java.util.*;
import java.util.jar.JarEntry;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 4/14/12
 * Time: 9:24 AM
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static Map<Integer, Integer> createMap(int dif) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i <= 10; i++) {
            for(int j = 0; j <= 10; j++) {
                for(int k = 0; k <= 10; k++) {
                    int min = Math.min(i, Math.min(j, k));
                    int max = Math.max(i, Math.max(j, k));
                    int sum = i + j + k;
                    if((max - min) <= dif) {
                        Integer val = map.get(sum);
                        if(val == null || val < max) {
                            map.put(sum, max);
                        }
                    }
                }
            }
        }
        return map;
    }

    public static void main(String[] args) throws Exception {

        Map<Integer, Integer> map1 = createMap(1);
        Map<Integer, Integer> map2 = createMap(2);


        Scanner scanner = new Scanner(new File("B-small-attempt0.in"));
        PrintWriter pw = new PrintWriter(new File("google.out"));

        int n = scanner.nextInt();
        for(int i = 0; i < n; i++) {
            int N = scanner.nextInt();
            int S = scanner.nextInt();
            int p = scanner.nextInt();
            int count = 0;
            for(int k = 0; k < N; k++) {
                int sum = scanner.nextInt();
                if(map1.get(sum) >= p) {
                    count++;
                } else if(map2.get(sum) >= p && S > 0) {
                    count++;
                    S--;
                }
            }
            pw.print(String.format("Case #%d: %d%n", i + 1, count));
        }


        scanner.close();
        pw.close();


    }

}
