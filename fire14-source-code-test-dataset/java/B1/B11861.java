package com.google.code.jam2012.problemC;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Vahid
 * Date: 4/14/12
 * Time: 6:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProblemC1 {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new FileInputStream("data.in"));

        FileOutputStream out = new FileOutputStream("C1.out");
        long a, b, m,n;
        int lines = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i<=lines; i++){
            a = scanner.nextLong();
            b = scanner.nextLong();
            out.write(("Case #"+i+": "+ calculate(a, b)).getBytes());
            out.write('\r');
            out.write('\n');
            if (scanner.hasNextLine()) scanner.nextLine();
        }
        scanner.close();
        out.close();
    }

    private static long calculate(long a, long b) {
        long logarithm = 1;
        long counter = 0;
        int len = 1;
        while (logarithm * 10 <= b) {
            logarithm *= 10;
            len++;
        }
        HashSet<Long> list;
        for (long n = a; n<b; n++) {
            list = new HashSet<Long>(100);
            long m = n;
            for (int i=1; i<len; i++){
                m = (m %10) *logarithm + (m/10);
                if ((n<m) && (m<=b) && (!list.contains(new Long(m)))) {
                    counter++;
                    list.add(new Long(m));
                }
            }
        }
        return  counter;
    }

}
