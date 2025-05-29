
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Chung Lee
 */
public class DanceGoogler {

    public static void Main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File(args[0]));
        PrintWriter writer = new PrintWriter(args[1]);

        int noCase = scanner.nextInt();

        for (int i = 0; i < noCase; i++) {
            int noGooglers = scanner.nextInt();
            int noSurprice = scanner.nextInt();
            int P = scanner.nextInt();

            List<Integer> totalScore = new ArrayList<Integer>();
            List<Integer> noSurpriceBest = new ArrayList<Integer>();
            for (int j = 0; j < noGooglers; j++) {
                int total = scanner.nextInt();
                totalScore.add(total);
                noSurpriceBest.add((int) Math.ceil(total / 3.));
            }
            
            int noAtLeastP = 0;

            for (int j = 0; j < totalScore.size(); j++) {
                if (noSurpriceBest.get(j) >= P) {
                    noAtLeastP++;
                } else if ((totalScore.get(j) % 3 == 0 || totalScore.get(j) % 3 == 2)
                        && totalScore.get(j) != 0
                        && totalScore.get(j) <= 27
                        && noSurpriceBest.get(j) == P - 1
                        && noSurprice > 0) {
                    noSurprice--;
                    noAtLeastP++;
                }
            }
            
            System.out.print(String.format("Case #%d: %d", i + 1, noAtLeastP));
            writer.print(String.format("Case #%d: %d", i + 1, noAtLeastP));
            
            if (i != noCase - 1) {
                System.out.println();
                writer.println();
            }

        }

        writer.close();
    }
}
