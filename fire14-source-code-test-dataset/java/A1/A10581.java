package googlers;

import java.io.File;

import io.Reader;

public class DanceParty {
	public static void main(String[] args){
		new DanceParty();
	}
	
	
	
	public DanceParty(){
		String[] lines = Reader.getInput(new File("B-small-attempt1.in"));
		//String[] lines = Reader.getInput(new File("danceInput.in"));
		
		
		for (int i = 0; i < lines.length; i++){
			String line = lines[i];
			String[] peicesString = line.split(" ");
			int[] peices = new int[peicesString.length];
			for(int j = 0; j<peices.length; j++){
				peices[j] = Integer.parseInt(peicesString[j]);
			}
			
			int numGooglers = peices[0];
			int numSurprises = peices[1];
			int minBestResult = peices[2];
			int numPossible = 0;
			int numPossibleSurprises = 0;
			
			int N = 3*minBestResult-2;
			
			for (int j = 3; j < peices.length; j++){
				int sc = peices[j];
				if (sc>=N){
					numPossible++;
				}
				else if (numPossibleSurprises<numSurprises && sc>=N-2 && sc>=minBestResult){
					numPossibleSurprises++;
				}
			}
			
			numPossible+=numPossibleSurprises;
			if (numPossible>numGooglers)numPossible=numGooglers;
			if (numPossible<0)numPossible=0;
			
			System.out.println("Case #"+(i+1)+": "+numPossible);
		}
		
		
	}
}
