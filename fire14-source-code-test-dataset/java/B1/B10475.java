import java.util.Scanner;

public class RecycledNumbers {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			int min = scan.nextInt();
			int max = scan.nextInt();

			int total = 0;
			for (int j = min; j <= max; j++)
				for (int k = j+1; k <= max; k++)
					if (isR(j, k))
						total++;
			array[i] = total;
		}
		for (int i = 1; i <= n; i++)
			System.out.println("Case #" + i + ": " + array[i - 1]);
	}

	private static boolean isR(int m, int n) { 
		if(m<10){
			return false;
		}
		else if(m<100){
			return isR(m,n,2);
		}
		else if(m<1000){
			return isR(m,n,3);
		}
		else if(m<10000){
			return isR(m,n,4);
		}
		else if(m<100000){
			return isR(m,n,5);
		}
		else if(m<1000000){
			return isR(m,n,6);
		}
		else if(m<10000000){
			return isR(m,n,7);
		}
		else return false;
	}

	private static boolean isR(int m, int n, int i) {
		boolean tf=false;
		for(int j=1;j<i;j++){
			int big=m/(int)Math.pow(10, j);
			int rem=m%(int)Math.pow(10, j);
			int mm=big+rem*(int)Math.pow(10, i-j);
			tf=tf||mm==n;
		}return tf;
	}
}
