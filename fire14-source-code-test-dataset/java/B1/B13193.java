import java.util.ArrayList;
import java.util.Scanner;


public class Prob3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int num = scan.nextInt();
		scan.nextLine();
		for(int i=0;i<num;i++){
			System.out.println("Case #" + (i+1) + ": " + eval(scan));
			scan.nextLine();
		}
	}
	
	private static int eval(Scanner scan){
		int A = scan.nextInt();
		int B = scan.nextInt();
		int sum = 0;
		
		for(int i=A;i<=B;i++){
			sum += pairsFor(i, A, B);
		}
		
		return sum;
	}
	
	private static int pairsFor(int n, int A, int B){
		int res = 0;
		int length = ("" + n).length() - 1;
		int mod;
		int m = n;
		//System.out.println("n: " + m);
		
		ArrayList<Integer> d = new ArrayList<Integer>(length);
		
		for(int i=0;i<length;i++){
			mod = m%10;
			m = (int)Math.floor(m/10.0) + mod*(int)Math.pow(10, length);
		
			//System.out.println("o: " + m);
			if(m > n && m <= B && m >= A && mod != 0 && !d.contains(m)){
				//System.out.println("n: " + n + " m: " + m);
				d.add(m);
				res++;
			}
		}
		
		return res;
	}

}
