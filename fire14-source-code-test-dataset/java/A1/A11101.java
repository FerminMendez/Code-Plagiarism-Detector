package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class QualificationB {

  public static void main(String[] args) throws IOException {
    String sampleIn = "input/b_sample.in";
    String sampleOut = "output/b_sample.out";
    
    String smallIn = "input/B-small-attempt0.in";
    String smallOut = "output/B-small-attempt0.out";
    
    String inFile = smallIn;
    String outFile = smallOut;
    
    FileWriter fstream = new FileWriter(outFile);
    BufferedWriter out = new BufferedWriter(fstream);
    
    int ncase = 0;
    for(TestCase tc : loadCodeLines(inFile)) {
      int withoutSurprises = 0;
      int withSurprises = 0;
      for (int s : tc.scores) {
        if (canMakeWithoutSurprise(tc.p, s)) {
          withoutSurprises++;
        } else if (canMakeWithSurprise(tc.p, s)) {
          withSurprises++;
        }
      }
      ncase++;
      System.out.println("Case #" + ncase + ": " + (withoutSurprises + Math.min(tc.s, withSurprises)));
      out.write("Case #" + ncase + ": " + (withoutSurprises + Math.min(tc.s, withSurprises)) + "\n");
      
      //System.out.println("n=" + tc.n + " s=" + tc.s + " p=" + tc.p + " scores=" + tc.scores.toArray());
    }
    out.close();
  }
  
  private static boolean canMakeWithoutSurprise(int p, int score) {
    int rem = score - p;
    if (rem < 0) return false;
    int lower = rem / 2;
    return lower >= Math.max(p-1, 0);
  }
  
  public static boolean canMakeWithSurprise(int p, int score) {
    int rem = score - p;
    if (rem < 0) return false;
    int lower = rem / 2;
    return lower >= Math.max(p-2, 0);
  }
 
  public static List<TestCase> loadCodeLines(String filename){
    List<TestCase> cases = new LinkedList<TestCase>();
    try{
      BufferedReader reader = new BufferedReader(new FileReader(filename));
      String tString = reader.readLine();
      int t = Integer.parseInt(tString);
      for(int i=0; i<t; i++){
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken(" "));
        int s = Integer.parseInt(tokenizer.nextToken(" "));
        int p = Integer.parseInt(tokenizer.nextToken(" "));
        List<Integer> scores = new LinkedList<Integer>();
        while(tokenizer.hasMoreTokens()) {
          int score = Integer.parseInt(tokenizer.nextToken(" \n"));
          scores.add(score);
        }
        cases.add(new TestCase(n,s,p,scores));
      }
    } catch(Exception e){
      e.printStackTrace();
      throw new RuntimeException("can't load " + filename + "!");
    }
    return cases;
  }

  private static class TestCase {
    public int n, s, p;
    public List<Integer> scores;
    public TestCase(int n, int s, int p, List<Integer> scores) {
      this.n = n;
      this.s = s;
      this.p = p;
      this.scores = scores;
    }
  }
  
}
