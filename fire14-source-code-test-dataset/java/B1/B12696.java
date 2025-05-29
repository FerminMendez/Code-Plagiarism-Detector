import java.awt.print.Printable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class C {
    public static void main(String[] args) throws IOException {
        Scanner scanner = null;
        scanner = new Scanner(new File("C-small-attempt0.in"));
//        scanner = new Scanner(System.in);
        FileWriter writer = new FileWriter("C.out");
        int t = scanner.nextInt();
        for (int tt = 1; tt <= t ; tt ++ ) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            
            String str;
            int k;
            int ans = 0;
            String tmp;
            for (int i = a; i <= b; i ++) {
                str = Integer.toString(i);
                if (str.length() > 1) {
                    for (int j = 1; j < str.length(); j++) {
                        tmp = str.substring(j, str.length())
                        + str.substring(0,j);
                        if (tmp.startsWith("0")) continue;
                        k = Integer.parseInt(tmp);
                        if (k >=a && k <= b && k > i) ans ++;
                    }
                }
            }
            
            writer.write(String.format("Case #%d: %d\n", tt,ans));
            System.out.println(String.format("Case #%d: %d\n", tt,ans));
        }
        writer.close();
    }

}
