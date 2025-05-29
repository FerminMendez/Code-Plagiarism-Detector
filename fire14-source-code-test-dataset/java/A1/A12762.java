import java.io.*;
import java.util.*;

public class Googlers{

	public static void main(String args[]){
		try{
  // Open the file that is the first 
  // command line parameter
  			FileInputStream fstream = new FileInputStream("textfile.txt");
  // Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			FileWriter ffstream = new FileWriter("./output.txt");
		  	BufferedWriter out = new BufferedWriter(ffstream);
			String strLine;
  //Read File Line By Line
			int i=0;
			strLine = br.readLine();
			i= Integer.parseInt(strLine);
			int j=1;
			while (j<=i)   {
  // Print the content on the console
				strLine = br.readLine();

				new GoogleCount(strLine,j,out);
				j++;
			}
  //Close the input stream
			in.close();
			out.close();
		}
		catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}

}

