import java.util.*;

class Recycle
{
  public static int compute(int lowerBound, int upperBound)
  {
    int count = 0;
    int numDigits = 1 + (int)Math.log10(lowerBound);
    int new_num, cut;
    boolean[] check = new boolean[upperBound-lowerBound+1];
    boolean[] check2;
    
    if(lowerBound/10 == 0)
      return 0;
    else
    {
      for(int i = lowerBound; i <= upperBound-2; i++)
      {
        check[i-lowerBound] = true;
        check2 = new boolean[upperBound-lowerBound+1];
        for(int j = 1; j < numDigits; j++)
        {
          cut = i % (int)Math.pow(10,j);
          new_num = cut*(int)Math.pow(10,numDigits-j) + i/(int)Math.pow(10,j);
          if(new_num > i && new_num <= upperBound && !check[new_num-lowerBound] && !check2[new_num-lowerBound])
          {
            check2[new_num-lowerBound] = true;
            count++;
          }
        }
      }
    }
    return count;
  }
  
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int numCase, lowerBound, upperBound;
    
    numCase = sc.nextInt();
    for(int i = 0; i < numCase; i++)
    {
      lowerBound = sc.nextInt();
      upperBound = sc.nextInt();
      System.out.println("Case #"+(i+1)+": "+compute(lowerBound,upperBound));
    }
  }
}