
import java.io.*;
import java.util.*;

public class Dancing {
    public enum Category {containsHighNotSupprising, containsHighOnlyIfSupprising, doesNotContainHigh};
    
    public class Score {
        
        public Score(int p, int score) {
            this.score = score;
            this.category = getCategoryFor(p, score);
        }
        
        private Category getCategoryFor(int p, int score) {
            if (score >= 29) {
                return Category.containsHighNotSupprising;
            } else if (score == 1) {
                if (p == 0 || p == 1) {
                    return Category.containsHighNotSupprising;
                }
                return Category.doesNotContainHigh;
            } else if (score == 0) {
                if (p == 0) {
                    return Category.containsHighNotSupprising;
                }
                return Category.doesNotContainHigh;
            } else if (score >= (3*p)-2) {
                return Category.containsHighNotSupprising;
            } else if (score >= (3*p)-4) {
                return Category.containsHighOnlyIfSupprising;
            }
            return Category.doesNotContainHigh;
        }
        
        public int score;
        public Category category;
    }
    
    public class TestCase {
        int p;
        int s;
        List<Score> scores = new ArrayList<Score>();
        
        public TestCase(String line) {
            Scanner scan = new Scanner(line);
            int numScores = scan.nextInt();
            s = scan.nextInt();
            p = scan.nextInt();
            for(int i = 0; i < numScores; i++) {
                int score = scan.nextInt();
                scores.add(new Score(p,score));
            }
        }
        
        public int getResult() {
            int countContainsHighNotSurprising = 0;
            int countContainsHighOnlyIfSurprising = 0;
            for(Score score : scores) {
                if(score.category==Category.containsHighNotSupprising) countContainsHighNotSurprising++;
                else if(score.category==Category.containsHighOnlyIfSupprising) countContainsHighOnlyIfSurprising++;
            }
            return countContainsHighNotSurprising + Math.min(s,countContainsHighOnlyIfSurprising);
        }
    }
    
    
    
    public static final PrintStream out = System.out;
    public static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public int numCases;
    
    public void doCase(int caseNumber) throws Exception {
        String line = in.readLine();
        TestCase testCase = new TestCase(line);
        out.println(testCase.getResult());
    }
    
    public void run() throws Exception {
        numCases = Integer.parseInt(in.readLine().trim());
        for (int i = 1; i <= numCases; i++) {
            out.print("Case #" + i + ": ");
            doCase(i);
        }
    }
    
    public static void main(String[] args) throws Exception {
        new Dancing().run();
    }

}
