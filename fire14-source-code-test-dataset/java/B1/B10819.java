import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashSet;
import java.util.Set;


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
				int A = Integer.parseInt(line[0]), B = Integer.parseInt(line[1]), found = 0, n, m, k;
				String N, M;
				Set<String> used = new HashSet<String>();
				for(n = A; n <= B; n ++)
				{
					N = n + "";
					for(k = 1; k < N.length(); k ++)
					{
						M = N.substring(k, N.length()) + N.substring(0, k);
						M = M.replaceAll("^0+", "");
						m = Integer.parseInt(M);
						if(m > n && m <= B && ! used.contains(N+M))
						{
							found ++;
							used.add(N+M);
						}
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
