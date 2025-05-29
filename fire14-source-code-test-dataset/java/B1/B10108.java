import java.util.*;

public class Main
{

  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    Integer numCases = Integer.parseInt(in.nextLine());
    
    for (int k = 0; k < numCases; k++)
    {
      Integer num1 = Integer.parseInt(in.next());
      int num2 = Integer.parseInt(in.next());
      int count = 0;
      //ArrayList<Integer> tested = new ArrayList<Integer>();
      
      for (Integer i = num1; i <= num2; i++)
      {
	String number = i.toString();
	for (int j = 1; j < number.length(); j++)
	{
	  
	    String front = number.substring(j);
	    String newNumber = front + number.substring(0, j);
	    
	    Integer result = Integer.parseInt(newNumber);
	    
	    if (result > i && result <= num2)
	    {
	      /*tested.add(result);
	      tested.add(i);
	      System.out.println(result);*/
	      count++; 
	    }
	}
	//tested.add(i);
      }
      System.out.println("Case #"+(k+1)+": "+count);
    }
  }

}