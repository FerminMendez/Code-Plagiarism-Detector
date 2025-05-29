import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;


public class Test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
		BufferedReader br  = new BufferedReader(new FileReader("in.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("out.txt"));
		
		int noOfCases = Integer.parseInt(br.readLine());
		
		int units;
		int tens;
		int hundreds;
		int n,m;
		
		for(int i=0; i < noOfCases; ++i) {
			int count = 0;
			String line = br.readLine();
			//System.out.println("line="+line);
			String[] values = line.split(" ");
			int a = Integer.parseInt(values[0]);
			int b = Integer.parseInt(values[1]);
			if(a < 10 && b < 10) {
				bw.write("Case #" + (i+1) + ": " + count + "\n");
				continue;
			}
			
			for(n = a; n <= b; ++n) {
				if(n < 10) {
					continue;
				} else if(n < 100) {
					
					units = n % 10;
					if(units == 0) {
						continue;
					}
					tens = n/10;					
					//recycle by 1 digit
					m = units * 10 + tens;
					if((n < m) && (m <= b)) {
						++count;
					}
				} else {
					
					units = n % 10;		
					tens = (n/10) % 10;
					hundreds = n/100;
					
					//recycle by 1 digit
					if(units != 0) {
						m = units * 100 + hundreds * 10 + tens;
						if((n < m) && (m <= b)) {							
							++count;
						}
					}
					//recycle by 2 digits
					if (tens != 0) {
						m = tens * 100 + units * 10 + hundreds;
						if((n < m) && (m <= b)) {
							++count;
						}
					}
				} //else
			} //for(n = a; n <= b; ++n) 
			bw.write("Case #" + (i+1) + ": " + count + "\n");
		}
		
		bw.close();
		br.close();

	}

}
