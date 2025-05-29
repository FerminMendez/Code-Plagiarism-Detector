import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 *
 * @author Sylphid
 */
public class ProbB {

    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("output");
        PrintWriter out = new PrintWriter(fw);
        File inp = new File("input");
        Scanner sc = new Scanner(inp);
        
        int tests = Integer.parseInt(sc.nextLine());
        for (int z = 0; z < tests; z++) {
            StringTokenizer strtok = new StringTokenizer(sc.nextLine(), " ");
            int n = Integer.parseInt(strtok.nextToken());
            int s = Integer.parseInt(strtok.nextToken());
            int p = Integer.parseInt(strtok.nextToken());

            List<Integer> ggl = new ArrayList<>(n);
            List<Integer> ggl_sprd = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                int newP = Integer.parseInt(strtok.nextToken());
                if (surprised(newP) && (highP(newP) <= 10)) {
                    ggl_sprd.add(newP);
                } else {
                    ggl.add(newP);
                }
            }
            Collections.sort(ggl_sprd);
            int maxG = 0;
            for (int i = 0; i < ggl.size(); i++) {
                if (highP(ggl.get(i)) >= p) {
                    maxG++;
                }
            }
            int sCount = s;
            int indx = ggl_sprd.size();
            for (int i = 0; i < ggl_sprd.size(); i++) {
                if (sCount == 0) {
                    indx = i;
                    break;
                }
                if (highP(ggl_sprd.get(i)) >= p) {
                    maxG++;
                    sCount--;
                }
            }
            if (sCount == 0) {
                for (int i = indx; i < ggl_sprd.size(); i++) {
                    if (highP_woS(ggl_sprd.get(i)) >= p) {
                        maxG++;
                    }
                }
            }
            out.println("Case #" + (z+1) + ": " + maxG);
        }
        sc.close();
        out.close();
    }

    static boolean surprised(int total) {
        if (total % 3 == 2 || total % 3 == 0) {
            return true;
        }
        return false;
    }

    static int highP(int total) {
        if (total == 0) {
            return 0;
        }
        int highestP = 0;
        if (total % 3 == 0) {
            highestP = (int) (total / 3) + 1;
        } else {
            highestP = (int) (total / 3) + (total % 3);
        }
        if (highestP > 10) {
            highestP = 10;
        }
        return highestP;
    }

    static int highP_woS(int total) {
        int highestP = (int) (total / 3);
        if (total % 3 != 0) {
            highestP++;
        }
        return highestP;
    }
}
