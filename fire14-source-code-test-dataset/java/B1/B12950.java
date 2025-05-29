package google.problems;

import google.loader.Challenge;

public abstract class AbstractChallenge implements Challenge{

	private final int problemNumber;
	private String result;
	public AbstractChallenge(int i) {
		this.problemNumber = i;
		
	}

	protected void setResult(String result){
		this.result = result;
	}
	
	@Override
	public String getResult() {
		return "Case #"+problemNumber+": "+result+"\n";
	}
	
	protected int getInt(int pos, String[] tokens) {
		return Integer.parseInt(tokens[pos]);
	}
	
	
}
