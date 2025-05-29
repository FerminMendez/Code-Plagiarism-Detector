import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

class Solution {
    private final String FILE_IN = "C-small-attempt0.in";
    private final String FILE_OUT = "C-small-attempt0.out";
    
    private final Scanner mScanner;
    private final PrintWriter mOut;

    private final int[] shifts = new int[7];
    private int shiftsCount = 0;
    
    public Solution() throws FileNotFoundException {
        mScanner = new Scanner(new FileInputStream(FILE_IN));
        mOut = new PrintWriter(new FileOutputStream(FILE_OUT));
    }
    
    public void closeFiles() {
        mScanner.close();
        mOut.close();
    }
    
    private int digitsAmount(int number) {
        int r = 0;
        while (number > 0) {
            number /= 10;
            r++;
        }
        return r;
    }
    
    private static int shiftRight(int number, int d) {
        int last = number % 10;
        for (int i = 0; i < d - 1; i++) {
            last *= 10;
        }
        
        return number / 10 + last;
    }
    
    private boolean isShiftedAlready(int shifted) {
        for (int i = 0; i < shiftsCount; i++) {
            if (shifts[i] == shifted) {
                return true;
            }
        }
        return false;
    }
    
    private void solve(int caseId, int A, int B) {
        int r = 0;
        int d = digitsAmount(A);
        
        for (int i = A; i < B; i++) {
            int shifted = i;
            shiftsCount = 0;
            for (int k = 0; k < d - 1; k++) {
                shifted = shiftRight(shifted, d);
                if (i < shifted && shifted <= B && !isShiftedAlready(shifted)) {
                    r++;
                    shifts[shiftsCount] = shifted;
                    shiftsCount++;
                }
            }
        }
        mOut.println("Case #" + (caseId + 1) + ": " + r);
    }
    
    public Solution run() {
        int n = mScanner.nextInt();
        mScanner.nextLine();
        
        for (int i = 0; i < n; i++) {
            int A = mScanner.nextInt();
            int B = mScanner.nextInt();
            if (mScanner.hasNext()) {
                mScanner.nextLine();
            }
            
            solve(i, A, B);
        }
        return this;
    }
}

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        new Solution().run().closeFiles();
    }
}
