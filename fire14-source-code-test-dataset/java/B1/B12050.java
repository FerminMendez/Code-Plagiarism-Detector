import java.util.Scanner;

public class RecycleNum {
	static int digit(int x){
		int d = 0;
		while( x>0 ){
			d++;
			x /= 10;
		}
		return d;
	}
	static int power(int x){
		int n = 1;
		while(x>0){
			n *= 10;
			x--;
		}
		return n;
	}
	static int cirNum(int n, int m){
		int d = digit(n);
		n = (n%power(d-m))*power(m) + (n/power(d-m));
		return n;
	}
	static int result(int A, int B){
		int d = digit(A);
		int count = 0;
		for(int i = A; i <= B; i++){
			int[] key = new int[d-1];
			for(int j = 1; j < d; j++){
				key[j-1] = cirNum(i, j);
				for(int k = 0; k < j-1; k++){
					if( key[j-1] == key[k] ){
						if( key[j-1] != i && key[j-1] >= A && key[j-1] <= B )
							count--;
					}
						
				}
				if( key[j-1] != i && key[j-1] >= A && key[j-1] <= B ){
					count++;		
				}
			}
		}
		return count/2;
		
	}
	
	public static void main(String[] args){
		Scanner stdIn = new Scanner(System.in);
		int T = stdIn.nextInt();  // the number of test cases
		String[] str = new String[T+1];
		String[][] data = new String[T][2];
		for(int i = 0; i < T+1; i++){
			str[i] = stdIn.nextLine();
		}
		for(int i = 0; i < T; i++){
			data[i] = str[i+1].split(" ", 2);
		}
		
		int[] A = new int[T];
		int[] B = new int[T];
		for(int i = 0; i < T; i++){
			A[i] = Integer.parseInt(data[i][0]);
			B[i] = Integer.parseInt(data[i][1]);
		}
		
		for(int i = 0; i < T; i++){
			System.out.println("Case #" + (i+1) + ": " + result(A[i], B[i]));
		}
	}

}
