import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;


public class main {

	/**
	 * @param args
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		long now = System.currentTimeMillis();
		// TODO Auto-generated method stub
		File file = new File("./input.txt");
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		DataInputStream dis = null;
		try
		{
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			dis = new DataInputStream(bis);
			int testCaseCount = Integer.parseInt(dis.readLine()), testCase;
			for(testCase = 0; testCase < testCaseCount; testCase ++)
			{
				String[] line = dis.readLine().split(" ");
				int N = Integer.parseInt(line[0])
					, S = Integer.parseInt(line[1])
					, p = Integer.parseInt(line[2])
					, i;
				int[] g = new int[N];
				for(i = 0; i < N; i ++)
				{
					g[i] = Integer.parseInt(line[i+3]);
				}
				// Program
				int found = 0, similar = p + ( 2 * (p-1)), surprise = p + (2 * (p-2));
				if(similar < 0)
				{
					if(p > 0 )
					{
						similar = 1;
					}
					else
					{
						similar = 0;
					}
				}
				if(surprise < 0)
				{
					if(p > 0 )
					{
						surprise = 1;
					}
					else
					{
						surprise = 0;
					}
				}
				for(i = 0; i < N; i ++)
				{
					// Not surprising
					if(g[i] >= similar)
					{
						found ++;
					}
					else if(g[i] >= surprise && S > 0)
					{
						found ++;
						S --;
					}
				}
				System.out.println("Case #" + (testCase + 1) + ": " + found);
			}
			fis.close();
			bis.close();
			dis.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
