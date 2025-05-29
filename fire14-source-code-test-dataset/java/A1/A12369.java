package de.pat.dev.y2012.qualification.b;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author pat.dev@alice.de
 * @since 14.04.12
 */
public class Main {
  public static void main(String[] args) {
    try {
      BufferedReader reader = new BufferedReader(new FileReader(args[0]));
      int numberOfTestCases = nextInt(reader);
      for (int i = 0; i < numberOfTestCases; i++) {
        StatisticParameters statisticParameters = nextParameters(reader);
        System.out.printf("Case #%d: %s\n", i+1,
          statisticParameters.statistics.numberOfGooglersReaching(statisticParameters.bestScore));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static StatisticParameters nextParameters(BufferedReader reader) throws IOException {
    String[] params = reader.readLine().trim().split("\\s+");
    int numberOfGooglers = toInt(params[0]);
    int numberOfSurprises = toInt(params[1]);
    int bestScore = toInt(params[2]);
    int[] scores = new int[numberOfGooglers];
    for (int i = 0; i < scores.length; i++) {
      scores[i]=toInt(params[i+3]);
    }
    ScoreStatistics statistics = new ScoreStatistics(numberOfSurprises, scores);
    return new StatisticParameters(bestScore,statistics);
  }
  private static int toInt(String value) {
    return Integer.parseInt(value);
  }

  private static int nextInt(BufferedReader reader) throws IOException {
    return toInt(reader.readLine().trim());
  }

  private static class StatisticParameters {
    public final int bestScore;
    public final ScoreStatistics statistics;

    public StatisticParameters(int bestScore, ScoreStatistics statistics) {
      this.bestScore = bestScore;
      this.statistics = statistics;
    }

    @Override
    public String toString() {
      return "StatisticParameters{" +
        "bestScore=" + bestScore +
        ", statistics=" + statistics +
        '}';
    }
  }
}
