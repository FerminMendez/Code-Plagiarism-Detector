import java.io.*;


class RecycledNumbers
{	
	public static void main(String a[]) throws Exception
	{
		BufferedReader br=new BufferedReader( new InputStreamReader(System.in) );
		int testCases=Integer.parseInt(br.readLine());
		int counter=0;
		
		for(int i=0;i<testCases;i++)
		{
			int count=0;
			String [] s=br.readLine().split(" ");
			int lowerLimit=Integer.parseInt(s[0]);
			int upperLimit=Integer.parseInt(s[1]);
			// all the combinations
			int noOfCombinations=s[0].length();
			for(int number=lowerLimit;number<=upperLimit;number++)
			{
				// System.out.print(number);
				int temp=number;
				int lastDigit=0;
				int [] doubling=new int[noOfCombinations];
				for(int ii=0;ii<noOfCombinations-1;ii++)
				{
					lastDigit=temp%10;
					// System.out.print("lastDigit-"+lastDigit);
					temp=(temp/10)+(int)Math.pow(10,(noOfCombinations-1))*lastDigit;
					// System.out.print("::::"+temp);
					if( (number<temp) && (temp<=upperLimit) )
					{
						doubling[ii]=temp;
						int j=0;
						for(j=0;j<ii;j++)
						{
							if(temp==doubling[j])
								break;
						}
						if(j==ii)		
						{
							count++;
							// System.out.println(number+" : "+temp);
						}
					}
				}
				
			}
			//str is changed now, to set to original add ""str=str.charAt(noOfCombinations)+str.substring(noOfCombinations-1);""
			System.out.println("Case #"+(++counter)+": "+count);
		}
	}
	

}