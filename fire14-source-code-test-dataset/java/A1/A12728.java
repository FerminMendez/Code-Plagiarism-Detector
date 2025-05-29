import java.util.*;

public class B {

public static void main(String[] args)

	{
			Scanner in = new Scanner(System.in);
			
			int T = Integer.parseInt(in.nextLine());
			
			for (int test = 0 ; test < T ; test ++)
			{

				String input = in.nextLine();
				String[] bIn = input.split(" ");
				
				int googlersNum = Integer.parseInt(bIn[0]);
				int suprisingMax = Integer.parseInt(bIn[1]);
				int requirement = Integer.parseInt(bIn[2]);
				
				int okay=0;
				int suprising=0;
				
				for (int run = 0 ; run < googlersNum ; run ++)
				{
			
					int S = Integer.parseInt(bIn[3+run]);

					int temp = S;
					boolean testCase = false,done=false;
			
		
					for (int i = 10 ; i >= 0 ; i--)
					{
						for (int j =  i ; j >= i-1 && j >= 0; j--)
						{
							for (int k = i ; k >= i-1  && k >= 0; k --)
							{
									temp = temp - k  - i - j;

									if (temp == 0) 
									{ 
									
										if ((i >= requirement || j >= requirement || k >= requirement) && !done)
										{
											okay++;
											done = true;
										}
									
									}
									temp = S;
							}
						}
					}	
				
					temp = S;
				
					if (!testCase && suprising < suprisingMax)
					{
						for (int i = 10 ; i >= 0 ; i--)
						{
							for (int j = i ; j >= i-2 && j >= 0 ; j--)
							{
								for (int k = i ; k >= i-2  && k >= 0 ; k--)
								{
									temp = temp - i - k - j;
									if (temp == 0) 
									{ 
										if ((i >= requirement || j >= requirement || k >= requirement) && !done)
										{
											testCase = true;
											suprising++;
											okay++;
											done = true;
										}
									
									}
									temp = S;

								}
							}
						}
					}
				}
				
				System.out.println("Case #"+(test+1)+": "+okay);
			}
					
			in.close();
	}
	
}
			
			