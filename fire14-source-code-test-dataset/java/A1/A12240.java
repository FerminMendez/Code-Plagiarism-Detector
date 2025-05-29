import java.io.*;
import java.util.*;

class ProblemB
{
	public static void main(String[] args) 
	{
		try{
			// Open the file that is the first 
			// command line parameter
			FileInputStream fstream = new FileInputStream("input.txt");
			BufferedWriter out = new BufferedWriter(new FileWriter("output.txt"));

			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			int[][]	judge = new int[3][1];
			int googler = 0, surprise = 0, p = 0;
			int count = 0;

			String strLine, outputLine;

			int line = 0;

			int control = 0;

			//to get rid of the first line
			br.readLine();

			//Read File Line By Line
			while ((strLine = br.readLine()) != null)   {

				line++;

				outputLine = "Case #"+line+": ";
				//outputLine = "";

				String tempString = "";
				control = 0;
				count = 0;

				for (int i = 0; i < strLine.length(); ++i)
				{
					if (strLine.charAt(i) == ' ' || i == strLine.length()-1)
					{
						if (i == strLine.length()-1)
						{
							tempString += ""+strLine.charAt(i);
						}
						switch (control)
						{
							case 0 :
								googler = Integer.parseInt(tempString);
								judge = new int[3][googler];
								break;
							case 1 :
								surprise = Integer.parseInt(tempString);
								break;
							case 2 :
								p = Integer.parseInt(tempString);
								break;				
							default :
								int score = Integer.parseInt(tempString);
								judge[0][control-3] = score/3;
								judge[1][control-3] = score/3;
								judge[2][control-3] = score/3;
								if (score%3 == 1)
								{
									judge[2][control-3]++;
								}
								else if (score%3 == 2)
								{
									judge[1][control-3]++;
									judge[2][control-3]++;
								}
								break;
						}
						control++;
						tempString = "";
						continue;
					}
					tempString += ""+strLine.charAt(i);
				}

				System.out.println(googler+" "+surprise+" "+p);
				for (int i = 0; i < googler; ++i)
				{
					System.out.print(judge[0][i]+" ");
					System.out.print(judge[1][i]+" ");
					System.out.print(judge[2][i]+" ");
					
				System.out.println();
				}

				for (int i = 0; i < googler; ++i)
				{
					if (judge[2][i] == p-1 && judge[2][i] == judge[1][i] && judge[0][i] > 0 && judge[1][i] > 0 && surprise > 0)
					{
						judge[2][i]++;
						judge[1][i]--;
						surprise--;
					}
				}

				
				for (int i = 0; i < googler; ++i)
				{
					if (judge[0][i] >= p || judge[2][i] >= p)
					{
						count++;
					}
				}

				outputLine += ""+count;

				out.write(outputLine);
				out.newLine();
				System.out.println(outputLine);
				System.out.println();
			}
			//Close the input stream
			in.close();
			out.close();
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		 }
	}
}
