package recycledNumbers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class InputFile 
{
	public ArrayList<String> readFile() throws Exception
	{
		File file = new File("C:\\Users\\Nikhil\\Desktop\\googleCodeJam\\C-small-attempt0.in");
		
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

		ArrayList<String> list = new ArrayList<String>();
		
		String line = null;
		
		line = bufferedReader.readLine();
		
		 while ((line = bufferedReader.readLine()) != null)
		 {
			 list.add(line);
		 }
		
		
		return list;
	}

}
