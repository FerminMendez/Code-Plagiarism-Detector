import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Googlers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = null;
		int caseNumber = 0;
		Googlers a = new Googlers();

		try {
			scanner = new Scanner(new FileInputStream(args[0]));
			while (scanner.hasNextLine()) {

				if (caseNumber == 0) {
					scanner.nextLine();
				} else {
					String pairs = scanner.nextLine();
					String[] numbers = pairs.split(" ");

					System.out.println("Case #" + caseNumber + ": "
							+ a.resolve(numbers));
				}
				caseNumber++;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}

	}

	private Integer resolve(String[] data) {

		int googlersNumber = Integer.parseInt(data[0]);
		int surprices = Integer.parseInt(data[1]);
		int p = Integer.parseInt(data[2]);
		int total = 0;

		ArrayList<Integer> googlers = new ArrayList<Integer>();
		for (int i = 0; i < googlersNumber; i++) {
			googlers.add(Integer.parseInt(data[3 + i]));
		}

		// create the triadas

		ArrayList<Integer[]> scores = createTriada(googlers);

		if (surprices > 0) {
			// Count number surpricing
			Integer totalSuprising = countNumberSurprising(scores);

			if (totalSuprising == surprices) {
				// Count p
				total = countP(p, scores);

			} else {
				// Create missing surprises
				scores = createMissingSurprices(surprices - totalSuprising, p,
						scores, false);

				Integer totalSuprisingB = countNumberSurprising(scores);

				if (totalSuprisingB != surprices) {
					scores = createMissingSurprices(surprices - totalSuprising,
							p, scores, true);
				}

				// check p
				total = countP(p, scores);
			}
		} else {
			total = countP(p, scores);
		}

		return total;
	}

	private ArrayList<Integer[]> createTriada(ArrayList<Integer> g) {

		ArrayList<Integer[]> scores = new ArrayList<Integer[]>();

		for (Integer number : g) {
			Integer[] score = new Integer[3];

			for (int i = 3; i > 0; i--) {

				float resultPrecise = number / i;
				int resultInteger = number / i;
				int calification = 0;
				if (resultPrecise > resultInteger) {
					calification = resultInteger + 1;
				} else {
					calification = resultInteger;
				}
				score[i - 1] = calification;
				number = number - calification;
			}
		
			scores.add(score);
		}

		return scores;
	}

	private Boolean checkSurprising(Integer[] scores) {

		Boolean found = false;

		int a = scores[0] - scores[1];
		int b = scores[0] - scores[2];
		int c = scores[1] - scores[2];

		if (a == 2 || b == 2 || c == 2) {
			found = true;
		}

		return found;
	}

	private int countNumberSurprising(ArrayList<Integer[]> c) {

		Boolean found = false;
		int surpriseN = 0;

		for (Integer[] integers : c) {

			if (checkSurprising(integers)) {
				surpriseN++;
			}
		}

		return surpriseN;

	}

	private ArrayList<Integer[]> createMissingSurprices(int missing, int p,
			ArrayList<Integer[]> s, Boolean forced) {

		for (int i = 0; i < s.size(); i++) {

			if (missing > 0) {

				if (!checkP(p, s.get(i)) || forced) {

					if (s.get(i)[1] > 0) {

						if ((s.get(i)[0] < p && s.get(i)[0] + 1 >= p) || forced) {
							
							Integer[] newTripleta = (Integer[])s.get(i).clone();
							newTripleta[0] = newTripleta[0]+1;
							newTripleta[1] = newTripleta[1]-1;

							if (validTripleta(newTripleta)) {
								s.set(i, newTripleta);
								missing--;
							}
						}
					}

				}
			}
		}
		return s;
	}

	private Boolean validTripleta(Integer[] scores) {
		Boolean found = true;

		int a = scores[0] - scores[1];
		int b = scores[0] - scores[2];
		int c = scores[1] - scores[2];

		if (a > 2 || b > 2 || c > 2) {
			found = false;
		}
		return found;
	}

	private Boolean checkP(int p, Integer[] scores) {

		Boolean found = false;

		for (Integer integer : scores) {
			if (integer >= p) {
				found = true;
				break;
			}
		}

		return found;
	}

	private Integer countP(int p, ArrayList<Integer[]> scores) {

		Integer total = 0;

		for (Integer[] integer : scores) {
			for (Integer integer2 : integer) {
				if (integer2 >= p) {
					total++;
					break;
				}
			}
		}

		return total;
	}

}
