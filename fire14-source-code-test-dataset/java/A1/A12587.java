import java.io.IOException;
import java.util.List;

public class Dancing extends JamProblem {

    public static void main(String[] args) throws IOException {
        Dancing p = new Dancing();
        p.go();
    }

    @Override
    String solveCase(JamCase jamCase) {
        int res = 0;
        DancingCase ca = (DancingCase) jamCase;
        for (int i = 0; i < ca.sums.length; i++) {
            int sum = ca.sums[i];
            if (sum == 0) {
                if (ca.p == 0) {
                    res++;
                }
                continue;
            }
            int n = sum % 3;
            int one = sum / 3;
            if (n == 0) {
                if (one >= ca.p) {
                    res++;
                    continue;
                }
                if (ca.sup > 0) {
                    if (one + 1 >= ca.p) {
                        res++;
                        ca.sup--;
                    }
                }
            }

            if (n == 1) {

                if (one + 1 >= ca.p) {
                    res++;
                }
            }
            if (n == 2) {
                if (one + 1 >= ca.p) {
                    res++;
                    continue;
                }

                if (ca.sup > 0) {
                    if (one + 2 >= ca.p) {
                        res++;
                        ca.sup--;
                    }
                }
            }
        }
        return "" + res;
    }

    @Override
    JamCase parseCase(List<String> file, int line) {
        DancingCase ca = new DancingCase();
        ca.lineCount = 1;
        String s = file.get(line);
        List<Integer> integers = JamUtil.parseIntList(s);
        int gs = integers.get(0);
        ca.sup = integers.get(1);
        ca.p = integers.get(2);
        ca.sums = new int[gs];
        for (int i = 0; i < gs; i++) {
            ca.sums[i] = integers.get(3 + i);
        }

        return ca;
    }
}

class DancingCase extends JamCase {
    int p;
    int[] sums;
    int sup;
}