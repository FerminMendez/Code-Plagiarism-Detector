import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileInputStream fstream = null;

		try {
			fstream = new FileInputStream(args[0]);
			//fstream = new FileInputStream("input.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Input File Not Found.");
			System.exit(1);
		}

		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));

		int lines = 0;

		try {
			lines = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BufferedWriter out = null;
		
		try {
			// Create file
			FileWriter outstream = new FileWriter("output.txt");
			out = new BufferedWriter(outstream);
			
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}

		String line[] = null;
		Integer numberA;
		Integer numberB;
		String sN;
		String sM;
		int m;


		for (int i = 1; i <= lines; i++) {
			try {
				line = br.readLine().split("\\s+");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			numberA = Integer.parseInt(line[0]);
			numberB = Integer.parseInt(line[1]);
			String parte1;
			String parte2;

			//System.out.println("Number A is " + numberA + " and number B is "
			//		+ numberB);

			int counter = 0;
			for (int n = numberA; n < numberB; n++) {

				sN = Integer.toString(n); // Aqui temos o número n (n,m)

				HashSet<Integer> respostas = new HashSet<Integer>();

				for (int pos = (sN.length() - 1); pos >= 0; pos--) {
					parte1 = sN.substring(pos);
					parte2 = sN.substring(0, pos);

					sM = parte1.concat(parte2); // Transformado
					m = Integer.parseInt(sM);

					if (numberA <= n && n < m && m <= numberB) {
						// System.out.println(sNumberA + " <= " + n + " < " + m
						// + " <= " + sNumberB);
						// counter++;
						respostas.add(m);
					}

				}
				counter += respostas.size();
			}

			System.out.println("Case #" + i + ": " + counter);
			try {
				out.write("Case #" + i + ": " + counter + "\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}



		try {
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
