package google.contest.C;

import google.loader.Challenge;
import google.problems.AbstractReader;

public class CReader extends AbstractReader {

	@Override
	protected Challenge createChallenge(int number) {
		int theLine = getActualLine();
		String[] lines = getLines();
		CChallenge chal = new CChallenge(number, lines[theLine]);
		setActualLine(theLine+1);
		return chal;
	}

}
