
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DancingGooglers {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner sc = new Scanner(new File("C:/B-small-attempt4.in"));
        BufferedWriter bf = new BufferedWriter(new FileWriter("C:/B-small.txt", false));

        int T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            int n, s, p;
            
            n = sc.nextInt();
            s = sc.nextInt();
            p = sc.nextInt();
            
            int highScore = 0;
            int medScore = 0;

            for (int j = 0; j < n; j++) {
                int score = sc.nextInt();
                if (score > 3 * (p - 1)) {
                    highScore++;
                } else if (p > 1 && score > 3 * (p - 2) + 1) {
                    medScore++;
                }
            }
            int maxval = highScore + Math.min(s, medScore);
            System.out.println("Case #" + i + ": " + maxval);
            bf.write("Case #" + i + ": " + maxval + "\n");
        }
        bf.close();
    }
}
