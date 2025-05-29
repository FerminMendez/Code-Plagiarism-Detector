package com.first;

public class BDancingWiththeGooglers {

	ReadWriteFileForCodeJam flatFile;

	public BDancingWiththeGooglers() {
		flatFile = new ReadWriteFileForCodeJam();
		initializeFlatFileParameters();
		performSolution();
		finalizeSolutionFileToSend();
	}

	private void performSolution(){
		String[] items;
		int noDancers, noOfSurprises, bestScore;
		int maxGooglers;
		int maxAchieved;
		boolean surprise;
		for(int i=1; i<=Integer.parseInt(flatFile.GetSingleLineFromFile(1)); i++){
			maxGooglers = 0;
			surprise = true;
			items = flatFile.GetSingleLineFromFile(i + 1).split(" ");
			noDancers = Integer.parseInt(items[0]);
			noOfSurprises = Integer.parseInt(items[1]);
			bestScore = Integer.parseInt(items[2]);
			flatFile.setFileContentToWrite("Case #" + i + ":", true, true);
			for(int j=0; j<noDancers; j++){
				if ((noOfSurprises <= 0) && surprise)
					surprise = false;
				maxAchieved = isBestScorePossible(Integer.parseInt(items[j+3]), bestScore);
				switch (maxAchieved){
				case 0: break;
				case 1: maxGooglers++;	break;
				case 2:
					if (surprise){
						maxGooglers++;
						noOfSurprises--;
					}
					break;
				}
			}
			flatFile.setFileContentToWrite(String.valueOf(maxGooglers), true, false);
		}
	}

	private int isBestScorePossible(int total, int least){
		/* return 0 if not possible
		 * 1 if possible without surprise
		 * 2 if possible with surprise
		 */
		
		if (total == 0){
			if (least == 0)
				return 1;
			else
				return 0;
		}
		
		if (total == 1){
			if ((least <= 1))
				return 1;
			else
				return 0;
		}
		
		if (least * 3 - 2 <= total)
			return 1;
		if (least * 3 - 4 <= total)
			return 2;
		return 0;
	}

	private void initializeFlatFileParameters() {
		flatFile.setFileNameForRead("C:\\Users\\i067221\\Downloads\\B-small-attempt0.in");
		flatFile.setFileNameForWrite("C:\\Users\\i067221\\Downloads\\Upload\\B-small-attempt0.txt");
		flatFile.setFileSeperatorForWrite(" ");
		System.out.println("File read, (" + flatFile.ReadFile(false) + ") returned.");
	}

	private void finalizeSolutionFileToSend() {
		System.out.println("Successful write to file performed: " + flatFile.WriteFile(false));
	}

}
