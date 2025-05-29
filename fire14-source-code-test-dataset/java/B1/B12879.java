package codejam2012.qr;

import codejam.common.CodeHelper;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Chen Ling
 */
public class ProblemC {

    private static String SMALL_IN_FILE_NAME = "/codejam2012/qr/C-small.in";
    private static String LARGE_IN_FILE_NAME = "/codejam2012/qr/C-large.in";
    private static String SMALL_OUT_FILE_NAME = "/codejam2012/qr/C-small.out";
    private static String LARGE_OUT_FILE_NAME = "/codejam2012/qr/C-large.out";

    public static int solve(int start, int end) {
        int total = 0;
        for (int number = start; number < end + 1; number++) {
            String pairN = String.valueOf(number);
            if (pairN.length() == 1) {
                continue;
            }
            for (int i = 1; i < pairN.length(); i++) {
                String pairM = pairN.substring(i, pairN.length()) + pairN.substring(0, i);
                int pairMI = Integer.parseInt(pairM);
                if (pairMI >= start && pairMI > number && pairMI <= end) {
                    total++;
//                    System.out.print("Pair(" + pairN + ", " + pairM + ")");
//                    System.out.print(", Ture");
//                    System.out.println("");
                }

            }
        }
//        System.out.println("Total: " + total);
        return total;
    }

    public static void main(String[] args) {
//        ProblemC.solve(1111, 2222);
        List<String> smallLinesIn = CodeHelper.loadInputLines(SMALL_IN_FILE_NAME);
        List<String> smallOuts = new ArrayList<String>();
        for (int i = 1; i < smallLinesIn.size(); i++) {
            String[] numbers = smallLinesIn.get(i).split(" ");
            int start = Integer.parseInt(numbers[0]);
            int end = Integer.parseInt(numbers[1]);
            smallOuts.add("Case #" + i + ": " + ProblemC.solve(start, end));
        }
        CodeHelper.writeOutputs(SMALL_OUT_FILE_NAME, smallOuts);
//
//        List<String> largeLinesIn = CodeHelper.loadInputLines(LARGE_IN_FILE_NAME);
//        List<String> largeOuts = new ArrayList<String>();
//        for (int i = 1; i < largeLinesIn.size(); i++) {
//            String[] numbers = largeLinesIn.get(i).split(" ");
//            int start = Integer.parseInt(numbers[0]);
//            int end = Integer.parseInt(numbers[1]);
//            largeOuts.add("Case #" + i + ": " + ProblemC.solve(start, end));
//        }
//        CodeHelper.writeOutputs(LARGE_OUT_FILE_NAME, largeOuts);
    }
}
