import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Dancing {

	
	public static void main(String[] args) throws IOException 
	{
		File file = new File("B-small-attempt0.in");
		Scanner scanner;
		BufferedWriter out = new BufferedWriter(new FileWriter("outfile"));
		
		try
		{
			scanner = new Scanner(file);
			int testCases = scanner.nextInt();
			scanner.nextLine();  
			
			for(int numTest=0; numTest<testCases; numTest++)
			{
				int N = scanner.nextInt();
				int S = scanner.nextInt();
				int P = scanner.nextInt();
				int[] total = new int[N];
				for(int i=0; i<N; i++)
				{
					total[i]=scanner.nextInt();
				}
				
				scanner.nextLine();
				
				int count=0;
				for(int i=0; i<N; i++)
				{
					if(total[i]==0)
					{
						if(P==0)
							count++;
					}
					else if(total[i]<=3)
					{
						if(P<=1)
							count++;
					}
					else
					{
					
						int avg = total[i]/3;
						int mod = total[i]%3;
						if(mod==0)
						{
							if(avg>=P)
								count++;
							else
							{
								if((avg+1>=P)&&(S>0))
								{
									count++;
									S--;
								}
							}
						}
						if(mod==1)
						{
							if(avg+1>=P)
								count++;
						}
						if(mod==2)
						{
							if(avg+1>=P)
								count++;
							else
							{
								if((avg+2>=P)&&(S>0))
								{
									count++;
									S--;
								}
							}
						}	
					}
				}
				out.write("Case #"+(numTest+1)+": "+ count +"\n");
			}
			
			out.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
