package DancingGooglers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Nikhil
 */
public class b {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File fInput = new File(args[0]);
        String tmp;
        if (fInput.exists() && fInput.isFile()) {
            BufferedReader br = new BufferedReader(new FileReader(fInput));
            int iTestCases = Integer.parseInt(br.readLine());
            int iCase = 1;
            while (null != (tmp = br.readLine())) {
                Danscore d = new Danscore(tmp);
                d.solve();
                System.out.println("Case #" + iCase + ": " + d);
                iCase++;
            }
            br.close();
        }
    }
}

class Danscore {

    private int iBestScoreDancers;
    private int iDancers;
    private int iSurprises;
    private int iBestScore;
    private List<Integer> scores;

    Danscore(String tmp) {
        String[] inp = tmp.split(" ");
        iDancers = Integer.parseInt(inp[0]);
        iSurprises = Integer.parseInt(inp[1]);
        iBestScore = Integer.parseInt(inp[2]);
        scores = new ArrayList<Integer>();
        for (int i = 3; i < inp.length; i++) {
            scores.add(Integer.parseInt(inp[i]));
        }
        Collections.sort(scores, Collections.reverseOrder());
    }

    void solve() {
        iBestScoreDancers = 0;
        // Minimum score required to qualify as best score + has Surprises
        int iMinimumReq = iBestScore + (iBestScore - 2) + (iBestScore - 2);
        // Make sure minimum required score is positive
        iMinimumReq = iMinimumReq<0? 0:iMinimumReq;
        // Normal scores required if Suprises are exausted
        int iNormalScore = iBestScore + (iBestScore - 1) + (iBestScore - 1);
        iNormalScore = iNormalScore<0? 0:iNormalScore;

        Iterator<Integer> itr = scores.iterator();
        while (itr.hasNext()) {
            int iscore = itr.next();
            if (iscore < iBestScore) continue;
            if (iscore >= iNormalScore) {
                iBestScoreDancers++;
                continue;
            }
            if (iSurprises > 0 && iscore >= iMinimumReq) {
                iBestScoreDancers++;
                iSurprises--;
            }
        }
    }

    @Override
    public String toString() {
        return String.valueOf(iBestScoreDancers);
    }
}
