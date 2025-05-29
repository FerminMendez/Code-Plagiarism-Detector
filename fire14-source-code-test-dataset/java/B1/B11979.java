package recycledNumbers;

import java.util.ArrayList;



public class MainClass 
{
	public static void main(String[] z)throws Exception
	{
		String string ="";
		ArrayList<String> list = new InputFile().readFile();
		int caseNumber =1;
		ArrayList<String> output = new ArrayList<String>();
		for(int i=0 ;i<list.size();i++)
		{
			
			String[] array = list.get(i).split(" ");
			//String[] array = "1 9".split(" ");
			int x = Integer.parseInt(array[0]);
			int y = Integer.parseInt(array[1]);
			string = 	"Case #" + caseNumber + ": " + new RecycledNumbers().countRecylcedNumbers(x, y);
			output.add(string);
			System.out.println(string );
			caseNumber++;
		}
		new OutputFile().writeFile(output);
	}
}