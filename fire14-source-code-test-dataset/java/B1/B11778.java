package codejam;

import java.util.*;

/**
 *
 * @author JoeJev
 */
public class ProblemC {

    Scanner scan;

    public ProblemC(Scanner scan) {
        this.scan = scan;
    }
    
    public void processProblem(){
        int cases = scan.nextInt();
        for (int m = 1; m <= cases; m++){
            System.out.println("Case #" + m + ": " + amountRecycled(scan.nextInt(), scan.nextInt()));
        }
    }

    private int amountRecycled(int n, int m) {
        int result = 0;
        int parsedInt;
        for (int o = n; o <= m; o++)
            for (int p = String.valueOf(o).length(); p > 0; p--){
                parsedInt = Integer.parseInt(String.valueOf(o).substring(p) + String.valueOf(o).substring(0, p));
                    if (parsedInt <= m && parsedInt >= n && parsedInt != o)
                        result++;
            }
        return result / 2;
    }
}
