import sun.rmi.runtime.NewThreadAction;

import java.io.*;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: Veniversum
 * Date: 4/15/12
 * Time: 2:26 AM
 */
public class Q3 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("in.txt")));
            Scanner scanner = new Scanner(new FileInputStream("in.txt"));
            int cases = scanner.nextInt();
            scanner.nextLine();
            String output="";
            for (int i= 0;i<cases;i++){
                HashSet<String> results = new HashSet<String>();
                Scanner sc = new Scanner(scanner.nextLine());
                int A = sc.nextInt();
                int B = sc.nextInt();
                int n;
                int m;
                for (int j = A; j <= B;j++) {
                    n = j;
                    m = j;
                    String str = ("" + m);
                    for (int k = 0; k < ("" + m).length();k++) {
                        if (A <= n && n < m && m <= B) {
                            results.add(m + "," + n);
                        }
                        str = str.concat("" + str.charAt(0)); //adds first digit to end
                        str = str.substring(1); //remove first digit
                        m = Integer.parseInt(str);
                    }
                }
                output += "Case #" + (i+1) + ": " + results.size() + "\n";
                PrintWriter outp = new PrintWriter(new FileOutputStream("out.txt"));
                  outp.print(output);
                outp.close();
            }
            System.out.print(output);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
