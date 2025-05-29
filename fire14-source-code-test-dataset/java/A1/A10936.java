
public class ProblemB {
	
	public static int[] generateTriplet(int totalScore)
	{
		int third = totalScore/3;
		int[] triplet = new int[3];
		int total = 0;
		int i = 0;
		
		triplet[0] = third;
		triplet[1] = third;
		triplet[2] = third;
		
		total = third*3;
		
		while(total < totalScore)
		{
			triplet[i] += 1;
			total += 1;
			i = (i+1)%3;
		}
		//System.out.println( triplet[0] + "," + triplet[1] + "," + triplet[2]);
		
		return triplet;
	}

}
