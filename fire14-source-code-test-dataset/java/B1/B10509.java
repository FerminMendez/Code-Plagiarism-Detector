import java.util.HashMap;
import java.util.Scanner;


public class Recycle {
    
    private static HashMap<Pair2, Boolean> mCache = new HashMap<Pair2, Boolean>();
    
    public static boolean isRecycle(int a, int b) {
        if (a >= b) return false;
        Pair2 p = new Pair2(a, b);
        Boolean cacheValue = mCache.get(p);
        if (cacheValue != null) return cacheValue;
        
        //System.out.println("isRecycle(" + a + ", " + b + ")");
        
        int len = (int)Math.floor(Math.log10(b));
        for (int i = 0; i < len; i++) {
            b = b / 10 + (b % 10) * pow10(len);
            //System.out.println(b);
            if (a == b) {
                mCache.put(p, true);
                return true;
            }
        }
        
        mCache.put(p, false);
        return false;
    }
    
    public static int pow10(int pow) {
        int ret = 1;
        for (int i = 0; i < pow; i++) {
            ret *= 10;
        }
        return ret;
    }
    
    public static int countRecycle(int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            for (int j = i; j <= end; j++) {
                if (isRecycle(i, j)) {
                    count++;
                }
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        
        for (int i = 0; i < num; i ++) {
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println("Case #" + (i + 1) + ": " + countRecycle(a, b));
        }
    }
}
