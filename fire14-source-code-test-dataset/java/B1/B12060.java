import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class C {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("c0.in"));
        PrintStream outputStream = new PrintStream(new FileOutputStream("c.out"));
//        PrintStream outputStream = System.out;
        int n = scanner.nextInt();
//        System.out.println(n);

        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            outputStream.println("Case #" + (i+1) + ": " + ile(a, b));
        }
    }

    private static int ile(int a, int b) {
        int para = 0;
        int ilenie = 0;

        int next = a;

        while (next <= b) {
            String now = String.valueOf(next);

//            if (!uzyte.contains(now)) {
                int przed = para;
            Set<String> uzyte = new HashSet<String>();
            for (int i = 0; i < ilecyfr(next)-1; i++) {
                    now = rotuj(now);
                    int nowInt = Integer.valueOf(now);
//                    if (ilecyfr(next) != ilecyfr(nowInt)) {
//                        continue;
//                    }

                    if (nowInt >= a && nowInt <= b && nowInt != next && !uzyte.contains(now)) {
//                        if (now > next) {
//                            System.out.println("hehe " + now + " " + next);
//                        }

//                        System.out.println(next + " " + now);
                        para++;
                        uzyte.add(now);
                    }
                }
                if (przed == para) {
                    ilenie++;
//                    System.out.println(next);

                }
//            } else {
//                System.out.println(now + " used");
//            }
            next++;
        }
//        System.out.println(ilenie);
//        return b - a - ilenie;
        return para / 2;
    }

    private static String rotuj(String n) {
        String s = String.valueOf(n);
        String substring = s.substring(1);
        return substring + s.charAt(0);

//        int len = ilecyfr(n);
//        int reszta = n %10;
//        n/=10;
//        return (int) (n + (reszta * Math.pow(10, len - 1)));
    }

    private static int ilecyfr(int n) {
        int ile = 0;
        while (n > 0) {
            ile++;
            n/=10;
        }
        return ile;
    }
}
