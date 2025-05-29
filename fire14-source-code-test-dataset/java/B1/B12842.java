import java.io.*;
import java.util.*;

public class problemC{
	
	public static void main(String args[]) {
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			int T = Integer.valueOf(br.readLine());
			int count, a, b, base;
			String line;
			String[] lineSplit;
			for(int i = 0; i < T; i++){
				line = br.readLine();
				lineSplit = line.split(" ");
				count = 0;
				a = Integer.valueOf(lineSplit[0]);
				b = Integer.valueOf(lineSplit[1]);
				base = base(a);
				for(int j = a; j < b; j++){
					count += switchAround(j, b, base);
				}
				System.out.println("Case #" + (i+1) + ": " + count);
			}
			
		} catch(Exception e){
			
		}
	}		int div = 10;

	
	public static int switchAround(int num, int max, int base){
		int copy = num;
		int count = 0;
		ArrayList<Integer> listN = new ArrayList<Integer>();
		for(int i = 1; i < base; i *= 10) {
			if(num % 10 == 0) {
				num = num/10;
				continue;
			}
			num = num/10 + (num % 10) * base;
			if(num <= max && num > copy && !listN.contains(num)) {
				count++;
				listN.add(num);
			}
		}
		return count;
	}
	
	public static int base(int num){
		int base = 1;
		while(num/base != 0){
			base *= 10;
		}
		
		return base/10;
	}
}