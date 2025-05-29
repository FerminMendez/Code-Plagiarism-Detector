package qB;

import static java.lang.Math.abs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B {
	
	public static class Pair<L, R> {
		public L left;
		public R right;

    	public Pair(L left, R right) {
			super();
			this.left = left;
			this.right = right;
		}
		
    	public static <L, R> Pair<L, R> of( L l, R r) {
			return new Pair<L, R>(l, r);
		}
	}
	
	/**
	 * The triplet score
	 */
    public static class TripletScore {
    	private final int s1;
    	private final int s2;
    	private final int s3;
		
    	public TripletScore(int score1, int score2, int score3) {
			super();
			this.s1 = score1;
			this.s2 = score2;
			this.s3 = score3;
		}
		
		public int getSurpriseCount() {
			int d1 = abs( s1 - s2);
			int d2 = abs( s2 - s3);
			int d3 = abs( s3 - s1);
			int c = 0;
			for ( int d: new int[] {d1, d2, d3}) {
				if ( d == 2) c++;
			}
			return c;
		}

		public int getNeverHappenCount() {
			int d1 = abs( s1 - s2);
			int d2 = abs( s2 - s3);
			int d3 = abs( s3 - s1);
			int c = 0;
			for ( int d: new int[] {d1, d2, d3}) {
				if ( d > 2) c++;
			}
			return c;
		}

		// surprising or never happen
		public boolean isNotSurprising() {
			return !isSurprising() && !isNeverHappen();
		}

		// surprising or never happen
		public boolean isSurprising() {
			return getSurpriseCount() > 0;
		}

		// surprising or never happen
		public boolean isNeverHappen() {
			return getNeverHappenCount() > 0;
		}
		
		public boolean isOneScoreMoreThanEqualsP( int p) {
			return s1 >= p || s2 >= p || s3 >= p;
		}

		public static boolean isOneScoreMoreThanEqualsP( List<TripletScore> scores, int p) {
			for ( TripletScore score: scores) {
				if ( !score.isOneScoreMoreThanEqualsP( p)) {
					return false;
				}
			}
			return true;
		}

		public int getTotalScore() {
			return s1 + s2 + s3;
		}
		
		@Override
		public String toString() {
			return "( " + s1 + ", " + s2 + ", " + s3 + ")";
		}

    }

	private static List<TripletScore> evaluateAllPossibleScores( int totalScore) {
		List<TripletScore> scores = new ArrayList<TripletScore>();
		for ( int s1 = 0; s1 <= 10; s1++) {
    		for ( int s2 = 0; s2 <= 10; s2++) {
    			int s3 = totalScore - s1 - s2;
    			if ( s3 < 0 || s3 > 10 ) {
    				// no good
    				continue;
    			}
    			TripletScore score = new TripletScore( s1, s2, s3);
				if ( evaluateAll( score)) {
					scores.add( score);
				}
    		}
		}
		return scores;
	}
	
	private static boolean evaluateAll( TripletScore score) {
		return !score.isNeverHappen();
	}

	private static List<TripletScore> compressPossibleScores( List<TripletScore> scores, int limit) {
		List<TripletScore> newScores = new ArrayList<TripletScore>();
		
		TripletScore lessPSurprising = null;
		TripletScore lessPNormal = null;
		TripletScore morePSurprising = null;
		TripletScore morePNormal = null;
		
		for ( TripletScore score: scores) {
			boolean isMoreThanEqualsP = score.isOneScoreMoreThanEqualsP( limit);
			boolean isSurprising = score.isSurprising();
			if ( isMoreThanEqualsP) {
				if ( isSurprising) {
					morePSurprising = score;
				} else {
					morePNormal = score;
				}
			} else {
				if ( isSurprising) {
					lessPSurprising = score;
				} else {
					lessPNormal = score;
				}
			}
		}
		
		if ( morePSurprising != null) {
			newScores.add( morePSurprising);
		} else if ( lessPSurprising != null) {
			newScores.add( lessPSurprising);
		}

		if ( morePNormal != null) {
			newScores.add( morePNormal);
		} else if ( lessPNormal != null) {
			newScores.add( lessPNormal);
		}
		
		if ( newScores.isEmpty()) {
			newScores.add( scores.get(0));
		}
		
		return newScores;
	}
	
	private static int solve( List<Integer> totalPoints, int totalSurprisingCount, int limitScore) {

		// BASE SCORES
		List<Pair<Integer, List<TripletScore>>> fullScoreList = new ArrayList<Pair<Integer, List<TripletScore>>>();
		for ( Integer totalScore: totalPoints) {
			Pair<Integer, List<TripletScore>> pair =
				Pair.of( totalScore, evaluateAllPossibleScores( totalScore));
			fullScoreList.add( pair);
		}
//		System.out.println( "scoreList: " + scoreList.size());
//		for ( Pair<Integer, List<TripletScore>> pair:scoreList) {
//			System.out.println("\t: " + pair.left + "(" + pair.right.size() + "): " + pair.right);
//		}

		// COMPRESS SCORES
		for ( Pair<Integer, List<TripletScore>> pair: fullScoreList) {
			List<TripletScore> newRight = compressPossibleScores( pair.right, limitScore);
//			System.err.println( pair.right + " -> " + newRight);
			pair.right = newRight;
		}

		// CONBINATION FILTER BY SURPRISING COUNT
		List<List<TripletScore>> filteredScoreCombo = evaluateAllScoreCombination( fullScoreList, totalSurprisingCount);
//		System.out.println( "filteredScoreCombo: " + filteredScoreCombo.size());
		
		// COUNT MORE THAN P
		int countMax = 0;
		for ( List<TripletScore> scores: filteredScoreCombo ) {
			int countOfMorethanP = 0;
			for ( TripletScore score: scores) {
				if ( score.isOneScoreMoreThanEqualsP( limitScore)) {
					countOfMorethanP++;
				}
			}
			countMax = Math.max( countMax, countOfMorethanP);
		}
//		System.out.println( "countMax: " + countMax);
		return countMax;
	}
    
	private static List<List<TripletScore>> evaluateAllScoreCombination(
			List<Pair<Integer, List<TripletScore>>> scoreList,
			int totalSurprisingCount) {
		
		List<List<TripletScore>> fullScoreList = new ArrayList<List<TripletScore>>();
		for ( Pair<Integer, List<TripletScore>> scoresPair: scoreList) {
			List<TripletScore> scores = scoresPair.right;
			fullScoreList.add( scores);
		}

		List<List<TripletScore>> resultList = 
		evaluateAllScoreCombinationRecursive( scoreList, new ArrayList<TripletScore>(), totalSurprisingCount, fullScoreList, new ArrayList<List<TripletScore>>());		

		return resultList;
	}
	
	private static boolean hasMoreThanNSurprises( List<TripletScore> scores, int n) {
		int count = 0;
		for ( TripletScore score: scores) {
			if ( score.isSurprising()) count++;
		}
		return count > n;
	}

	private static boolean hasNSurprises( List<TripletScore> scores, int n) {
		int count = 0;
		for ( TripletScore score: scores) {
			if ( score.isSurprising()) count++;
		}
		return count == n;
	}

	private static List<List<TripletScore>> evaluateAllScoreCombinationRecursive(
			List<Pair<Integer, List<TripletScore>>> fullScoresList,
			List<TripletScore> currentScoreList,
			int totalSurprisingCount, List<List<TripletScore>> left, List<List<TripletScore>> result) {
		if ( left.isEmpty()) {
			// COMPLETE
			if ( hasNSurprises( currentScoreList, totalSurprisingCount)) {
				result.add( currentScoreList);
			}
		} else {
			List<List<TripletScore>> newLeft = new ArrayList<List<TripletScore>>( left);
			List<TripletScore> currentScores = left.iterator().next();
			newLeft.remove( currentScores);

			// BUILD
			for ( TripletScore currentScore: currentScores) {
				List<TripletScore> newScoresList = new ArrayList<TripletScore>( currentScoreList);
				newScoresList.add( currentScore);
				if ( hasMoreThanNSurprises( newScoresList, totalSurprisingCount)) {
					continue;
				}
				evaluateAllScoreCombinationRecursive(
						fullScoresList, newScoresList,
						totalSurprisingCount, newLeft, result);
			}
		}
		return result;
	}

	public static void main(String[] args) throws FileNotFoundException {
		if ( args.length == 0) {
			throw new IllegalArgumentException("no file given");
		}

		// TEST
		assert( !new TripletScore( 8, 8, 8).isNotSurprising());
		assert( !new TripletScore( 7, 8, 7).isNotSurprising());
		assert( !new TripletScore( 6, 7, 8).isSurprising());
		assert( !new TripletScore( 6, 8, 8).isSurprising());
		assert( !new TripletScore( 7, 6, 9).isNeverHappen());

		// PREP
		String filename = args[0];
		Scanner scanner = new Scanner( new File( filename));
		int numOfLines = scanner.nextInt();
		scanner.nextLine();
		
		for ( int lineIdx = 0; lineIdx < numOfLines; lineIdx++) {
			String line = scanner.nextLine();
			Scanner lineScanner = new Scanner( line);
			int numOfTi = lineScanner.nextInt();
			int n = lineScanner.nextInt();
			int p = lineScanner.nextInt();
			List<Integer> tiList = new ArrayList<Integer>();
			for ( int idx = 0; idx < numOfTi; idx++) {
				tiList.add( lineScanner.nextInt());
			}
			int caseNo = lineIdx + 1;
			//System.out.printf("Case @%d: %s\n" , caseNo, "n=" + n + ", p=" + p + ", ti=" + tiList );

			int result = solve( tiList, n, p);
			System.out.printf("Case #%d: %d\n" , caseNo, result );
		}

		//List<Integer> sampleTotalScores = Arrays.asList( new Integer[] {29, 20, 8, 18, 18, 21});
		//solve( sampleTotalScores, 2, 8);
	}
}
