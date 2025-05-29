/**
 * 
 */
package org.codejam.rn;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;


/**
 * 
 * @author juanjo
 */
public class RecycledNumbersMain {
  
  public static String newline = System.getProperty("line.separator");
  
  
  private static void generateNumbers(Map<String, String> pairs, int A, int B, int n) {
    int m;
    String s = String.valueOf(n);
    String pair = null;
    int length = s.length() - 1;
    int[] data = new int[length];
    
    for (int i = 0; i < length; i++) {
      //s = s.charAt(length) + s.substring(0, length);   
      s = new StringBuilder().append(s.charAt(length)).append(s.substring(0, length)).toString();
      data[i] = Integer.parseInt(s);
      m = Integer.parseInt(s);
      
      if ((A <= n) && (n < m) && (m<=B)) {
        pair = new StringBuilder().append(n).append("-").append(m).toString();
        if (!pairs.containsKey(pair));
          pairs.put(pair, pair);
      }
    }   
  }
  
  private static int getRecyledPairsCount(int A, int B) {
    Map<String, String> pairs = new HashMap<String, String>();    
    for (int n = A; n <= B; n++) {
      generateNumbers(pairs, A, B, n);
    }
    return pairs.size();
  }

	/**
	 * @param args
	 */
	public static void main2(String[] args) {
	  long time = System.currentTimeMillis();
	  System.out.println("getRecyledPairsCount: " + getRecyledPairsCount(100,500));
	  System.out.println("Execution time ms.: " + (System.currentTimeMillis() - time) );
	}
	
	public static void main(String[] args) {
	  long time = System.currentTimeMillis();
    if (args.length != 2) {
      System.out.println("Usage: java " + RecycledNumbersMain.class  + " inputFile outputFile");
      System.exit(0);
    }

    int count = 0;
    BufferedReader in = null;
    FileWriter out = null;
    String line = null;
    int testCasesTotal = 0;
    int testCasesCount = 0;
    String result;
    
    int A, B;
    String s[];

    try {
      in = new BufferedReader(new FileReader(args[0]));
      out = new FileWriter(args[1]);
      
      while ( (line = in.readLine()) != null) {
        count++;
        if (count == 1) {
          testCasesTotal = Integer.valueOf(line);
          System.out.println("In file number of test cases: " + testCasesTotal + ".");
        } //if
        else {
          s = line.split(" ");
          A = Integer.parseInt(s[0]);
          B = Integer.parseInt(s[1]);    
          
          result = String.valueOf(getRecyledPairsCount(A, B));
          testCasesCount++;
          result = "Case #" + testCasesCount + ": " + result;
          System.out.println(result + " -- Line: " + testCasesCount + ": " + line);
          out.write(result + newline);
        }
      }
      if (out != null) {
        out.close();
      }
    } //try
    catch (Exception e) {
      e.printStackTrace();
    }
    finally {
      System.out.println("Execution time ms.: " + (System.currentTimeMillis() - time) );
    }
  } // Main

}
