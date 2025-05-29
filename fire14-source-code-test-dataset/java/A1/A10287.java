package Problem2;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

	public static void main(String[] args){
		
		ArrayList<String> ArS = new ArrayList<String>();
		ArS = FileReader.Parsefile("input.txt");
		int[] ArS2 = DancingGooglers.Count_List(ArS);
		FileReader.writeconfig("output.txt", ArS2);
	
	}

	
	
}
