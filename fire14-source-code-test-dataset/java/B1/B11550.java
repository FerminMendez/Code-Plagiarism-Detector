
import java.io.*;
import java.math.*;
import java.util.Arrays;
import java.util.Scanner;

public class RecycledNumbers {

    public static void main(String[] args) {
        try{
          FileWriter fw = new FileWriter("C:\\Users\\Razvan\\Documents\\NetBeansProjects\\Google Code Jam\\src\\Out.out");
            Scanner input = new Scanner(new File("C:\\Users\\Razvan\\Documents\\NetBeansProjects\\Google Code Jam\\src\\C-small-attempt0.in"));
            PrintWriter outfile;
            outfile = new PrintWriter(fw);

        int runs = input.nextInt();
        for (int i = 1; i <= runs; i++) {
            int a = input.nextInt();
            int b = input.nextInt();
            int count = 0;
            // int y = a + 1;

            for (int x = a; x <= b; x++) {
                int[] hi = null;
                if (x >= 100 && x <= 999) {

                    hi = method_threedigit(x);
                }
                if (x >= 10 && x <= 99) {
                    int num1 = x % 10;
                    int num2 = (int) (x / 10);
                    hi = method_twodigit(num2, num1);
                }
                if (x > 0 && x < 10) {
                    count = 0;
                } else {
                    Arrays.sort(hi);
                    for (int k = 0; k < hi.length; k++) {

                        if (hi[k] > x && hi[k] <= b) {
                            if (hi[k] > hi[k - 1]) {  //get rid of repeat...
                                count++;
                            }
                        }
                    }

                }
            }

            outfile.println("Case #" + i + ": " + count);
        }
        input.close();
            fw.close();
            outfile.close();
        }catch (Exception e){
            System.out.println(e);
        }

    }

    static int[] method_threedigit(int b) {
        int[] a = new int[6];
        a[0] = (b % 10) * 100 + (int) (b / 10);
        a[1] = (b % 100) * 10 + (int) (b / 100);

        return a;
    }

    static int[] method_twodigit(int a1, int a2) {
        int a[] = new int[2];
        a[0] = a1 * 10 + a2;
        a[1] = a2 * 10 + a1;
        return a;
    }
}