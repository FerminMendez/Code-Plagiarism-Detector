import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class problem2
{
	void main()
	{
		solve();
	}
	
	void solve()
	{
		try
		{
			FileInputStream fstream = new FileInputStream("pr2_input.txt");
			DataInputStream in      = new DataInputStream(fstream);
			BufferedReader  br      = new BufferedReader(new InputStreamReader(in));
			
			FileWriter fout = new FileWriter("output.txt");
			BufferedWriter out = new BufferedWriter(fout);
			
			int iCases = Integer.parseInt(br.readLine());
			for (int iStep = 0; iStep < iCases; iStep++)
			{
				String strLine = br.readLine();
				String[] numbers = strLine.split(" ");
				
				int N = Integer.valueOf(numbers[0]).intValue();
				int S = Integer.valueOf(numbers[1]).intValue();
				int P = Integer.valueOf(numbers[2]).intValue();
				
				List<Integer> notes = new ArrayList<Integer>();
				for (int jStep = 0; jStep < N; jStep++)
				{
					notes.add(Integer.valueOf(numbers[jStep + 3]).intValue());
				}
				
				//< Calcculate notes
				int iNormalMinNote = P * 3 - 2;
				int iSurpriseMinNote = P * 3 - 4;
				
				Collections.sort(notes);
				
				int iGooglers = 0;
				for (int jStep = 0; jStep < notes.size(); jStep++)
				{
					if (S > 0)
					{
						if (notes.get(jStep) >= iSurpriseMinNote)
						{
							if (notes.get(jStep) >= 2)
							{
								S--;
								iGooglers++;
							}
						}
					}
					else
					{
						if (notes.get(jStep) >= iNormalMinNote)
						{
							iGooglers++;
						}
					}
				}
				
				if (iStep != (iCases - 1))
				{
					out.write(String.format("Case #%d: %d\n", iStep + 1, iGooglers));
				}
				else
				{
					out.write(String.format("Case #%d: %d", iStep + 1, iGooglers));
				}
			}
			
			out.close();
		}
		catch (Exception e)
		{
			  System.err.println("Error: " + e.getMessage());
		}
	}
}
