import java.util.ArrayList;
import java.util.List;

public class RecyclePair {
	
	private static boolean IsRecycle(int a, int n, int m, int b, List<String> pairs, String pair){
		return a <= n && n < m && m <= b && !pairs.contains(pair);
	}
	
	public static int Calculate(int a, int b){
		int count = 0;

		List<String> pairs = new ArrayList<String>();

		for(int n=a;n<=b;n++){
			for(int j=1;j<String.valueOf(n).length(); j++){
				String m = String.valueOf(n).substring(j) + String.valueOf(n).substring(0, j);
				String pair = n + "," + m;

				if(IsRecycle(a, n, Integer.parseInt(m), b, pairs, pair)){
					pairs.add(pair);    
					count++;
				}
			
			}
		}

		return count;
	}
}
