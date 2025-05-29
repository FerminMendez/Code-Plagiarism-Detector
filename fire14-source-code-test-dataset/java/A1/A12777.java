import java.util.ArrayList;




public class Logic {




	public static void solve() {

		//First input line
		//Texter.readLine();

		int noOfCases = Integer.valueOf(Texter.readLine());




		//Texter.writeText("Output");


		for (int i = 1; i <= noOfCases; i++) {

			int caseNo = i;

			String nextLine = Texter.readLine();

			if (nextLine == null) {

				nextLine = Texter.readLine();
				System.out.println("HHH");
			}
			System.out.println("HHHsda");

			ArrayList<Integer> numbers = Texter.parseNumberList(nextLine);
			//ArrayList<Integer> numbers = (ArrayList<Integer>) numbersOrig.clone();

			ArrayList<Integer[]> triplets = new ArrayList<Integer[]>();


			int noOfGooglers = numbers.get(0);
			int surprises = numbers.get(1);
			int minBest = numbers.get(2);

			numbers.remove(0);
			numbers.remove(0);
			numbers.remove(0);

			for (int q = 0; q < noOfGooglers; q++) {

				int curScore = numbers.get(q);

				triplets.add(crunch(curScore));


			}


			int[] surpriseIndexes = new int[surprises];


			//Count how many above min

			int answer = 0;

			for (int z = 0; z < numbers.size(); z++) {

				if (triplets.get(z)[0] >= minBest) {

					answer++;

				}


			}



			//Loop number of surprises

			ArrayList<Integer> triedOnes = new ArrayList<Integer>();

			for (int t = 0; t < surprises; t++) {

				Integer[] reCrunched = null;

				//while (reCrunched == null) {
				for (int y = 0; y < triplets.size(); y++) {


					int curMin = -1;

					int surpriseIndex = -1;

					//Find the highest one that is below min
					//Start there

					for (int r = 0; r < triplets.size(); r++) {

						if (triedOnes.contains(r)) {
							continue;
						}


						int highestNum = triplets.get(r)[0];

						if (highestNum < minBest && highestNum > curMin) {

							curMin = highestNum;
							//surpriseIndexes[t] = r;
							surpriseIndex = r;

						}

					}

					//Remove so don't find again
					//triplets.remove(surpriseIndex);

					if (surpriseIndex == -1) {

						break;

					}

					triedOnes.add(surpriseIndex);

					//See if it can be made a surprise one

					// + y to account for the number that have been removed
					reCrunched = surpriseCrunch(numbers.get(surpriseIndex));




					if (reCrunched != null) {

						reCrunched = getHighest(reCrunched[0], reCrunched[1], reCrunched[2]);

					}
					//If still too low set to null so will continue looping

					if (reCrunched != null) {

						if (reCrunched[0] < minBest) {

							reCrunched = null;

						}
					}


					if (reCrunched != null) {

						if (reCrunched[0] >= minBest) {

							answer++;
							break;

						}
					}

				}




			}




			Texter.writeText("Case #" + caseNo + ": " + answer);


			//int no = 15;

			//triplets.add(crunch(no));




		}




	}



	static Integer[] crunch(int score) {



		/*for (int i = 10; i >= 0; i--) {
			for (int q = 10; q >= 0; q--) {
				for (int w = 10; w >= 0; w--) {*/


		int i = 10;
		int q = 10;
		int w = 10;


		while (true) {


			if (i + q + w == score) {

				return getHighest(i, q, w);

			}

			w--;

			if (i + q + w == score) {

				return getHighest(i, q, w);

			}

			q--;

			if (i + q + w == score) {

				return getHighest(i, q, w);

			}

			i--;


		}




		/*}
		}
		}*/




	}



	static Integer[] surpriseCrunch(int score) {



		for (int i = 10; i >= 0; i--) {
			for (int q = 10; q >= 0; q--) {
				for (int w = 10; w >= 0; w--) {


					if (i + q + w == score) {

						if (checkSurprise(i, q, w)) {

							return new Integer[] { i, q, w };
						}
					}
				}
			}
		}

		return null;




	}



	static boolean checkSurprise(int i, int q, int w) {

		if (i >= 0 && q >= 0 && w >= 0) {

			//Check if a diff of 2

			if (i - q == 2 || i - w == 2 || q - i == 2 || q - w == 2 || w - i == 2 || w - q == 2) {

				//No greater than 2 diff

				if (i - q <= 2 && i - w <= 2 && q - i <= 2 && q - w <= 2 && w - i <= 2 && w - q <= 2) {

					return true;

				}
			}
		}

		return false;




	}



	static Integer[] getHighest(int i, int q, int w) {

		if (i >= q && i >= w) {

			return new Integer[] { i, q, w };

		}


		if (q >= i && q >= w) {

			return new Integer[] { q, i, w };

		}

		if (w >= i && w >= q) {

			return new Integer[] { w, i, q };

		}


		return null;




	}




}
