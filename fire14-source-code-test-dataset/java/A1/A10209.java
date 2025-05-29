import java.io.*;

public class gcj2 {
	static int T; // tesztesetek száma
	static int N[]; // Googlerek számai
	static int S[]; // meglepő tripletek száma
	static int p[]; // pék
	static int total[][]; // összpontszámok
	static int tripletek[][];
	
	
	static void beolvas (String f) throws IOException {
		BufferedReader be = new BufferedReader(new FileReader(f));
		String sor = be.readLine();
		T = Integer.parseInt(sor);
		N = new int[T];
		S = new int[T];
		p = new int[T];
		tripletek = new int[T][3];
		for (int i = 0; i < T; i++) {
			sor = be.readLine();
			String nums[] = sor.split(" ");
			N[i] = Integer.parseInt(nums[0]);
			S[i] = Integer.parseInt(nums[1]);
			p[i] = Integer.parseInt(nums[2]);
		}
		be.close();
		
		int Nmax = N[0];
		for (int j = 0; j < T; j++){
			if (N[j] > Nmax) Nmax = N[j];
		}
		total = new int[T][Nmax];
		BufferedReader be2 = new BufferedReader(new FileReader(f));
		sor = be2.readLine();
		for (int i = 0; i < T; i++) {
			sor = be2.readLine();
			String nums[] = sor.split(" ");
			for (int j = 0; j < N[i]; j++) {
				total[i][j] = Integer.parseInt(nums[3+j]);
			}
		}
		be2.close();
	}
	
	static void kiir () {
		System.out.println(T);
		for (int i = 0; i < T; i++) {
			System.out.print(N[i]+" "+S[i]+" "+p[i]+" ");
			for (int j = 0; j < N[i]; j++) {
				System.out.print(total[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	static int count (int a) {
		int er = 0;
		int surp = S[a];
		for (int i = 0; i < N[a]; i++) {
			if (total[a][i] >= (3*p[a])-2) {
				er++;
			} else {
				if (surp > 0 && total[a][i] >= (p[a]+2*(p[a]-2)) && p[a] > 1) {
					er++;
					surp--;
				}
			}
		}
		return er;
	}
	
	public static void main (String args[]) throws IOException {
		beolvas("B-small-attempt0.in");
		// kiir();
		for (int a = 0; a < T; a++) {
			System.out.println("Case #"+(a+1)+": "+count(a));
		}
	}
}

