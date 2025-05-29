import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProblemC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		List<Integer>[] l = genRecycled();
		
		for(int i = 0; i < T; i++){
			int c = processCase(sc, l);
			
			System.out.println("Case #" + (i+1) + ": " + c);
		}
	}
	
	public static List<Integer>[] genRecycled(){
		// gen all the possible ms for a given n
		List<Integer>[] rec = new List[1001];
		
		int cmp;
		
		// generate a load of blank lists
		for(int i = 0; i < rec.length; i++){
			// if(i % 10000 == 0) System.out.println("hi " + i);
			rec[i] = new ArrayList<Integer>();
			
			String n = Integer.toString(i);
			String m = rotate(n);
			
			// detect when back to the first
			while(!m.equals(n)){
				
				// no leading zeros
				if(m.charAt(0) != '0'){
					// find the numeric value
					cmp = Integer.parseInt(m);
					
					// number can't be greater than the max
					// and also has to be greater than n
					if(cmp < rec.length && cmp > i){
						// add it to the list of possibles
						rec[i].add(cmp);
					}
				}
				
				m = rotate(m);
			}
		}

		return rec;
	}
	
	public static String rotate(String s){
		return s.substring(1) + s.charAt(0);
	}
	
	public static int processCase(Scanner sc, List<Integer>[] l){
		int a = sc.nextInt();
		int b = sc.nextInt();
		int count = 0;
		
		// loop through the range
		for(int i = a; i < b; i++){
			List<Integer> li = l[i];
			
			// find the pre-calculated things
			for(Integer el : li){
				// if m is less than or equal to B, count it
				if(el <= b) count++;
			}
		}
		
		return count;
	}

}
