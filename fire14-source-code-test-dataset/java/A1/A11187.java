import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class GoogleDancers {
	public static String rootDir = System.getProperty("user.dir")
			+ File.separator;
	public static String filesDir = rootDir + "files" + File.separator;
	private FileWriter fw;
	private FileWriter fw2;

	private int tests;
	private int[] numGooglers;
	private int[] numSurprises;
	private int[] target;
	private int[][] points;

	public static void main(String[] args) {
		GoogleDancers g = new GoogleDancers();
		//g.makeTest(100);
		g.loadFile();
		g.go();
//		Compare c = new Compare();
//		try {
//			c.go("dancingAns.txt","dancingtest1Ans.txt");
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
	}

	public GoogleDancers() {

	}

	private void loadFile() {
		try {
			Scanner input = new Scanner(new File(filesDir + "dancing.txt"));
			tests = Integer.parseInt(input.nextLine());
			numGooglers = new int[tests];
			numSurprises = new int[tests];
			target = new int[tests];
			points = new int[tests][];
			Scanner line;

			for (int i = 0; i < tests; i++) {
				line = new Scanner(input.nextLine());

				numGooglers[i] = line.nextInt();
				numSurprises[i] = line.nextInt();
				target[i] = line.nextInt();
				points[i] = new int[numGooglers[i]];

				for (int j = 0; j < numGooglers[i]; j++) {
					points[i][j] = line.nextInt();
				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		}	}
	
	private void go() {

		int s;
		int count;
		int high;
		int total;
		int[] surprises;
		int[] normals;
		boolean[] marks;
		open("dancingAns.txt");
		for (int c = 0; c < tests; c++) {
//			System.out.println("\nTEST CASE " + (c + 1));
//			System.out.println("Target is " + target[c]);
			count = 0;
			s = numSurprises[c];
			// surprises = new int[numGooglers[c]];
			// normals = new int[numGooglers[c]];

			for (int i = 0; i < numGooglers[c]; i++) {
//				System.out.println("	# Surprises = " + s);
//				System.out.println("	Total Score is " + points[c][i]);
//				System.out.println("		Best Normal Score is "
//						+ normalHigh(points[c][i]));
				if (points[c][i] == 0) {
					if (0 >= target[c])
						count++;
					continue;
				} else if (points[c][i] == 30) {
					if (10 >= target[c])
						count++;
					continue;
				}
				
				if (normalHigh(points[c][i]) >= target[c]) {
//					System.out.println("			Qualifies");
					count++;
				} else if (s > 0) {
//					System.out.println("			Does not qualify");
					if (surpriseHigh(points[c][i]) >= target[c]) {

//						System.out.println("		Best Surprise Score is "
//								+ surpriseHigh(points[c][i]));
//							System.out.println("			Qualifies");
						count++;
						s--;
							//System.out.println("# Surprises = " + s);
//							System.out.println("			Does not qualify");
					}
				}
				// System.out.println("# Qualified Scores = " + count);

				// surprises[i] = surpriseHigh(points[c][i]);
				// normals[i] = normalHigh(points[c][i]);
				//
				// if (points[c][i] == 0)
				// surprises[i] = 0;
				// else if (points[c][i] == 10)
				// surprises[i] = 10;
			}

			System.out.println("Case #" + (c + 1) + ": " + count);
			//System.out.println("		Surprises Left = " + s);
			write("Case #" + (c + 1) + ": " + count);
			if (c != tests - 1)
				write("\n");
		}
		close();
	}

	private int surpriseHigh(int score) {
		switch (score % 3) {
		case 0:
			return score / 3 + 1;
		case 1:
			return score / 3 + 1;
		case 2:
			return score / 3 + 2;
		default:
			System.out.println("Error in surpriseHigh method");
			return 0;
		}
	}

	private int normalHigh(int score) {
		switch (score % 3) {
		case 0:
			return score / 3;
		case 1:
			return score / 3 + 1;
		case 2:
			return score / 3 + 1;
		default:
			System.out.println("Error in normalHigh method");
			return 0;
		}
	}

	private void open(String fileName) {
		try {
			fw = new FileWriter(new File(filesDir + fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void openAnother(String fileName) {
		try {
			fw2 = new FileWriter(new File(filesDir + fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void closeOther() {
		try {
			fw2.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void writeOther(String s) {
		try {
			fw2.write(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void close() {
		try {
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void write(String s) {
		try {
			fw.write(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void makeTest(int numTests) {
		int maxNumGooglers = 5;
		
		open("dancingtest1.txt");
		openAnother("dancingtest1Ans.txt");
		write(numTests + "\n");
		
		int numGs;
		int numSs;
		int testTarget;
		int[][] scores;
		for (int c = 0; c < numTests; c++) {
			numGs = (int)(Math.random()*((double)maxNumGooglers) + 1.0);
			write(numGs + " ");
			print(numGs + " ");
			
			numSs = 0;
			
			testTarget = (int)(Math.random()*11.0);
			
			scores = generateScores(numGs);
			
			for (int[] s : scores) {
				if (isSurprising(s))
					numSs++;
			}
			
			write(numSs + " ");
			write(testTarget + "");
			print(numSs + " ");
			print(testTarget + "");
			
			for (int[] s : scores) {
				write(" " + (s[0]+s[1]+s[2]));
				print(" " + (s[0]+s[1]+s[2]));
			}
			
			write("\n");
			print("\n");
			
			writeOther("Case #" + (c+1) + ": " + answer(scores,testTarget,numSs));
			
			if (c != numTests-1)
				writeOther("\n");
		}
		close();
		closeOther();
	}
	
	private int answer(int[][] scores,int testTarget,int surprises) {
		int answer = 0;
		int ss = surprises;
		
		for (int[] s : scores) {
			if (s[0]+s[1]+s[2] == 0) {
				if (0 >= testTarget)
					answer++;
				continue;
			}

			if (s[0]+s[1]+s[2] == 30) {
				if (10 >= testTarget)
					answer++;
				continue;
			}
			
			if (max(s) >= testTarget)
				answer++;
			else if ((s[0]+s[1]+s[2])%3 == 0 || (s[0]+s[1]+s[2])%3 == 2) {
				if (surpriseHigh(s[0]+s[1]+s[2]) >= testTarget && (ss > 0)) {
					answer++;
					ss--;
				}
			}
		}
		return answer;
	}
	
	private int max(int[] scores) {
		int max = scores[0];
		
		if (scores[1] > max)
			max = scores[1];
		if (scores[2] > max)
			max = scores[2];
		return max;
	}
	
	private void print(String s) {
		System.out.print(s);
	}
	
	private boolean isSurprising(int[] scores) {
		return (Math.abs(scores[0] - scores[1]) == 2) || (Math.abs(scores[0] - scores[2]) == 2) || (Math.abs(scores[1] - scores[2]) == 2);
	}
	
	private int[][] generateScores(int numScores) {
		int[][] scores = new int[numScores][3];
		
		int temp;
		int temp2;
		for (int[] s : scores) {
			s[0] = (int)(Math.random() * 11.0);
			
			do {
				temp = ((int)(Math.random() * 5.0) - 2) + s[0];
			} while (temp < 0 || temp > 10);
			
			s[1] = temp;
			
			if (Math.abs(s[1]-s[0]) == 2) { // first two scores are two apart
				if (s[0] > s[1])
					temp2 = s[1];
				else temp2 = s[0];
				
				do {
					temp = (int)(Math.random()*3.0) + temp2;
				} while (temp < 0 || temp > 10);
			} else if (Math.abs(s[1]-s[0]) == 1) { // first two scores are adjacent
				if (s[0] > s[1])
					temp2 = s[1];
				else temp2 = s[0];
				
				do {
					temp = ((int)(Math.random() * 4.0)) + temp2 - 1;
				} while (temp < 0 || temp > 10);
			} else { // first two scores are equal
				do {
					temp = ((int)(Math.random() * 5.0) - 2) + s[0];
				} while (temp < 0 || temp > 10);
			}
			
			s[2] = temp;
			
			//print("[" + s[0] + " " + s[1] + " " + s[2] + "]");
		}
		
		return scores;
	}
}
