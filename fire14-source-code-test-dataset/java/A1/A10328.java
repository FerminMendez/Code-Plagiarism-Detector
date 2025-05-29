import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;


public class SecondQuestion {
	
	public static int findBestScore(double[] scores, int surprise, int p){

		int count = 0;
		for(int i = 0; i < scores.length; i++)
		{
			if(scores[i] > 0)
				{
				double app = scores[i] / 3;
				app = Math.ceil(app);
				if(app >= p)
					count++;
				else
				{
					if(surprise > 0)
					{
						if((app + 1) >= p)
						{
							if(((app + 1) + (app - 1) + (app - 1)) == scores[i] || 
									((app + 1) + (app - 1) + (app)) == scores[i] ||
									((app + 1) + (app) + (app)) == scores[i])
							{
								surprise--;
								count++;
							}
						}
					}
				}
			}
			else
			{
				if(p == 0)
					count++;
			}
		}
	
		return count;
		
	}
	
	public static void main(String args[]) {
		try{
			int numLines;
			String result = "";
		  FileInputStream fstream = new FileInputStream("B-small-attempt2.in");

		  DataInputStream in = new DataInputStream(fstream);
		  BufferedReader br = new BufferedReader(new InputStreamReader(in));
		  numLines = Integer.parseInt(br.readLine());
		  for(int i = 0; i < numLines; i++)
		  {
			  String[] str = br.readLine().split(" ");
			  double[] scores = new double[Integer.parseInt(str[0])];
			  int surprise = Integer.parseInt(str[1]);
			  int p = Integer.parseInt(str[2]);
			  for(int j = 3; j < str.length; j++)
				  scores[(j-3)] = Double.parseDouble(str[j]);
			  result = result + "Case #" + (i+1) + ": " + findBestScore(scores, surprise, p) + "\n";
		  }
		  in.close();
		  
		  //write the solution to file
		  FileWriter outstream = new FileWriter("solution.txt");
		  BufferedWriter out = new BufferedWriter(outstream);
		  out.write(result);
		  //Close the output stream
		  out.close();
		  
	    } catch (Exception e){//Catch exception if any
		  System.err.println("Error: " + e.getMessage());
	  }
	}
}
