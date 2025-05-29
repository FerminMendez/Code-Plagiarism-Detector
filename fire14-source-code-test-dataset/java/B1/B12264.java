import java.io.*;
import java.util.*;

class ProblemC
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

			String strLine, outputLine;

			int line = 0;
			int control = 0;
			int count = 0;

			int[] check = new int[128];

			int A = 0, B = 0;

			//to get rid of the first line
			br.readLine();

			//Read File Line By Line
			while ((strLine = br.readLine()) != null)   {

				String tempString = "";

				control = 0;
				count = 0;

				line++;

				outputLine = "Case #"+line+": ";
				//outputLine = "";

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
								A = Integer.parseInt(tempString);
								break;
							case 1 :
								B = Integer.parseInt(tempString);
								break;
						}
						control++;
						tempString = "";
						continue;
					}
					tempString += ""+strLine.charAt(i);
				}

				System.out.println(A+" "+B);

				for (int i = A; i <= B; ++i)
				{
					int digit = String.valueOf(i).length();

					check = new int[digit];

					for (int j = 0; j < digit; ++j)
					{
						check[j] = 0;
					}

					for (int j = 1; j < digit; ++j)
					{
						String testingStr = String.valueOf(i);
						String anotherStr = testingStr.substring(j)+testingStr.substring(0,j);

						if (anotherStr.charAt(0) == '0') continue;

						int pairTesting = Integer.parseInt(anotherStr);

						if (A <= pairTesting && pairTesting <= B && pairTesting != i)
						{
							boolean checked = false;
							for (int k = 0; k < j; ++k)
							{
								if (pairTesting == check[k])
								{
									checked = true;
								}
							}
							if (!checked)	
							{
								check[j] = pairTesting;
								count++;
							}
						}
					}
				}

				count /= 2;
				outputLine += ""+count;

				out.write(outputLine);
				out.newLine();
				System.out.println(outputLine);
			}
			//Close the input stream
			in.close();
			out.close();
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		 }
	}
}
