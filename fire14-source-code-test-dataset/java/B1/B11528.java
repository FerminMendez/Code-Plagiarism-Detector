package qualification;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class ProblemC {
	
	public static int solve(int A, int B){
		
		int count = 0;
		
		for (int i = A; i <= B; i++){
			String number = String.valueOf(i);
			String s = number + number;
			for (int j = 1; j < number.length(); j++){
				int newnumber = Integer.parseInt(s.substring(j, j + number.length()));
				if ((newnumber > i) && (newnumber <= B))
					count++;
			}
		}
		
		return count;
	}
	
	public static void main(String[] args){
		try{
			BufferedReader br = new BufferedReader(new FileReader("C-small-attempt0.in"));
			BufferedWriter bw = new BufferedWriter(new FileWriter("outputC"));
			String line = br.readLine();
			int ans = 0;
			int num = Integer.parseInt(line);
			
			for (int i = 0; i < num; i++){
				line = br.readLine();
				String[] segs = line.split("\\s+");
				ans = solve(Integer.parseInt(segs[0]), Integer.parseInt(segs[1]));
				bw.write("Case #" + (i+1) + ": " + ans + "\n");
			}
			
			br.close();
			bw.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
