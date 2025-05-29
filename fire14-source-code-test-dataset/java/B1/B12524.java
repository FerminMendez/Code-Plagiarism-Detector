package inam.qual;

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class C {
    public void go() {
        Scanner in = new Scanner(System.in);
        int cc = in.nextInt();
        for (int c = 1; c <= cc; c++) {
            int val = 0;
            int a = in.nextInt();
            int b = in.nextInt();
            Set<String> set = new HashSet<String>();
            for (int i = a; i <= b; i++) {
                String str = String.valueOf(i);
                for (int j = 1; j < str.length(); j++) {
                    String re = str.substring(j, str.length()) + str.substring(0, j);
                    if (str.equals(re) || re.startsWith("0") || Integer.parseInt(re) > b || a > Integer.parseInt(re)) {
                        continue;
                    }
                    String key = "";
                    if (Integer.parseInt(str) < Integer.parseInt(re)) {
                        key = str + " " + re;
                    } else {
                        key = re + " " + str;
                    }
                    set.add(key);
                }
            }
            val = set.size();
            System.out.println("Case #" + c + ": " + val);
        }
    }
    public static void main(String[] args) {
        try {
            String p = "C-small";
            String r = "qual";
            System.setIn(new FileInputStream(new File(r, p + ".in")));
            if (1 == 1) {
                System.setOut(new PrintStream(new File(r, p + ".out")));
            }
            new C().go();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
