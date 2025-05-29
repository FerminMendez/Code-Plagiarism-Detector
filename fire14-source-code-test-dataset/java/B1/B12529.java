import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: student
 * Date: 4/14/12
 * Time: 6:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class Recycled {
    private static ArrayList<String> validNumbers;
    private static int lower;
    private static int upper;

    public static void main(String[] args) {
        doProblems("50\n" +
                "13 35\n" +
                "147 992\n" +
                "116 940\n" +
                "129 926\n" +
                "130 961\n" +
                "56 58\n" +
                "882 882\n" +
                "143 642\n" +
                "163 958\n" +
                "358 767\n" +
                "113 980\n" +
                "167 914\n" +
                "1 2\n" +
                "164 920\n" +
                "185 954\n" +
                "132 929\n" +
                "150 999\n" +
                "183 992\n" +
                "123 997\n" +
                "190 990\n" +
                "184 937\n" +
                "214 517\n" +
                "177 927\n" +
                "118 983\n" +
                "117 980\n" +
                "382 382\n" +
                "178 999\n" +
                "145 958\n" +
                "149 930\n" +
                "188 915\n" +
                "119 996\n" +
                "109 975\n" +
                "148 912\n" +
                "176 980\n" +
                "184 937\n" +
                "142 991\n" +
                "164 935\n" +
                "100 100\n" +
                "134 999\n" +
                "144 986\n" +
                "185 972\n" +
                "4 4\n" +
                "101 934\n" +
                "118 953\n" +
                "180 926\n" +
                "116 969\n" +
                "100 999\n" +
                "147 998\n" +
                "161 973\n" +
                "10 99\n");
    }

    public static void doProblems(String input) {
        String[] problems = input.split("\n");
        for (int count = 0; count < Integer.valueOf(problems[0]); count++) {
            doProblem(problems[count + 1], count + 1);
        }
    }

    public static void doProblem(String input, int problemNumber) {
        validNumbers = new ArrayList<String>();
        String[] array = input.split(" ");
        lower = Integer.valueOf(array[0]);
        upper = Integer.valueOf(array[1]);
        if (upper < 10) {
            System.out.println("Case #" + problemNumber + ": " + 0);
            return;
        }
        for (int count = lower; count < upper; count++) {
            doNumber(count);
        }
        System.out.println("Case #" + problemNumber + ": " + validNumbers.size());
    }

    private static void doNumber(int n) {
        String current = String.valueOf(n);
        String nString = String.valueOf(n);
        for (int count = 0; count < nString.length(); count++) {
           // System.out.println(nString + " " + current + " " + count);
            int m = Integer.valueOf(current);

            if (m > n && m <= upper) {
               // System.out.println("KJAWHEKJHAFKJHASKJITUAW");
                String entry = nString + " " + current;
                if (!validNumbers.contains(entry)) {
                    validNumbers.add(entry);
                }
            }
            current = current.substring(current.length() - 1, current.length()) +
                    current.substring(0, current.length()-1);
        }
    }
}
