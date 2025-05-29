import com.sun.org.apache.bcel.internal.generic.AALOAD;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RecycledNum extends JamProblem {
    public static void main(String[] args) throws IOException {
        RecycledNum p = new RecycledNum();
        p.go();
    }

    @Override
    String solveCase(JamCase jamCase) {
        RecNCase ca = (RecNCase) jamCase;
        int res = 0;
        for (int n = ca.A; n < ca.B; n++) {
            String m = "";
            //print("n "+n);
            Set<Integer> bag = new HashSet<>();
            int length = intLength(n);
            for (int t = 1; t < length; t++) {
                int pow = (int) Math.pow(10, t);
                int pow2 = (int) Math.pow(10,length-t);
                int f = (n / pow);
                int s = n - (pow * f);
                int cand = f + (pow2 * s);
                //print("m " + cand);
                if (cand < ca.A || cand > ca.B || cand <= n) {
                    continue;
                }
                if (bag.contains(cand)) {
                    continue;
                }
                if (intLength(cand) != intLength(n)) {
                    continue;
                }
                res++;
                bag.add(cand);
                //print(""+ n+ " " + cand);
            }
        }
        return "" + res;
    }

    private void print(String m) {
        System.out.println(m);
    }

    private int intLength(int n) {
        return Integer.toString(n).length();
    }

    @Override
    JamCase parseCase(List<String> file, int line) {
        RecNCase ca = new RecNCase();
        ca.lineCount = 1;
        String s = file.get(line);
        int[] ints = JamUtil.parseIntList(s, 2);
        ca.A = ints[0];
        ca.B = ints[1];
        return ca;
    }
}

class RecNCase extends JamCase {
    int A, B;
}
