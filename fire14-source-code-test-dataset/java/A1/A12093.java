import java.util.Scanner;
public class Dancing {
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    int numCases = sc.nextInt();
    
    for (int i = 0; i < numCases; i++) {
      int N = sc.nextInt();
      int S = sc.nextInt();
      int S_counter = S;
      int p = sc.nextInt();
      int numPassed = 0;
      int minSurprise;
      int minNoSurprise;
      
      //special cases
      if (p == 0) {
        minSurprise = 0;
        minNoSurprise = 0;
      }
      else if (p == 1) {
        minSurprise = 1;
        minNoSurprise = 1;
      }
      else {
        minSurprise = p + 2*(p - 2);
        minNoSurprise = p + 2*(p - 1);
      }
      
      if (minNoSurprise < 0) minNoSurprise = 0;
      for (int j = 0; j < N; j++) {
        int t = sc.nextInt();
        if (t < minSurprise) continue;
        else if (t < minNoSurprise && 
                 t >= minSurprise &&
                 S_counter <= 0) continue;
        else if (t < minNoSurprise && 
                 t >= minSurprise &&
                 S_counter > 0) {
          numPassed++;
          S_counter--;
        }
        else if (t >= minNoSurprise)
          numPassed++;
        else
          System.out.println("Something Broke"); 
      }
      System.out.println("Case #" + (i + 1) + ": " + numPassed);
    }
  }
}
    