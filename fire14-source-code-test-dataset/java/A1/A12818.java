import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class TripletScore {

	public int[] scores;
	
	boolean isSurprising;
	
	public int maxScore;
	
	public TripletScore(int num1, int num2, int num3) {
		this.scores = new int[]{num1, num2, num3};
		Arrays.sort(scores);
		
		if(scores[2] - scores[0] >= 2)
			isSurprising = true;
		
		this.maxScore = scores[2];
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof TripletScore) {
			TripletScore other = (TripletScore) obj;
			
			if(other.scores[0] == this.scores[0] && other.scores[1] == this.scores[1] && other.scores[2] == this.scores[2])
				return true;
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		return (scores[0] + " " + scores[1] + " " + scores[2] + " " + this.isSurprising);
	}
	
	@Override
	public int hashCode() {
		return (31 * scores[0]) + (31 * scores[1]) + (31 * scores[2]);
	}
	
	public static List<TripletScore> getTriplet(int score) {
		Set<TripletScore> tripletSet = new HashSet<TripletScore>();
		
		int num2 = getMidNumber(score);
		int num1 = num2 > 0 ? num2 - 1 : num2;
		int num3 = num2 < 10 ? (num2 + 1) : num2;
		
		int[] numbers = new int[]{num1, num2, num3};
		for(int i = 0; i < 3; i++) {
			int number1 = numbers[i];
			for(int j = 0; j < 3; j++) {
				int number2 = numbers[j];
				for(int k = 0; k < 3; k++) {
					int number3 = numbers[k];
					if((number1 + number2 + number3) == score) {
						TripletScore ts = new TripletScore(number1, number2, number3);
						tripletSet.add(ts);
					}
				}
			}
		}
		
		
		return new ArrayList<TripletScore>(tripletSet);
	}
	
	
	public static int getMidNumber(int score) {
		double dScore = score;
		return (int) Math.rint(dScore / 3);
	}
	
	public static void main(String[] args) {
		//System.out.println(27 + " = " + getTriplet(27));
		for(int i = 0; i <= 30; i++) {
			System.out.println(i + " = " + getTriplet(i));
		}
	}
}
