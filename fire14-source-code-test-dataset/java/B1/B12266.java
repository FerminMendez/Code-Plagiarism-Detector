import java.io.*;

public class RecycledNumbers {

	public RecycledNumbers() {}

	public Integer count(String num, int A, int B) {
		int count = 0;	
		Integer numS = new Integer(num);		
		for (int i = 1; i < num.length(); i++) {			
			Integer newNum = new Integer(num.substring(i) + num.substring(0, i));
			if (newNum <= B && newNum > A && newNum > numS) { 
				count++; 
				//System.out.println("(" + numS + ", " + newNum + ")"); 
			}			
		}
		return count;
	}
	
	public static void main(String[] args) {
		RecycledNumbers rn = new RecycledNumbers();
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String line;
			Integer T; int cn = 0;
			while ((line = in.readLine()) != null) {				
				if (cn == 0) {
					T = new Integer(line);
					cn++;
				} else {
					int count = 0;
					String[] AB = line.split(" ");
					int A = new Integer(AB[0]);
					int B = new Integer(AB[1]);
					for (int n = A; n < B; n++) {
						count += rn.count(Integer.toString(n), A, B);
					}					
					System.out.println("Case #" + cn + ": " + count);
					cn++;
				}
			}		
		} catch (Exception e) {}
		
	}
}
