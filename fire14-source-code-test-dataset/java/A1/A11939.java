package dancingWithGooglers;


public class BestResult 
{
	public int result(String input)throws Exception
	{
		String[] array= input.split(" ");
		int noOfGooglers = Integer.parseInt(array[0]);
		int surprising = Integer.parseInt(array[1]);
		int p = Integer.parseInt(array[2]);
		int x;
		int[] listOfBestResults = new int[noOfGooglers];
		int count = 0;
		for(int i=3;i<array.length;i++)
		{
			x = Integer.parseInt(array[i]);
			if(canItBeBestResult(x, p))
			{
				listOfBestResults[count] = x;
				count++;
			}
		}
		int bestResultCount = 0;
		for(int i=0;i<count;i++)
		{
			if(listOfBestResults[i]%3 == 2)
			{
				if(listOfBestResults[i]/3>=p)
				{
					System.out.println("list of best result w/o surprising " + listOfBestResults[i]);
					bestResultCount++;
				}
				
				else if((listOfBestResults[i]/3) + 2>=p && (listOfBestResults[i]/3) + 1>=p)
				{
					System.out.println("list of best result w/o surprising " + listOfBestResults[i]);
					bestResultCount++;
				}
				else if((listOfBestResults[i]/3) + 2>=p && surprising!=0)
				{
					System.out.println("list of best result surprising " + listOfBestResults[i]);
					bestResultCount++;
					surprising--;
				}
			}
			else if(listOfBestResults[i]%3 == 1 )
			{
				if(listOfBestResults[i]/3>=p)
				{
					System.out.println("list of best result w/o surprising " + listOfBestResults[i]);
					bestResultCount++;
				}
				else if((listOfBestResults[i]/3) + 1>=p)
				{
					System.out.println("list of best result w/o surprising " + listOfBestResults[i]);
					bestResultCount++;
				}
				else if((listOfBestResults[i]/3) + 1>=p && surprising!=0)
				{
					System.out.println("list of best result surprising " + listOfBestResults[i]);
					bestResultCount++;
					surprising--;
				}
			}
			else if( listOfBestResults[i]%3 == 0 )
			{
				if(listOfBestResults[i]/3>=p)
				{
					System.out.println("list of best result w/o surprising " + listOfBestResults[i]);
					bestResultCount++;
				}
				
				else if((listOfBestResults[i]/3) + 1>=p && surprising!=0)
				{
					System.out.println("list of best result surprising " + listOfBestResults[i]);
					bestResultCount++;
					surprising--;
				}
			}
			
		}
		return bestResultCount;
		
	}
	public boolean canItBeBestResult(int x, int p)
	{
		if(p==0)
		{
			return true;
		}
		if( x%3 == 2 && ((x/3)+2) >= p)
		{
			return true;
		}
		else if( x%3 == 1 && ((x/3)+1) >= p)
		{
			return true;
		}
		else if( x%3 == 0 && ((x/3)+1)>=p && x!=0)
		{
			return true;
		}
		
		return false;
	}
}
