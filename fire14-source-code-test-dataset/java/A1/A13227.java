import java.io.File;
import java.util.Scanner;


public class surprising {

  public static int solve(String input)
  {
    String[] inputs = input.split(" ");
    int count = Integer.parseInt(inputs[0]);
    int surprises = Integer.parseInt(inputs[1]);
    int best = Integer.parseInt(inputs[2]);
    int[] scores = new int[inputs.length - 3];
    
    for (int i = 3; i < inputs.length; i++) {
      scores[i-3] = Integer.parseInt(inputs[i]);
    }
    
    int bestCount = 0;
    int surprisesCount = 0;
    
    for (int i = 0; i < scores.length; i++) {
      int num = scores[i];
      if (best == 0) bestCount++;
      else if (num == 0) continue;
      else if (isBest(num, best)) bestCount++;
      else if (isSuprising(num, best)) surprisesCount++;
    }
    
    return bestCount + Math.min(surprisesCount, surprises);
  }
  
  public static boolean isBest(int n, int best)
  {
    int start = n / 3; 
    if (start >= best) return true;
    
    // have two remaining, and is only less by one.
    // We can get a non-surprising result this way
    int remain = n % 3;
    if (start == best - 1 && (remain == 2 || remain == 1)) return true;
    return false;
  }
  
  public static boolean isSuprising(int n, int best)
  {
    int start = n / 3;
    int remain = n % 3;
    if (start == best - 1 && remain == 0) return true;
    if (start == best - 2 && remain == 2) return true;
    return false;
  }
  
  public static void main(String[] args) {
    Scanner scanner = null;
    try {
      scanner = new Scanner(new File("A-small-attempt0.in"));
    }catch (Exception e){
      System.out.println(e.getMessage());
    }
    
    String c = scanner.nextLine();
    int i = 1;
    while (scanner.hasNextLine()) {
      String input = scanner.nextLine();
      System.out.println("Case #" + i + ": " + solve(input));
      i++;
    }
  }
}
