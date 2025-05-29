import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class C {
    public static void main (String [] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("csmall.in"));
        int count = input.nextInt();
        for (int i = 0; i < count; i++) {
            int A = input.nextInt();
            int B = input.nextInt();
            System.out.println("Case #" + (i+1) + ": " + doWork(A, B));
        }
    }
    
    private static int doWork(int a, int b) {
        int count = 0;
        int n = a;
        int m = a + 1;
        while (m <= b) {
            n = a;
            while (n < m) {
                if (checkRotation(Integer.toString(n), Integer.toString(m)))
                    count++;             
                n++;
            }
            m++;
        }
        return count;
    }

    private static boolean checkRotation(String given, String toCheck) {
        char [] giv = given.toCharArray();
        char [] temp = new char[giv.length + 1];
        int i , j , n;
        n = temp.length - 1;
        for (i = 0; i < giv.length; i++) {
            temp[i] = giv[i];
        }
        for(i = 0; i < given.length(); i++)
        {
            temp[n] = temp[0];

            for(j = 0; j < n; j++)
            {
                temp[j] = temp[j+1];
            }
            char[] moreTemp = new char[giv.length];
            for (int k = 0; k < giv.length; k++) {
                moreTemp[k] = temp[k];
            }
            if ((new String(moreTemp)).equals(toCheck)) {
                return true;
            }
            //System.out.printf("\n %s", new String(moreTemp));
        }
        return false;
    }
}
