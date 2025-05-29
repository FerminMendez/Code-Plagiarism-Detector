import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dancer {

public static void main(String args[]) throws FileNotFoundException{
		
		Scanner in=new Scanner(new FileInputStream("input2.txt"));
		
		int T=in.nextInt();
		
		System.out.println("T : " + T);
		
		int N,P,S,temp;
		
		int clear=0,surprise=0;
		
		for(int i=1;i<=T;i++)
		{
			clear=0;
			
			surprise=0;
			
			N=in.nextInt();
			
			S=in.nextInt();
			
			P=in.nextInt();
			
			//System.out.println("N : " + N);
			
			//System.out.println("S : " + S);
			
			//System.out.println("P : " + P);
			
			
			if(P==0)
			{
				for(int j=1;j<=N;j++)
				{
					temp=in.nextInt();
						clear++;
				}
			}
			
			else if(P==1)
			{
				for(int j=1;j<=N;j++)
				{
					temp=in.nextInt();
					
					if(temp>=P)
						clear++;
				}
			}
			
			else{
			for(int j=1;j<=N;j++)
			{
				temp=in.nextInt();
				
				if(temp>3*P-3)
					clear++;
				
				else if((temp==3*P-3)||(temp==3*P-4))
					surprise++;
			}
			//System.out.println("clear: " + clear);
			
			//System.out.println("surprise : " + surprise);
			}
			System.out.println("Case #" + i + ": " + (clear+Math.min(surprise,S)));
		}
		
	}
}
