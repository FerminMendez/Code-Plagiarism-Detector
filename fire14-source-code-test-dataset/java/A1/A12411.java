import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class DancingWiththeGooglers {

	public static void main(String[] args) throws FileNotFoundException {
		 Scanner in = new Scanner(new File("B-small-attempt5.in"));
//		Scanner in = new Scanner(System.in);
		BufferedWriter out = null;
		try {
			FileWriter fstream = new FileWriter("out.txt");
			out = new BufferedWriter(fstream);
			int cases = in.nextInt();
			int N;
			int S;
			int P;
			LinkedList<Integer> googlers;
			for (int i = 0; i < (cases); i++) {
				int result = 0;
				int surprising = 0;
				int canBe = 0;
				N = in.nextInt();
				S = in.nextInt();
				P = in.nextInt();
				googlers = new LinkedList<Integer>();
				for (int j = 0; j < N; j++) {
					int t = in.nextInt();
					// if (t != 0)
					googlers.add(t);
				}
				for (int j = 0; j < googlers.size(); j++) {
					int temp = googlers.get(j) - (3 * P);
					if (temp == -3 || temp == -4) {
						if (googlers.get(j) != 0) {
							surprising++;
						}
					} else if (temp >= -2) {
						result++;
						if (googlers.get(j) != 29 || googlers.get(j) != 30) {
							canBe++;
						}
					}
				}
				int answer = 0;
				int tempo = 0;
				if (S <= surprising) {
					tempo = S;
				} else {
					tempo = surprising;
					// if(tempo<=canBe)
					// answer=result;
					// tempo = Math.abs(tempo - canBe);
				}
//				System.out.println(result + " " + tempo);
				answer = result + tempo;
				out.write("Case #" + (i + 1) + ": " + answer + "\n");
				System.out.println("Case #" + (i + 1) + ": " + answer);
			}
			out.close();
		} catch (Exception e) {// Catch exception if any
		}

	}
}
