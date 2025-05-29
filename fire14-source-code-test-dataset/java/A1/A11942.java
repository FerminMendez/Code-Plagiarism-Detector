import java.util.*;
import java.io.*;

public class Q2 {

	static int m1(String st) {
		Scanner sc=new Scanner(st);
		int nG=sc.nextInt();
		int nS=sc.nextInt();
		int p=sc.nextInt();
		int count=0;
		int[] maxG=new int[nG];
		for (int i=0; i<nG; i++)
			maxG[i]=sc.nextInt();
		int[] m=new int[nG];
		int[] mS=new int[nG];
		for (int i=0; i<nG; i++) {
			m[i]=-1; mS[i]=-1;
		}
		for (int i=0; i<nG; i++)
			for (int x=0; x<=10; x++)
				for (int y=0; y<=10; y++)
					for (int z=0; z<=10; z++)
						if ((x+y+z==maxG[i]) && Math.abs(x-y)<=2 && Math.abs(x-z)<=2 && Math.abs(y-z)<=2)
							if (Math.max(x, Math.max(y, z))>=p)
								if (Math.abs(x-y)<2 && Math.abs(x-z)<2 && Math.abs(y-z)<2)
									m[i]=Math.max(m[i], Math.max(x, Math.max(y, z)));
								else
									mS[i]=Math.max(mS[i], Math.max(x, Math.max(y, z)));
		
		for (int a:m)
			if (a>-1)
				count++;
		for (int i=0; i<nG; i++)
			if (mS[i]>-1)
				if (nS>0 && m[i]==-1)
				{
					count++;
					nS--;
				}
		return count;
	}
	public static void main(String[] args) throws IOException {
		File inFile=new File("B-small-attempt1.in");
		File outFile=new File("B-small-attempt1.out");
		BufferedReader br=new BufferedReader(new FileReader(inFile));
		PrintWriter out=new PrintWriter(new FileWriter(outFile));
		StringBuilder sb=new StringBuilder();
		int ntc=Integer.parseInt(br.readLine());
		for (int tc=1; tc<=ntc; tc++)
		{
			String s=br.readLine();
			sb.append("Case #"+tc+": "+m1(s)+"\n");
		}
		out.write(sb.toString());
		br.close();
		out.close();
	}
}
