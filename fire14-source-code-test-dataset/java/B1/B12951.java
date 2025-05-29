package google.problems;

import google.loader.Challenge;
import google.loader.ChallengeReader;

import java.util.ArrayList;
import java.util.List;


public abstract class AbstractReader implements ChallengeReader {

	private String[] lines;
	private List<Challenge> challenges;
	private int actualLine;

	public AbstractReader(){
		challenges = new ArrayList<Challenge>();
	}
	
	
	protected void setLines(String[] input) {
		lines=input;
	}

	protected String[] getLines(){
		return lines;
	}
	
	protected int getNumberOfChallenges() {
		return Integer.parseInt(lines[0]);
	}
	
	@Override
	public List<Challenge> createChallenges(String[] input) {
		setLines(input);
		readChallenges();
		return challenges;
	}

	private void readChallenges() {
		int numOfChallanges = getNumberOfChallenges();
		setActualLine(1);
		actualLine = 1;
		for(int i=1;i<=numOfChallanges; i++){
			challenges.add(createChallenge(i));
		}
	}
	
	protected int[] asInt(String values) {
		String[] split = values.split(" ");
		int res [] = new int[split.length];
		for(int i=0;i<split.length;i++){
			res[i]=Integer.parseInt(split[i]);
		}
		return res;
	}

	protected List<Integer> asIntList(String values) {
		List<Integer> res = new ArrayList<Integer>();
		for(int i : asInt(values)){
			res.add(i);
		}
		return res;
	}
	

	protected abstract Challenge createChallenge(int i) ;
	
	protected void setActualLine(int i) {
		actualLine =i;
	}
	protected int getActualLine(){
		return actualLine;
	}
	
}
