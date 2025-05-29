import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;


public class GoogleCodeB {
	public static void main(String args[]) throws Exception {
		FileReader fr = new FileReader("C:/Users/moez/Desktop/B-small-attempt1.in");
		BufferedReader br = new BufferedReader(fr);
		FileWriter fstream = new FileWriter("C:/Users/moez/Desktop/out.txt");
		BufferedWriter out = new BufferedWriter(fstream);
		  int l= 1;
		String s;
		
		int N, S, P, X, Y, nsurp, surp, temp;
		int i = 0;
		int[] t = new int[6];
		String[] st = new String [6];
		br.readLine();
		while((s = br.readLine()) != null) {
			Scanner sc = new Scanner(s);
			i = 0;
			N = sc.nextInt();
			S = sc.nextInt();
			P = sc.nextInt();
			X = 3*P-2;
			Y = ((3*P-4 > 0) ? 3*P-4 : P);
			nsurp = surp= 0;
			for (i=0; i<N ;i++){
				temp = sc.nextInt();
				if ( temp >= X){
					nsurp++;
				}else if ( temp >= Y)
					surp++;
			}
			nsurp+=((surp > S) ? S : surp);		
				
		out.write("Case #"+l+": "+nsurp);
		out.write("\r\n");
		
		
		l++;
		}
		out.close();
		fr.close();
		}
}
