
import java.util.*;
public class C {

	public static void main (String[] args)
	{	
			String bIn;
			Scanner in = new Scanner(System.in);
			
			int T = Integer.parseInt(in.nextLine());
			
			for (int test = 0 ; test < T ; test++)
			{
				String range = in.nextLine();
				String[] cIN = range.split(" ");
				int max = Integer.parseInt(cIN[1]);
				int min = Integer.parseInt(cIN[0]);
				int count = 0;
				for (int findPair = min ; findPair <= max ; findPair ++)
				{
					String thisOne = String.valueOf(findPair);
					
					String[] gothrough = thisOne.split("");
					int digitLength = gothrough.length-1;
					
					int sameTest = Integer.parseInt(thisOne);
					
				//	System.out.println(digitLength);
					
					for (int shuffle1 = 0 ; shuffle1 < digitLength ; shuffle1++)
					{
		
							String temp = thisOne.substring(shuffle1)+thisOne.substring(0,shuffle1);
						//	System.out.println(temp);
							
							int test1 = Integer.parseInt(temp);
							
							if (test1 <= max && test1 >= min && test1 != sameTest)
							{
							//	System.out.println(test1);
							//	System.out.println("( "+thisOne+","+test1+")");
								count++;
							}
			
					}
					
				}
				count = count/2;
				System.out.println("Case #"+(test+1)+": "+count);
			}

	}
	

}