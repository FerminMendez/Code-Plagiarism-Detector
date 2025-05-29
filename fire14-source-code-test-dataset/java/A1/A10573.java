import java.io.*;
import java.util.*;

class dancing
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
		String inp;
		int i,j;

		int T=Integer.valueOf(r.readLine());
		for(int a=0;a<T;a++)
		{
			/*The first integer will be N, the number of Googlers, and the second integer will be S, the number of surprising triplets of scores. The third integer will be p, as described above. Next will be N integers ti: the total points of the Googlers. */
			String[] tmp =r.readLine().split("\\s");
			int N = Integer.valueOf(tmp[0]);
			int S = Integer.valueOf(tmp[1]);
			int p = Integer.valueOf(tmp[2]);
			int y = 0;
			for(i=0;i<N;i++) {
				int ti = Integer.valueOf(tmp[i+3]);
				if (ti >= (p*3)-2) y++;
				else if ((ti >= (p*3)-4) && ((p*3)-4>0) && S>0) {
					S--; y++;
				}
			}


			System.out.println("Case #"+(a+1)+": "+y);
		}
	}
}

