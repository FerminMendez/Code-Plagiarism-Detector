package MyAllgoritmicLib;

public class BinnomNeutona {

	public static int C(int k, int n){
		return factorial(n)/(factorial(k)*factorial(n-k));
	}
	
	public static int factorial(int n){
		int result = 1;
		for(int i = n; i > 1; i--){
			result *= i;
		}
		return result;
	}
}
