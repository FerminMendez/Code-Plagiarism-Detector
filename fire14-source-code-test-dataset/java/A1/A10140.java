import java.io.*;
import java.util.Scanner;

class dancing
{
	public static void main(String Args[]) throws Exception
	{
		Scanner s=new Scanner(new FileReader("inputBs.in"));
		BufferedWriter b=new BufferedWriter(new FileWriter("outputBs.txt"));
		int T,S,N,p,total,score,max;
		T=s.nextInt();
		for(int I=0;I<T;I++)
		{
			total=0;
			N=s.nextInt();
			S=s.nextInt();
			p=s.nextInt();
			total=0;
			for(int i=0;i<N;i++)
			{
				score=s.nextInt();
				switch(score%3)
				{
					case 0:max=score/3;
						   if(max>=p)
						   {
								total++;
						   }
						   else if(max==p-1&&S>0&&score!=0)
						   {
								S--;
								total++;
						   }
						   break;
						   
						   
					case 1:max=score/3+1;
						   if(max>=p)
						   {
								total++;
						   }
						   break;
						   
						   
					case 2:max=score/3+1;
						   if(max>=p)
						   {
								total++;
						   }
						   else if(max==p-1&&S>0)
						   {
								S--;
								total++;
						   }
						   break;
				}
			}
			b.write("Case #"+(I+1)+": "+total);
			if(I!=T-1)
			b.write("\n");
			
		}
		s.close();
		b.close();
	}
}

