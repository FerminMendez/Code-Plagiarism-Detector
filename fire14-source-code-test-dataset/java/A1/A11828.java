package com.google.codejam2011.dancing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Runner {

	public ArrayList<String> output = new ArrayList<String>();
	
	public class DancingEvent {
		private ArrayList<Score> scoreList;
		private int surprisingCount;
		private int maxValue;

		public ArrayList<Score> getScoreList() {
			return scoreList;
		}

		public void setScoreList(ArrayList<Score> scoreList) {
			this.scoreList = scoreList;
		}

		public int getSurprisingCount() {
			return surprisingCount;
		}

		public void setSurprisingCount(int surprisingCount) {
			this.surprisingCount = surprisingCount;
		}

		public int getMaxValue() {
			return maxValue;
		}

		public void setMaxValue(int maxValue) {
			this.maxValue = maxValue;
		}
	}

	private class Score {
		private final static int JURY_COUNT = 3;
		private int values[] = new int[JURY_COUNT];
		private int sum;
		private int max;
		private int maxSurprise;

		public Score(int pSum) {
			this.sum = pSum;
		}

		public void calcValues() {
			if (this.sum == 0) {
				max = 0;
				maxSurprise = 0;
			} else {
				int base = this.sum / JURY_COUNT;
				int rest = this.sum % JURY_COUNT;

				for (int i = 0; i < values.length; i++) {
					values[i] = base;
					if (rest != 0) {
						values[i]++;
						rest--;
					}
				}

				rest = this.sum % JURY_COUNT;

				if (rest == 0) {
					max = base;
					maxSurprise = base + 1;
				} else {
					max = base + 1;
					if (rest == 1)
						maxSurprise = base + 1;
					else
						maxSurprise = base + 2;
				}
			}
		}

		public boolean isBigger(int p) {
			if (this.max >= p)
				return true;
			else
				return false;
		}

		public boolean isSurpriseBigger(int p) {
			if (this.maxSurprise >= p)
				return true;
			else
				return false;
		}
	}

	public class InputParser {
		private BufferedReader br;

		public InputParser(String path, ArrayList<DancingEvent> dances) {
			try {
				br = new BufferedReader(new FileReader(new File(path)));

				String inputLine;
				int T = 0, N, S, P, counter = 0;
				int countBase = 0, counterSurprise = 0;
				try {
					while ((inputLine = br.readLine()) != null) {
						if (T == 0) {
							T = new Integer(inputLine);
						} else {
							String input[] = inputLine.split(" ");
							N = new Integer(input[0]);
							S = new Integer(input[1]);
							P = new Integer(input[2]);
							countBase = 0;
							counterSurprise = 0;
							ArrayList<Score> scores = new ArrayList<Runner.Score>();

							for (int i = 3; i < input.length; i++) {
								Score tmpScore = new Score(
										new Integer(input[i]));
								tmpScore.calcValues();
								scores.add(tmpScore);

								if (tmpScore.isBigger(P))
									countBase++;
								else if (tmpScore.isSurpriseBigger(P))
									counterSurprise++;
							}

							DancingEvent dance = new DancingEvent();
							dance.setMaxValue(P);
							dance.setScoreList(scores);
							dance.setSurprisingCount(S);
							dances.add(dance);
							output.add("Case #"+ counter + ": "
											+ ((Integer) Math.min(
													counterSurprise, S) + (Integer) countBase));
						}
						counter++;
					}
				} catch (NumberFormatException e) {
					e.printStackTrace();
					System.out.println("Could not parse Numbers");
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("Could not Read Lines");
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				System.out.println("Could not open file");
			}

		}
	}
	
	public void writeOutput(String path){
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(	new FileWriter(new File(path)));
			for(String s : output)
				try {
					bw.write(s + "\r\n");
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("Could not write in file");
				}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Could not open file");
		}

	}

	public static void main(String args[]) {
		Runner r = new Runner();
		ArrayList<DancingEvent> dances = new ArrayList<Runner.DancingEvent>();
		r.new InputParser("src/com/google/codejam2011/dancing/input.txt",
				dances);
		r.writeOutput("src/com/google/codejam2011/dancing/output.txt");
	}
}
