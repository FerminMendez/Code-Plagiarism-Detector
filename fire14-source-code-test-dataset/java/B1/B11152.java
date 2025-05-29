package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class QualificationC {

  public static void main(String[] args) throws IOException {
    
    String sampleIn = "input/c_sample.in";
    String sampleOut = "output/c_sample.out";
    
    String smallIn = "input/C-small-attempt1.in";
    String smallOut = "output/C-small-attempt1.out";
    
    String largeIn = "input/C-large.in";
    String largeOut = "output/C-large.out";
    
    String inFile = smallIn;
    String outFile = smallOut;
    
    FileWriter fstream = new FileWriter(outFile);
    BufferedWriter out = new BufferedWriter(fstream);
    
    int limit = 2000000;
    
    int ncase = 0;
    Map<Integer,Set<Integer>> map = mapGreaterRecycleds(limit);
    for (TestCase tc : loadTestCases(inFile)) {
      ncase++;
      long recycledsBetween = findPairsBetween(map, tc.a, tc.b);
      System.out.println("Case #" + ncase + ": " + recycledsBetween);
      out.write("Case #" + ncase + ": " + recycledsBetween + "\n");

    }
    out.close();
  }
  
  private static void test(int n, int limit) {
    for (int r : getGreaterRecycleds(n, limit)) {
      System.out.println(r);
    }
  }
  
  private static long findPairsBetween(Map<Integer,Set<Integer>> map, int a, int b) {
    long ret = 0;
    for (int i=a; i<b; i++) {
      for (int recycle : map.get(i)) {
        if (recycle <= b) {
          ret++;
        }
      }
    }
    return ret;
  }
  
  private static Map<Integer, Set<Integer>> mapGreaterRecycleds(int maxB) {
    Map<Integer, Set<Integer>> map = new HashMap<Integer,Set<Integer>>();
    for (int i = 1; i<maxB; i++) {
      map.put(i, getGreaterRecycleds(i, maxB));
    }
    return map;
  }
  
  private static Set<Integer> getGreaterRecycleds(int start, int maxB) {
    String s = Integer.toString(start);
    Set<Integer> ret = new TreeSet<Integer>();
    for (int firstChar = 1; firstChar < s.length(); firstChar++) {
      String rebuild = s.substring(firstChar) + s.substring(0, firstChar);
      if (!rebuild.startsWith("0")) {
        int recycled = Integer.parseInt(rebuild);
        if (recycled <= maxB && recycled > start) {
          ret.add(recycled);
        }
      }
    }
    return ret;
  }
  
  public static List<TestCase> loadTestCases(String filename){
    List<TestCase> cases = new LinkedList<TestCase>();
    try{
      BufferedReader reader = new BufferedReader(new FileReader(filename));
      String tString = reader.readLine();
      int t = Integer.parseInt(tString);
      for(int i=0; i<t; i++){
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int a = Integer.parseInt(tokenizer.nextToken(" "));
        int b = Integer.parseInt(tokenizer.nextToken(" \n"));
        cases.add(new TestCase(a,b));
      }
    } catch(Exception e){
      e.printStackTrace();
      throw new RuntimeException("can't load " + filename + "!");
    }
    return cases;
  }
  
  private static class TestCase {
    public int a, b;
    public TestCase(int a, int b) {
      this.a = a;
      this.b = b;
    }
  }
  
}
