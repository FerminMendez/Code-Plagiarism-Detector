import java.io.*;
import java.util.*;

public class DancingWithTheGooglers {
  
  private static final int NUM_JUDGES = 3;
  private static final int MAX_DIFF = 2;
  private static final int MIN_SCORE = 0;
  private static final int MAX_SCORE = 10;
  
  public static void main(String[] args) throws Exception {
    String fileName = args[0];
    BufferedReader reader = new BufferedReader(new FileReader(fileName + ".in"));
    PrintWriter writer = new PrintWriter(new FileWriter(fileName + ".out"));
    int cases = Integer.parseInt(reader.readLine());
    for (int i = 1; i <= cases; i++) {
      String[] data = reader.readLine().split(" ");
      int numSurprises = Integer.parseInt(data[1]);
      int minBestResult = Integer.parseInt(data[2]);
      int topGooglers = 0;
      int either = 0;
      List<Integer> doubtful = new ArrayList<Integer>();
      for (int j = 3; j < data.length; j++) {
        int totalPoints = Integer.parseInt(data[j]);
        if (totalPoints >= NUM_JUDGES * MAX_SCORE - 1) { // 29 30
          topGooglers++; // bestResult = 10, not surprise
        } else if (totalPoints <= MIN_SCORE + 1) { // 0 1
          if (totalPoints >= minBestResult) {
            topGooglers++; // bestResult = totalPoints, not surprise
          }
        } else { // we can choose between surprise or not surprise
          int bestResult = (totalPoints + (NUM_JUDGES - 1) * MAX_DIFF) / NUM_JUDGES;
          if ((totalPoints - 1) % NUM_JUDGES == 0) { // 4 7 10 13 16 19 22 25 28
            either++; // same bestResult
            if (bestResult >= minBestResult) {
              topGooglers++;
            }
          } else {
            doubtful.add(bestResult - 1); // if we choose surprise -> bestResult++
          }
        }
      }
      if (either + doubtful.size() < numSurprises) { // not enough surprises
        writer.println("Case #" + i + ": 0");
      } else {
        Collections.sort(doubtful);
        Collections.reverse(doubtful); // we want the best first
        int surprises = 0;
        for (int bestResult: doubtful) {
          if (bestResult < minBestResult && surprises < numSurprises) { // we haven't reached numSurprises yet
            surprises++; // we can afford to add one surprise
            bestResult++; // and +1 bestResult
          }
          if (bestResult >= minBestResult) {
            topGooglers++;
          }
        }
        writer.println("Case #" + i + ": " + topGooglers);
      }
    }
    reader.close();
    writer.close();
  }
  
}