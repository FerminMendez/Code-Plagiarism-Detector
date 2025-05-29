import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
public class RecycledNo
{
  private Scanner input = null;
  private PrintWriter output = null;
  private int numOfCases;
  int getNextCount=0;
  ArrayList<String> al = new ArrayList<String>();
  public static void main(String[] args)
  {
    RecycledNo myRecycle = new RecycledNo();
//    for (int i=1;i<=12;i++)
//    {
//      System.out.println(myRecycle.getNext(1,10));
//    }
    //System.out.println(myRecycle.recycle("123456789",5));
    try
    {
      myRecycle.solve();
    }
    catch(IOException ioe)
    {
      System.out.println("oops");
      System.exit(0);
    }
  }
  public int getNext(int a, int b)
  {
    getNextCount=getNextCount+1;
    if(a+getNextCount-1<=b)
      return a+getNextCount-1;
    else
      return -1;
  }
  public int recycle(String numString, int loc) //recycled part begins with loc, including. Use 1,2,3 as index, excluding 0
  {
    String newNumString = numString.substring(loc-1)+numString.substring(0,loc-1);
    try
    {
      return Integer.parseInt(newNumString);
    }
    catch(NumberFormatException NFE)
    {
      System.out.println("wrong format");
    }
    return -1;
  }
  public void solve() throws IOException
  {
    input = new Scanner(new File("C-small-attempt0.in"));
    output = new PrintWriter("output.txt");
    numOfCases = input.nextInt();
    for (int i = 1; i <= numOfCases; i++)
    {
      int min=input.nextInt();
      int max=input.nextInt();
      int count = 0;
      for(int j = 1; j<=max-min+1;j++)
      {
        int nextInt=getNext(min,max);
        String s = ""+nextInt;
        
        for (int k = 2; k<=s.length();k++) //loop for a specific getNext()
        {
          
          if (s.charAt(k-1)=='0')
            continue;
          
          
          if((recycle(s,k)<=max)&&(recycle(s,k)>=min)&&(recycle(s,k)>nextInt)&&(!al.contains(""+recycle(s,k))))
          {
            count = count + 1;
            //System.out.println(s+" "+recycle(s,k));
          }
          al.add(""+recycle(s,k));
        }
        al.clear();
      }
      output.println("Case #"+i+": "+count);
      getNextCount=0;
    }
    output.close();
    input.close();
  }
}