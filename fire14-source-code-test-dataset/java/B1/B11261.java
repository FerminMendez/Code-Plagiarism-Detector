import java.util.HashMap;
import java.util.Scanner;


public class RecycledNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		//number of case tests
		int n;
		
		int a, b;

		n = s.nextInt();
		s.nextLine();
		
		for(int t=1; t<= n; t++){
			a = s.nextInt();
			b = s.nextInt();
			s.nextLine();
			
			int counter = 0;
			for(int i = a; i<b; i++ ){
				char[] originalChars = Integer.toString(i).toCharArray();
				int length = originalChars.length;
				
				for(int j = 0; j< (length-1); j++){
					char[] recycledChars = new char[length];
					
					recycledChars[0] = originalChars[length-1];
					
					for(int r = 1; r<length; r++)
						recycledChars[r] = originalChars[r-1];
					
					if(recycledChars[0] != '0'){
						int recycled_candidate = Integer.parseInt(String.valueOf(recycledChars));
						
						if( (i<recycled_candidate) && (recycled_candidate<=b))
							counter ++;
					}
					
					originalChars = recycledChars;
				}
				
			}
			
			System.out.println("Case #" + t + ": " + counter);
		}
		
	}

}
