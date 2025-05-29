package google.code.jam.problem.c;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MainClass {

	public static final String PATH_FILE = "C:/Temp/";

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {

			MainClass mainClass = new MainClass();
//			HashSet <String> recycledNumbersCollection = new HashSet <String>();
			List<String> recycled = new ArrayList<String>();
			
			// Open the file that is the first
			// command line parameter
			FileInputStream fstream = new FileInputStream(PATH_FILE
					+ "C-small-attempt1.in");

			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			String strLine = br.readLine();

			int numOfTestCase = Integer.parseInt(strLine);

			
			if ((numOfTestCase >= 1) && (numOfTestCase <= 50)) {

				int i = 1;

				// Read File Line By Line
				while ((strLine = br.readLine()) != null) {

					StringTokenizer st = new StringTokenizer(strLine, " ");

					int numberA = Integer.parseInt(st.nextToken());
					int numberB = Integer.parseInt(st.nextToken());

					if ((1 <= numberA) && (numberA <= numberB)
							&& (numberB <= 1000)) {

						int recycledPair = 0;

						for (int j = numberA; j < numberB; j++) {

							String rotateNumber = String.valueOf(j);
							
							int currentNumber = j;

//							System.out.println("currentNumber: " + currentNumber);
							
							for (int k = 1; k < String.valueOf(j).length(); k++) {

								String rotateNumberNew = mainClass
										.rotateNumber(rotateNumber);
								
//								System.out.println(rotateNumberNew);

								if ((!"-1".equals(rotateNumber))
										&& (Integer.valueOf(rotateNumberNew) > currentNumber)
										&& (Integer.valueOf(rotateNumberNew) <= numberB)
										&& (rotateNumber != rotateNumberNew)) {

									recycledPair++;
//									recycledNumbersCollection.add(rotateNumberNew);
									recycled.add(currentNumber + " , " + rotateNumberNew);
//									System.out.println(":: recycledPair :: " + rotateNumberNew);
								}
								
								rotateNumber = rotateNumberNew;
							}
						}

//						int temp = 0;
//						for (String string : recycled) {
//							System.out.println("number " + ++temp +": " + string);
//						}
						
						System.out.println("Case #" + i++ + ": " + recycledPair);

//						System.out.println(recycledNumbersCollection.size());
						
					} else {

						throw new Exception("Condition not 1 <= A <= B <= 1000");
					}
				}

			} else {

				throw new Exception("Number of test case is not valid");
			}
			// Close the input stream
			in.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}

	public String rotateNumber(String number) {

		String returnValue = "-1";
		
		try {

			if (Integer.parseInt(number) >= 10) {

				String lastDigit = number.substring(number.length() -1 , number.length());
				
				returnValue = lastDigit + number.substring(0, number.length() -1);
				
//				String firstDigit = number.substring(0, 1);

//				returnValue = number.substring(1) + firstDigit;
				

			} else {

				returnValue = "-1";
			}

		} catch (Exception e) {

			System.err.println("Error: " + e.getMessage());
		}

		return returnValue;
	}

}

//1111 2222
