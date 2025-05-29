import java.util.ArrayList;
import java.util.Scanner;

public class recycled
{
  public static void main(String[] args)
  {
    Scanner in = new Scanner (System.in);
    String scases = in.nextLine(); 
    int T = Integer.parseInt(scases);
    for(int i = 1; i<(T+1); i++)
    {
      String temp1 = in.nextLine();
      String[] temp2 = temp1.split(" ");
      int low = Integer.parseInt(temp2[0]); 
      int high = Integer.parseInt(temp2[1]);
      int count = 0;
      ArrayList<String> checked = new ArrayList<String>();
      for(int test = low; test < high; test++)
      {
	String stest = Integer.toString(test);
	int len = stest.length();
	for(int pos = 1; pos < (len) ; pos++)
	{
	  String scheck = "";
	  scheck += stest.charAt(len-1);
	  scheck += stest.substring(0,len-1);
	  stest = scheck;
	  int check = Integer.parseInt(scheck);

	    if(check > test && check <= high)
	    {
	      count = count +1;
	      checked.add(scheck);
	    }

	  
	}
      }
      System.out.println("Case #"+ i +": "+count);
    }
  }

}
