package codejam.surprisingGooglers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solver {

	public int getMaximumNumberOfPHavers(int numberOfSurprises, int bestResult, Integer... totals){
		List<PossibleSurpriseCase> allCases = buildCases(numberOfSurprises, Arrays.asList(totals));
		int maxPHavers = 0;
		for (PossibleSurpriseCase surpriseCase : allCases) {
			maxPHavers = Math.max(surpriseCase.getMaximumPHavers(bestResult), maxPHavers);
		}
		return maxPHavers;
	}

	private List<PossibleSurpriseCase> buildCases(int numberOfSurprises, List<Integer> totals) {
		if (totals.isEmpty()) return Collections.singletonList(PossibleSurpriseCase.trivial());
		List<PossibleSurpriseCase> surprise = combine(true, totals.get(0), buildCases(numberOfSurprises-1, totals.subList(1, totals.size())));
		if (numberOfSurprises == totals.size()) return surprise;
		List<PossibleSurpriseCase> noSurprise = combine(false, totals.get(0), buildCases(numberOfSurprises, totals.subList(1, totals.size())));
		if (numberOfSurprises <= 0) return noSurprise;
		return append(surprise,	noSurprise);
	}
	
	private List<PossibleSurpriseCase> append(
			List<PossibleSurpriseCase> one,
			List<PossibleSurpriseCase> two) {
		List<PossibleSurpriseCase> r = new ArrayList<PossibleSurpriseCase>(one.size() + two.size());
		r.addAll(one);
		r.addAll(two);
		return r;
	}

	public static List<PossibleSurpriseCase> combine(boolean isSurprise, int score, List<PossibleSurpriseCase> cases) {
		List<PossibleSurpriseCase> r = new ArrayList<PossibleSurpriseCase>(cases.size());
		for (PossibleSurpriseCase surpriseCase : cases) {
			r.add(PossibleSurpriseCase.combine(isSurprise, score, surpriseCase));
		}
		return r;
	}

	
}
