package recycledNumbers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class OutputFile
{
	public void writeFile(ArrayList<String> data) throws Exception
	{
		File file = new File("C:\\Users\\Nikhil\\Desktop\\googleCodeJam\\output.txt");
		
		BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
		
		for(int i=0;i<data.size();i++)
		{
			
			bufferedwriter.write(data.get(i));
			bufferedwriter.newLine();
		}
		bufferedwriter.flush();
		
	}
}
