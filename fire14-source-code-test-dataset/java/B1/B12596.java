package info.zhenhua.codejam;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;

abstract class RecycledNumbersSolver {
  protected String inputFileName;
  String outputFileName = null;
  PrintStream ps = null;
  
  public final static String smallInput = "-small-practice.in";
  public final static String bigInput = "-large-practice.in";
  public final static String smallOutput = "-small-practice.out";
  public final static String bigOutput = "-large-practice.out";
  
  public final static String smallContestInput = "-small-attempt0.in";
  public final static String bigContestInput = "-large.in";
  public final static String smallContestOutput = "-small-attempt0.out";
  public final static String bigContestOutput = "-large.out";
  
  protected String fileNamePrefix = null;
  
  public RecycledNumbersSolver(String inputFileName, String outputFileName, String fileNamePrefix) {
    this.inputFileName = inputFileName;
    this.outputFileName = outputFileName;
    this.fileNamePrefix = fileNamePrefix;
  }
  
  
  public String getInputFileName() {
    return fileNamePrefix + inputFileName;
  }

  public void setInputFileName(String inputFileName) {
    this.inputFileName = inputFileName;
  }

  public String getOutputFileName() {
    return fileNamePrefix + outputFileName;
  }

  public void setOutputFileName(String outputFileName) {
    this.outputFileName = outputFileName;
  }

  abstract protected void solveAll() throws IOException;

  protected void printOutput (String result) throws FileNotFoundException {
    if (ps == null) {
      if (this.getOutputFileName() == null)
        ps = new PrintStream(System.out);
      else
        ps = new PrintStream(this.getOutputFileName());
    }
    ps.println(result);
  }
}
/**
 * @author zhguo
 * 
 */
public class RecycledNumbers extends RecycledNumbersSolver {

  public RecycledNumbers(String inputFileName, String outputFileName) {
    super(inputFileName, outputFileName, "C");
  }

  /**
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    RecycledNumbers recycledNumbers = new RecycledNumbers(smallContestInput,
        smallContestOutput);
    recycledNumbers.solveAll();
  }

  @Override
  protected void solveAll() throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(getInputFileName()));
    String line = br.readLine();
    int testcases = Integer.valueOf(line);
    for (int j = 1; j <= testcases; ++j) {
      line = br.readLine();
      String[] parts = line.split(" ");
      int min = Integer.valueOf(parts[0]);
      int max = Integer.valueOf(parts[1]);
      
      long result = solveOneTestCase(min, max);
      printOutput("Case #" + j + ": " + result);
    }
    br.close();
    if (ps != null)
      ps.close();
  }

  static final int MAX = 2000000;
  boolean[] visited = new boolean[MAX + 1];
  private long solveOneTestCase(int min, int max) {
    StringBuilder sb = new StringBuilder();
    long nums = 0;
    for (int i = min; i <= max; ++i) {
      Arrays.fill(visited, false);
      sb.replace(0, sb.length(), String.format("%d%d", i, i));
      int len = sb.length() / 2;
      for (int j = 1; j < len; ++j) {
        int num = Integer.valueOf(sb.substring(j, j + len));
        if (num > max || num <= i || visited[num]) continue;
        visited[num] = true;
        ++nums;
      }
    }
    return nums;
  }
}
