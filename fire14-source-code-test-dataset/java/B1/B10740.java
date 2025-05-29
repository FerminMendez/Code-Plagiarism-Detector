import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class problem3
{
	void main()
	{
		solve();
	}
	
	public void solve()
	{
		try
		{
			FileInputStream fstream = new FileInputStream("pr3_input.txt");
			DataInputStream in      = new DataInputStream(fstream);
			BufferedReader  br      = new BufferedReader(new InputStreamReader(in));
			
			FileWriter fout = new FileWriter("output.txt");
			BufferedWriter out = new BufferedWriter(fout);
			
			int iCases = Integer.parseInt(br.readLine());
			
			for (int iStep = 0; iStep < iCases; iStep++)
			{
				String strLine = br.readLine();
				String[] myNumbers = strLine.split(" ");
				int A = Integer.valueOf(myNumbers[0]).intValue();
				int B = Integer.valueOf(myNumbers[1]).intValue();
				int digits = myNumbers[0].length();
				
				int iValue = 0;
				for (int jStep = A; jStep <= B; jStep++)
				{
					List<Integer> pairs = new ArrayList<Integer>();
					
					for (int kStep = 1; kStep < digits; kStep++)
					{
						int m = perm(jStep, kStep);
						if ((A <= jStep)&&(jStep < m)&&(m <= B))
						{
							if (false == pairs.contains(m))
							{
								iValue++;
								pairs.add(m);
							}
						}
					}
				}
				
				if (iStep != (iCases - 1))
				{
					out.write(String.format("Case #%d: %d\n", iStep + 1, iValue));
				}
				else
				{
					out.write(String.format("Case #%d: %d", iStep + 1, iValue));
				}
			}
			out.close();
		}
		catch (Exception e)
		{
			  System.err.println("Error: " + e.getMessage());
		}
	}
	
	public int perm(int iNumber, int iDigitsPerm)
	{
		String strNumber = String.format("%d", iNumber);
		String strReturn = strNumber.substring(strNumber.length() - iDigitsPerm) + strNumber.substring(0, strNumber.length() - iDigitsPerm);
		if (strReturn.charAt(0) == '0')
		{
			strReturn = "0";
		}
		return Integer.parseInt(strReturn);
	}
}
