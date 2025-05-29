public class Combinations
{
	/*
	 * Since for a given number 0 - 30,
	 * MAXIMUM only 2 valid set (distinct combinations) 
	 * of 3 integers (0 - 10)
	 * which add up to give the number as sum
	 * are available,
	 * We consider two such set for all the numbers from 0-30
	 */
	
	int countPopultatedSet;
	
	int s[][] = {{0,0,0},{0,0,0}};
	Surprising surprising[] = new Surprising [2];
	
	int bestResult[] = {1000 , 1000};	//1000 represents default value
										//Index 0 => for Surprising Result
										//Index 1 => for Non Surprising Result
	
	Combinations()
	{
		countPopultatedSet = 0;
		surprising[0] = new Surprising();
		surprising[1] = new Surprising();
	}
	
	boolean ignore(int x , int y , int z , int whichSurprising)
	{
		int d1 = x - y;
		int d2 = y - z;
		int d3 = z - x;
		
		if(d1 >= -2 && d1 <= 2)
		{
			if(d2 >= -2 && d2 <= 2)
			{
				if(d3 >= -2 && d3 <= 2)
				{
					if(d3 == -2 || d3 == 2 || d2 == -2 || d2 == 2 || d1 == -2 || d1 == 2)
					{
						
						surprising[whichSurprising].isSurprising = 'Y';
					}
					else
					{
						surprising[whichSurprising].isSurprising = 'N';
					}
					return false;
				}
			}
		}
		
		return true;
	}
	
	void populateSets(int x , int y , int z)
	{		
		switch(countPopultatedSet)
		{
			case 0:
				if(!(ignore(x, y, z, 0)))
				{
					s[0][0] = x;
					s[0][1] = y;
					s[0][2] = z;
					
					int tempIndex;
					
					if(surprising[0].isSurprising == 'Y')
					{
						tempIndex = 0;
					}
					else
					{
						tempIndex = 1;
					}
					
					bestResult[tempIndex] = (x > y) ? ((x > z) ? x : z) :((y>z) ? y : z);
					
					countPopultatedSet++;
				}
				break;
				
			case 1:
				if(!(ignore(x, y, z, 1)))
				{
					if(
							!(
									(x == s[0][0] && (y == s[0][1] || y == s[0][2])) ||
									(x == s[0][1] && (y == s[0][2] || y == s[0][0])) ||
									(x == s[0][2] && (y == s[0][0] || y == s[0][1]))
							)
						)
					{
						//Condition to Avoid repeat while adding
						s[1][0] = x;
						s[1][1] = y;
						s[1][2] = z;
						
						int tempIndex;
						
						if(surprising[1].isSurprising == 'N')
						{
							tempIndex = 1;
						}
						else
						{
							tempIndex = 0;
						}
						
						bestResult[tempIndex] = (x > y) ? ((x > z) ? x : z) :((y>z) ? y : z);
												
						countPopultatedSet++;
					}
				}
				break;
		}
	}	
	
	void displayCombinations(int x)
	{
		System.out.println(x + "a => ");
		
		System.out.println(s[0][0] + "," + s[0][1] + "," + s[0][2] + " : " + surprising[0].isSurprising + " Best = " + ((surprising[0].isSurprising) == 'Y' ? bestResult[0] : bestResult[1]));
		
		if(countPopultatedSet == 2)
		{
			System.out.println(s[1][0] + "," + s[1][1] + "," + s[1][2] + " : " + surprising[1].isSurprising + " Best = " + ((surprising[1].isSurprising) == 'Y' ? bestResult[0] : bestResult[1]));
		}
	}
}