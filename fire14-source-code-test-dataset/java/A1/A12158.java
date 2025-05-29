import java.util.Scanner;

public class DancingWithTheGooglers {
    public static void main(String[] args) {

        bestResultForScores();

        new DancingWithTheGooglers().go();
    }

    public static int[] bestUnsurprisingResultForScore = new int[31];
    public static int[] bestSurprisingResultForScore = new int[31];
    public static int[] upgradeBySurprise = new int[31];

    private static void bestResultForScores() {
        for (int a = 0; a <= 10; a++)
            for (int b = 0; b <= 10; b++)
                for (int c = 0; c <= 10; c++) {
                    int bestResult = Math.max(a, Math.max(b, c));
                    int worstResult = Math.min(a, Math.min(b, c));
                    int spread = bestResult - worstResult;

                    int totalScore = a + b + c;

                    switch (spread) {
                        case 0:
                        case 1:
                            if (bestResult > bestUnsurprisingResultForScore[totalScore])
                                bestUnsurprisingResultForScore[totalScore] = bestResult;
                            break;
                        case 2:
                            if (bestResult > bestSurprisingResultForScore[totalScore])
                                bestSurprisingResultForScore[totalScore] = bestResult;
                    }
                }

        for(int i = 0; i < 31; i++) {
            upgradeBySurprise[i] = Math.max(0, (bestSurprisingResultForScore[i] - bestUnsurprisingResultForScore[i]));
        }
    }

    private void go() {
        Scanner sc = new Scanner(System.in);

        int numTestCases = Integer.parseInt(sc.nextLine());

        for (int caseNum = 1; caseNum <= numTestCases; caseNum++) {
            System.out.print("Case #" + caseNum + ": ");

            int numGooglers = sc.nextInt();
            int numSurprisingTriplets = sc.nextInt();
            int p = sc.nextInt();

            int[] totalPoints = new int[numGooglers];
            for (int i = 0; i < numGooglers; i++) {
                totalPoints[i] = sc.nextInt();
            }

            int[] bestPossibleScores = new int[31];
            for (int i = 0; i < numGooglers; i++) {
                bestPossibleScores[bestUnsurprisingResultForScore[totalPoints[i]]]++;
            }

            int sum = 0;
            for (int i = p; i < 31; i++) {
                sum += bestPossibleScores[i];
            }

            for(int totalScore : totalPoints) {
                if(bestUnsurprisingResultForScore[totalScore] == p-1 && bestSurprisingResultForScore[totalScore] == p && numSurprisingTriplets > 0) {
                    numSurprisingTriplets--;
                    sum++;
                }
            }

            System.out.println(sum);
        }
    }
}
