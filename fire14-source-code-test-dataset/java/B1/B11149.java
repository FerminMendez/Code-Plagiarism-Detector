import java.util.*;
import java.io.*;
import java.lang.Integer;


public class C {	
	
    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new File("C-small-attempt0.in"));
		Scanner in1 = new Scanner(new File("C-small-attempt0.in"));
		FileWriter fw = new FileWriter("C-small.out");	
		int T = in.nextInt();
		in.nextLine();
		in1.nextLine();
		for (int cases = 1; cases <= T; cases++){
			
			// read the string length for this case
			String line = in.nextLine();
			int len = (line.length() - 1)/2;
			int valueA = 0;
			int valueB = 0;
			int base = 1;
			int smallNum = in1.nextInt();
			int largeNum = in1.nextInt();			
			int[] number = new int[len];
			int total = 0;
			// get the base number
			for (int i = 1; i < len; i++){
				base = base * 10;							
			}
			fw.write("Case #" + cases + ": ");
			for(int i = smallNum; i <= largeNum; i++) {
				number[0] = i;
				// fw.write(number[0] + " ");
				for (int j = 1; j < len; j++) {
					boolean norepeat = false;
					number[j] = number[j - 1] / base + (number[j - 1] % base) * 10;
					// fw.write(number[j] + " ");
					if (number[j] >= smallNum && number[j] <= largeNum) {
						norepeat = true;
						for (int k = j - 1; k >= 0; k--){
							norepeat = norepeat && (number[j] != number[k]);
						}
					}
					if(norepeat) total++;
				}				
			}
			total = total / 2;
			fw.write(total + "\n");
		}
		fw.flush();
		fw.close();		
	}
}
