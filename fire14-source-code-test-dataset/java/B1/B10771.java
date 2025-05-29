import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;


public class C {

	Scanner in;
	public C()
	{
		in = new Scanner(System.in);
		int t = in.nextInt();               // number of test cases ...:)
		for(int l=1;l<=t;l++)
		{
			int n = in.nextInt();           // got n 
            
			int m = in.nextInt();           // got m
			
			int temp=0;                     // For Every data set it has to change 
			int temp2=0;
			int reverse=0;
			int reverse2=0;
			int count=0;
			
			if(n>=10 &&m<100)
			{
				for(int i=n;i<=m;i++)
				{
					temp=i;
					while( temp != 0 )
				      {
				          reverse = reverse * 10;
				          reverse = reverse +temp%10;
				          temp = temp/10;
				      }
					
					
					
					
					if((reverse>=n)&&(reverse<=m)&&(reverse!=i))
					{
						count++;
						
					}
					reverse=0;
				
				}
				
				count=count/2;
			}
			if(n>99 && m<=1000)
			{
				for(int i=n;i<=m;i++)
				{
					 temp=temp2=i;
					
				     
				     reverse = reverse +temp%10;
				     reverse2 = reverse2+temp%100;
				     temp = temp/10;
				     temp2=temp2/100;
				     reverse = (reverse * 100)+temp;      //one position replaced 
				     reverse2= (reverse2*10)+temp2;       //two position interchange
					
					 
					
					if((reverse>=n)&&(reverse<=m)&&(reverse!=i))
						
					{
						count++;
					}
					reverse=0;
					
                    if((reverse2>=n)&&(reverse2<=m)&&(reverse2!=i))
						
					{
						count++;
					}
					reverse2=0;
				
			}
				count=count/2;
		}
			System.out.printf("Case #%d: %d\n", l,count);
	}
	
	}
	public static void main(String[] args) {
		
		try
		{
			String inp="C-small-attempt0";
			System.setIn(C.class.getResourceAsStream(inp+".in"));
			System.setOut(new PrintStream(new File("outputC.out")));
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		new C();

	}

}
