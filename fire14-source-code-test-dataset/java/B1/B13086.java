import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: aeg
 * Date: 12/04/14
 * Time: 22:58
 * To change this template use File | Settings | File Templates.
 */
public class ReceycledNumbers {
    public static void main (String[] argc) throws FileNotFoundException {
        ReceycledNumbers  renum = new ReceycledNumbers();
        renum.solve();

    }

    private void solve() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("csv/QR_C/C-small-attempt1.in");
        Scanner sc = new Scanner(fis);

        int T = sc.nextInt();

        loop:
        for (int i = 0; i < T; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int count =0;

            System.out.print("Case #"+(i+1)+": ");
     //      System.out.println("A is " + A + ",M is " + M);
            if (B < 10) {
                System.out.println("0");
                continue;
            }
            for (int j = A; j < B; j++) {
                String str = ((Integer) j).toString();
              //  System.out.println(str +"**");
                count +=tryRecycle(str, j, B);

            }
            System.out.println(count);
        }
      }

    private int tryRecycle(String str, int j, int b) {
        int count=0;
        for(int i=1;i<str.length();i++){
            String s2 = str.substring(str.length()-i,str.length()) + str.substring(0,str.length()-i);
            Integer i2 = Integer.valueOf(s2);
            if ((j < i2) && (i2 <= b)) {
                count++;
            }
        }
        return count;
    }


}
