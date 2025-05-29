import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DancingWithGoolers {
    public static void main(String args[]) {
        try {
            BufferedReader inputReader = new BufferedReader(new FileReader(
                "input"));
            String line = inputReader.readLine();
            BufferedWriter outWriter = new BufferedWriter(new FileWriter(
                "output.txt"));
            int number = Integer.parseInt(line);
            for ( int i = 1; i <= number; i++ ) {
                String result = "Case #" + i + ": ";
                line = inputReader.readLine();
                String inputs[] = line.split(" ");
                int num = Integer.parseInt(inputs[0]);
                int surprise = Integer.parseInt(inputs[1]);
                int point = Integer.parseInt(inputs[2]);
                int scores[] = new int[num];
                for ( int j = 0; j < num; j++ ) {
                    scores[j] = Integer.parseInt(inputs[3 + j]);
                }
                outWriter.write(result
                    + getResult(num, surprise, point, scores) + "\n");
            }
            outWriter.flush();
            outWriter.close();
        } catch ( FileNotFoundException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch ( IOException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static int getResult(int number, int surprise, int point,
        int scores[]) {
        int surpriseLimit = 3 * point - 4;
        if ( surpriseLimit <= 0 ) {
            surpriseLimit = point;
        }
        int acceptableLimit = 3 * point - 2;
        if ( acceptableLimit <= 0 ) {
            acceptableLimit = point;
        }
        int surpriseNum = 0;
        int acceptableNum = 0;
        for ( int i = 0; i < scores.length; i++ ) {
            int score = scores[i];
            if ( score < acceptableLimit && score >= surpriseLimit ) {
                surpriseNum++;
            } else if ( score >= acceptableLimit ) {
                acceptableNum++;
            }
        }
        return acceptableNum + Math.min(surpriseNum, surprise);
    }
}
