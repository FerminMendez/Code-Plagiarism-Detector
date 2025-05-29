import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class ProbC {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader("C-small-attempt0.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("C-small-attempt0.out"));
		String line = br.readLine();
		int T = Integer.parseInt(line);
		for(int i = 0; i < T; i++)
		{
			line = br.readLine();
			String[] tokens = line.split(" ");
			int A = Integer.parseInt(tokens[0]);
			int B = Integer.parseInt(tokens[1]);
			int cnt = 0;
			for(int j = A; j < B; j++)
			{
				for(int k = j + 1; k <= B; k++)
				{
					String nstr = "" + j;
					String mstr = "" + k;
					if(nstr.length() != mstr.length())
					{
						if(mstr.length() > nstr.length())
							break;
						else
							continue;
					}
					
					String tstr = nstr + nstr;
					if(tstr.contains(mstr))
						cnt++;
				}
			}
			String outputline = "Case #" + (i + 1) + ": " + cnt;
			System.out.println(outputline);
			bw.write(outputline + "\n");
		}
		br.close();
		bw.close();
	}

}
