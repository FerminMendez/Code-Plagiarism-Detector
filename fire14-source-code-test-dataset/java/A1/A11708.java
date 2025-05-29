import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problemB {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int cases = Integer.parseInt(br.readLine());
            for (int i = 1; i <= cases; i++) {
              String[] tokens = br.readLine().split(" ");
              int persons = Integer.parseInt(tokens[0]);
              int surprises = Integer.parseInt(tokens[1]);
              int bestResult = Integer.parseInt(tokens[2]);

              int lowestVal = bestResult - 2;
              if (lowestVal < 0) {
                  lowestVal = 0;
              }

              int surpriseThreshold = (bestResult + (lowestVal*2));
              int normalThreshold = ((bestResult*2) + (lowestVal));
              int total = 0;

              for (int j = 0; j < persons; j ++) {
                if (Integer.parseInt(tokens[3+j]) >= normalThreshold ) {
                  total++;
                } else if ((Integer.parseInt(tokens[3+j]) >= surpriseThreshold) && (surprises > 0)) {
                  total++;
                  surprises--;
                }
              }

              System.out.println("Case #" + i + ": " + total);
            }
        } catch (IOException e) {
            System.out.println("Error!");
            System.exit(1);
        }

    }
}
