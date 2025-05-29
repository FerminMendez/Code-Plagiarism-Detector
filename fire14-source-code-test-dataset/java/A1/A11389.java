import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("test2.data"));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        int testCases = Integer.valueOf(tokenizer.nextToken());
        int currentCase = 0;
        while (++currentCase <= testCases) {
            tokenizer = new StringTokenizer(reader.readLine(), " ");
            int googlers = Integer.valueOf(tokenizer.nextToken());
            int surprises = Integer.valueOf(tokenizer.nextToken());
            int topScore = Integer.valueOf(tokenizer.nextToken());
            int worseScore = topScore - 1;
            if (worseScore < 0)
                worseScore = 0;
            int worstScore = topScore - 2;
            if (worstScore < 0)
                worstScore = 0;
            int result = 0;
            while (--googlers >= 0) {
                int score = Integer.valueOf(tokenizer.nextToken());
                if (score >= topScore + worseScore + worseScore)
                    result++;
                else if (surprises > 0 && score >= topScore + worstScore + worstScore) {
                    result++;
                    surprises--;
                }
            }
            System.out.println("Case #" + currentCase + ": " + result);
        }

    }
}

