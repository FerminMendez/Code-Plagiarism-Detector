package Main;

import com.sun.deploy.util.ArrayUtil;
import org.apache.commons.lang3.ArrayUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: arran
 * Date: 14/04/12
 * Time: 3:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class Round {
    public StringBuilder parse(BufferedReader in) throws IOException {
        StringBuilder out = new StringBuilder();
        String lineCount = in.readLine();

        for (int i = 1; i <= Integer.parseInt(lineCount); i++)
        {
            out.append("Case #"+i+": ");
            String line = in.readLine();
            String[] splits = line.split(" ");
            int googlers = Integer.valueOf(splits[0]);
            int surprisingScores = Integer.valueOf(splits[1]);
            int bestScore = Integer.valueOf(splits[2]);
            String[] totalsStr = Arrays.copyOfRange(splits, 3, 3 + googlers);
            ArrayList<Integer> totalsIntList = new ArrayList<Integer>();
            for (String str : totalsStr)
            {
                totalsIntList.add(Integer.valueOf(str));
            }
            int[] totals = ArrayUtils.toPrimitive(totalsIntList.toArray(new Integer[0]));
            int r = findOutScore(surprisingScores, bestScore, totals);
            out.append(r);

//            if (i < Integer.parseInt(lineCount))
                out.append("\n");
        }
        return out;
    }

    public static int findOutScore(int surprisingScores, int bestScore, int[] totals) {
        int result = 0;
        for (int total : totals)
        {
            int remTotal = total - bestScore;
            if (remTotal < 0) continue;
            if (bestScore - (remTotal / 2) > 2) continue;
            if (bestScore - (remTotal / 2) == 2)
                if (surprisingScores > 0)
                {
                    surprisingScores--;
                } else continue;
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        InputStreamReader converter = null;
        try {
            int attempt = 0;
            converter = new InputStreamReader(new FileInputStream("src/resource/B-small-attempt"+attempt+".in"));
            BufferedReader in = new BufferedReader(converter);
            Round r = new Round();
            String str = r.parse(in).toString();
            System.out.print(str);
            FileOutputStream fos = new FileOutputStream("B-small-attempt"+attempt+".out");
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(str);
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
