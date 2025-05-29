import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DancingWithTheGooglers {
    public static void main(String[] args) throws IOException {
        printMaxPossibleHighScorers(new BufferedReader(new FileReader("B-small-attempt2.in")), new BufferedWriter(new FileWriter("out.txt")));
    }
    
    public static void printMaxPossibleHighScorers(BufferedReader in, BufferedWriter out) throws IOException {
        String line = in.readLine(); // we don't need to read num test cases
        int caseNum = 1;
        
        while ((line = in.readLine()) != null && line.length() != 0 ) {
            String result = "Case #" + caseNum + ": ";
            
            String[] lineDetails = line.split(" ");
            int n = Integer.parseInt(lineDetails[0]);   // googlers
            int s = Integer.parseInt(lineDetails[1]);   // surprises
            int p = Integer.parseInt(lineDetails[2]);   // high score
            int[] googlers = new int[lineDetails.length-3];
            
            for (int j = 3; j < lineDetails.length; j++) {
                googlers[j-3] = Integer.parseInt(lineDetails[j]);
            }
            
            int maxPossibleHighScorers = 0;
            int possibleHighScorers = 0;
            int surprisesLeft = s;
            for (int j = 0; j < n; j++) {
                int score = googlers[j];
                int base = score / 3;
                int offset = score % 3;
                int maxScore = -1;
                if (base > 0) {
                	maxScore = (offset == 0 ? base : base + 1);
                    if ((p - maxScore == 1) && offset != 1 && surprisesLeft > 0) {
                        maxScore++;
                        surprisesLeft--;
                    }
                } else {
                	maxScore = (score == 0 ? 0 : 1);
                    if ((p - maxScore == 1) && offset == 2 && surprisesLeft > 0) {
                        maxScore++;
                        surprisesLeft--;
                    }
                }
                 
                if (maxScore >= p) {
                    possibleHighScorers++;
                }
            }
            if (possibleHighScorers > maxPossibleHighScorers) {
                maxPossibleHighScorers = possibleHighScorers;
            }
            result += maxPossibleHighScorers;
            
            out.write(result);
            out.newLine();
            caseNum++;
        }
        in.close();
        out.close();
    }
}
