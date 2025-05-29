import java.io.*;
import java.util.*;

class recycled
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
		String inp;
		int i,j;

		int T=Integer.valueOf(r.readLine());
		for(int a=0;a<T;a++)
		{
			/*consists of a single line containing the integers A and B. */
			String[] tmp =r.readLine().split("\\s");
			int A = Integer.valueOf(tmp[0]);
			int B = Integer.valueOf(tmp[1]);
			int y=0;
			HashSet<String> stv = new HashSet<String>();
			for(i=A;i<=B;i++) {
				String s = ""+i;
				for(j=1;j<s.length();j++) {
					String sj = s.substring(j) + s.substring(0,j);
					int k = Integer.valueOf(sj);
					String str="("+s+","+sj+")";
					if (k>i && k<=B && !stv.contains(str)) {
						y++;
						stv.add(str);
					}
				}
			}
			
			System.out.println("Case #"+(a+1)+": "+y);
		}
	}
}

