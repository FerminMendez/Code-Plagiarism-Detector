import java.util.*;
import java.math.*;

public class dancingGooglers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int numStrings = scan.nextInt();
		
		for(int i =1; i <= numStrings; i++){
			int numGooglers = scan.nextInt();
			int numSurprises = scan.nextInt();
			int p = scan.nextInt();
			
			int[] totalScores;
			totalScores = new int[numGooglers];
			
			int withoutSurpriseCount, withSurpriseCount;
			withoutSurpriseCount = 0 ;
			withSurpriseCount = 0;
			
			for(int j = 1; j <= numGooglers; j++){
				
				totalScores[j-1] = scan.nextInt();
				
				if(totalScores[j-1] >= p + 2*Math.max(p-1, 0)){
					withoutSurpriseCount = withoutSurpriseCount + 1;
				}
				else if(totalScores[j-1] >= p + 2*Math.max(p-2,0)){
					withSurpriseCount = withSurpriseCount + 1;
				}
			}
			
			//System.out.println("\n " + numGooglers + " " + numSurprises + " " + withoutSurpriseCount + " " + withSurpriseCount);
			
			int temp1 = Math.min(withSurpriseCount, numSurprises);
			int temp2 = temp1 + withoutSurpriseCount;
			int temp3 = Math.min(numGooglers, temp2);
			
			System.out.format("Case #%d: %d\n", i, temp3);
		
		}
	}

}
