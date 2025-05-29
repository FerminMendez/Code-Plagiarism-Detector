package qualification;

import java.util.ArrayList;
import java.util.List;

import loader.InputReader;
import loader.OutPutWriter;

public class GoogleDance {
	
	static String inputName = "B-small-attempt0.in";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		start();

	}

	public static void start(){
		InputReader reader = new InputReader();
		reader.read(inputName);
		List<String> inputs = reader.getInputs();
		List<String> outputs = new ArrayList<String>();
		for(String in: inputs){
			List<Integer> aLine = transfer(in);
			int out = process(aLine);
			outputs.add(new Integer(out).toString());
		}
		
		OutPutWriter writer = new OutPutWriter();
		writer.write("question2.out", outputs);
	}
	
	
	public static int process(List<Integer> aLine){
		int res = 0;
		int number = aLine.get(0);
		int avaliableSup = aLine.get(1);
		int p = aLine.get(2);
		
		if(p == 0)
			return number;

		int standard = p*3;
		
		int mustSuccessCounter = 0;
		int needSup = 0;
		for(int i=3; i<aLine.size(); i++){
			int t = aLine.get(i);
			if(t >= standard-2) mustSuccessCounter++;
			if((t == standard-3 || t == standard-4) && (standard-3>0))needSup++;
		}
		
		res = mustSuccessCounter + (Math.min(avaliableSup, needSup));
		
		return res;
	}
	
	private static List<Integer> transfer(String s){
		List<Integer> l = new ArrayList<Integer>();
		String[] arrayString = s.split(" ");
		for(int i=0; i<arrayString.length; i++){
			l.add(Integer.parseInt(arrayString[i]));
		}
		return l;
	}
}
