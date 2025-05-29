import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class B {
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(new FileReader("B-small-attempt0.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("B-small-output.txt"));
    int T = sc.nextInt();       // number of test cases
    int numResult;
    for (int k=1; k <= T; k++) {
      numResult = 0;
      
      int N = sc.nextInt();     // number of Googlers
      int B = sc.nextInt();     // number of surprising triplet scores
      int p = sc.nextInt();     // "best result" (max of triplets)
      int t[] = new int[N];     // total points for a given Googler (b/t 0 & 30)
      
      int minInd[] = new int[B];
      int minCount = 0;
      
      for (int i=0; i<N; i++) {    // for each of the Googler's total points
        t[i] = sc.nextInt();
      }
      Arrays.sort(t);           // can then start w/ lowest total score
      
      int surpriseCount = 0;    // counts the num of surprising triplets used
      
      for (int i=0; i<N; i++) {    
        // check possible scores:
        if (surpriseCount<B) {
          firstScore: for (int num1=0; num1<11; num1++) {
            for (int num2=min(num1+2,10); num2>=num1; num2--) {
              for (int num3=min(num1+2,10); num3>=num1; num3--) {
                if ((num1+num2+num3)==t[i]) {
                  if (max(num2, num3)>=p) {
                    if (max(num2, num3) > (num1+1)) {
                      surpriseCount++;
                    }
                    numResult++;
                    break firstScore;
                  }
                }
              }
            }
          }
        } else {
          firstScore: for (int num1=0; num1<11; num1++) {
            for (int num2=min(num1+1,10); num2>=num1; num2--) {
              for (int num3=min(num1+1,10); num3>=num1; num3--) {
                if ((num1+num2+num3)==t[i]) {
                  if (max(num2, num3)>=p) {
                    numResult++;
                    break firstScore;
                  }
                }
              }
            }
          }
        }
      }
      
      pw.format("Case #%d: %d\n", k, numResult);
    }
    
    pw.flush();
    pw.close();
    sc.close();
  }
}