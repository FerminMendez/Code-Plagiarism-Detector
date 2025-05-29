import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * Google Code Jam 2012
 * Qualification 2012
 * raguenets@gmail.com
 * Usage : java DancingWithTheGooglers inputFileName outputFileName
 */
public class DancingWithTheGooglers {
  public static int[] BEST_VALUE_NOT_SURPRISING = new int[] { 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 9, 9, 9, 10, 10, 10 };
  public static int[] BEST_VALUE_SURPRISING = new int[] { 0, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 9, 9, 9, 10, 10, 10, 10, 10 };

  public static void main(String[] args) {
    int T = 0;
    int N = 0;
    int p = 0;
    int S = 0;

    if (args.length == 2) {
      String inputFilename = args[0];
      File finput = new File(inputFilename);
      String outputFilename = args[1];
      File foutput = new File(outputFilename);
      Scanner scanner = null;
      BufferedWriter bw = null;
      try {
        bw = new BufferedWriter(new FileWriter(foutput));
      }
      catch (IOException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
      if (finput.exists()) {
        try {
          scanner = new Scanner(finput);
          // Reads first line : number of Tests
          if (scanner.hasNextInt()) {
            T = scanner.nextInt();
            scanner.nextLine();
          }
          for (int i = 0; i < T; i++) {
            // Read number of flies
            N = scanner.nextInt();
            S = scanner.nextInt();
            p = scanner.nextInt();
            int[] ti = new int[N];
            for (int j = 0; j < N; j++) {
              ti[j] = scanner.nextInt();
            }
            // Read fly positions
            bw.write("Case #" + (i + 1) + ": " + bestSolution(N, S, p, ti) + "\n");
          }
        }
        catch (FileNotFoundException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        finally {
          try {
            bw.close();
            if (scanner != null) {
              scanner.close();
            }
          }
          catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        }
      }
    }
  }

  public static int bestSolution(int N, int S, int p, int[] ti) {
    if (S == 0) {
      int bestFound = 0;
      for (int i = 0; i < N; i++) {
        if (BEST_VALUE_NOT_SURPRISING[ti[i]] >= p) {
          bestFound++;
        }
      }
      return bestFound;
    }
    else if (S == 1) {
      int bestAll = 0;
      for (int i = 0; i < N; i++) {
        int bestFound = 0;
        for (int j = 0; j < N; j++) {
          if (ti[j] == 0 || ti[j] == 1 || ti[j] == 29 || ti[j] == 30) {
            continue;
          }
          if (i == j) {
            if (BEST_VALUE_SURPRISING[ti[j]] >= p) {
              bestFound++;
            }
          }
          else {
            if (BEST_VALUE_NOT_SURPRISING[ti[j]] >= p) {
              bestFound++;
            }
          }
        }
        if (bestFound > bestAll) {
          bestAll = bestFound;
        }
      }
      return bestAll;
    }
    else if (S == 2) {
      int bestAll = 0;
      for (int i = 0; i < N; i++) {
        if (ti[i] == 0 || ti[i] == 1 || ti[i] == 29 || ti[i] == 30) {
          continue;
        }
        for (int j = i; j < N; j++) {
          if (ti[j] == 0 || ti[j] == 1 || ti[j] == 29 || ti[j] == 30) {
            continue;
          }
          int bestFound = 0;
          for (int k = 0; k < N; k++) {
            if (k == i || k == j) {
              if (BEST_VALUE_SURPRISING[ti[k]] >= p) {
                bestFound++;
              }
            }
            else {
              if (BEST_VALUE_NOT_SURPRISING[ti[k]] >= p) {
                bestFound++;
              }
            }
          }
          if (bestFound > bestAll) {
            bestAll = bestFound;
          }
        }
      }
      return bestAll;
    }
    else if (S == 3) {
      int bestAll = 0;
      for (int i = 0; i < N; i++) {
        if (ti[i] == 0 || ti[i] == 1 || ti[i] == 29 || ti[i] == 30) {
          continue;
        }
        for (int j = i; j < N; j++) {
          if (ti[j] == 0 || ti[j] == 1 || ti[j] == 29 || ti[j] == 30) {
            continue;
          }
          for (int k = j; k < N; k++) {
            if (ti[k] == 0 || ti[k] == 1 || ti[k] == 29 || ti[k] == 30) {
              continue;
            }
            int bestFound = 0;
            for (int m = 0; m < N; m++) {
              
              if (m == i || m == j || m == k) {
                if (BEST_VALUE_SURPRISING[ti[m]] >= p) {
                  bestFound++;
                }
              }
              else {
                if (BEST_VALUE_NOT_SURPRISING[ti[m]] >= p) {
                  bestFound++;
                }
              }
            }
            if (bestFound > bestAll) {
              bestAll = bestFound;
            }
          }
        }
      }
      return bestAll;

    }
    return 0;
  }
}
