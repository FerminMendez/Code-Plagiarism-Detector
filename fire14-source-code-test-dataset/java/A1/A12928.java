package google.contest.B;

import google.loader.Challenge;
import google.problems.AbstractReader;

public class BReader extends AbstractReader {

	@Override
	protected Challenge createChallenge(int number) {
		int theLine = getActualLine();
		String[] lines = getLines();
		BChallenge chal = new BChallenge(number, lines[theLine]);
		setActualLine(theLine+1);
		return chal;
	}

}
