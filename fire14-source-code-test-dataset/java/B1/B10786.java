package jam_q_c_s;
import java.util.*;

public class Jam_Q_C_S {

    public static void main(String[] args) {
        int[] A = {116,144,168,240,165,169,170,142,202,162,15,171,10,164,135,169,120,10,125,177,142,135,146,180,160,142,156,183,173,158,103,11,164,1,144,190,110,146,158,6,100,122,187,823,123,319,100,248,115,188};
        int[] B = {963,996,994,925,918,924,926,911,353,970,53,952,99,972,954,913,965,99,990,931,942,910,924,950,918,944,996,967,996,970,999,34,926,1,923,956,944,977,978,7,101,941,924,823,941,319,920,857,939,990};
        for(int i=0; i<A.length; i++)
            System.out.println("Case #" + (i+1) + ": " + numTot(A[i], B[i]));
    }

    public static int numTot(int A, int B) {
        int r = 0;
        for (int X = A; X <= B; X++) {
            Set<Integer> T = new HashSet<Integer>();
            String x = "" + X;
            for (int i = 0; i < x.length() - 1; i++) {
                int Y = Integer.parseInt(x = x.substring(1) + x.charAt(0));
                if (Y > X && Y <= B) T.add(Y);
            }
            r += T.size();
        }
        return r;
    }
}