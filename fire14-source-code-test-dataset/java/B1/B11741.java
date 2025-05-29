import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


/**
 *Recycled Numbers
 */

/**
 * @author Avengee
 */

public class Demo {

	public static void main(String[] args) throws IOException {
		//Reading and Writing Files
		Scanner scan = new Scanner(new File("C-small-attempt0.in"));
		FileWriter writer = new FileWriter("C-small-output.txt");
		PrintWriter pw = new PrintWriter(writer);

		//variable declaration
		int T,A,B;
	
		//code
		T = scan.nextInt();
		for (int i=1;i<=T;i++) 
		{
			A = scan.nextInt();
			B = scan.nextInt();
			int y=0;
			
			int num=String.valueOf(A).length();//number of digits
			int nl=A;
			
			while(nl<=B)
			{
				int n=nl;
			for(int j=1;j<num;j++)
			{
				int m,mult=1;;
				
				int k=n%10;
				n/=10;
				for(int l=1;l<num;l++)
					mult*=10;
				m=(k*mult)+n;
				if(m>nl && m<=B)
					{y++;
					//System.out.println(nl+" "+m);
					}
				n=m;
			}
			nl++;
			
			}
			
			System.out.println("Case #"+i+": "+y);
			pw.println("Case #"+i+": "+y);
			
		}
	
		scan.close();
		writer.close();	
	}
	

}


