package googleCodeJam;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Set;
import java.util.TreeSet;

public class RecycledNumbers {
  public static void main(String[] args) throws Exception {
    if (args.length == 1) {
      // opening the input
      BufferedReader in = new BufferedReader(new FileReader(args[0]));
      
      // reading the number of test cases
      String line = null;
      int numberOfTestCases = ((line = in.readLine()) != null) ? Integer.parseInt(line) : 0;
      for (int t = 0; t < numberOfTestCases; t ++) {
        line = in.readLine();
        out.print("Case #" + (t+1) + ": ");
        
        // parse input
        String[] numbers = line.split(" ");
        int n = Integer.parseInt(numbers[0]);
        int m = Integer.parseInt(numbers[1]);
        
        int counter = 0;
        StringBuffer is = new StringBuffer(128);
        String isCurrent = null;
        for (int i = n; i <= m; i ++) {
          is.append(i);
          int size = is.length();
          is.append(i);
          //
          Set<Integer> qs = new TreeSet<Integer>();
          for (int j = 0; j < size; j ++) {
            isCurrent = is.substring(j, j+size);
            int q = Integer.parseInt(isCurrent);
            if (i < q && q <= m /*&& !isCurrent.startsWith("0")*/) {
              //counter ++;
              //out.println(i + "\t" + q + "\t" + (size - j));
              qs.add(q);
            }
          }
          //
          counter += qs.size();
          is.setLength(0);
        }
        
        out.println(counter);
      }
      
      // closing the input
      in.close();
    } else {
      // show the usage
      System.err.println("Using: java googleCodeJam.RecycledNumbers input");
    }
  }

}
