import java.io.BufferedReader;
import java.io.IOException;

import javax.management.RuntimeErrorException;


public class DancingGooglersProblemCase implements ProblemCase {

	final int dancers;
	final int special;
	final int bar;
	final int scores[];
	
	public DancingGooglersProblemCase(BufferedReader reader) throws IOException {
		String newCase = reader.readLine();
		String[] params = newCase.split(" ");
		dancers = Integer.parseInt(params[0]);
		special = Integer.parseInt(params[1]);
		bar = Integer.parseInt(params[2]);
		if (dancers != params.length-3) {
			throw new RuntimeErrorException(null);
		}
		scores = new int[dancers];
		for (int j = 0; j < dancers; j++) {
			scores[j] = Integer.parseInt(params[j+3]);
		}
	}
	
	
	public String getResult() {
		Integer res = 0;
		int caclBar = bar*3-2;
		int specialCounter = special;
		for (int score : scores) {
			if (score >= caclBar || bar == 0 || (bar == 1 && score > 0 )){
				res++;
			} else if (score >= caclBar - 2 && specialCounter > 0 && !(bar == 1 && score == 0 )) {
				specialCounter--;
				res++;
			}
		} 
		return res.toString();
	}

}
