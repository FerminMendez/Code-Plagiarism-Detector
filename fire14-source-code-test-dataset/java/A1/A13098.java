import java.io.*;
import java.util.*;
public class Qual22B
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader ips=new BufferedReader(new FileReader("B-small-attempt2.in"));
		PrintWriter ops=new PrintWriter(new FileWriter("dwgop.in"));
		int T=Integer.parseInt(ips.readLine());
		for(int i=0; i<T;i++)
		{
			String line=ips.readLine();
			char[] ca=line.toCharArray();
			int j=0, G=0, S=0, p=0;
			for(j=0; ca[j]!=' ';j++)
				G=(G*10)+(ca[j]-'0');
			//System.out.println("Googlers: "+G);
			j++;
			for( ; ca[j]!=' ';j++)
				S=(S*10)+(ca[j]-'0');
			j++;
			//System.out.println("Surprises: "+S);
			for( ; ca[j]!=' ';j++)
				p=(p*10)+(ca[j]-'0');
			//System.out.println("Best score: "+p);
			j++;
			int[] ts= new int[G];
			for(int k=0; k<G; k++)
				ts[k]=0;
			for(int k=0; k<G;k++)
			{
				while( j<ca.length  && ca[j]!= ' ')
				{
					ts[k]=(ts[k]*10)+(ca[j]-'0');
					//System.out.print(ts[k]+" ");
					j++;
				}
				j++;
			}
			//System.out.println("");
			Arrays.sort(ts);
			int mod=0, sc=0, count=0;
			int[][] marks=new int[G][3];
			for(int k=G-1; k>=0; k--)
			{
				mod=ts[k]%3;
				for(int l=0; l<3; l++)
					marks[k][l]=ts[k]/3;
				if(mod==2)
				{
					if(sc<S && marks[k][0]!=9 && (((ts[k]/3)+2) == p )) 
					{
						marks[k][0]= marks[k][0]+2;
						sc++;
					}
					else
					{
						for(int l=0; l<2; l++)
							marks[k][l]=marks[k][l]+1;
					}		
				}
				else
				{
					if(mod==1)
					{
						marks[k][0]=marks[k][0]+1;
					}
					else
					{
						if(mod==0 && (((ts[k]/3)+1) ==p) && (ts[k]/3 != 0))
						{
							if(sc<S)
							{
								marks[k][0]=marks[k][0]+1;
								marks[k][1]=marks[k][1]-1;
								sc++;
							}
						}
					}
				}
			} 
			for(int k=0; k<G; k++)
			{
				for(int l=0; l<3; l++)
				{
					//System.out.print(marks[k][l]+" ");
					if(marks[k][l]>=p)
					{
						count++;
						break;
					}
				}
				//System.out.println("");
			}
			ops.println("Case #"+(i+1)+": "+count);
		}
		ips.close();
		ops.close();
	}
}