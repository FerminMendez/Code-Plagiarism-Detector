import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GoogleReplaced {
    static BufferedWriter bw = null;

    public static void main(String[] args) throws Exception {
        try {
            Scanner sc = new Scanner(new File("C-small-attempt.in"));
            bw = new BufferedWriter(new FileWriter("output.txt"));
            long totalCases = sc.nextLong();
            for (int i = 1; i <= totalCases; i++) {
                int finalCount = 0;
                int i1 = sc.nextInt();
                int i2 = sc.nextInt();
                int tempNum1 = i1;
                for (; tempNum1 <= i2; tempNum1++) {
                    String string = String.valueOf(tempNum1);
                    List usedList = new ArrayList();
                    for (int j = 1; j < string.length(); j++) {
                        String string1 = string.substring(string.length() - j, string
                                .length());
                        String string2 = string.substring(0, string.length() - j);
                        String newString = string1 + string2;
                        int newIntValue = Integer.parseInt(newString);

                        if ((i1 <= newIntValue) && ((i2 >= newIntValue))) {
                            if (newIntValue > tempNum1) {
                                if (!usedList.contains(newIntValue)) {
                                    usedList.add(newIntValue);
                                    finalCount = finalCount + 1;
                                }
                            }
                        }
                    }
                }
                bw.append("Case #" + i + ": ");
                bw.append(String.valueOf(finalCount));
                bw.append("\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bw.flush();
            bw.close();
        }
    }
}
