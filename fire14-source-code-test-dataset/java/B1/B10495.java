import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Numbers {
	
	public static void main(String args[])throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String regex = " ";
		int T = Integer.parseInt(in.readLine());
		String str;
		String[] split;
		String[] result = new String[T+1];
		for(int x = 1; x <= T; x++){
			result[x] = "Case #" + x + ": ";
			str = in.readLine();
			split = str.split(regex);
			if(split.length < 2) {
				result[x] = result[x].concat("0");
			} else {
				result[x] = result[x].concat(Integer.toString(getNumberOfPairs(Integer.parseInt(split[0]), Integer.parseInt(split[1]))));
			}
		}
		for(int u = 1; u <= T; u++){
			System.out.println(result[u]);
		}
			
		
	}
	
	public static int getNumberOfPairs(int a, int b){
		int pairs = 0;
		for(int x = a; x < b; x++) {
			for(int y = b; y > x; y--) {
				if(isRecycledPair(x,y)){
					pairs++;
				}
			}
		}
		return pairs;
	}
	
	public static boolean isRecycledPair(int a, int b){
		boolean result = false;
		String A = Integer.toString(a);
		String B = Integer.toString(b);
		String tempA;
		if(A.length() != 1 && B.length() != 1){
			for(int x = 1; x < A.length();x++){
				tempA = A.substring(x, A.length());
				tempA = tempA.concat(A.substring(0, x));
				if(tempA.equals(B)){
					result = true;
				}
			}
		}
		return result;
		
	}

}
