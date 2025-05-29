import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class one {
	public static void main(String[] args) {
		try {
			Scanner in = new Scanner(new File(args[0]));
			PrintWriter out = new PrintWriter( new FileWriter(args[1]));
			int T = in.nextInt();
			for(int i=0;i<T;i++)
			{
				int res = 0;
				int n = in.nextInt();
				int t[] = new int[n];
				int s = in.nextInt();
				int p = in.nextInt();
				for(int j=0;j<n;j++)
					t[j]=in.nextInt();
				for(int j=0;j<n-1;j++)
					for(int k=j+1;k<n;k++)
						if(t[j]<t[k])
						{
							int temp=t[k];
							t[k]=t[j];
							t[j]=temp;
						}
				int j=0;
				while(j<n)
				{
					if(t[j]>=3*p-2)
						res++;
					else if(s>0 && (t[j]==3*p-3 || t[j]==3*p-4) && t[j]>0)
					{
						res++;
						s--;
					}
					j++;
				}
				out.println("Case #"+(i+1)+": "+res);
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
