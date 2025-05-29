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
 * Usage : java RecycledNumbers inputFileName outputFileName
 */
public class RecycledNumbers {

  public static void main(String[] args) {
    int T = 0;
    int A = 0;
    int B = 0;

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
            A = scanner.nextInt();
            B = scanner.nextInt();
            // Read fly positions
            bw.write("Case #" + (i + 1) + ": " + numberOfRecycled(A,B) + "\n");
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
  
  public static int numberOfRecycled(int A,int B) {
    if (B < 10) {
      return 0;
    } else if (B < 100) {
      int count = 0;
      for (int i=A; i < B;i++) {
        int tens = i/10;
        int units = i%10;
        if (units*10+tens <= B && units*10+tens > i) {
          count++;
        }
      }
      return count;
    } else if (B < 1000) {
      int count = 0;
      for (int i=A; i < B;i++) {
        int cents = i/100;
        int tens = (i-100*cents)/10;
        int units = i%10;
        // ABC
        // BCA
        // CAB
        if (units*100+cents*10+tens <= B && units*100+cents*10+tens >i) {
          count++;
        }
        if (tens*100+units*10+cents <= B && tens*100+units*10+cents > i) {
            count++;
        }        
      }
      return count;
    }
    return 0;
  }
}
