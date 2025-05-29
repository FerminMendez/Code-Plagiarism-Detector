import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;



public class RecycledNum {

	
	public static void main(String[] args) throws IOException
	{
		File file = new File("C-small-attempt0.in");
		Scanner scanner;
		BufferedWriter out = new BufferedWriter(new FileWriter("outfile1"));
		
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
				int totalcount=0;
				
				Stack<Integer> st = new Stack<Integer>();
				int numDigit =0;
				int temp = A;
				while(temp != 0)
				{
					st.push(temp%10);
					numDigit++;
					temp=temp/10;	
				}
				int[] digitsA = new int[numDigit];
				for(int i=0; i<numDigit; i++)
					digitsA[i]= st.pop();
				int[] digitsB = new int[numDigit];
				temp=B;
				int index=numDigit;
				while(temp != 0)
				{
					digitsB[index-1]=(temp%10);
					index--;
					temp=temp/10;	
				}
				
				
				
				int numofInt = B-A+1;
				boolean[] mark = new boolean[numofInt];
			
				
				for(int num=A; num<=B; num++)
				{
				
					int[] curDigits = new int[numDigit];
					temp = num;
				    index=numDigit;
					while(temp!=0)
					{
						curDigits[index-1]=(temp%10);
						index--;
						temp=temp/10;	
					}
					int count = 0;
					for(int j=0; j<numDigit; j++)
					{
						boolean cycle = false;
						if(curDigits[j]!=0)
						{
							int sum=0;
							int curindex=j;
							for(int kk=0; kk<numDigit; kk++)
							{
						
					
								if(curindex>=numDigit)
								
									sum=sum*10+curDigits[curindex-numDigit];
								else
									sum=sum*10+curDigits[curindex];
								curindex=curindex+1;
								
							}
				
							if((sum<=B)&&(sum>=A))
								cycle=true;
							
							
							
							if(cycle==true)
							{
								
							
								
								if(mark[sum-A]!= true)
								{
									mark[sum-A]= true;
									count++;
				
								}	
							}
							
						}
					}
					
					if(count==7)
						totalcount=totalcount+21;
					else if(count==6)
						totalcount=totalcount+15;
					else if(count==5)
						totalcount=totalcount+10;
					else if(count==4)
						totalcount=totalcount+6;
					else if(count==3)
						totalcount=totalcount+count;
					else if(count==2)
						totalcount=totalcount+1;
					
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
