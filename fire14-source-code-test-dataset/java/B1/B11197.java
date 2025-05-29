import java.io.*;

public class TaskC {
	public static void main(String[] args) {
		try {
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.valueOf(input.readLine());
			for(int z=1; z<=t; z++) {
				int out = 0;
				String[] line = input.readLine().split(" ");
				int A = Integer.valueOf(line[0]),
				    B = Integer.valueOf(line[1]);
				    
				for(int i=A; i<=B; i++)
					bylo[i] = false;
				    
				// czas na rotacje    
				ileRot = line[0].length() - 1;
				for(int i=A; i<=B; i++)
					if(bylo[i] == false) {
						bylo[i] = true;
						int dodajnik = 1;
						int liczba = i;
						String ls = Integer.toString(liczba);
						// System.out.println("Rotuje " + ls);
						// rotuje ile sie da
						for(int rot=0; rot<ileRot; rot++) {
							// wykonuje rotacje
							String tmp = ls.substring(1);
							tmp = tmp.concat(Character.toString(ls.charAt(0)));
							ls = tmp;
							liczba = Integer.valueOf(ls);
							// sprawdzam czy mam cos nowego
							if(bylo[liczba]==false && liczba>=A && liczba <= B) {
								// System.out.println("Zgadza sie z " + ls);
								bylo[liczba] = true;
								out += dodajnik;
								dodajnik += 1;
							}
						}
					}
				    
				System.out.println("Case #" + z + ": " + out);
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	
	
	static int ileRot;
	static boolean[] bylo = new boolean[2000001];
}
