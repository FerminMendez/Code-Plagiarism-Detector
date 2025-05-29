package qualification;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

import com.sun.org.apache.xpath.internal.axes.ReverseAxesWalker;

public class BMain {

	private static final int S_THEN_P = 0;
	private static final int NO_S_THEN_P = 1;
	private static final int ALWAYS_P = 2;
	private static final int CAN_BE_S = 3;

	public static void main(String[] args) {
		String inputFileName = args[0];
		String outputFileName = args[1];
		BufferedReader reader = null;
		File outputfile = new File(outputFileName);
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(outputfile);
		} catch (FileNotFoundException e1) {
			System.err.println("Output file not found");
			System.exit(1);
		}

		DataOutputStream dos = new DataOutputStream(fos);
		try {
			reader = new BufferedReader(new FileReader(inputFileName));

			String numberOfCasesStr = reader.readLine(); // Number of cases
			int numberOfCases = Integer.valueOf(numberOfCasesStr); // Default:
																	// number of
																	// cases
			for (int i = 0; i < numberOfCases; i++) {
				System.out.println("Case #" + (i + 1));
				// Read Case
				StringTokenizer tokenizer = new StringTokenizer(
						reader.readLine());
				int N = Integer.valueOf(tokenizer.nextToken());
				int S = Integer.valueOf(tokenizer.nextToken());
				int p = Integer.valueOf(tokenizer.nextToken());

				List<Integer> totalPoints = new ArrayList<Integer>();
				for (int j = 0; j < N; j++) {
					totalPoints.add(Integer.valueOf(tokenizer.nextToken()));
				}

				// Solve Case
				int result = N;

				Collections.sort(totalPoints, Collections.reverseOrder());

				for (Integer points : totalPoints) {
					boolean sThenP = false;
					boolean noSThenP = false;
					boolean alwaysP = false;
					boolean canBeS = false;
					if (p == 0) {
						continue;
					} else if (points.equals(0) || points.equals(1)) {
						if (points >= p) {
							continue;
						} else {
							sThenP = false;
							noSThenP = false;
						}
					} else if (points.equals(30) || points.equals(29)) {
						sThenP = true;
						noSThenP = true;
					} else {
						boolean divBy3 = (points % 3) == 0;
						double third = (double) points / 3;

						// TODO Ver caso de borde 10
						if (divBy3) {
							sThenP = third + 1 >= p;
							noSThenP = third >= p;							
						} else {
							int ceiling = (int) Math.ceil(third);
							boolean prevDivBy3 = ((points - 1) % 3 == 0);

							if (prevDivBy3) {
								sThenP = ceiling >= p;
								noSThenP = ceiling >= p;								
							} else {
								sThenP = ceiling + 1 >= p;
								noSThenP = ceiling >= p;								
							}
						}
					}
					
					alwaysP = sThenP && noSThenP;
					if (sThenP && !noSThenP) {
						if (S > 0) {
							canBeS = true;
							S--;
						} else {
							canBeS = false;
						}
					} else {
						canBeS = false;
					}
					
					if (!alwaysP && !canBeS) {
						result--;
					}
					 
				}
				try {
					dos.writeBytes("Case #" + (i + 1) + ": " + result + "\n");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Input file not found");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
