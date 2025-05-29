import java.util.*;
import java.io.*;

public class Q3 {

	static int m1(String s) {
		int count=0;
		Scanner sc=new Scanner(s);
		int a=sc.nextInt(), b=sc.nextInt();
		String s1=null, s2=null;
		for (int n=a; n<b; n++)
		{
			for (int m=n+1; m<=b; m++)
			{
				s1=String.valueOf(n); s2=String.valueOf(m);
				if (s1.length()==s2.length())
				{
					List<String> iso=new ArrayList<String>();
					for (int i=0; i<s1.length()-1; i++)
						iso.add(s1.substring(s1.length()-i-1)+s1.substring(0, s1.length()-i-1));
					for (String ss:iso)
						if (ss.equals(s2))
							count++;
				}
			}
		}
		return count;
	}
	public static void main(String[] args) throws IOException {
		File inFile=new File("C-small-attempt0.in");
		File outFile=new File("C-small-attempt0.out");
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
