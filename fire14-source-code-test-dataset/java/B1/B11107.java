import java.util.*;

public class RecycledNumbers{

    public static void main(String[] args){
	Scanner scanner = new Scanner(System.in);
	int num = Integer.parseInt(scanner.nextLine());
	for(int i = 1; i <= num; ++i){
	    String[] tokens = scanner.nextLine().split(" ");
	    int lower = Integer.parseInt(tokens[0]);
	    int upper = Integer.parseInt(tokens[1]);
	    RecycledNumbers r =  new RecycledNumbers();
	    System.out.println("Case #" + i + ": " + r.recycledNumbers(lower, upper));
	}
    }

    public int recycledNumbers(int a , int b){
	this.lower = a;
	this.upper = b;
	for(int i = a; i <= b; ++i){
	    findAllRecycleNumbers(i);
	}
	return numRecycleNumbers;
    }

    public void findAllRecycleNumbers(int i){
	Set<Integer> pairs = new HashSet<Integer>();
	int power  = getPower(i);
	int recycleNumber = i;
	for(int count = 0; count <= power; ++count){
	    int quotient = recycleNumber / 10;
	    int remainder = recycleNumber % 10;
	    recycleNumber = (int)Math.pow(10, power) * remainder + quotient;
	    if(recycleNumber >= lower && recycleNumber > i && recycleNumber <= upper){
		if(!pairs.contains(recycleNumber)){
		    pairs.add(recycleNumber);
		    ++numRecycleNumbers;
		}
	    }
	}	
    }
    
    private int getPower(int i){
	int pow = 0;
	while(i > 9){
	    i /= 10;
	    ++pow;
	}
	return pow;
    }	

    public static class Pairs{
	int lower;
	int upper;
	public Pairs(int lower, int upper){
	    this.lower = lower;
	    this.upper = upper;
	}

    }
    private int numRecycleNumbers;
    private int lower;
    private int upper;
}