import java.util.*;
import java.io.*;


public class C {
	public static final String INPUT_FILE = "C-small-attempt0.in";
	public static final String OUTPUT_FILE = "c1.out";

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner input = new Scanner(new File(INPUT_FILE));
		PrintStream output = new PrintStream(new File(OUTPUT_FILE));
		
		Map<Integer, Integer> answerKey = new HashMap<Integer, Integer>();
		answerKey.put(1,0);
		answerKey.put(2,1);
		answerKey.put(3,3);
		answerKey.put(4,6);
		answerKey.put(5,10);
		answerKey.put(6,15);
		answerKey.put(7,21);
		
		
		int trials = Integer.parseInt(input.nextLine());


		// START
		for(int i = 1; i <= trials; i++) {
			String[] line = input.nextLine().split(" ");
			int A = Integer.parseInt(line[0]); 
			int B = Integer.parseInt(line[1]);
			
			Set<Integer> seen = new HashSet<Integer>();
			List<Integer> answer = new ArrayList<Integer>();
			
			int length = getLength(A);
			
			if(length > 1) {
				for(int j = A; j <= B; j++) {
					
					if(!seen.contains(j)) {
					
						answer.add(numberOfPerms(A, B, j, length, seen));
					
					} // It is seen, so don't do anything
				}			
			} else { // length = 1			
			}			
			
			int answerCount = 0;
			for(int k = 0; k < answer.size(); k++) {
				answerCount += answerKey.get(answer.get(k));
			}
			
			output.print("Case #" + i + ": " + answerCount);
			if(i != trials) {
				output.println();
			}
	
		}
		
	}
	
	public static int numberOfPerms(int A, int B, int num, int length, Set<Integer> s) {
		int original = num;
		int count = 1;
		int permute = permute(num, length);
		s.add(original);
		while(original != permute) {
	
			if(permute >= A && permute <= B && !s.contains(permute)) {
				s.add(permute); // add bc we've now seen it
				count++;        // we have a good permute
			}
			
			permute = permute(permute, length);	
		}
		return count;
	}


	public static int getLength(int num) {
		return (num + "").length();

	}

	public static int permute(int num, int length) {
		int a = num % 10;
		int b = num / 10;
		return a * (int) Math.pow(10, length-1) + b;		
	}
	
}