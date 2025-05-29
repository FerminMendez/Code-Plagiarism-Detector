import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.Scanner;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class RecycledNumbers {
    private static int[][] testCases = null;
    private static int numTestCases;
    private static HashMap<String, String> visitedNumbers;

    public static void main(String[] args) throws IOException {
        change();
        if (true)
            return;

        readInput();
        visitedNumbers = new HashMap<String, String>();

        PrintWriter out = new PrintWriter(new FileWriter("D:\\amir\\codejam\\out.txt"));
        for (int i = 0; i < numTestCases; i++)
        {
            int count = countRecycled(testCases[i][0], testCases[i][1]);
            int m = i + 1;
            out.write("Case #" + m + ": " + count);
            out.println();
            System.out.println(count);
        }

        out.flush();
        out.close();
    }

    public RecycledNumbers() {
    }

    private static void change() throws IOException {
          InputStream inputStream = new FileInputStream("D:\\amir\\codejam\\out.txt");
          StringWriter writer = new StringWriter();
          IOUtils.copy(inputStream, writer);
          String theString = writer.toString();
          theString = theString.replaceAll(" Case", "\nCase");
        
          System.out.println(theString);
          
    }
    private static void readInput() throws IOException {
        InputStream inputStream = new FileInputStream("D:\\amir\\codejam\\csmall22.txt");
        Scanner scanner = new Scanner(inputStream);

        numTestCases = scanner.nextInt();
        testCases = new int[numTestCases][2];
        for (int i = 0; i < numTestCases; i++) {
            testCases[i][0] = scanner.nextInt();
            testCases[i][1] = scanner.nextInt();
        }

        inputStream.close();
    }

    private static Integer[] getNewNumbers(int n) {
        if (n < 1
//                || visitedNumbers.get(n) != null
                )
            return null;

        String aStr = String.valueOf(n);
        int c = 0;
        if (aStr.length() > 1) {
            char[] chs = aStr.toCharArray();
            for (int i = 0; i < aStr.toCharArray().length - 1; i++)
                if (chs[i] == chs[i+1])
                    c++;
        }
        if (c == aStr.length() - 1)
            return null;

        Integer[] newNumbers = new Integer[aStr.length() - 1];

        for (int i = 0; i < aStr.length() - 1; i++) {
            String rec = getRecycled(i + 1, aStr);
            if (rec == null) {
                newNumbers[i] = null;
                continue;
            }
            newNumbers[i] = Integer.valueOf(rec);
        }

        return newNumbers;
    }

    static int countRecycled(int n, int m) {
        int count = 0;
        for (int i = n; i <= m; i++) {
            Integer[] newNumbers = getNewNumbers(i);
            if (newNumbers == null)
                continue;

            for (int j = 0; j < newNumbers.length; j++) {
                if (newNumbers[j] == null)
                    continue;

                if (newNumbers[j] <= m) {

                    if (i == 111)
                        System.out.println("");

                    String v1 = visitedNumbers.get(newNumbers[j] + "-" + i);

                    if (v1 == null)
                        count++;

                    visitedNumbers.put(i + "-" + newNumbers[j], "" + newNumbers[j]);
                    System.out.println(i + "-" + newNumbers[j]);
                }
            }
        }

        return count;
    }

    private static String getRecycled(int index, String number) {
        String num1 = number.substring(0, index);

        String num2 = number.substring(index, number.length());

//        if (num1.equals(num2))
//            return null;

        String str = num2 + num1;

//        if (str.startsWith("0"))
//            return null;
        
        return str;
    }
}
