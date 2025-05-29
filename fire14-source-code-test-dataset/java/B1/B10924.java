package utils;

/**
 *
 * @author Fabien Renaud
 */
public abstract class JamCase implements Runnable, JamCaseSolver {

  protected final int number;
  protected String result;
  private final StopWatch timer;
  private final Jam parent;

  protected JamCase(Jam parent, int number) {
    this.parent = parent;
    this.number = number;
    this.timer = new StopWatch();
  }

  public final int getNumber() {
    return number;
  }

  public final String getResult() {
    return result;
  }

  public final StopWatch getTimer() {
    return timer;
  }

  @Override
  public final void run() {
    timer.start();

    parse();
    solve();

    if (parent != null) {
      parent.appendOutput(number, result);
    }

    timer.stop();
  }
}