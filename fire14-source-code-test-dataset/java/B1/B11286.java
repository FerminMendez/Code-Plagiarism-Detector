import java.util.Scanner;

/**
 * author - coolprosu
 * Problem - C
 */

public class RecycledNumbers {
	private int T = 0;
	public static void main(String[] args) {
		RecycledNumbers solveProb = new RecycledNumbers();
		solveProb.solve();
	}
	private void solve() {
		Scanner sc = new Scanner(System.in);
		//Input no. of test cases
		T = sc.nextInt();
		//Solved strings
		String solutionArray[] = new String[T];	
		for(int i=0;i<T;i++) {
			solutionArray[i] = "Case #"+(i+1)+": ";
			int A = sc.nextInt();
			int B = sc.nextInt();
			int recyclePairCount = 0;
			for(int n=A;n<B;n++) {
				for(int m=n+1;m<=B;m++) {
					recyclePairCount+=countRecyclable(n,m);
				}
			}
			solutionArray[i] += recyclePairCount;
		}
		//Output result
		for(int i=0;i<T;i++) {
			System.out.println(solutionArray[i]);
		}			
	}
	private int countRecyclable(int a, int b) {
		String str1 = ""+a;
		String str2 = ""+b;
		if(str1.length()!=str2.length())
			return 0;
		int totalCombinations = 0;
		for(int i=1;i<str1.length();i++) {
			//String operation calculation
			if(str2.equals(str1.substring(i,str1.length())+str1.substring(0,i)))
				totalCombinations++;
			//Mathematical calculation
			/*int takenOut = a%((int)Math.pow(10,i));
			int previousPart = (int)a/(int)Math.pow(10,i);
			int multiplier = (int)Math.pow(10,(str1.length()-i));
			int finalInt = takenOut*multiplier + previousPart; 
			if(b==finalInt)
				totalCombinations++;*/
		}
		return totalCombinations;
	}
}
