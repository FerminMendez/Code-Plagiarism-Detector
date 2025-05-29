
package codejam2012.qualification;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("B-small-attempt0.in"));
        System.setOut(new PrintStream(new FileOutputStream("B-small-attempt0.out")));
        Scanner in = new Scanner(System.in);
        int testCase = in.nextInt();
        
        for(int i = 1; i <= testCase; i++) {
            int count = 0, count2 = 0;
            
            int n = in.nextInt();
            int s = in.nextInt();
            int p = in.nextInt();
            for(int j = 0; j < n; j++) {
                int t = in.nextInt();
                if(t >= 3*p-2)
                    count++;
                else if(3*p-4 >= 0 && t >= 3*p-4)
                    count2++;
            }
            count += (count2>s? s: count2);
            System.out.printf("Case #%d: %d%n", i, count);
        }
    }
}
