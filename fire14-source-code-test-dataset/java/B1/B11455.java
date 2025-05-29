import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class C {
	public static int factorial(int x) {

		int fact = 1;

		for (int i = 2; i <= x; i++) {

			fact *= i;

		}
		return fact;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
//		Scanner s = null;
//		try {
//			s = new Scanner(new FileInputStream("s.in"));
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		int lines = s.nextInt();
		for (int i = 1 ; i <= lines ;i++){
			int A = s.nextInt();
			int B = s.nextInt();
			HashSet<Integer> h = new HashSet<Integer>();
			for (int j  = A;j<=B;j++){
				h.add(j);
			}
			
			int comb = 0;
			for (int j  = A;j<=B;j++){
				if (!h.remove(j)){
					continue;
				}
				int len = (int)Math.log10(j);
				int c = 1;
				int newj = j;
				for (int k = 0; k < len;k++){
					newj = newj/10 + (newj % 10)*((int)Math.pow(10, len));
					if (h.remove(newj)){
						
						c++;
					}
				}
				if (c !=1){
					comb += factorial(c)/(factorial(c-2)*2);
				}
				
			}
			System.out.printf("Case #%d: %d\n",i,comb);
		}
	}
}
