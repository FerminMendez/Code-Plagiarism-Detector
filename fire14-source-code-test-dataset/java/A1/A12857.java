import java.util.Scanner;

public class DancingWithTheGooglers {

   public static void main(String[] argv) {

      int lineCounter,numberOfLines,people,currentScore;
      int surprises,scoreToBeat,counter,answer;
      int possibleScore;
      Scanner input = null;

      try {input = new Scanner(System.in);}
      catch (Exception e) { System.err.println("FileNotFoundException: " + e.getMessage()); }

      numberOfLines = input.nextInt();

      for (lineCounter = 0; lineCounter < numberOfLines; lineCounter++) {
         answer = 0;
         input.nextLine();
         people = input.nextInt();
         surprises = input.nextInt();
         scoreToBeat = input.nextInt();

         for (counter = 0; counter < people; counter++) {
            currentScore = input.nextInt();
            possibleScore = scoreNoSurprise(currentScore);
            if (possibleScore >= scoreToBeat)
               answer++;
            else if (surprises > 0) {
               possibleScore = scoreSurprise(currentScore);
               if (possibleScore >= scoreToBeat) {
                  answer++;
                  surprises--;
               }
            }
         }

         System.out.printf("Case #%d: %d\n",lineCounter+1,answer);

      }

   }

   public static int scoreNoSurprise(int value) {
      if (value < 2)
         return value;
      if (value == 2)
         return 1;
      int totalScore = value;
      int divergence = totalScore%3;
      int baseScore = totalScore/3;
      if (divergence == 2) {
         return baseScore+1;
      }
      else if (divergence == 1) {
         return baseScore+1;
      }
      else { // divergence == 0
         return baseScore;
      }
   }

   public static int scoreSurprise(int value) {
      if (value < 3)
         return value;
      int totalScore = value;
      int divergence = totalScore%3;
      int baseScore = totalScore/3;
      if (divergence == 2) {
         return baseScore+2;
      }
      else if (divergence == 1) {
         return baseScore+1;         
      }
      else { // divergence == 0
         return baseScore+1;
      }
   }

}
