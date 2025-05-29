package algorithm.adhoc;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 4/15/12
 * Time: 1:00 AM
 * To change this template use File | Settings | File Templates.
 */
public class GoogleCodeJam {
    public static void main(String[] arg) throws IOException {
        Scanner scanner = new Scanner(new FileReader("G:\\C-small-attempt1.in"));
        PrintWriter pw = new PrintWriter("output.txt");
        int t, tcase = 1;
        int a, b, start, end, temp;
        int count = 0;
        t = scanner.nextInt();
        String tempStr, tempStr2;
        char[] chars;
        char tmp, temp1;
        while (t > 0) {
            count = 0;
            a = scanner.nextInt();
            b = scanner.nextInt();
            start = a;
            end = b;
            for (int i = start; i <= end; ++i) {
                tempStr = Integer.toString(i);
                if (tempStr.length() != 1) {
                    if (tempStr.length() == 2) {
                        chars = tempStr.toCharArray();
                        tmp = chars[0];
                        chars[0] = chars[1];
                        chars[1] = tmp;
                        tempStr2 = new String(chars);
                        temp = Integer.parseInt(tempStr2);
                        if (temp > i && temp <= b) ++count;
                    } else if (tempStr.length() == 3) {
                        chars = tempStr.toCharArray();
                        tmp = chars[0];
                        chars[0] = chars[2];
                        chars[2] = tmp;
                        tmp = chars[1];
                        chars[1] = chars[2];
                        chars[2] = tmp;
                        tempStr2 = new String(chars);
                        temp = Integer.parseInt(tempStr2);
                        if (temp > i && temp <= b) ++count;
                        chars = tempStr.toCharArray();
                        tmp = chars[0];
                        chars[0] = chars[1];
                        chars[1] = tmp;
                        tmp = chars[1];
                        chars[1] = chars[2];
                        chars[2] = tmp;
                        tempStr2 = new String(chars);
                        temp = Integer.parseInt(tempStr2);
                        if (temp > i && temp <= b) ++count;
                    }
                }
            }

            //System.out.println(count);
            pw.println("Case #" + tcase + ": " + count);
            --t;
            ++tcase;
        }
        pw.close();
        scanner.close();
    }
}
