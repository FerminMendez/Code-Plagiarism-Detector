import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class B {

	static Scanner reader;
	static BufferedWriter writer;	

	static int countS;
	static int S;
	static int P;
	static int N;
	static int result;

	public static void verifiyTriple(int pi) {
		int div = pi/3;
		int mod = pi%3;
		int dif = P - pi/3;

		if (div >= P) {
			result++;
		} else if (dif <= 2){
			if (mod == 0) {
				if (countS < S && dif == 1) {
					countS++;
					result++;
				}
			}
		} else {
			if (dif==1) {
				result++;
			} else if ( mod == 2 && countS < S ) {
				countS++;
				result++;
			}
		}
	}


	public static void main(String[] args) throws IOException {
		reader = new Scanner(new FileReader("in.txt"));
		writer = new BufferedWriter(new FileWriter("out.txt"));

		int nt = reader.nextInt();
		for(int i = 1; i <= nt; i++) {
			result = 0;
			N = reader.nextInt();
			S = reader.nextInt();
			P = reader.nextInt();
			countS = 0;
			for (int j = 0; j < N; j++) {
				int pi = reader.nextInt();
				int div = pi/3;
				int mod = pi%3;
				int dif = P - div;

				if (pi < P)
					continue;

				if (div >= P) {
					result++;
				} else if (dif <= 2){
					if (mod == 0) {
						if (countS < S && dif == 1) {
							countS++;
							result++;
						}
					} else {
						if (dif==1) {
							result++;
						} else if ( mod == 2 && countS < S ) {
							countS++;
							result++;
						}
					}

				}
			}

			writer.write("Case #" + i + ": " + result);
			if (i < nt)
				writer.newLine();
		}
		writer.close();
	}

}
