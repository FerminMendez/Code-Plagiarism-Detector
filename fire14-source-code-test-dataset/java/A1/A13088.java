package com.jedruch.dancing;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.jedruch.utils.Files;
import com.jedruch.utils.Files.LineReader;

public class Dancing {

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("missing file name");
			return;
		}
		String fileName = args[0];
		Files.readFileByLine(fileName, new LineReader() {
			
			Dancing gt = new Dancing();
			@Override
			public void onNewLine(String line, int lineNumber) {
				if ( lineNumber > 1) {
					int max = gt.getMaximumGooglers(line);
					String output = String.format("Case #%d: %d", lineNumber - 1, max);
					System.out.println(output);
				}
			}
		});
	}
	
	public int getMaximumGooglers(String line) {
		Object[] params = parseInput(line);
		return getMaximumGooglers((int)params[0], (int)params[1], (int[])params[2]);
	}
	public Object[] parseInput(String line) {
		String[] tokens = line.split(" ");
		int arraySize = Integer.valueOf(tokens[0]);
		int surprsingS = Integer.valueOf(tokens[1]);
		int betScore = Integer.valueOf(tokens[2]);
		int[] scores = new int[arraySize];

		int count = 0;
		for (int i = 3; i < tokens.length; i++) {
			scores[i - 3] = Integer.valueOf(tokens[i]);
			count++;
		}
		if (arraySize != count) {
			throw new IllegalStateException(
					"Given number of scores do not match");
		}
		return new Object[] { surprsingS, betScore, scores };
	}

	/**
	 * 
	 * @param surprisingScores
	 *            - ti ( i = N)
	 * @param maxBestScore
	 *            - p
	 * @param results
	 * @return
	 */
	public int getMaximumGooglers(int surprisingScores, int maxBestScore,
			int[] results) {
		List<Score> scores = new LinkedList<>();
		for (int s : results) {
			scores.add(new Score(s));
		}
		makeSurprsingScores(surprisingScores, maxBestScore, scores);
		return calculateWithScoreMoreThenGiven(scores, maxBestScore);
	}

	public void makeSurprsingScores(int noOfSurprisingScores, int bestScore,
			List<Score> scores) {
		int count = 0;
		for (Score s : scores) {
			if (count == noOfSurprisingScores) {
				break;
			}
			if (s.getBestScore() >= bestScore)
				continue; // ignore this case;

			boolean result = makeSuprisingOnlyIfWorth(s, bestScore);
			if (result) {
				count++;
			}
		}
		if (count > noOfSurprisingScores)
			throw new IllegalStateException(
					"Make more surprsing then exptecated");
	}

	private boolean makeSuprisingOnlyIfWorth(Score s, int bestScore) {
		int tmp = s.getTotal();
		s.makeSurprising();
		if (s.getBestScore() >= bestScore) {
			return true;
		} else {
			s.initScores(tmp); // rollback
			return false;
		}
	}

	public int calculateWithScoreMoreThenGiven(List<Score> scores,
			int maxBestScore) {
		int count = 0;
		for (Score s : scores) {
			if (s.getBestScore() >= maxBestScore) {
				count++;
			}
		}
		return count;
	}

	public int calculateWithTheBestScore(List<Score> scores) {
		int max = -1;
		int count = 0;
		for (Score s : scores) {
			if (s.getBestScore() > max) {
				count = 1;
				max = s.getBestScore();
			} else if (s.getBestScore() == max) {
				count++;
			}
		}
		return count;

	}

	public void makeSurprsingScores(int noOfSurprisingScores, List<Score> scores) {
		int count = 0;
		for (Score s : scores) {
			if (count == noOfSurprisingScores) {
				break;
			}
			boolean result = s.makeSurprising();
			if (result) {
				count++;
			}
		}
		if (count > noOfSurprisingScores)
			throw new IllegalStateException(
					"Make more surprsing then exptecated");
	}

}

class Score {
	private int[] scores = new int[3];
	private int moduloType = -1;

	public Score(int score) {
		initScores(score);
	}

	void initScores(int total) {
		moduloType = total % 3;
		int div = total / 3;
		Arrays.fill(scores, div);
		if (moduloType == 1) {
			scores[0] += 1;
		} else if (moduloType == 2) {
			scores[0] += 1;
			scores[1] += 1;
		}
	}

	void initScores(int first, int second, int third) {
		scores[0] = first;
		scores[1] = second;
		scores[2] = third;
	}

	public boolean makeSurprising() {
		if (moduloType == -1) {
			throw new IllegalStateException("Can not be -1");
		}
		if (moduloType == 1 || getTotal() == 0)
			return false;
		if (moduloType == 0) {
			scores[0] += 1;
			scores[2] -= 1;
		} else if (moduloType == 2) {
			scores[0] += 1;
			scores[1] -= 1;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Score [scores=" + Arrays.toString(scores) + "]";
	}

	public boolean isSurprising() {
		int first = scores[0];
		int second = scores[1];
		int third = scores[2];
		boolean surprsing = false;
		surprsing |= checkSurprising(first, second);
		surprsing |= checkSurprising(first, third);
		surprsing |= checkSurprising(second, third);
		return surprsing;
	}

	private boolean checkSurprising(int int1, int int2) {
		int diff = Math.abs(int1 - int2);
		if (diff > 2)
			throw new IllegalStateException("Some problem with judges");
		return diff == 2;
	}

	public int[] getScores() {
		return scores;
	}

	public int getTotal() {
		int sum = 0;
		for (int s : scores) {
			sum += s;
		}
		return sum;
	}

	public int getBestScore() {
		int max = -1;
		for (int s : scores) {
			max = Math.max(max, s);
		}
		return max;
	}

}
