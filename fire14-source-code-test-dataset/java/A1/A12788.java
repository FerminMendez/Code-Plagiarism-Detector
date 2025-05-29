import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DancingGooglers {

	static BufferedWriter out;
	private static int countMaxScores = 0;

	public static void main(String[] args) {
		System.out.print("Start\n");

		// Prepare the writer
		try {
			FileWriter fstream;
			fstream = new FileWriter("resultfinal.txt");
			out = new BufferedWriter(fstream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Prepare the reader
		try {
			BufferedReader reader = new BufferedReader(new FileReader("B-small-attempt4.in"));

			// Read the count of testcases
			int testcases = Integer.parseInt(reader.readLine());

			for (int i = 0; i < testcases; i++) {
				countMaxScores = 0;
				int countwinners = doYourThing(reader.readLine());
				out.write("Case #" + (i + 1) + ": " + countwinners + "\n");
			}

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Close the output stream
		try {
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static Integer doYourThing(String readLine) {
		// System.out.print(readLine +"\n");
		String parts[] = readLine.split(" ");
		int countgooglers = Integer.parseInt(parts[0]);
		int suprising = Integer.parseInt(parts[1]);
		int maxscore = Integer.parseInt(parts[2]);

		ArrayList<Integer> surprisings = new ArrayList<Integer>();
		surprisings.clear();

		// First get all the obvious winners
		for (int i = 0; i < countgooglers; i++) {
			int j = i + 3;
			int score = Integer.parseInt(parts[j]);

			if (score >= maxscore) {
				if (score >= ((maxscore * 3) - 2)) {
					countMaxScores++;
				} else if (score <= ((maxscore * 3) - 5)) {
					// Finding the obvious loser
					System.out.print("Loser " + score + "\n");
				} else {
					surprisings.add(score);
				}
			}
		}
		if (surprisings.size() >= suprising) {
			return countMaxScores + suprising;
		} else {
			return countMaxScores + surprisings.size();
		}

	}
}
