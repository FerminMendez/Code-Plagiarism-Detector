package taskc;

import java.util.*;

public class TaskC {

    public static void main(String[] args) {
        new TaskC().main();
    }
    
    int numOfDigits(int x) {
        int res = 0;
        while (x > 0) {
            res++;
            x /= 10;
        }
        return res;
    }
    
    int getCycle(int n, int i) {
        String s = Integer.toString(n);
        int leftlen = s.length() - i;
        String res = s.substring(leftlen) + s.substring(0, leftlen);
        return Integer.parseInt(res);
    }
    
    Set<Integer> generateCycleNumbers(int x) {
        Set<Integer> res = new HashSet<Integer>();
        int n = numOfDigits(x);
        for (int i = 1; i < n; i++) {
            int z = getCycle(x, i);
            if (numOfDigits(z) == numOfDigits(x)) {
                res.add(z);
            }
        }
        return res;
    }
    
    int f(int x, int y) {
        int res = 0;
        
        for (int i = x; i <= y; i++) {
            Set<Integer> cycles = generateCycleNumbers(i);
            for (int q: cycles) {
                if (q >= x && q <= y && q != i) {
                    //System.out.println(i +" -> " + q);                    
                    res++;
                }
            }
        }
        
        return res/2;
    }
    
    void main() {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int i = 1; i <= T; i++) {
            int a = s.nextInt(), b = s.nextInt();
            int ans = f(a, b);
            System.out.println("Case #" + i + ": " + ans);
        }
    }
}
