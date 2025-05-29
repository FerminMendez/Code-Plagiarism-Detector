import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;


public class QualificationQ2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		

		FileWriter fstream = new FileWriter("out.txt");
		BufferedWriter out = new BufferedWriter(fstream);

		File file = new File(args[0]);
		Scanner in = new Scanner(file);
		int T = in.nextInt();
		in.nextLine();
		for (int zz = 1; zz <= T; zz++) {

			String inputLine = in.nextLine();
			String outputLine = process(inputLine);
			output(out,zz,outputLine);
		}
		in.close();
		out.close();
	}
	
	private static String process(String inputLine) {
		
		int counter = 0;
	
		String[] elements = inputLine.split(" ");
		int numberOfPlayers = new Integer(elements[0]);
		int numberOfSuprisings = new Integer(elements[1]);
		int score = new Integer(elements[2]);
		int sureCountScore = 3 * (score - 1) + 1;
		int surprisingCountScore = 2 * (score -2) + score;
		
		for (int i=3;i<numberOfPlayers+3;i++){
			if (new Integer(elements[i])>=sureCountScore){
				counter++;
			}else if (new Integer(elements[i])>0&&numberOfSuprisings>0&& new Integer(elements[i])>=surprisingCountScore){
				counter++;
				numberOfSuprisings--;
			}
		}
		
		return ""+counter;
	}

	private static void output(BufferedWriter out, int zz, String formattedString) throws IOException {
		// TODO Auto-generated method stub
		String outputLine = String.format("Case #%d: %s\n", zz,
				formattedString);
		System.out.format(outputLine);
		out.write(outputLine);
	}

}
