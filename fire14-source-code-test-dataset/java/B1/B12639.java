import java.util.Scanner;

/**
 *
 * @author Yasura
 */
public class C {

    public static void main(String[] args) {
        Scanner scanInt = new Scanner(System.in);
        int noOfCases = scanInt.nextInt();
        int count, length, A, B, tmp, base, invBase;
        for (int i = 0; i < noOfCases; i++) {
            count = 0;
            A = scanInt.nextInt();
            B = scanInt.nextInt();
            length = (Integer.toString(A)).length();
            for (int k = A; k <= B; k++) {
                for (int j = 1; j < length; j++) {
                    base = (int) Math.pow(10, j);
                    invBase = (int) Math.pow(10, length - j);

                    tmp = ((k % base) * invBase + k / base);
                    if (tmp > k && tmp <= B ) {
                        count++;
                    }
                }
            }
            System.out.println("Case #"+(i+1)+": "+count);
        }
    }
}
