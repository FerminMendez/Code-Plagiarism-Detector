import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DancingWithGooglers {

    public static void main(String[] args) {
        Scanner problem = new Scanner(System.in);
        int T = problem.nextInt();
        for (int i = 0; i < T; i++) {
            int answer = 0;
            int N = problem.nextInt();
            int S = problem.nextInt();
            int p = problem.nextInt();
            List<Triplet> googlers = new ArrayList<Triplet>();
            for (int j = 0; j < N; j++) {
                googlers.add(new Triplet(problem.nextInt()));
            }
            int possibleSurprises = 0;
            for (Triplet triplet : googlers) {
                if (triplet.minMax() >= p) {
                    answer++;
                    continue;
                }
                if (triplet.maxMax() >= p) {
                    possibleSurprises++;
                }
            }
            answer += possibleSurprises >= S ? S : possibleSurprises;
            System.out.println(String.format("Case #%s: %s", i + 1, answer));
        }
    }

}

class Triplet {

    private int totalScore;

    public Triplet(int totalScore) {
        this.totalScore = totalScore;
    }
    
    private int min() {
        return new BigDecimal(totalScore).divide(new BigDecimal(3), RoundingMode.FLOOR).intValue();
    }

    public int minMax() {
        return new BigDecimal(totalScore).divide(new BigDecimal(3), RoundingMode.CEILING).intValue();
    }

    public int maxMax() {
        int lalala = this.totalScore % 3;
        if (lalala == 0) {
            lalala = 1;
        }
        if (this.totalScore == 0) {
            lalala = 0;
        }
        return this.min() + lalala;
    }
}
