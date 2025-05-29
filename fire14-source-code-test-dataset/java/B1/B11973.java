package com.sam.googlecodejam.dance;

import com.sam.googlecodejam.helper.InputReader;

public class DanceScore {

	int iBestScore;
	int iSuprize;

	int iMean;

	int iSetCount = 0;

	class TripletScore {
		public int judge1;
		public int judge2;
		public int judge3;

		public void setValue(int j1, int j2, int j3) {
			judge1 = j1;
			judge2 = j2;
			judge3 = j3;
		}

		public int sum() {
			//System.out.println(judge1 + judge2 + judge3);
			return judge1 + judge2 + judge3;
		}

		public boolean containsGreater(int value) {
			//System.out.println(judge1 >= value || judge2 >= value || judge3 >= value);
			if(judge1 >=0 && judge2 >=0 && judge3 >=0)
			{
				return judge1 >= value || judge2 >= value || judge3 >= value;
			}
			return false;
		}
	}

	/*
	 * e.g. If score is 13,14,15, 15 - avg = 15/3 + (15%3==0)= 5 (3,5,5),
	 * (4,4,5) (4,5,5) (5,5,5) (4,6,5) If score is 22,23,24 22 - avg = 22/3
	 * +(22%3==0) = 8 (6,8,8), (7,7,8) (7,8,8) (8,8,8), (7,8,9)
	 */
	TripletScore possibleValues[] = new TripletScore[6];

	public void generateTripletFromScore(int score) {
		int mean = score / 3 + (score % 3 == 0 ? 0 : 1);
		iMean = mean;
		for(int i=0;i<6;i++)
		{
			possibleValues[i] = new TripletScore();
		}
		// Non Suprizing
		possibleValues[0].setValue(mean - 1, mean - 1, mean);
		possibleValues[1].setValue(mean - 1, mean, mean);
		possibleValues[2].setValue(mean, mean, mean);
		// Suprizing
		possibleValues[3].setValue(mean - 2, mean, mean);
		possibleValues[4].setValue(mean - 1, mean + 1, mean);
		possibleValues[5].setValue(mean - 1, mean - 1, mean + 1);

	}

	public void isScore(int score) {
		// check if any combination yeilds a result that would be greater than
		// the better score
		// We first check if a non-suprizing one works and only then use up a
		// suprizing!
		for (int i = 0; i < 3; i++) {
			if (possibleValues[i].sum() == score) {
				if (possibleValues[i].containsGreater(iBestScore)) {
					iSetCount++;
					return;
				}
			}
		}
		if (iSuprize != 0) {
			for (int i = 3; i < 6; i++) {
				if (possibleValues[i].sum() == score) {
					if (possibleValues[i].containsGreater(iBestScore)) {
						iSetCount++;
						iSuprize--;
						return;
					}
				}
			}
		}
	}

	public static void main(String[] args) {

		InputReader reader = new InputReader("c://input.in");
		reader.readNextLine(); // read the line number off - we don't need it

		String lineRead = null;
		int i = 1;
		while ((lineRead = reader.readNextLine()) != null) {
			DanceScore score = new DanceScore();
			System.out.print("Case #" + i + ": ");
			i++;
			String values[] = lineRead.split(" ");

			score.iSuprize = Integer.parseInt(values[1]);
			score.iBestScore = Integer.parseInt(values[2]);

			for (int LoopCount = 3; LoopCount <= Integer.parseInt(values[0])+2; LoopCount++) {
				score.generateTripletFromScore(Integer
						.parseInt(values[LoopCount]));
				score.isScore(Integer
						.parseInt(values[LoopCount]));
			}
			System.out.println(score.iSetCount);
		}
	}

}
