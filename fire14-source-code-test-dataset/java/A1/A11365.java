

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Googlers {
	public static void main(String[] args) throws Exception{
		String inputFile = "B-small-attempt0.in";
		
		BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile)));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output")));
		long num_cases = Long.parseLong(input.readLine());
		int current_case = 0;
		
		while (current_case < num_cases){
			current_case++;
			
			String[] fields = input.readLine().split(" ");
			int N = Integer.parseInt(fields[0]);
			int S = Integer.parseInt(fields[1]);
			int p = Integer.parseInt(fields[2]);
			
			int max = 0;
			int sc = 0;
			for (int i = 0; i < N; i++){
				int v = Integer.parseInt(fields[3+i]);
				double d = Math.ceil(v/3.0);
				if (d >= p){
					max++;
				} else {
					if (d != 0 && d == p-1){
						if (sc < S){
							max++;
							sc++;
						}
					}
				}
			}
			System.out.println("Case #" + current_case + ": " + max);
			output.write("Case #" + current_case + ": " + max + "\n");
		}
		output.close();
	}
}
