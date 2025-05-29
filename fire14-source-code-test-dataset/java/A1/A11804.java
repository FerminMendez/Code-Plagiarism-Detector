import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Qualify {

	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File("B-small-attempt3.in")));
			int cases = Integer.parseInt(reader.readLine());
			for (int d = 0; d < cases; d++) {

				// parse
				String line = reader.readLine();
				String[] spLine = line.split(" ");
				int googs = Integer.parseInt(spLine[0]);
				int surprises = Integer.parseInt(spLine[1]);
				int prize = Integer.parseInt(spLine[2]);
				Googler[] googArr = new Googler[googs];

				// find the solutions for each googler
				for (int r = 0; r < googs; r++) {
					googArr[r] = new Googler();
					Integer total = Integer.parseInt(spLine[(r + 3)]);
					googArr[r].poss(total, prize);

				}

				// sort the array based on how many possibilities it has
				Arrays.sort(googArr, new Comparator<Googler>() {
					@Override
					public int compare(Googler o1, Googler o2) {
						// TODO Auto-generated method stub
						return new Integer(o1.trueCounter)
								.compareTo(o2.trueCounter);
					}
				});

				int surCounter = 0;
				int winCounter = 0;
				/*
				 * boolean prizeSurprise = false; boolean prizeNoSurprise =
				 * false; boolean failSurprise = false; boolean failNoSurprise =
				 * false;
				 */
				for (int i = 0; i < googs; i++) {
					if (googArr[i].trueCounter == 1) {
						if (googArr[i].prizeSurprise == true) {
							winCounter++;
							surCounter++;
							googArr[i].used = true;
						} else if (googArr[i].prizeNoSurprise == true) {
							winCounter++;
							googArr[i].used = true;
						} else if (googArr[i].failSurprise == true) {
							surCounter++;
							googArr[i].used = true;
						} else {
							// nothing to do with this
							googArr[i].used = true;
						}
					}
				}

				for (int i = 0; i < googs && surCounter < surprises; i++) {
					if (googArr[i].used == false) {
						if (googArr[i].prizeSurprise == true && googArr[i].prizeNoSurprise == false) {
							winCounter++;
							surCounter++;
							googArr[i].used = true;
							break;
						}
					}
				}
				
				for (int i = 0; i < googs && surCounter < surprises; i++) {
					if (googArr[i].used == false) {
						if (googArr[i].prizeSurprise == true) {
							winCounter++;
							surCounter++;
							googArr[i].used = true;
							break;
						}
					}
				}

				for (int i = 0; i < googs && surCounter < surprises; i++) {
					if (googArr[i].used == false) {
						if (googArr[i].failSurprise == true) {
							surCounter++;
							googArr[i].used = true;
						}
					}
				}

				for (int i = 0; i < googs; i++) {
					if (googArr[i].used == false) {
						if (googArr[i].prizeNoSurprise) {
							winCounter++;
							googArr[i].used = true;
						}
					}
				}

				System.out.println("Case #" + (d+1) + ": " + winCounter);

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
