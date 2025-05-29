package problemC;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.StringTokenizer;

public class RecycledNumbers {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("C-small-attempt0.in"));
		FileWriter fw = new FileWriter("C-small-attempt0.out");
		/*BufferedReader in = new BufferedReader(new FileReader("C-large-practice.in"));
		FileWriter fw = new FileWriter("C-large-practice.out");*/
		int T = new Integer(in.readLine());
		for (int cases = 1; cases <= T; cases++){
			StringTokenizer st=new StringTokenizer(in.readLine());
			int A = new Integer(st.nextToken());
			int B = new Integer(st.nextToken());
			int num_bits = 0;
			long result = 0;
			int tempn = B;
			HashSet<Integer> hs = new HashSet<Integer>();
			while (tempn > 0){
				num_bits++;
				tempn = tempn/10;
			}
			
			if (num_bits == 1) {
				result = 0;
			}else {
				for (int target = A; target <= B; target++){
					
					if(!hs.contains(target)){
					int temp = target;
					int p = 1;
					int bit = 0;
					for (int t = 1 ; t < num_bits; t++){
						bit = temp % 10;
						temp = temp/10;
						if (bit != 0){
							temp = temp + (int) (bit * Math.pow(10, num_bits-1));
							if ((temp >= A) && (temp <= B) && (temp!=target)&&(!hs.contains(temp))){
								hs.add(target);
								hs.add(temp);
								p++;
							}
						}
					}
					
					result = result + (p*(p-1))/2;
					}
				}
			}
			
			if (cases != T) {fw.write("Case #" + cases + ": "+ result + "\n");
			}
			else {fw.write("Case #" + cases + ": "+ result);}
		}
		fw.flush();
		fw.close();
	}
}
