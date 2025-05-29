package codjamdoce;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DancingGooglers {

	private final File file;
	private int ncases;
	private DanceContest[] contests;
	private int[] result;

	public DancingGooglers(File file) {
		this.file = file;
	}

	public void init() throws Exception {
		int numberOfParticipantsIndex = 0;
		int numberOfSurprisingScoresIndex = 1;
		int minScoreIndex = 2;
		BufferedReader reader = new BufferedReader(new FileReader(file));
		try {
			String line;
			int lineNumber = 0;

			int contestsCount = 0;
			while ((line = reader.readLine()) != null) {
				if (lineNumber == 0) {
					ncases = Integer.valueOf(line.trim());
					contests = new DanceContest[ncases];
					result = new int[ncases];
				} else {
					StringTokenizer tokenizer = new StringTokenizer(line.trim(), " ");

					int index = 0;
					Googler[] participants = null;
					int surprisingScores = 0;
					int minScore = 0;

					int participantsCount = 0;
					while (tokenizer.hasMoreElements()) {
						String next = tokenizer.nextToken();
						if (index == numberOfParticipantsIndex) {
							participants = new Googler[Integer.valueOf(next)];
						} else if (index == numberOfSurprisingScoresIndex) {
							surprisingScores = Integer.valueOf(next);
						} else if (index == minScoreIndex) {
							minScore = Integer.valueOf(next);
						} else {
							Googler googler = new Googler(Integer.valueOf(next), minScore);
							participants[participantsCount] = googler;
							participantsCount++;
						}
						index++;
					}

					if (participants != null && surprisingScores >= 0 && minScore >= 0) {
						contests[contestsCount] = new DanceContest(participants, surprisingScores);
						contestsCount++;
					}
				}
				lineNumber++;
			}

		} finally {
			reader.close();
		}
	}

	public void processContests() {
		int count = 0;
		for (DanceContest contest : contests) {
			result[count] = contest.getBestResultParticipants();
			count++;
		}
	}

	public void printResult() throws IOException {
		int count = 0;
		File outfile = new File("out");
		if (outfile.exists())
			outfile.delete();
		outfile.createNewFile();
		FileOutputStream out = new FileOutputStream(outfile);
		try {
			for (int r : result) {
				if (count == ncases - 1) {
					out.write(MessageFormat.format("Case #{0}: {1}", (count + 1), r).getBytes());
				} else {
					out.write(MessageFormat.format("Case #{0}: {1}\n", (count + 1), r).getBytes());
				}
				count++;
			}
		} finally {
			out.close();
		}
	}

	private static class DanceContest {

		private final Googler[] participants;
		private final int surprisingScores;

		public DanceContest(Googler[] participants, int surprisingScores) {
			this.participants = participants;
			this.surprisingScores = surprisingScores;
		}

		private int getBestResultParticipants() {
			int surprisingScoresLeft = surprisingScores;
			int result = 0;

			for (Googler participant : participants) {
				participant.getBestScoreTable(surprisingScoresLeft > 0);

				boolean haveSurprisingScore = participant.haveSurprisingScore();
				if (participant.hasBestResult(participant.getTableScore())) {
					if (!haveSurprisingScore) {
						result++;
					} else if (haveSurprisingScore && surprisingScoresLeft > 0) {
						result++;
					}
				}

				if (haveSurprisingScore) {
					surprisingScoresLeft--;
				}

			}
			return result;
		}

	}

	private static class Googler {

		enum ScoreType {
			LESSER, GREATER, EQUAL
		}

		private final int score;
		private final int MAX_SCORE = 30;
		private List<Integer> tableScore;
		private final int minScore;

		public Googler(int score, int minScore) {
			this.score = score;
			this.minScore = minScore;
		}

		public void getBestScoreTable(boolean canBeSurprising) {
			tableScore = new ArrayList<Integer>();
			
			if (this.score == 0) {
				tableScore.add(0);
				tableScore.add(0);
				tableScore.add(0);
				return;
			}

			this.tableScore = calculateTable((getScore() * 10) / MAX_SCORE);

			if (!isValidTable(this.tableScore) || !hasBestResult(this.tableScore)) {
				int retry = 4;
				while (retry > 0) {
					if (retryTable(canBeSurprising, retry) && isValidTable(this.tableScore)) {
						break;
					}
					retry--;
				}
			}
			
			if (!isValidTable(this.tableScore)) {
				Integer[] array = this.tableScore.toArray(new Integer [tableScore.size()]);
				this.tableScore = new ArrayList<Integer>();
				this.tableScore.add(array[0]);
				this.tableScore.add(array[1] - 1);
				this.tableScore.add(array[2] + 1);
			}
			
			if (!isValidTable(this.tableScore)) {
				System.out.println();
			}

			return;
		}

		public boolean retryTable(boolean canBeSurprising, int retry) {
			int average = (getScore() * 10) / MAX_SCORE;
			if (retry == 6 && average > 2 && canBeSurprising) {
				List<Integer> table = calculateTable(average - 2);
				if (hasBestResult(table) && isValidTable(table)) {
					this.tableScore = table;
					return true;
				}
				table = calculateTable(average - 2);
				Integer second = table.remove(1);
				Integer third = table.remove(1);
				second -=1;
				third +=1;
				table.add(second);
				table.add(third);
				if (hasBestResult(table) && isValidTable(table)) {
					this.tableScore = table;
					return true;
				}
			}
			if (retry == 6 && average > 1) {
				List<Integer> table = calculateTable(average - 1);
				if (hasBestResult(table) && isValidTable(table)) {
					this.tableScore = table;
					return true;
				}
			}

			if (retry == 5 && average > 2 && canBeSurprising) {
				List<Integer> table = calculateTable(average - 2);
				if (hasBestResult(table) && isValidTable(table)) {
					this.tableScore = table;
					return true;
				}
			}
			if (retry == 5 && average > 1) {
				List<Integer> table = calculateTable(average - 1);
				if (hasBestResult(table) && isValidTable(table)) {
					this.tableScore = table;
					return true;
				}
			}

			if (retry == 4 && canBeSurprising) {
				List<Integer> table = calculateTable(average + 2);
				if (hasBestResult(table) && isValidTable(table)) {
					this.tableScore = table;
					return true;
				}
				table = calculateTable(average + 2);
				Integer second = table.remove(1);
				Integer third = table.remove(1);
				second -=1;
				third +=1;
				table.add(second);
				table.add(third);
				if (hasBestResult(table) && isValidTable(table)) {
					this.tableScore = table;
					return true;
				}
			}
			if (retry == 4 && average > 1) {
				List<Integer> table = calculateTable(average + 1);
				if (hasBestResult(table) && isValidTable(table)) {
					this.tableScore = table;
					return true;
				}
			}

			if (retry == 3 && canBeSurprising) {
				List<Integer> table = calculateTable(average + 2);
				if (hasBestResult(table) && isValidTable(table)) {
					this.tableScore = table;
					return true;
				}
				table = calculateTable(average + 2);
				Integer second = table.remove(1);
				Integer third = table.remove(1);
				second -=1;
				third -=1;
				table.add(second);
				table.add(third);
				if (hasBestResult(table) && isValidTable(table)) {
					this.tableScore = table;
					return true;
				}
			}
			if (retry == 3 && average > 1) {
				List<Integer> table = calculateTable(average + 1);
				if (hasBestResult(table) && isValidTable(table)) {
					this.tableScore = table;
					return true;
				}
			}
			return false;
		}

		public List<Integer> calculateTable(int average) {
			List<Integer> table = new ArrayList<Integer>();
			if (average * 3 == getScore()) {
				table.add(average);
				table.add(average);
				table.add(average);
			} else {
				ScoreType scoreType = firstScoreType(average);
				if (scoreType != null) {
					if (scoreType != null && scoreType == ScoreType.LESSER) {
						processLesser(average, table);
					} else if (scoreType == ScoreType.GREATER) {
						processGreater(average, table);
					} else {
						processEqual(average, table);
					}
				} else {
					scoreType = secondScoreType(average);
					if (scoreType != null) {
						if (scoreType == ScoreType.LESSER) {
							processLesser(average, table);
						} else if (scoreType == ScoreType.GREATER) {
							processGreater(average, table);
						} else {
							processEqual(average, table);
						}
					}
				}
			}

			return table;
		}

		private void processEqual(int average, List<Integer> table) {
			table.add(average);
			table.add(average + 1);
			table.add((getScore() - ((average + average))));
		}

		private boolean hasBestResult(List<Integer> tableScore) {
			for (int score : tableScore) {
				if (score >= this.minScore) {
					return true;
				}
			}
			return false;
		}

		public void processGreater(int average, List<Integer> table) {
			table.add(average);
			table.add(average + 1);
			table.add((getScore() - ((average + 1) + average)));
		}

		public void processLesser(int average, List<Integer> table) {
			table.add(average);
			table.add(average - 1);
			table.add((getScore() - ((average - 1) + average)));
		}

		public ScoreType secondScoreType(int average) {
			int number = getScore() - ((average - 1) + average);
			boolean result = number - average <= 2;
			boolean lesser = result;

			number = getScore() - ((average + 1) + average);
			result = number - average <= 2;
			boolean greater = result;

			if (lesser) {
				return ScoreType.LESSER;
			} else if (greater) {
				return ScoreType.GREATER;
			} else {
				number = getScore() - ((average) + average);
				result = number - average <= 2;
				if (result) {
					return ScoreType.EQUAL;
				}
				return null;
			}
		}

		public ScoreType firstScoreType(int average) {
			int number = getScore() - ((average - 1) + average);
			number = number - average;
			boolean lesser = number == 1 || number == 0;

			number = getScore() - ((average + 1) + average);
			number = number - average;
			boolean greater = number == 1 || number == 0;

			if (lesser) {
				return ScoreType.LESSER;
			} else if (greater) {
				return ScoreType.GREATER;
			} else {
				number = getScore() - ((average) + average);
				boolean result = (number - average) == 0 || (number - average) == 1;
				if (result) {
					return ScoreType.EQUAL;
				}
				return null;
			}
		}

		public int getScore() {
			return this.score;
		}

		public List<Integer> getTableScore() {
			return this.tableScore;
		}

		public boolean haveSurprisingScore() {
			boolean result = false;
			outer: for (int s : tableScore) {
				for (int cs : tableScore) {
					if ((cs - s) == 2) {
						result = true;
						break outer;
					}
					if ((cs - s) > 2) {
						System.out.println();
					}
				}
			}
			return result;
		}
		
		private boolean isValidTable(List<Integer> table) {
			boolean valid = true;
			int calculatedScore = 0;
			for (int s : table) {
				calculatedScore += s;
			}
			
			if (calculatedScore != score) {
				return false;
			}
			
			outer: for (int s : table) {
				for (int cs : table) {
					if ((cs - s) > 2) {
						valid = false;
						break outer;
					}
				}
			}
			return valid;
		}

	}

	public static void main(String[] args) throws Exception {
		if (args.length < 1) {
			System.out.println("Provide absolute path of input file");
		}
		File file = new File(args[0]);
		if (file.isFile()) {
			DancingGooglers dancingGooglers = new DancingGooglers(file);
			dancingGooglers.init();
			dancingGooglers.processContests();
			dancingGooglers.printResult();
		}
	}
}
