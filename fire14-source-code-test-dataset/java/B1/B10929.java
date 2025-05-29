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
public class RecycledNumbers extends Jam {

  public RecycledNumbers(String filename) {
    super(filename);
  }

  @Override
  public JamCase getJamCase(int number) {
    return new Line(this, number, lines[number]);
  }

  private class Line extends JamCase {

    private int a;
    private int b;
    private String line;
    private int count;

    public Line(Jam parent, int number, String line) {
      super(parent, number);
      this.line = line;
    }

    @Override
    public void parse() {
      String[] integers = line.split(" ");
      a = Integer.parseInt(integers[0]);
      b = Integer.parseInt(integers[1]);
    }

    @Override
    public void solve() {
      count = 0;
      for (int i = a; i <= b; i++) {
        countRecycles(i);
      }
      result = Integer.toString(count);
    }

    private void countRecycles(int number) {
      int len = 0;
      int n = number;
      while (n != 0) {
        n /= 10;
        len++;
      }
      n = number;
      int exp = (int) Math.pow(10, len - 1);
      for (int i = 0; i < len; i++) {
        n = nextRecycled(n, exp);
        if (n == number) {
          return;
        }
        if (n <= b && n > number) {
          count++;
        }
      }
    }

    private int nextRecycled(int i, int exp) {
      int r = i % 10;
      i = (i - r) / 10;
      i += r * exp;
      return i;
    }
  }
}
