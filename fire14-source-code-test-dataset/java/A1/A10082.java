package qualificationRound;

public class Dancing {

	/**
	 * 
	 * @param N
	 *            Number of Googlers
	 * @param S
	 *            number of surprising triplets of scores
	 * @param P
	 * 
	 * @param Ti
	 *            the total points of the Googlers
	 * 
	 * @return what is the maximum number of Googlers that could have had a best
	 *         result of at least p
	 */
	public static int howMany(int N, int S, int P, int[] Ti) {

		if (0 == P)
			return N;

		int count = 0;
		int specials = 0;

		for (int t : Ti) {

			if (0 == t)
				continue;
			
			int mod = t % 3;
			int div = t / 3;

			int max = -1;
			int maxSpecial = -1;

			switch (mod) {

			case 0:
				max = div;
				maxSpecial = div + 1;
				break;

			case 1:
				max = div + 1; // same as 'maxSpecial'
				break;

			case 2:
				max = div + 1;
				maxSpecial = div + 2;
				break;
			}

			if (max >= P)
				count++;

			else if (maxSpecial >= P)
				specials++;
		}

		if (specials > S)
			count += S;

		else
			count += specials;

		return count;
	}
}
