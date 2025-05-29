import java.io.*;

public class GoogleCodeInP3 {
  
  public static void main(String[] args) throws IOException {
    BufferedReader mbr = new BufferedReader(new FileReader(args[0]));
    int a = -1;
    try {
      a = Integer.parseInt(mbr.readLine());
    }
    catch (Exception e) { }
    FileWriter fw = new FileWriter("outputFile2a");
    BufferedWriter bfw = new BufferedWriter(fw);
    for (int i = 0; i < a; i++) {
      String thisLine = mbr.readLine();
      String[] w = thisLine.split(" ");
      String N = w[0];
      String M = w[1];
      bfw.write("Case #" + (i + 1) + ": " + recycleNumbers(N, M));
      if (i < a - 1) { bfw.write("\n"); }
    }
    bfw.close();
  }

  
  
  public static int recycleNumbers(String a, String b) {
    int a1 = Integer.parseInt(a);
    int b1 = Integer.parseInt(b);
    int howMany = 0;
    int w = 0;
    return howManyFor(a1, b1);
  }
  
  public static int howManyFor(int a, int b) {
    int thisMany = 0;
    int y = b + 1;
    while (y >= a) {
      y = y - 1;
      int w = 0;
      while (a + w < y) {
        if (!checkSameDigits(a + w, y)) { w = w + 1; continue; }
        String currentA = "" + (a + w);
        String currentB = "" + y;
        thisMany = thisMany + checkIfMatch(currentA, currentB);
        w = w + 1;
      }
    }
    return thisMany;
  }
  
  public static boolean checkSameDigits(int a, int b) {
    String s = "" + a;
    String t = "" + b;
    if (s.length() != t.length()) { return false; }
    int[] whereFound = new int[s.length()];
    for (int i = 0; i < s.length(); i++) {
      if (s.indexOf(t.charAt(i)) == -1) { return false; }
      if (whereFound[s.indexOf(t.charAt(i))] == 0) {
        whereFound[s.indexOf(t.charAt(i))] = 1;
        continue;
      }
      int x = s.indexOf(t.charAt(i));
      for (int j = x; j < whereFound.length; j++) {
        if (whereFound[j] == 1) { x = j; }
      }
      if (s.indexOf(t.charAt(x)) == -1) { return false; }
      whereFound[s.indexOf(t.charAt(x))] = 1;
    }
    return true;
  }
  
  public static int checkIfMatch(String currentA, String currentB) {
    String a = currentA;
    String b = currentB;
    int andThisMany = 0;
    for (int w = 0; w < a.length(); w++) {
      if (w == 0) { if (a.equals(b)) { andThisMany = andThisMany + 1; continue; } }
      if ((a.substring(w) + a.substring(0, w)).equals(currentB)) { andThisMany = andThisMany + 1; }
    }
    return andThisMany;
  }

}