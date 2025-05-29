package compete;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class B {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("B-small-attempt1.in"));
		FileWriter fw = new FileWriter("B-small.out");
		int T = new Integer(in.readLine());
		for (int cases = 1; cases <= T; cases++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = new Integer(st.nextToken());
			int S = new Integer(st.nextToken());
			int p = new Integer(st.nextToken());

			int[] scores = new int[N];
			for (int j = 0; j < scores.length; j++) {
				scores[j] = new Integer(st.nextToken());
			}

			int max = recurse(scores,0,S,p);
			
			fw.write("Case #" + cases + ": " + max + "\n");
		}
		fw.flush();
		fw.close();
	}

	private static int recurse(int[] sc, int pos, int nbS, int p) {
		if (pos==sc.length) {
			if (nbS==0) return 0;
			else return Integer.MIN_VALUE;
		}
		int somme = sc[pos];
		int a0=0, a1=0, a2=0, a2s=0, a3s=0, a4s=0;
		// a, a-2, a-2 surprising
		if (( (somme>=2) && ((somme+4)<=30) && ((somme+4)%3)==0) && (nbS>0)) {
			int reste = recurse(sc,pos+1,nbS-1,p);
			int a = (somme+4)/3;
			if (a>=p) {
				a4s=reste+1;
			} else {
				a4s = reste;
			}
		}
		// a, a-1, a-2 surprising
		if ((( (somme>=2) && ((somme+3)<=30) && ((somme+3)%3)==0) && (nbS>0))) {
			int reste = recurse(sc,pos+1,nbS-1,p);
			int a = (somme+3)/3;
			if (a>=p) {
				a3s=reste+1;
			} else {
				a3s = reste;
			}
		}
		// a, a, a-2 surprising
		if (( (somme>=2) && ((somme+2)<=30) && ((somme+2)%3)==0)&&(nbS>0)) {
			int reste = recurse(sc,pos+1,nbS-1,p);
			int a = (somme+2)/3;
			if (a>=p) {
				a2s=reste+1;
			} else {
				a2s = reste;
			}
		}
		// a, a-1, a-1 
		if (( (somme>=1) && ((somme+2)<=30) && ((somme+2)%3)==0)) {
			int reste = recurse(sc,pos+1,nbS,p);
			int a = (somme+2)/3;
			if (a>=p) {
				a2=reste+1;
			} else {
				a2 = reste;
			}
		}
		// a, a, a-1 
		if (( (somme>=1) && ((somme+1)<=30) && ((somme+1)%3)==0)) {
			int reste = recurse(sc,pos+1,nbS,p);
			int a = (somme+1)/3;
			if (a>=p) {
				a1=reste+1;
			} else {
				a1 = reste;
			}
		}
		// a, a, a 
		if ((somme%3)==0) {
			int reste = recurse(sc,pos+1,nbS,p);
			int a = somme/3;
			if (a>=p) {
				a0=reste+1;
			} else {
				a0 = reste;
			}
		}
		int max = Math.max(Math.max(a4s,a3s), Math.max(Math.max(a0,a1), Math.max(a2, a2s)));
		return max;
	}

}
