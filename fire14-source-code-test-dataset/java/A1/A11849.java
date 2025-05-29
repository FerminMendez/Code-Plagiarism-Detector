


public class DancingWithTheGooglers extends ProgrammingProblem
{

  static int min[] = { 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 9, 9, 9, 10, 10, 10 };
  static int max[] = { 0, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 9, 9, 9, 10, 10, 10, 10, 10 };

  int N, S, p, t[];

  @Override
  protected void print()
  {

  }

  @Override
  protected void readInput()
  {
    N = sc.nextInt();
    S = sc.nextInt();
    p = sc.nextInt();
    t = new int[N];
    for (int i = 0; i < N; i++)
    {
      t[i] = sc.nextInt();
    }
  }

  @Override
  protected String execute()
  {
    int c = 0;
    for (int i = 0; i < N; i++)
    {
      if (min[t[i]] >= p || (max[t[i]] >=p && S-- > 0 ))
      {
        c++;
      }
    }

    return c + "";
  }

  public static void main(String[] args) throws Exception
  {
    DEBUG = false;
    main(DancingWithTheGooglers.class);
  }
}
