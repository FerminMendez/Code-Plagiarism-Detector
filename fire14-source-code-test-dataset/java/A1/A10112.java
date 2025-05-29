import java.io.*;
import java.util.Scanner;

public class DancinWithGooglers {

    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(new File("input.txt"));
            PrintStream output = new PrintStream(new FileOutputStream("output.txt"));
            solveTask(input, output);
        } catch (FileNotFoundException e) {
            System.out.println("input.txt not found");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void solveTask(Scanner input, PrintStream output) {

        int testsCount = input.nextInt();

        for (int test=1; test<=testsCount; test++) {

            int dancersCount = input.nextInt();
            int surprises = input.nextInt();
            int bestResult = input.nextInt();
            int scoreNeeded = bestResult*3-2;

            int gotResultAnywayCount = 0;
            int gotResultConditionallyCount = 0;

            for (int i=0; i<dancersCount; i++) {
                int score = input.nextInt();

                if (score >= scoreNeeded) {
                    gotResultAnywayCount++;
                } else if (score > 1 && score < 29 && score >= scoreNeeded-2) {
                    gotResultConditionallyCount++;
                }
            }

            int total = gotResultAnywayCount + Math.min(gotResultConditionallyCount, surprises);

            System.out.print("Case #"+test+": ");
            System.out.println(total);
            output.print("Case #"+test+": ");
            output.println(total);
        }
    }

}
