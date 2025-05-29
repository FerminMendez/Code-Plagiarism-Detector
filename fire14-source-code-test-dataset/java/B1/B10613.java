import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) throws Exception
	{
		Scanner kb=new Scanner(new FileInputStream(args[0]));
		BufferedWriter bw= new BufferedWriter(new FileWriter(args[1]));
		int T=kb.nextInt();
		for(int i=0;i<T;i++)
		{
			long value=0;
			long x=kb.nextInt();
			long y=kb.nextInt();
			for(long k=x;k<y;k++)
			{
				String s1=new Long(k).toString();
				long lastValue=0;
				long nextValue=0;
				for(int j=1;j<s1.length();j++)
				{ 
					String u=s1.substring(j)+s1.substring(0,j);
					long u1=Long.parseLong(u);
					nextValue=u1;
					if(x<=k && k<u1 && u1<=y)
					{
						if(nextValue!=lastValue)
						{
							value++;
						}
						lastValue=nextValue;											
					}
				}					
			}
			bw.write("Case #"+(i+1)+": "+value);
			bw.newLine();
			bw.flush();
		}
		
 
bw.close();
	}

}
