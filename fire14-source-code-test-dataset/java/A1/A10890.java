package utils;

/**
 *
 * @author Fabien Renaud
 */
public abstract class Jam implements Runnable, JamParser {

  protected final String[] lines;
  protected final JamCase[] cases;
  protected final int t;
  private final String filenameInput;
  private final String filenameOutput;
  private final String[] output;
  private final StopWatch timer;
  private int count;

  protected Jam(String filename) {
    this.filenameInput = filename;
    this.filenameOutput = filename.replace(".in", ".out");
    this.count = 0;
    this.lines = File.readAllLines(filenameInput);
    this.timer = new StopWatch();
    this.t = Integer.parseInt(lines[0]);
    this.cases = new JamCase[t];
    this.output = new String[t];
    File.delete(filenameOutput);
  }

  protected final synchronized void appendOutput(int number, String result) {
    output[number - 1] = String.format("Case #%1$d: %2$s", number, result);
    count++;
    if (count == t) {
      timer.stop();
      saveOutput();
    }
  }

  private void saveOutput() {
    if (count != t) {
      System.err.println(String.format("%1$d results are missing. File not saved."));
    } else {
      File.writeAllLines(filenameOutput, output);
      System.out.println("File saved at " + filenameOutput);
      System.out.println("---------- OUTPUT ----------");
      for (String s : output) {
        System.out.println(s);
      }
      System.out.println("--- Processed in " + timer.getElapsedSeconds() + " seconds.");
    }
  }

  @Override
  public final void run() {
    int j;
    count = 0;

    timer.start();
    for (int i = 1; i <= t; i++) {
      j = i - 1;
      cases[j] = getJamCase(i);
      if (cases[j] != null) {
        new Thread(cases[j]).start();
      }
    }
  }
}
