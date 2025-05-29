package codejam;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.common.base.Splitter;

public class ProblemB extends CodeJamRunner {

	
	private int nrOfCases;
	private int testCaseIndex;
	int numberOfGooglers;
	int surprisingTriplets;
	int personalBestBar;
	int maxAbovePersonalBestBar;

	private List<Integer> totalPoints = new ArrayList<Integer>();

	public void process(int lineNr, String line) {
		if (lineNr == 1) {
			nrOfCases = Integer.valueOf(line);
			resetForNextCase();
		} else {
			Iterator<String> split = Splitter.on(" ").split(line).iterator();
			numberOfGooglers = Integer.parseInt(split.next());
			surprisingTriplets = Integer.parseInt(split.next());
			personalBestBar = Integer.parseInt(split.next());
			while ( split.hasNext() ) {
				totalPoints.add(Integer.parseInt(split.next()));
			}
			calc();
			write();
			resetForNextCase();
		}
	}

	private void write() {
		String resultLine = "Case #" + testCaseIndex + ": " + maxAbovePersonalBestBar;
		printlnOutput(resultLine);
	}

	private void calc() {
		int normalAboveCount = 0;
		int surpriseAboveCount = 0;
		for ( int i : totalPoints ) {
			Triplet t = new Triplet( i );
			if ( t.calcMaxNormal() >= personalBestBar ){
				normalAboveCount++;
			}
			else if ( t.calcMaxSurprise() >= personalBestBar ){
				surpriseAboveCount++;
			}
		}
		int surprisesHappened = Math.min(surpriseAboveCount, surprisingTriplets );
		maxAbovePersonalBestBar = normalAboveCount + surprisesHappened;
	}

	private void resetForNextCase() {
		testCaseIndex++;
		totalPoints.clear();
	}

	public static void main(String args[]) {
		ProblemB ao = new ProblemB();
		ao.run(args);
	}

}
