import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class RecycledNumbers {

	static class NumberPairs{
		int a ;
		int b ;
		int large ;
		int small;
		NumberPairs(String input){
			populateInput(input);
		}
		private void populateInput(String input) {
			StringTokenizer tokenizer = new StringTokenizer(input, " ");
			a = Integer.parseInt((String) tokenizer.nextElement());
			b = Integer.parseInt((String) tokenizer.nextElement());
			
			if(a<b || a==b){
				small = a;
				large = b;
			}else if (a>b){
				small = b;
				large = a;
			}
		}
		
		private int computeResult(){
			int count=0;
			
			for(int number = small ; number <= large; number ++){
				// Get every number under small
				Set<Integer> set = new HashSet<Integer>();
				for(int i = 0 ; i < Integer.toString(number).length()-1 ;i++){
					// Rotate number to get another number 
					
					int rotated = rotateCircular(number, i+1);
					
					if(number < rotated && rotated <= large){
						if(set.contains(rotated)) continue;
						else
							set.add(rotated);
						count++;
					}
				}
			}
			return count;
		}
		
		private static int rotateCircular(int number, int n){
			char [] val =rotateCircularly(Integer.toString(number), n);
			return Integer.parseInt(new String(val));
		}
		
		public void printResult(int i) {
			System.out.println("Case #" + i + ": " + computeResult());
		}
		
		
		public static  char[] rotateCircularly(String input1 , int n) {
			char[] input = input1.toCharArray();
			input = reverse (input, 0 , input.length-1);
			input = reverse (input , 0 , n-1);
			input = reverse (input, n , input.length-1);
			// Reverse the last n 
			
			return input;
		}
		
		public static char[] reverse(char[] input, int start, int end){
			for(int i = 0 ; i < (end - start + 2) / 2 ; i ++){
				char temp = input[start + i];
				input[start + i] = input[end-i];
				input[end-i] = temp;
			}
			return input;
		}
	}
	public static void main(String[] args) {
		try {
			String [] input = getInput("C-small-attempt0.in");
			for(int i=0;i< input.length; i++){
				new NumberPairs(input[i]).printResult(i+1);
			}
		} catch (IOException e) {
		}
		
	}
	
	static String[] getInput(String fileName) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		try {
			String message = reader.readLine();
			int numberOfTestCases = Integer.parseInt(message);
			String[] input = new String[numberOfTestCases];
			for (int i = 0; i < numberOfTestCases; i++) {
				message = reader.readLine();
				input[i] = message;
			}
			return input;
		} finally {
			reader.close();
		}
	}
}
