import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class MinimumScalar extends JamProblem {
    public static void main(String[] args) throws IOException {
        MinimumScalar p = new MinimumScalar();
        p.go();
    }
    @Override
    String solveCase(JamCase jamCase) {
        MSCase c= (MSCase) jamCase;
        Arrays.sort(c.a);
        Arrays.sort(c.b);

        BigDecimal b = new BigDecimal(0);
        for (int i=0; i< c.lengh; i++) {
            BigDecimal aaa = new BigDecimal(c.a[i]);
            BigDecimal bbb = new BigDecimal(c.b[c.lengh - i - 1]);
            b = b.add(aaa.multiply(bbb));
        }
        return "" + b;
    }

    @Override
    JamCase parseCase(List<String> file, int line) {
        MSCase c= new MSCase();
        c.lineCount=3;
        int i = line;
        c.lengh = Integer.parseInt(file.get(i++));
        c.a = JamUtil.parseIntList(file.get(i++),c.lengh);
        c.b = JamUtil.parseIntList(file.get(i++),c.lengh);
        return c;
    }
}

class MSCase extends JamCase {
    int lengh;
    int[] a;
    int[] b;
}

