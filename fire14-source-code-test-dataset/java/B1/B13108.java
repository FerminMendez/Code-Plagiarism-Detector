import java.util.*;

public class RCTest{

	public static void main(String[] args){
	
		Scanner scan = new Scanner(System.in);
		int numberOfCases = Integer.parseInt(scan.nextLine());
		for(int i = 1; i <= numberOfCases; ++i){
			String line = scan.nextLine();
			String[] inputs = line.split(" ");
			int lower = Integer.parseInt(inputs[0]);
			int upper = Integer.parseInt(inputs[1]);
			RCTest r = new RCTest();
			System.out.println("Case #" + i + ": " + r.getRecycleNumbers(lower, upper));
		}
	}
	
	public int getRecycleNumbers(int a, int b){
		this.lower = a;
		this.upper = b;
		int counter = 0;
		for(int i = a; i<=b; ++i){
			int originalNumber = i;
			int index = getIndex(originalNumber);
			int recycledNumber = getRecycledNumber(i,index);
			
			while(originalNumber!=recycledNumber){
			
				if(originalNumber < recycledNumber && recycledNumber <= upper)++counter;
				recycledNumber = getRecycledNumber(recycledNumber,index);
			}
			
		}
		return counter;
	}
	public int getRecycledNumber(int number, int index){
		int remainder = number % 10;
		int quotient = number/10;
		int recycledNumber = ((int)Math.pow(10,index) * remainder) +  quotient;
		return recycledNumber;
	}	
	
	private int getIndex(int number){
		int index = 0;
		while(number!=0){
			number/=10;
			++index;
		}
		return index-1;
	}
	private int lower;
	private int upper;
}