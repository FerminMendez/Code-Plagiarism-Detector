import java.util.Scanner;


public class B {

	int answer (int N, int S, int p, int[] T) {
		int num = 0;

		for (int t: T) {
			int avg = t/3;

			boolean canBeSurprising = false;
			boolean cleanWin = false;
			for (int a=avg-2; a<=avg+3; a++) {
				for (int b=avg-2; b<=avg+3; b++) {
					int c = t-a-b;
					
					if (a<0 || b<0 || c<0)
						continue;
					
					if (Math.abs(Math.max(Math.max(a, b),c) - Math.min(Math.min(a, b),c))<=1) {
						if (Math.max(Math.max(a, b),c)>=p)
							cleanWin=true;
					} else if (Math.abs(Math.max(Math.max(a, b),c) - Math.min(Math.min(a, b),c))<=2) {
						if (Math.max(Math.max(a, b),c)>=p)
							canBeSurprising=true;
					}
				}
			}
			
			if (cleanWin) 
				num++; 
			else if (canBeSurprising && S>0) {
				num++; S--;
			}
		}
		
		return num;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		B b = new B();
		int T = Integer.parseInt(sc.nextLine());
		for (int i=0; i<T; i++) {
			int N = sc.nextInt();
			int S = sc.nextInt();
			int p = sc.nextInt();
			int t[] = new int[N];
			for (int j=0; j<N; j++)
				t[j] = sc.nextInt();

			System.out.println("Case #"+(i+1)+": "+b.answer(N, S, p, t));
		}
	}
}

/*

4
3 1 5 15 13 11
3 0 8 23 22 21
2 1 1 8 0
6 2 8 29 20 8 18 18 21


 */