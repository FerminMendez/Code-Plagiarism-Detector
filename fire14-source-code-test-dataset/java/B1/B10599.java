import java.io.*;
import java.util.Scanner;

public class Main {
	public static void main (String[] args) {
		int i = 1;
		try{
			BufferedReader in = new BufferedReader(new FileReader("input.txt"));
			String ligne;
			ligne = in.readLine();
			ligne = in.readLine();
			while (ligne != null) {
				int res = 0;
				System.out.print("Case #" + i + ": ");
				Scanner sc = new Scanner(ligne);
				int A = sc.nextInt();
				int B = sc.nextInt();
				for (int m=A;m<B;m++){
					for (int n=m+1;n<=B;n++){
						if(recycle(n, m)){
							res++;
						}
					}
				}
				i++;
				System.out.println(res);
				ligne = in.readLine();
			}
			in.close();
		} catch (Exception e){
			System.err.println("Erreur !");
		}
	}

	//préconditions : a != b a>0 b>0
	public static boolean recycle (int a, int b) {
		long nbDigitsA = Math.round(Math.ceil(Math.log10(a)));
		long nbDigitsB = Math.round(Math.ceil(Math.log10(b)));
		if (nbDigitsA != nbDigitsB || nbDigitsA == 1) {
			return false;
		}
		for (int i=1;i<nbDigitsA;i++){
			String ch_b = "" + b;
			String ch_bTrans = ch_b.substring(i) + ch_b.substring(0, i);
			if (a == Integer.parseInt(ch_bTrans)) {
				return true;
			}
		}
		return false;
	}
}
