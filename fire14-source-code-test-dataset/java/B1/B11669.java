import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class RecycledNumbers {

	public static void main(String[] args){
		List<Integer> res = new ArrayList<Integer>();
		try {
			FileInputStream fstream = new FileInputStream("C-small-attempt0 (1).in");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			int cases = Integer.valueOf(br.readLine());
			for(int i = 0; i < cases; i++) {
				String line = br.readLine();
				int min = Integer.valueOf(line.split("[ \r\n\t]+")[0]);
				int max = Integer.valueOf(line.split("[ \r\n\t]+")[1]);
				res.add(solve(min, max));
			}
			in.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
		
		try {
			// Create file
			File fout = new File("out.txt");
			FileWriter fstream = new FileWriter(fout);
			BufferedWriter out = new BufferedWriter(fstream);
			for (int i = 0; i < res.size(); i++){
				out.write("Case #" + (i+1) + ": " + res.get(i)); 
				out.newLine();
			}
			// Close the output stream
			out.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}

	}
	
	static int solve(int min, int max){
		//find number of digits
		int tmp = min;
		int size = 0;
		while(tmp > 0){
			tmp /= 10;
			size++;
		}
		if(size == 1)
			return 0;
		int res = 0;
		for(int i = min; i <= max; i++){
			int[] digits = toDigits(i, size);
			Set<Integer> candidates = asNumbers(digits);
			for(int candidate : candidates){
				if(candidate > i && candidate >= min && candidate <= max)
					res++;
			}
		}
		return res;
	}
	
	static int[] toDigits(int i, int size){
		int[] res = new int[size];
		int counter = size-1;
		while(i > 0){
			res[counter--] = i%10;
			i /= 10;
		}
		return res;
	}
	
	static Set<Integer> asNumbers(int[] digits){
		Set<Integer> res = new HashSet<Integer>();
		int tmp = 0;
		for(int i = 0; i < digits.length; i++){
			tmp *= 10;
			tmp += digits[i];
		}
		for(int i = 0; i < digits.length-1; i++){
			int mod = tmp%10;
			tmp /= 10;
			for(int j = 0; j < digits.length-1; j++){
				mod *= 10;
			}
			tmp += mod;
			res.add(tmp);
		}
		return res;
	}
	
}
