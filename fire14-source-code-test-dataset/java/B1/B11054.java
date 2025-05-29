import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeJam {
	public static void main(String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		for(int ii=1;ii<=num;++ii)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int begin = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cnt=0;

			for(int i=begin; i<=end ; ++i)
			{
				int line = i;
				String orig = Integer.toString(line);
				String curr = orig;
				for(int j = 0; j<orig.length(); ++j )
				{
					curr = curr.substring(1) + curr.charAt(0);
					int intcurr = Integer.parseInt(curr);
					if(intcurr == line)
						break;
					if(intcurr >= begin && intcurr <=end && intcurr > line)
						cnt++;
				}
			}
			System.out.println("Case #"+ii+": "+cnt);
		}
	}
}
