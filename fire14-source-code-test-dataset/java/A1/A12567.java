import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;

public class Welcome extends JamProblem {

    String welc = "welcome to code jam";

    public static void main(String[] args) throws IOException {
        Welcome p = new Welcome();
        p.go();
    }

    @Override
    String solveCase(JamCase jamCase) {
        WelcomeCase cas = (WelcomeCase) jamCase;
        int length = welc.length();
        int strL = cas.str.length();
        String str = cas.str;

        int[][] tab = new int[length][strL];
        for (int i = length - 1; i >= 0; i--) {
            char c = welc.charAt(i);
            for (int j = strL - 1; j >= 0; j--) {
                if (i == length - 1) {
                    if (j == strL - 1) {
                        tab[i][j] = str.charAt(j) == c ? 1 : 0;
                    } else {
                        tab[i][j] = mod(tab[i][j + 1] + (str.charAt(j) == c ? 1 : 0));
                    }
                } else {
                    if (j == strL - 1) {
                        tab[i][j] = 0;
                    } else {
                        tab[i][j] = mod(tab[i][j + 1] + (str.charAt(j) == c ? 1 : 0) * tab[i + 1][j]);
                    }
                }
            }
        }
        NumberFormat nf = NumberFormat.getInstance(); // Get Instance of NumberFormat
        nf.setMinimumIntegerDigits(4); // The minimum Digits required is 5
        nf.setMaximumIntegerDigits(4); // The maximum Digits required is 5
        nf.setGroupingUsed(false);
        return nf.format(tab[0][0]);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    JamCase parseCase(List<String> file, int line) {
        WelcomeCase cas = new WelcomeCase();
        cas.lineCount = 1;
        cas.str = file.get(line);
        return cas;
    }

    int mod(int i) {
        return i % 10000;
    }
}

class WelcomeCase extends JamCase {
    String str;
}
