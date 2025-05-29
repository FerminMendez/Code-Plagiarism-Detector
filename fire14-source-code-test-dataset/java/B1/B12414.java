import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		try
		{
			  // Open the file that is the first 
			  // command line parameter
			  FileInputStream fstream = new FileInputStream("C-small-attempt0.in");
			  // Get the object of DataInputStream
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine;
			  //Read File Line By Line			
			  int cases = 0;
			  ArrayList<String> input = new ArrayList();
			  ArrayList<String> output = new ArrayList();
			  
			  while ((strLine = br.readLine()) != null)   
			  {
				  // Print the content on the console
				  input.add(strLine);
			  }
			  //Close the input stream
			  in.close();
			  
			  cases = Integer.parseInt(input.get(0));			  
			  
			  for(int i=0; i<cases; i++)
			  {
				  String[] numbers = input.get(1 + 1*i).split(" ");				  
				  int A = Integer.valueOf(numbers[0]);
				  int B = Integer.valueOf(numbers[1]);				  
				  
				  int number = 0;
				  
				  for (int k=B; k>=A; k--)
					  for (int j=A; j<=k; j++)
					  {
						  String strJ = String.valueOf(j);
						  String strK = String.valueOf(k);
												  
						  
						  if (strJ.length() == strK.length())
						  {							  
							  
							  String newJ = strJ.substring(strJ.length() - 1) + strJ.substring(0, strJ.length() -1);
							  
							  while(!newJ.equals(strJ))
							  {								 
								  if (newJ.equals(strK))
									  number++;  
								  
								  newJ = newJ.substring(newJ.length() - 1) + newJ.substring(0, newJ.length() -1);
							  }
								  
						  }
					  }
				  
				  output.add("Case #" + (i + 1) + ": " + number);
			  }
			  
			  for (int i=0; i<output.size(); i++)
				  System.out.print(output.get(i) + "\n");
			  
		}
		catch (Exception e)
		{
			//Catch exception if any
			System.err.println("Error: " + e.getMessage() + " " + e.getClass());
		}

	}

}
