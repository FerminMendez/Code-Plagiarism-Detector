import java.io.*;
import java.util.*;

public class ProblemB {
  

  
  /*
   * Takes an input file and output file as inputs.
   */
  public static void main(String file[]) throws IOException{
    
    BufferedReader in;
    BufferedWriter out;
    int numCases, numGooglers, numSurp, p, score;
    Integer result;
    
    
    // Open the file and create a reader
    in = new BufferedReader(new FileReader(file[0]));
    
    // Create an output file and a writer
    out = new BufferedWriter(new FileWriter(file[1]));
    
    numCases = Integer.parseInt(in.readLine());
    
    // for each case
    for (int i = 0; i < numCases; i++) {
      out.write("Case #" + (i+1) + ": ");
      
      // prepare variables
      String line = in.readLine();
      String[] numbers = line.split(" ");
      numGooglers = Integer.parseInt(numbers[0]);
      numSurp = Integer.parseInt(numbers[1]);
      p = Integer.parseInt(numbers[2]);
      result = 0;
      for (int j = 0; j < numGooglers; j++) {
          score = Integer.parseInt(numbers[j+3]);
      
          // first check if it could give p without being surprising
          if (score >= 3*p-2) {
              result++;
              if (score < p)
                  result--;
          }
          // otherwise see if it could give p being a surprise and
          // also if we even have any suprises left
          else if (numSurp > 0 && score >= 3*p-4) {
              result++;
              numSurp--;
              if (score < p) {
                  result--;
                  numSurp++;
              }
          }
      }
      System.out.println(result);    
      out.write(result.toString());
      out.newLine();
    }
    in.close();
    out.close();
  }
}
    
    