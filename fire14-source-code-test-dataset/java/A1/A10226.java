import java.util.Scanner;

public class B2 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int nbrCases = sc.nextInt();
    for (int i = 1; i <= nbrCases; ++i) {
      sc.nextLine();
      System.out.print("Case #" + i + ": ");

      int nbrGooglers = sc.nextInt();
      int nbrSurprising = sc.nextInt();
      int atLeast = sc.nextInt();

      // The lowest value of a triplet which isn't surprising with
      // at least N is a triplet with the values N, N-1 and N-1
      int lowestNonSurprisingSum = 3 * atLeast - 2;
      // The lowest value of a triplet which is surprising with
      // at least N is a triplet with the values N, N-2 and N-2
      int lowestSurprisingSum = 3 * atLeast - 4;
      // Base cases
      if (atLeast == 0) {
        lowestNonSurprisingSum = 0;
        lowestSurprisingSum = 0;
      } else if (atLeast == 1) {
        lowestNonSurprisingSum = 1;
        lowestSurprisingSum = 1;
      }

      int nbrNonSurprisingFound = 0;
      int nbrSurprisingFound = 0;
      for (int j = 0; j < nbrGooglers; ++j) {
        int score = sc.nextInt();
        if (score >= lowestNonSurprisingSum) {
          ++nbrNonSurprisingFound;
        } else if (score >= lowestSurprisingSum) {
          ++nbrSurprisingFound;
        }
      }

      int max = nbrNonSurprisingFound + Math.min(nbrSurprisingFound, nbrSurprising);
      System.out.println(max);
    }
  }
}
