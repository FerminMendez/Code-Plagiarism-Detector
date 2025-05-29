import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class RecycledNumbers {

	
	int A;
	int B;
	int count = 0;
	List pairs = new ArrayList<String>();
	
	public static void main(String[] args) {
		
		int T;
		
		BufferedReader bf;
		try {
			bf = new BufferedReader(new FileReader("C-small-attempt1.in"));
			T = Integer.parseInt(bf.readLine().trim());
			
			for (int i = 0; i <= T -1 ; i++) {
				
				RecycledNumbers rn = new RecycledNumbers();
				String[] line = bf.readLine().split(" ");
				rn.A = Integer.parseInt(line[0]);
				rn.B = Integer.parseInt(line[1]);
				rn.count = 0;
				
				rn.resolve();
				
				rn.printOut(i + 1);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void printOut(int i) {
		
		System.out.println("Case #" + i + ": " + count);
	}

	private void resolve() {
		int min = A;
		int minLength;
		if(min < 12){
			min = 12;
		}
		
		while (min <= B){
			String minS = String.valueOf(min); 
			String start = "";
			String end = "";
			minLength = minS.length();
			for (int i = 0; i < minLength -1; i++) {
				start = minS.substring(0,i +1 );
				end = minS.substring(i +1);
				if ( checkNewPair(minS, start,end)){
					count += 1;
				}
			}
			min += 1;
		}
	}

	private boolean checkNewPair(String minS, String start, String end) {
		if (end.charAt(0) == '0'){
			return false;
		}
		
		int newNumber = Integer.parseInt(end + start);
		
		if (newNumber > B ){
			return false;
		}
		
		int min = Integer.parseInt(minS);
		
		String newPair = "";
		if (min < newNumber){
			newPair = minS +"," + newNumber;
		}else if(min > newNumber){
			return false;
		}else if (min == newNumber){
			return false;
		}
			
		if ( pairs.contains(newPair)){
			return false;
		}
		pairs.add(newPair);
		return true;
	}

}


