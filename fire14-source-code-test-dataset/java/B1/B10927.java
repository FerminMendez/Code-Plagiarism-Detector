/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codejam.y12.round0;

import utils.Jam;
import utils.JamCase;

/**
 *
 * @author fabien
 */
public class DancingGooglers extends Jam {

  public DancingGooglers(String filename) {
    super(filename);
  }

  @Override
  public JamCase getJamCase(int number) {
    return new Line(this, number, lines[number]);
  }

  private class Line extends JamCase {

    private String line;
    private int s;
    private int p;
    private int[] scores;

    public Line(Jam parent, int number, String line) {
      super(parent, number);
      this.line = line;
    }

    @Override
    public void parse() {
      String[] integers = line.split(" ");
      scores = new int[Integer.parseInt(integers[0])];
      s = Integer.parseInt(integers[1]);
      p = Integer.parseInt(integers[2]);
      int j = 0;
      for (int i = 3; i < integers.length; i++) {
        scores[j++] = Integer.parseInt(integers[i]);
      }
    }

    @Override
    public void solve() {
      int r = 0;
      if (p == 0) {
        r = scores.length;
      } else {
        float average = 0;
        float pnor = p - 1;
        float psus = p - 1.4f;
        for (int score : scores) {
          if (score > 0) {
            average = score / 3.0f;
            if (average > pnor) {
              r++;
            } else if (s > 0 && average >= psus) {
              r++;
              s--;
            }
          }
        }
      }
      result = Integer.toString(r);
    }
  }
}
