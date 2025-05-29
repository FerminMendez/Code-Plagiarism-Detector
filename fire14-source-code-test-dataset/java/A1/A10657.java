import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Dancing
{
  public static void main(String... args)
  {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    for (int test = 1; test <= tests; test++)
    {
      int n = sc.nextInt();
      int s = sc.nextInt();
      int p = sc.nextInt();
      List<Integer> scores = new ArrayList<Integer>(n);
      for (int i = 0; i < n; i++)
      {
        scores.add(sc.nextInt());
      }
      int result = solve(n, s, p, scores);
      System.out.println("Case #" + test + ": " + result);
    }
  }

  public static int solve(int n, int s, int p, List<Integer> scores)
  {
    java.util.Collections.sort(scores);
    java.util.Collections.reverse(scores);
    int result = 0;
    for (Integer score : scores)
    {
      int avg = score / 3;
      if (avg >= p)
      {
        result++;
        continue;
      }
      if (score - (avg * 3) > 0 && avg + 1 >= p)
      {
        result++;
        continue;
      }
      // need a surprising result
      if (score < 2 || score > 28)
      {
        // suprising results impossible here
        continue;
      }
      if (score - (avg * 3) == 2 && avg + 2 >= p && s > 0)
      {
        result++;
        s--;
        continue;
      }
      if (score - (avg * 3) == 0 && avg + 1 >= p && s > 0)
      {
        result++;
        s--;
        continue;
      }
    }
    return result;
  }
}
