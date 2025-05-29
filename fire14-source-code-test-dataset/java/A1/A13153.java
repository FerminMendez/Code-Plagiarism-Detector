import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;






public class B { 

	static String inner = "input.in";
	static Scanner scan;
	public static void main (String[]args) throws IOException
	{
		File f = new File (inner);
		File out = new File("output.out");
		FileWriter wr; 
		wr = new FileWriter(out); 
		scan = new Scanner(f); 
		int test = scan.nextInt();
		scan.nextLine();
		for(int i = 0 ; i < test ; i++)
		{
			Scanner sc = new Scanner (scan.nextLine());
			int n = sc.nextInt();
			int surp = sc.nextInt();
			int p = sc.nextInt();
			int [] ggs = new int[n];
			for(int j = 0 ;j < n ; j++)
				ggs[j] = sc.nextInt();  
			String ret = "Case #"+ (i+1)+": ";
			 
			int zero =0;
			int one = 0;
			int twolow = 0;
			int lowhigh = 0;
			int high  = 0;
			int top = 0;
			for(int j = 0 ;j < n ; j++)
			{
				if(ggs[j] == 0)
					zero++;
				else if(ggs[j]<2)
					one++;
				else if(ggs[j]< 3*p-4)
					twolow++;
				else if(ggs[j] < 3*p-2)
					lowhigh++;
				else if(ggs[j]< 29)
					high++;
				else
					top++; 
			}
			if(p == 0)
				ret += ""+n;
			else if(p == 1 )
				ret += ""+ (n-zero);
			else
				ret += (Math.min(surp,lowhigh ) + high + top)+"";  
			wr.write(ret+"\n");
			
		}
		
		
		
		 
		 wr.flush();
	}
}
