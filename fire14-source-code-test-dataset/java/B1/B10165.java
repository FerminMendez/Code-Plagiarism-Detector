import java.io.*;
import java.util.*;
public class RecycledNumbers
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[][] ab = new int[T][2];
		StringTokenizer st = null;
		for (int i=0; i<T; i++)
		{
			st = new StringTokenizer(br.readLine());
			ab[i][0]=Integer.parseInt(st.nextToken());
			ab[i][1]=Integer.parseInt(st.nextToken());
		}
		for (int i=0; i<T; i++)
		{
			System.out.print("Case #"+(i+1)+": ");
			int c=0;
			int dig = (int)Math.log10(ab[i][0]);
			for (int j=ab[i][0]; j<=ab[i][1]; j++)
			{
				int newno=j;
				do
				{
					int last = newno%10;
					newno/=10;
					newno = (int) (last*Math.pow(10,dig) + newno);
					if (newno == j)
						break;
					if (newno <= ab[i][1] && newno >= ab[i][0] && j<newno)
						c++;
				} while (true);
			}
			System.out.println(c);
		}
	}
}
