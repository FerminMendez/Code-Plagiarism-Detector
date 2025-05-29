import java.io.IOException;
import java.util.List;

public class StoreCredit extends JamProblem {
    public static void main(String[] args) throws IOException {
        StoreCredit problem= new StoreCredit();
        problem.go();
    }

    @Override
    String solveCase(JamCase jamCase) {
        StoreCreditCase cas = (StoreCreditCase) jamCase;
        for (int i=0; i<cas.itemCount; i++) {
            for (int j=0; j<cas.itemCount; j++) {
                if (i==j) {
                    continue;
                }
                if (cas.prices[i] + cas.prices[j] == cas.credit) {
                    return "" + (i+1) + " " + (j+1);
                }
            }
        }
        throw new RuntimeException();
    }

    @Override
    JamCase parseCase(List<String> file, int line) {
        StoreCreditCase cas = new StoreCreditCase();
        String fist =  file.get(line);
        String second =  file.get(line+1);
        String third =  file.get(line+2);
        cas.credit= Integer.parseInt(fist);
        cas.lineCount = 3;
        cas.itemCount = Integer.parseInt(second);
        cas.prices = JamUtil.parseIntList(third, cas.itemCount);
        return cas;
    }
}

class StoreCreditCase extends JamCase {
    int itemCount;
    int[] prices;
    public int credit;
}
