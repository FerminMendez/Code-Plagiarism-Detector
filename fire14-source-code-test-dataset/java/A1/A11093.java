import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

class Solution {
    private final String FILE_IN = "B-small-attempt0.in";
    private final String FILE_OUT = "B-small-attempt0.out";
    
    private final Scanner mScanner;
    private final PrintWriter mOut;

    private final boolean perm[] = new boolean[101];
    
    public Solution() throws FileNotFoundException {
        mScanner = new Scanner(new FileInputStream(FILE_IN));
        mOut = new PrintWriter(new FileOutputStream(FILE_OUT));
    }
    
    public void closeFiles() {
        mScanner.close();
        mOut.close();
    }
    
    static private boolean canHaveP(int summ, int p, boolean s) {

        int modulo = summ % 3;
        int div = summ / 3;
        
        if (modulo == 0) {
            return div + ((s) ? ((summ >= 1) ? 1 : 0) : 0) >= p;
        }

        if (modulo == 1) {
            return div + ((summ >= 1) ? 1 : 0) >= p;
        } else {
            int max = div;
            if (s && summ >= 2) {
                max += 2;
            } else if (summ >= 1) {
                max += 1;
            }
            
            return max >= p;
        }
    }
    
    private boolean nextPerm(int n) {
        int trues = 0;
        for (int i = 0; i < n - 1; i++) {
            if (!perm[i]) {
                continue;
            }
            if (!perm[i + 1]) {
                perm[i + 1] = true;
                
                for (int j = 0; j <= i; j++) {
                    perm[j] = j < trues;
                }
                return true;
            } else {
                trues++;
            }
        }
        
        return false;
    }
    
    void solve(int caseId, int n, int s, int p, int[] ti) {
        for (int i = 0; i < n + 1; i++) {
            perm[i] = i < s;
        }
        
        int maxSurprises = 0;
        do {
            int surprises = 0;
            for (int i = 0; i < n; i++) {
                if (canHaveP(ti[i], p, perm[i])) {
                    surprises++;
                }
            }
            if (surprises > maxSurprises) {
                maxSurprises = surprises;
            }
            
        } while (nextPerm(n));

        mOut.println("Case #" + (caseId + 1) + ": " + maxSurprises);
    }
    
    Solution run() {
        int t = mScanner.nextInt();
        mScanner.nextLine();

        int[] ti = new int[100];
        
        for (int i = 0; i < t; i++) {
            int n = mScanner.nextInt();
            int s = mScanner.nextInt();
            int p = mScanner.nextInt();
            
            for (int j = 0; j < n; j++) {
                ti[j] = mScanner.nextInt();
            }
            if (mScanner.hasNext()) {
                mScanner.nextLine();
            }

            solve(i, n, s, p, ti);
        }
        return this;
    }
}


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        new Solution().run().closeFiles();
    }
}
