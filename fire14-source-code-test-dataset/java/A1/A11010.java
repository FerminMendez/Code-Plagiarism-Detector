import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeJam3 {
	public static void main(String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcases = Integer.parseInt(br.readLine());
		for(int ii=1;ii<=testcases;++ii)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int cnt=0;
			
			int p34 = 3*p-4;
			int p33 = 3*p-3;

			if(p34 < 0 )
				p34 = 0;

			for(int i=0; i<num ; ++i)
			{
				int curr = Integer.parseInt(st.nextToken());
				if(curr > p33)
					cnt++;
				else if(curr >= p34 && s > 0 && curr >= p)
				{
					--s;
					cnt++;
				}
			}
			System.out.println("Case #"+ii+": "+cnt);
		}
	}
}
