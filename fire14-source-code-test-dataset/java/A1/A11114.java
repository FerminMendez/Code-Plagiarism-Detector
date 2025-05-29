package com.googlecode.codejam.contest.gcj2012.round_q;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.Callable;

import com.googlecode.codejam.model.JamCaseResolver;
import com.googlecode.codejam.model.JamCaseResolverFactory;
import com.googlecode.codejam.model.JamResolver;

public class B extends JamCaseResolver {

	private final int s; // surprising
	private final int p; // score limit
	
	private final int[] scores;
	
	public B(final int caseNumber, final Iterator<String> lineIterator) {
		super(caseNumber);
		int[] input = this.parseInt(lineIterator.next().split(" "));
		s = input[1];
		p = input[2];
		scores = Arrays.copyOfRange(input, 3, input.length);
	}
	
	@Override
	protected String resolve() {
		int surprisingUsed = s;
		int result = 0;
		for (int score : scores) {
			if(score < 2) {
				if(score >= p)
					result++;
				continue;
			}
			double avg = Math.ceil(score / 3.0);
			
			if(avg >= p) {
				result++;
			} else if (surprisingUsed > 0 && avg + 1 >= p && (score - 1) % 3 != 0) {
				result++;
				surprisingUsed--;
			}
		}
		return String.valueOf(result);
	}

	public static void main(String[] args) throws Exception {
		final JamCaseResolverFactory factory = new JamCaseResolverFactory() {
			@Override
			public Callable<String> newJamCaseResolver(int caseNumber, Iterator<String> lineIterator) {
				return new B(caseNumber, lineIterator);
			}
		};
		final JamResolver jamResolver = new JamResolver(factory, "gcj2012/round_q", "B-small-attempt0.in");
		jamResolver.resolve();
	}

}
