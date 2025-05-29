package google.contest.C;

import google.loader.Challenge;
import google.problems.AbstractChallenge;

import java.util.HashSet;
import java.util.Set;

public class CChallenge extends AbstractChallenge implements Challenge {

	private int B;
	private int A;
	private int num;
	Set<String>pairs ;
	public CChallenge(int number, String line) {
		super(number);
		num=0;
		
		pairs = new HashSet<String>();
		
		String[] tokens = line.split(" ");

		A = Integer.parseInt(tokens[0]);
		B = Integer.parseInt(tokens[1]);
		int i=0;
		for( i=A ; i<=B; i++){
			calcFor(i);
		}
		
		setResult(""+num);
	}

	private void calcFor(int i) {
		String numString = ""+i;
		
		for(int j=1; j<= numString.length()-1; j++){
			String first = numString.substring(0,j);
			String second = numString.substring(j);
			String third = second+first;
			check(i, third);
			
		}
	}

	private void check(int i, String third) {
		if(third.startsWith("0")){
			return;
		}
		int j = Integer.parseInt(third);
		if(A<=i && i<j && j<=B){
			
			String hlp = ""+i+j;
			if(! pairs.contains(hlp)){
				pairs.add(hlp);
				num++;
			}else{
				System.out.println(""+num+"  "+i+"  "+j);
			}
		}
	}
}
