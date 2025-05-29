import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class ProblemC {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine());
		
		String[] split;
		StringBuilder number;
		int A, B, count, nAux;
		char first;
		//Map<Integer, Boolean> counted;
		Map<Integer, Boolean> countedAux;
		
		for(int t = 0; t < T; t++){
			//counted = new HashMap<Integer, Boolean>();
			count = 0;
			split = reader.readLine().split(" ");
			A = Integer.parseInt(split[0]);
			B = Integer.parseInt(split[1]);
			
			extern:for(int n = A; n < B; n++){
				number = new StringBuilder(String.valueOf(n));
				if(sameNumbers(number)){
					continue;
				}
				//if(counted.get(n) != null) continue;
				//counted.put(n, true);
				countedAux = new HashMap<Integer, Boolean>();
				countedAux.put(n, true);
				
				for(int i = 0; i < number.length()-1; i++){
					first = number.charAt(0);
					number.deleteCharAt(0);
					number.append(first);
					if(number.charAt(0) == '0') {
						continue;
					}
					nAux = Integer.parseInt(number.toString());
					if(nAux > B) {
						continue;
					}
					if(nAux < A) {
						continue;
					}
					if(nAux < n) continue extern;
					//counted.put(nAux, true);
					countedAux.put(nAux, true);
				}
				if(countedAux.size() > 1){
					count += (countedAux.size() * (countedAux.size()-1))/2;
				}
			}
			System.out.println("Case #"+(t+1)+": "+count);
		}
	}
	
	private static boolean sameNumbers(StringBuilder number){
		for(int i = 1; i < number.length(); i++){
			if(number.charAt(i-1) != number.charAt(i)) return false;
		}
		return true;
	}
}
