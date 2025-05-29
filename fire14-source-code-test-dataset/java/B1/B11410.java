import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;


public class Recycled {

	public static String cycleString(String str)
	{
		String first = str.substring(0, 1);
		String newstr = str.substring(1)+first;
		return newstr;
	}
	
	public static void main(String[] args) throws IOException
	{
		
		File file = new File("C-small-attempt0.in");
		Scanner scanner;
		BufferedWriter out = new BufferedWriter(new FileWriter("outfile"));
		
		try
		{
			scanner = new Scanner(file);
			int testCases = scanner.nextInt();
			scanner.nextLine();  
			
			for(int numTest=0; numTest<testCases; numTest++)
			{
				int A = scanner.nextInt();
				int B = scanner.nextInt();
				scanner.nextLine();
				int totalcount = 0;
				String str = String.valueOf(A);
				int digits = str.length();
				ArrayList<Integer> number = new ArrayList<Integer>();
				
				for(int i=A; i<=B; i++)
				{
					if(!number.contains(i))
					{
						int count = 0;
						String temp = String.valueOf(i);
						for(int j=0; j<digits-1; j++)
						{
							String cyclestr = cycleString(temp);
		
							if(!cyclestr.substring(0,1).equals("0"))
							{
								int cycled = Integer.parseInt(cyclestr);
								if(!number.contains(cycled))
								{
									if ((cycled<=B)&&(cycled!=i)&&(cycled>=A))
									{
										number.add(cycled);
										count++;
										if(!number.contains(i))
										{
											number.add(i);
											count++;
										}
									}
								}
							}
							temp = cyclestr;
						}
						if(count==4)
							totalcount=totalcount+6;
						else if(count==3)
							totalcount=totalcount+count;
						else if(count==2)
							totalcount=totalcount+1;		
							
					}
				}
				out.write("Case #"+(numTest+1)+": "+ totalcount +"\n");
			}
			
			out.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
