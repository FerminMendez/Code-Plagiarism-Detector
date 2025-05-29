
package codejam2012.qualification;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ProblemC {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("C-small-attempt0.in"));
        System.setOut(new PrintStream(new FileOutputStream("C-small-attempt0.out")));
        Scanner in = new Scanner(System.in);
        int testCase = in.nextInt();
        Set<Integer> duplicates = new TreeSet<>();
        
        for(int i = 1; i <= testCase; i++) {
            int a = in.nextInt(),
                b = in.nextInt();
            int count = 0;
            
            for(int n = a; n < b; n++) {
                String s = String.valueOf(n);
                String s2 = s+s;
                
                duplicates.clear();
                for(int j = 1, len = s.length(); j < len; j++) {
                    int m = Integer.parseInt(s2.substring(j, j+len));
                    if(m > n && m <= b && !duplicates.contains(m)) {
                        count++;
                        duplicates.add(m);
                    }
                }
            }
            System.out.printf("Case #%d: %d%n", i, count);
        }
    }
}
