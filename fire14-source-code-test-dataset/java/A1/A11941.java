package dancingWithGooglers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class OutputFile 
{
	public void writeFile(ArrayList<String> data) throws Exception
	{
		File file = new File("C:\\Users\\Nikhil\\Desktop\\googleCodeJam\\output.txt");
		
		BufferedWriter bufferedReader = new BufferedWriter(new FileWriter(file));
		
		for(int i=0;i<data.size();i++)
		{
			
			bufferedReader.write(data.get(i));
			bufferedReader.newLine();
		}
		bufferedReader.flush();
	}
}
