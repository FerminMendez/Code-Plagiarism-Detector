package qualificationRound;

public class Recycled {

	public static int howMany(int A, int B){
		
		int count = 0;
		
		for (int i = A; i < B; i++){
			
			for (int j = i + 1; j <= B; j++){
		
				String I = String.valueOf(i);
				String J = String.valueOf(j);
				
				String AA = I + I; 
				
				if (AA.contains(J))
					count++;
			}
		}
		
		return count;
	}
}
