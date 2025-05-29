package google.contest.A;

import google.loader.Challenge;
import google.problems.AbstractReader;

public class AReader extends AbstractReader {

	@Override
	protected Challenge createChallenge(int number) {
		int theLine = getActualLine();
		String[] lines = getLines();
		AChallenge chal = new AChallenge(theLine,lines[theLine]);
		setActualLine(theLine+1);
		return chal;
	}

}
