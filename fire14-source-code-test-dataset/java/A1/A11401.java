import java.util.*;

public class DancingWithTheGooglers {
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      int numCases, currentCase, numGooglers, surprisingScores, searchFor, answer, currentScore;
      ArrayList<Integer> scores;

      numCases = scan.nextInt();
      currentCase = 0;
      while (currentCase < numCases) {
         currentCase++;
         numGooglers = scan.nextInt();
         surprisingScores = scan.nextInt();
         searchFor = scan.nextInt();
         scores = new ArrayList<Integer>();
         for (int i = 0; i < numGooglers; i++)
            scores.add(scan.nextInt());
         answer = 0;
         for (int i = 0; i < scores.size(); i++) {
            currentScore = scores.get(i);
            currentScore = currentScore / 3;
            if (scores.get(i) == 0 && searchFor != 0) {
            } else if (currentScore > searchFor) {
               answer++;
            } else if (currentScore * 3 == scores.get(i)) {
               if (currentScore == searchFor) {
                  answer++;
               } else if (surprisingScores > 0 && (currentScore + 1 == searchFor || currentScore - 1 == searchFor)) {
                  answer++;
                  surprisingScores--;
               }
            } else if ((currentScore * 3) + 1 == scores.get(i)) {
               if (currentScore == searchFor || currentScore + 1 == searchFor) {
                  answer++;
               } else if (surprisingScores > 0 && (currentScore - 1 == searchFor)) {
                  answer++;
                  surprisingScores--;
               }
            } else if ((currentScore * 3) + 2 == scores.get(i)) {
               if (currentScore == searchFor || currentScore + 1 == searchFor) {
                  answer++;
               } else if (surprisingScores > 0 && (currentScore + 2 == searchFor)) {
                  answer++;
                  surprisingScores--;
               }
            }
         }
         System.out.printf("Case #%d: %d\n", currentCase, answer);
      }
   }
}
