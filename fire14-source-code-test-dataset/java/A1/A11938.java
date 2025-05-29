package dancingWithGooglers;

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
			System.out.println(list.get(i));
			string = 	"Case #" + caseNumber + ": " + new BestResult().result(list.get(i));
			//string = 	"Case #" + caseNumber + ": " + new BestResult().result("3 0 0 12 13 0");
			output.add(string);
			caseNumber++;
			System.out.println(string );
		}
		new OutputFile().writeFile(output);
	}
}