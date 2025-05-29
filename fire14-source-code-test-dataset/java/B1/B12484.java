import java.util.*;

public class C {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i=0; i<T; i++){
			int A = sc.nextInt();
			int B = sc.nextInt();
			int count = 0;
			for (int j=A; j<B; j++){
				if (j<10) {continue;}
				int[] recycles = recycles(j);
				for (int k=0; k<recycles.length; k++){
					int recycle = recycles[k];
					if (j<recycle && recycle<=B) {count++;}
				}
			}
			System.out.format("Case #%d: %d\n", i+1, count);
		}
		
	}
	private static int[] recycles(int a){
		String aStr = ((Integer) a).toString();
		int length = aStr.length();
		int[] result = new int[length-1];
		for (int i=0; i<length-1; i++){
			String recycle = aStr.substring(i+1, length)+aStr.substring(0, i+1);
			int recycleInt = Integer.parseInt(recycle);
			result[i] = recycleInt;
		}
		return result;
	}
	
}
