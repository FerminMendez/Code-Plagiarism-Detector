package com.codejam2012;

public class CodeJam2 {

	public static String fileDir = "P:\\CodeJam2012\\";
	public static String baseFileName = "B-small-attempt0";
	public static String inputFileName = fileDir + baseFileName + ".in";
	public static String outputFileName = fileDir + baseFileName + ".out";

	public static int Tcase;
	public static int Ccase = 0;
	public static String[] cases;
	public static Case singleCase;

	public static void main(String[] args) {

		FileUtils.deleteFile(outputFileName);
		String inputString = FileUtils.readFile(inputFileName);
		parseInputString(inputString);
		for (; Ccase < Tcase;) {
			parse();
		}
	}

	public static void parseInputString(String inputString) {

		cases = inputString.split("\n");
		Tcase = Integer.parseInt(cases[0]);
		Ccase = 0;
	}

	private static void parse() {

		Ccase++;
		FileUtils.appendToFile(outputFileName, "Case #" + Ccase + ": ");
		singleCase = new Case(cases[Ccase]);
		singleCase.execute();
		FileUtils.appendToFile(outputFileName, singleCase.getDataToPrint()
				+ "\n");

	}

	public static class Case {
		StringBuilder outputStatement;
		private int N, S, P;
		private int[] G;
		private boolean[][] B; // greater than p , surprising , both

		public Case(String caseString) {
			outputStatement = new StringBuilder();
			String[] arr = caseString.split(" ");
			N = Integer.parseInt(arr[0]);
			S = Integer.parseInt(arr[1]);
			P = Integer.parseInt(arr[2]);
			G = new int[N];
			B = new boolean[N][3];

			for (int i = 0; i < G.length; i++) {
				G[i] = Integer.parseInt(arr[i + 3]);
			}
			java.util.Arrays.sort(G);
		}

		public void execute() {

			for (int loop = 0; loop < G.length; loop++) {
				checkANumberForSurprisingAndDeleteSurprising(G[loop], loop);

			}

			int finalYeild = 0;
			for (int loop = 0; loop < N; loop++) {
				// if(S >= 1){
				// if(B[loop][2] == true){
				// S--;
				// finalYeild++;
				// }else if(B[loop][1] == true){
				// S--;
				// }else if(B[loop][0] == true){
				// finalYeild++;
				// }
				// }else{
				// if(B[loop][0] == true){
				// finalYeild++;
				// }
				// }

				if (S >= 1) {
					if (B[loop][2] == true) {
						S--;
						finalYeild++;
						B[loop][0] = false;
						B[loop][1] = false;
						B[loop][2] = false;
					}
				}

			}

			for (int loop =0; loop < G.length; loop++) {
				if (S >= 1) {
					if (B[loop][1] == true) {
						S--;
					} else if (B[loop][0] == true) {
						finalYeild++;
					}
				} else {
					if (B[loop][0] == true) {
						finalYeild++;
					}
				}

			}

			outputStatement.append(finalYeild);

		}

		private void checkANumberForSurprisingAndDeleteSurprising(
				int underprocess, int index) {

			int s[] = { underprocess / 3, underprocess / 3, underprocess / 3 };

			int seed = -2;
			int endseed = 2;
			for (int i = seed; i <= endseed; i++) {
				s[0] = underprocess / 3 + i;
				if (s[0] != Math.abs(s[0])) {
					continue;
				}
				for (int t = seed; t <= endseed; t++) {
					s[1] = underprocess / 3 + t;
					if (s[1] != Math.abs(s[1])) {
						continue;
					}
					for (int u = seed; u <= endseed; u++) {
						s[2] = underprocess / 3 + u;
						if (s[2] != Math.abs(s[2])) {
							continue;
						}
						if ((s[0] + s[1] + s[2]) == underprocess) {
							if (Math.abs(s[0] - s[1]) > 2
									|| Math.abs(s[0] - s[2]) > 2
									|| Math.abs(s[2] - s[1]) > 2) {

							} else if (Math.abs(s[0] - s[1]) == 2
									|| Math.abs(s[0] - s[2]) == 2
									|| Math.abs(s[2] - s[1]) == 2) {
								if (s[0] >= P || s[1] >= P || s[2] >= P) {
									B[index][2] = true;
								} else {
									B[index][1] = true;
								}
							} else if (Math.abs(s[0] - s[1]) < 2
									|| Math.abs(s[0] - s[2]) < 2
									|| Math.abs(s[2] - s[1]) < 2) {

								if (s[0] >= P || s[1] >= P || s[2] >= P) {
									B[index][0] = true;
								}
							}
						}

					}
				}

			}

		}

		public String getDataToPrint() {
			return outputStatement.toString();

		}

	}
}
