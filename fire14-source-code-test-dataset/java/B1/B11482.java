import java.util.*;

public class Recycled {
	public static void main(String[] args) {
		
		Scanner p = new Scanner(System.in);
		int tests = p.nextInt();
		
		for(int i = 0; i<tests; i++) {
			int count = 0;
			boolean[] used = new boolean [1001];
			Integer a = p.nextInt();
			Integer b = p.nextInt();
			if( b == 1000 ) {
				b = 999;
			}
			for( ; a<b; a++) {
				if( a < 10 ) {
					a = 10;
				}
				char[] start = ((a.toString()).toCharArray() );
				if(a <= 99) {
					char temp0 = start[0];
					char temp1 = start[1];
					
					start[1] = temp0;
					start[0] = temp1;
					int number1 = Integer.parseInt(new String(start));
					if(number1 <= b && number1 >= a && !used[number1] && number1 != a) {
						used[a] = true;
						count++;
					}
				}
								
				else if(a >= 100) {
					char temp0 = start[0];
					char temp1 = start[1];
					char temp2 = start[2];
					//one rotation
					start[2] = temp1;
					start[1] = temp0;
					start[0] = temp2;
					int number1 = Integer.parseInt(new String(start));
					if(number1 <= b && number1 >= a && !used[number1] && number1 != a) {
						used[a] = true;
						count++;
					}
				
					start[2] = temp0;
					start[1] = temp2;
					start[0] = temp1;
					int number2 = Integer.parseInt(new String(start));
					if(number2 <= b && number2 >= a && !used[number2] && number1 != number2 && number2 != a) {
						used[a] = true;
						count++;
					}
				}
			}
			System.out.println("Case #" + (i+1) + ": " + count);
		}
	}
}

