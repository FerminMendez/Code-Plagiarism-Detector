package de.pat.dev.y2012.qualification.b;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author pat.dev@alice.de
 */
public class ScoreStatistics {
  private final int numberOfSurprises;
  private final int[] scores;

  public ScoreStatistics(int numberOfSurprises, int[] scores) {
    this.numberOfSurprises = numberOfSurprises;
    this.scores = scores;Arrays.sort(scores);
  }

  public int numberOfGooglersReaching(int bestScore) {
    final int bestScoreSum=3*bestScore;
    int numberOfSuccessfulGooglers=0;
    int surprises=numberOfSurprises;

    for (int i=scores.length-1;i>=0;i--) {
      int diff = scores[i]-bestScoreSum;
      if (diff >= -2) { // e.g. : t=13, p=5 => t=4+4+5, diff=-t-3*p=13-3*5=-2
        numberOfSuccessfulGooglers++;
      } else { // diff < -2
        if (surprises>0 && diff >= -4 && scores[i]>0) { // -4 <= diff < -2, e.g.: t=11, p=5 => t=3+5+3=11, diff=11-15=-4
          numberOfSuccessfulGooglers++;
          surprises--;
        } else break;
      }
    }
    return numberOfSuccessfulGooglers;
  }

  @Override
  public String toString() {
    return "ScoreStatistics{" +
      "numberOfSurprises=" + numberOfSurprises +
      ", scores=" + Arrays.toString(scores) +
      '}';
  }
}
