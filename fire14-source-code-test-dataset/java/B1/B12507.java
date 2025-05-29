
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Chung Lee
 */
public class RecycleNumber {
    
    public static void Main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File(args[0]));
        
        PrintWriter writer = new PrintWriter(args[1]);

        int noCase = scanner.nextInt();

        for (int i = 0; i < noCase; i++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();

            int noRecyclePair = 0;
            for (int j = A; j <= B; j++) {
                noRecyclePair += getNoRecyclePair(j, A, B);
            }

            noRecyclePair /= 2;

            System.out.print(String.format("Case #%d: %d", i + 1, noRecyclePair));
            writer.print(String.format("Case #%d: %d", i + 1, noRecyclePair));

            if (i != noCase - 1) {
                System.out.println();
                writer.println();
            }
        }
        writer.close();
    }

    public static int getNoRecyclePair(int num, int A, int B) {
        int temp = num;
        int digits = 0;
        while (temp != 0) {
            temp /= 10;
            digits++;
        }

        int noRecyclePair = 0;
        
        
        for (int i = 1; i <= digits; i++) {
            int recycleNum = (int) ((num % Math.pow(10, i)) * Math.pow(10, digits - i)
                    + (num / Math.pow(10, i)));
            if (recycleNum != num
                    && recycleNum >= A
                    && recycleNum <= B) {
                noRecyclePair++;
                    
            }
        }

        return noRecyclePair;

    }
}
