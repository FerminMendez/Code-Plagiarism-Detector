package RecycledNumbers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

/**
 *
 * @author Nikhil
 */
public class c {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File fInput = new File(args[0]);
        String tmp;
        BufferedReader br = new BufferedReader(new FileReader(fInput));
        int iTestCases = Integer.parseInt(br.readLine());
        int A, B, iCase = 1;
        while (null != (tmp = br.readLine())) {
            A = Integer.parseInt(tmp.split(" ")[0]);
            B = Integer.parseInt(tmp.split(" ")[1]);
            System.out.println("Case #" + iCase + ": " + findRecycled(A, B));
            iCase++;
        }
        br.close();
    }

    private static int findRecycled(final int A, final int B) {
        int iRecycled = 0;
        int iRemainder, m, iTenPowMove;
        int iRemainderB;
        String sUnqNM;
        HashSet<String> hsRecycled = new HashSet<String>();
        final int B_LEN = String.valueOf(B).length() - 1;
        if (B < 10) {
            return 0;
        }
        //System.out.println("A=" + A + "\tB=" + B);
        //dblRemainderB = B / Math.pow(10d, (double) (String.valueOf(B).length() - 1));
        for (int iMoveDigitCount = 1; iMoveDigitCount <= B_LEN; iMoveDigitCount++) {
            // Increament 10^x to compute last digit from A
            iTenPowMove = (int) Math.pow(10d, (double) iMoveDigitCount);
            // Get the MSB digits from B to optimize algo
            iRemainderB = Integer.parseInt(String.valueOf(B).substring(0, iMoveDigitCount));
            for (int n = A; n <= B; n++) {
                iRemainder = n % iTenPowMove;
                if (0 == iRemainder || n < iTenPowMove) {
                    continue;
                } else if (iRemainder > iRemainderB) {
                    //iMoveDigitCount++;
                    n += iTenPowMove - iRemainder;
                    continue;
                } else {
                    String strM = null;
                    StringBuilder sb = new StringBuilder(String.valueOf(n));
                    int iPre = sb.length() - iMoveDigitCount;
                    try {
                     strM = sb.substring(iPre) + sb.substring(0, iPre);
                    } catch (StringIndexOutOfBoundsException ex) {
                        System.out.println("sb=" + iRemainder + "\niPre=" + iPre);
                        throw ex;
                    }
                    m = Integer.parseInt(strM);
                    if (m <= n) {
                        continue;
                    } else if (m <= B) {
                        sUnqNM = String.valueOf(n) + String.valueOf(m);
                        if (!hsRecycled.contains(sUnqNM)) {
                            hsRecycled.add(sUnqNM);
                            iRecycled++;
                       }
                    }
                }
            }
        }
        return iRecycled;
    }

}
