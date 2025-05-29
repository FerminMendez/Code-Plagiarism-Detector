

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author Gershom
 */
public class DancingWithGooglers {

    public static void main(String[] args0) {
        try {
            File f = new File("example");
            Scanner s = new Scanner(new FileReader(f));
            int num = Integer.parseInt(s.nextLine());
            for (int i = 0; i < num; i++) {
                String line = s.nextLine();
                int[] dat = new int[3];
                intList(line, dat);
                int numGooglers = dat[0];
                int numSurprising = dat[1];
                int p = dat[2];
                int[] scoresTemp = new int[3 + numGooglers];
                intList(line, scoresTemp);
                int[] scores = new int[numGooglers];
                for (int j = 0; j < scores.length; j++) {
                    scores[j] = scoresTemp[j + 3];
                }
                
                System.out.println("Case #" + (i + 1) + ": " + 
                        calcNumBest(numSurprising, p, scores));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static int calcNumBest(int sur, int p, int[] scores) {
        int numSurprisingRequired = 0;
        int num = 0;
        
        for (int i = 0; i < scores.length; i++) {
            switch (scoreBreakdown(scores[i], p)) {
                case 1:
                    numSurprisingRequired++;
                    break;
                case 2:
                    num++;
                    break;
            }
        }
        
        return num + Math.min(sur, numSurprisingRequired);
    }
    
    /**
     * 0 means target can't be met, 1 means it can be met if it's "surprising",
     * 2 means it can be met without being surprising.
     * @param best
     * @return 
     */
    static int scoreBreakdown(int score, int target) {
        //Remaining points assuming target was met
        int rem = score - target;
        
        if (rem < 0) {
            return 0;
        }
        
        int otherScores = rem / 2;
        
        int gap = target - otherScores;
        if (gap > 2) {
            return 0;
        } else if (gap == 2) {
            return 1;
        }
        return 2;
    }
    
    public static void intList(String s, int[] array) {
        int index = 0;
        String cur = "";
        for (int i = 0; i < s.length() + 1; i++) {
            if (i == s.length() || s.charAt(i) == ' ') {
                array[index++] = Integer.parseInt(cur);
                if (index == array.length) {
                    break;
                }
                cur = "";
            } else {
                cur += s.charAt(i);
            }
        }
    }
}
