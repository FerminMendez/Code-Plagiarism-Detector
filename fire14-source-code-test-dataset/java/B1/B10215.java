import java.io.*;

public class gcj3 {
	static int T;
	static int AB[][];
	
	static void beolvas (String f) throws IOException {
		BufferedReader be = new BufferedReader(new FileReader(f));
		String sor = be.readLine();
		T = Integer.parseInt(sor);
		AB = new int[T][2];
		for (int i = 0; i < T; i++) {
			sor = be.readLine();
			AB[i][0] = Integer.parseInt(sor.split(" ")[0]);
			AB[i][1] = Integer.parseInt(sor.split(" ")[1]);
		}
	}
	
	static boolean recyclable (int n, int m) {
		if ( ((int) ((Math.log(n))/(Math.log(10)))) != ((int) ((Math.log(m))/(Math.log(10)))) ) return false;
		String ns = n+"";
		String ms = m+"";
		for (int i = 1; i <= ms.length(); i++) {
			char c = ms.charAt(ms.length()-1);
			ms = c + ms.substring(0,ms.length()-1);
			if (ns.equals(ms)) return true;
		}
		return false;
	}
	
	static void kiir () {
		System.out.println(T);
		for (int i = 0; i < T; i++) {
			System.out.println(AB[i][0]+" "+AB[i][1]);
		}
	}
	
	static int count (int a, int b) {
		int er = 0;
		for (int n = a; n < b; n++) {
			for (int m = n+1; m <= b; m++) {
				if (recyclable(n,m)) {
					// System.out.println(n+" es "+m+" ***IGEN***");
					er++;
				} else {
					// System.out.println(n+" es "+m+" nem");
				}
			}
		}
		
		return er;
	}
	
	public static void main (String args[]) throws IOException {
		beolvas("C-small-attempt0.in");
		// kiir();
		for (int k = 1; k <= T; k++) {
			System.out.println("Case #"+k+": "+count(AB[k-1][0],AB[k-1][1]));
		}
	}
}

