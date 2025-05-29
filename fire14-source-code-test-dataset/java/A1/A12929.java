package google.contest.B;

import google.loader.Challenge;
import google.problems.AbstractChallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BChallenge extends AbstractChallenge implements Challenge {

	private int numberOfGooglers;
	private int numberOfSurprise;
	private int desiredScore;
	List<Integer> scores;
	private String resultNumber;
	private static  HashMap<Integer, ScoreInfo> map;

	public BChallenge(int number, String line) {
		super(number);

		String[] tokens = line.split(" ");

		numberOfGooglers = Integer.parseInt(tokens[0]);
		numberOfSurprise = Integer.parseInt(tokens[1]);

		desiredScore = Integer.parseInt(tokens[2]);

		scores = new ArrayList<Integer>();
		for(int i=0;i<numberOfGooglers;i++){
			scores.add(Integer.parseInt(tokens[3+i]));
		}
		calculate();

		setResult(resultNumber);
	}

	private void calculate() {
		if(map == null){
			init();
		}

		// teile in bigger und nicht bigger
		List<Integer> bigger = new ArrayList<Integer>();
		List<Integer> biggerAndSurprising = new ArrayList<Integer>();
		List<Integer> smaller = new ArrayList<Integer>();
		List<Integer> smallerAndSuprising = new ArrayList<Integer>();
		for(Integer score : scores ){
			ScoreInfo info = getScoreInfo(score);
			if(info.canBeBigger(desiredScore)){
				if(info.mustBeSuprisingBeingBigger(desiredScore)){
					biggerAndSurprising.add(score);	
				}else{
					bigger.add(score);
				}
			}else{
				if(info.canBeSuprising()){
					smallerAndSuprising.add(score);
				}else{
					smaller.add(score);
				}
			}
		}

		int biggerSize = bigger.size();
		int biggerAndSuprSize = biggerAndSurprising.size();
		int smallerSize = smaller.size();
		int smallerAndSupSize = smallerAndSuprising.size();
		
		if(biggerAndSuprSize>=numberOfSurprise){
			resultNumber = ""+ ( biggerSize + numberOfSurprise);
			return;
		}
			resultNumber = ""+ (biggerSize + biggerAndSuprSize);
		
	}

	private ScoreInfo getScoreInfo(Integer score) {
		return map.get(score);
	}

	private void init() {
		map = new HashMap<Integer, ScoreInfo>();
		for(int i=0;i<11;i++){
			for(int j=0;j<11;j++){
				for(int k=0;k<11;k++){
					addTripple(i,j,k);
				}
			}
		}

	}

	private void addTripple(int i, int j, int k) {

		int sum = i+j+k;
		if(! map.containsKey(sum)){
			map.put(sum, new ScoreInfo(sum));
		}
		map.get(sum).addTripple(i,j,k);

	}



	private static class ScoreInfo{

		private List<Tripple> tripples;

		public ScoreInfo(int sum) {
			tripples = new ArrayList<BChallenge.Tripple>();
		}

		public boolean mustBeSuprisingBeingBigger(int desiredScore) {
			
			for(Tripple tripple : tripples){
				if(tripple.isBigger(desiredScore)){
					if(!tripple.isSuprising()){
						return false;
					}
				}
			}
			return true;
		}

		public boolean canBeBiggerAndSuprising(int desiredScore) {
			for(Tripple tripple : tripples){
				if(tripple.isBigger(desiredScore)){
					if(tripple.isSuprising()){
						return true;
					}
				}
			}
			return false;
		}

		public boolean canBeBigger(int desiredScore) {
			for(Tripple tripple : tripples){
				if(tripple.isBigger(desiredScore)){
					return true;
				}
			}
			return false;
		}

		public boolean canBeSuprising() {
			for(Tripple tripple : tripples){
				if(tripple.isSuprising()){
					return true;
				}
			}
			return false;
		}

		public void addTripple(int i, int j, int k) {
			Tripple tripple = new Tripple(i,j,k);
			if(tripple.isValid()){
				tripples.add(tripple);
			}

		}

	}

	private static class Tripple{

		private final int i;
		private final int j;
		private final int k;

		public Tripple(int i, int j, int k) {
			this.i = i;
			this.j = j;
			this.k = k;
		}


		public boolean isBigger(int desiredScore) {
			return i>=desiredScore || j>=desiredScore || k>=desiredScore;
		}


		public boolean isSuprising() {
			return 2==getMaxDifference();
		}


		private boolean isValid() {
			int max = getMaxDifference();
			return max<3;
		}

		private int getMaxDifference() {
			int a1 = Math.abs(i-j);
			int a2 = Math.abs(i-k);
			int a3 = Math.abs(k-j);

			int max = Math.max(Math.max(a1,a2), a3);
			return max;
		}

	}



}
