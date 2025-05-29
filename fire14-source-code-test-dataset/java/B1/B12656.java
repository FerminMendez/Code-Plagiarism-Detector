import java.io.*;
import java.util.*;

public class RecycledNumbers
{
	public static void main(String[] args)throws Exception
	{
		File f = new File("recyclednumbers.txt");
		File outp = new File("recyclednumbers.out");
		Scanner sc = new Scanner(new FileReader(f));
		Writer wr = new BufferedWriter(new FileWriter(outp));
		int t = sc.nextInt();
		for(int casse=1; casse<=t; casse++)
		{
			String as = sc.next(), bs = sc.next();
			int a = Integer.parseInt(as), b = Integer.parseInt(bs);
			boolean[][] check = new boolean[b-a+1][b-a+1];
			int digits = (int) (Math.ceil(Math.log10(b)));
			for(int i=a; i<=b; i++)
			{
				String temp1 = new Integer(i).toString();
				//StringBuffer temp1 = new StringBuffer(s);
				int start=0;
				for(int j=1; j<=digits; j++)
				{
					StringBuffer temp2 = new StringBuffer(temp1.length());
					int count = 1;
					for(int k=start; count<=digits; count++, k=(k+1)%digits)
						temp2.append(temp1.charAt(k));
					start++;
					if(temp2.charAt(0)=='0')
						continue;
					int n1 = Integer.parseInt(temp1.toString());
					int n2 = Integer.parseInt(temp2.toString());
					if(a<=n2 && n2<=b)
						check[n1-a][n2-a] = check[n2-a][n1-a] = true;
				}
			}
			int count = 0;
			for(int i=0; i<check.length; i++)
				for(int j=i+1; j<check[i].length; j++)
					if(check[i][j])
						count++;
			wr.write("Case #"+casse+": "+count+"\n");
		}
		sc.close();
		wr.close();
		return;
	}
}