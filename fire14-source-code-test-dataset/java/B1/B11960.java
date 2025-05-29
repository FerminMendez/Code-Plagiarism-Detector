import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class RecycledNumbers {

	private static int noOfDigits(int n){
		if (n < 10) return 1;
		return 1 + noOfDigits(n/10);
	}

	private static int raisedTo(int n, int m){
		if (n==0) return 0;
		else if (m==0) return 1;
		else if (m==1) return n;
		return n*raisedTo(n, m-1);
	}

	private static int rotateBy(int n, int s, int nod){
		if (s == 0) return n;
		int N = noOfDigits(n);
		int pow = raisedTo(10, nod-1);
		int MSB = (N==nod)? n/pow: 0;
		return rotateBy((n%pow)*10+MSB, s-1, nod);
	}

	private static int[] giveDistinctNos(int n, int min, int max){
		int s = 0, r = n, j=0;
		int N = noOfDigits(r);
		int A[] = new int[N];
		for (int i=0; i<N; i++){
			for (j=0; j<s; j++){
				if (A[j] == r)
					break;
			}
			if (j == s){
				A[s++] = r;
			}
			r = rotateBy(r, 1, N);
			while (r<min || r>max || N != noOfDigits(r))
				r = rotateBy(r, 1, N);
		}
		return A;
	}

	private static int nC2(int n){
		return n*(n-1)/2;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		//		for (int i=0; i< 2000000; i++);

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = new Integer(in.readLine()).intValue();
		int A = 0, B = 0, ans = 0;
		String str[];
		int X[];
		for (int i=0; i<T; i++){
			ans = 0;
			str = in.readLine().split(" ");
			A = new Integer(str[0]).intValue();
			B = new Integer(str[1]).intValue();
			X = new int[B-A+1];
			for (int j=A; j<B+1; j++){
				if (X[j-A] != 1){
					int N[] = giveDistinctNos(j, A, B);
					int n=0;
					for (int k=0; k<N.length; k++){
						if (N[k] == 0)
							break;
						X[N[k]-A] = 1;
						n++;
					}
					ans += nC2(n);
				}
			}
			System.out.print("Case #"+(i+1)+": "+ans);
			System.out.println();
		}
	}

}
