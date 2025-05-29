import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class C {

	/**
	 * @param args
	 */

	public static String rest(ArrayList<String> list) {

		String n = list.get(0);
		list.remove(0);
		return n;
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String line;
		ArrayList<String> liste = new ArrayList<String>();

		BufferedReader buffer = null;
		try {
			buffer = new BufferedReader(new FileReader(new File(args[0])));

			for (int i = 0; (line = buffer.readLine()) != null; i++) {
				liste.add(line);
			}
		} catch (IOException e) {
			System.out.println("IO-Fehler!");
		}

		int anzahl = Integer.parseInt(rest(liste));

		// fuer jeden Fall methode aufrufen
		for (int i = 0; i < anzahl; i++) {
			methode(i + 1, liste);
		}
	}

	// spezifische code fŸr alle aufgaben
	public static void methode(int nummer, ArrayList<String> liste) {
		// buffer und input machen
		// input ist ein stringarray mit meiner ersten Zeile
		// String[] input = rest(liste);

		String[] input = rest(liste).split(" ");
		ArrayList<Integer> arraylist = new ArrayList<Integer>();

		for (int i = 0; i < input.length; i++) {
			int n = Integer.parseInt(input[i]);
			arraylist.add(n);
		}



		int a = arraylist.get(0);
		int b = arraylist.get(1);

		int sum = 0;

		for (int i = a; i < b; i++) {
			StringBuilder builder = new StringBuilder(Integer.toString(i));
			
			ArrayList<Integer> ergebnisse = new ArrayList<Integer>();

			for (int k = 1; k < builder.length(); k++) {
				
				
				
				if ((Integer.parseInt(umdudeln(builder, k).toString()) > i)
						&& (Integer.parseInt(umdudeln(builder, k).toString()) <= b)) {
					
					if (!(ergebnisse.contains(Integer.parseInt(umdudeln(builder,k).toString())))){
						sum=sum +1;
					};
					ergebnisse.add(Integer.parseInt(umdudeln(builder,k).toString()));

					
					// System.out.println(umdudeln(builder, k).toString());

				}
			}
			;

		}
		System.out.println("Case #" + nummer + ": " +  sum);

	}

	public static StringBuilder umdudeln(StringBuilder builder, int i) {

		if (builder.length() == 1) {
			return builder;
		}
		String eins = builder.substring(0, builder.length() - i);
		String zwei = builder.substring(builder.length() - i);

		StringBuilder newbuilder = new StringBuilder(zwei.concat(eins));

		// System.out.println(" " + builder + " " + eins + " " + zwei + " " + newbuilder);

		return newbuilder;

	}
}
