import java.util.*;
import java.io.*;

public class b {
  
  public static void main (String[] args){
    
    //settingup input and output
    Scanner in = null;
    PrintWriter out = null;
    try{
      in = new Scanner(new File("bsmall.txt"));
      out = new PrintWriter(new FileOutputStream("bsmallout.txt"), true);
    }catch(Exception e){
      System.out.println("file not found");
    }
    
    // number of cases
    int n = in.nextInt(); 
    in.nextLine();
    
    // run through each case
    for(int currentCase = 1; currentCase <= n; currentCase++){
      
      int result = 0;
      int N = in.nextInt(); // number of Googlers
      int S = in.nextInt(); // number of surprising triplets
      int p = in.nextInt(); // must be >= p to be considered
      int t[] = new int[N]; // total point for each Googler
      for(int i = 0; i < N; i++){
        t[i] = in.nextInt();
      }
      
      for(int i = 0; i < N; i++){
        if(t[i] >= (p*3 - 2)) result++; // automatically pass
        else if((S > 0) && ((((p*3 - 3) > 0) && (t[i] == (p*3 - 3)))  
                              || (((p*3 - 4) > 0) && (t[i] == (p*3 - 4))))){
          result++;
          S--; // consumes a quota of surprising triplet to pass
        }
      }
      
      //output answers for each case
      out.println("Case #" + currentCase + ": " + result);
    }
    
    // close input and output streams
    in.close();
    out.close();
  } 
}