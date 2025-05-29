package qualification;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Recycled {
    private static String fileName = "recycled-small";
    private static String inputFileName = fileName + ".in";
    private static String outputFileName = fileName + ".out";
    private static Scanner in;
    private static PrintWriter out;
    private static int MIN = 12;
    private static int MAX = 1000;
    private static ArrayList<ArrayDeque<Integer>> data = new ArrayList<ArrayDeque<Integer>>(MAX-MIN);

    private static void calcData() {
        for (int i = MIN; i < MAX; i++) {
            String value = String.valueOf(i);
            String concatValue = value.concat(String.valueOf(i));
            ArrayDeque<Integer> goodShifts = new ArrayDeque<Integer>(value.length());
            HashSet<Integer> alreadyProcessed = new HashSet<Integer>(value.length());
            for (int n = 1; n < value.length(); n++) {
                String shiftedValue = concatValue.substring(n, n + value.length());
                int shiftedNum = Integer.parseInt(shiftedValue);
                if (!alreadyProcessed.contains(shiftedNum)) {
                    alreadyProcessed.add(shiftedNum);
                    if ((i < shiftedNum) && (shiftedNum <= MAX) && (value.length() == shiftedValue.length())) {
                        goodShifts.add(shiftedNum);
                    }
                }
            }
            data.add(goodShifts);
        }
    }

    private void solve() {
        int A = in.nextInt();
        int B = in.nextInt();
        int numRecycled = 0;
        for (int n = ((A < MIN) ? MIN : A); n < B; n++) {
            ArrayDeque<Integer> goodShifts = data.get(n-MIN);
            for (Integer m : goodShifts) {
                if (m <= B) {
                    numRecycled++;
                }
            }
        }
        out.print(numRecycled);
    }

    /**
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        calcData();
        in = new Scanner(new FileReader(inputFileName));
        out = new PrintWriter(outputFileName);
        int tests = in.nextInt();
        in.nextLine();
        for (int t = 1; t <= tests; t++) {
            out.print("Case #" + t + ": ");
            new Recycled().solve();
            out.println();
        }
        in.close();
        out.close();
    }

}
