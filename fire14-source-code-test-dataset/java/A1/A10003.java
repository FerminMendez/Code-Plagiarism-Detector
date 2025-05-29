package qualification.b;

import java.util.Scanner;

public class DancingWith {

	/**
	 * OK, I think the algorithm is this:
	 * for each googler's score:
	 * -could this have a highest value > N when it's unsurprising? If so, count it.
	 * If not,
	 * 	-- do we have a surprising score left?
	 * 	--can we get above N by making it surprising?
	 * 		If so, use up a 'surprising' point and make it so.
	 * 	you don't have to backtrack. there are at most 100 googlers
	 * 	so performance should be easy?
	 */

	public static void main(final String[] args) {
		new DancingWith().start();
	}

	private void start() {
		final Scanner s = new Scanner(System.in);
		final int numTests = s.nextInt();
		for (int i = 0; i < numTests; i++) {
			//			deb("Case " + (i + 1) + "---------");
			final int numGooglers = s.nextInt(); //<= 100
			final int numSurprises = s.nextInt();
			final int scoreRequired = s.nextInt();

			//output and calculation variables
			int surprisesLeft = numSurprises;
			int matchesFound = 0;
			for (int g = 0; g < numGooglers; g++) { //for each googler
				final int score = s.nextInt();
				if (highEnough(score, scoreRequired, false)) {
					matchesFound++;
				} else if (surprisesLeft > 0 && highEnough(score, scoreRequired, true)) {
					surprisesLeft--;
					matchesFound++;
				}
			}
			System.out.println("Case #" + (i+1) + ": " + matchesFound);
		}
	}

	//we have the sum of three scores, at most 1 apart.
	//[todo] There are only 30 possible scores so we could precalc or cache these.
	//this code keeps the value of the middle score as low as possible.
	private boolean highEnough(final int score, final int scoreRequired, final boolean surprising) {
		final int range = surprising ? 2 : 1;
		int one = score; //only decreases
		int two = 0; //only increases
		int three = 0; //only increases
		while (one - three > range) {
			//three can't increase above two - keep the order.
			if (three < two) {
				one--;
				three++;
			} else {
				one--;
				two++;
			}
		}
		//		deb(three + " " + two + " " + one + (one >= scoreRequired ? "*" : "") + (surprising ? " S" : ""));
		return (one >= scoreRequired);
	}

	//	private void deb(final String value) {
	//		System.out.println(value.toString());
	//	}

}
