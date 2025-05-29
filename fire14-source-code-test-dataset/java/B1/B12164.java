import java.util.Scanner;


public class Main {
	public static void main(String [] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int x=0; x<T; x++) {
			int A = in.nextInt();
			int B = in.nextInt();
			int pow = (int) Math.floor(Math.log10(A));
			//System.out.println("Pow=" + String.valueOf(pow));
			int tomult = (int) Math.pow(10, pow);
			int compteur = 0;
			for(int n=A; n<=B; n++) {
				int m = n;
				for(int i=0; i<pow; i++) {
					m = (m%10)*tomult + m/10;
					//System.out.println("m="+ String.valueOf(m));
					if(m>n && m<= B) {
						compteur++;
						//System.out.println("("+String.valueOf(n)+","+String.valueOf(m)+")");
					}
				}
			}
			System.out.print("Case #" + String.valueOf(x+1) + ": ");
			System.out.println(compteur);
		}
	}
}