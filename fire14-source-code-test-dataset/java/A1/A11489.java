package qualification;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class ProblemB {
	
	public static int solve(String in){
		int n;
		int s;
		int p;
		
		int need = 0;
		int count = 0;
		String[] segs = in.split("\\s+");
		n = Integer.parseInt(segs[0]);
		s = Integer.parseInt(segs[1]);
		p = Integer.parseInt(segs[2]);
		
		for (int i = 3; i < segs.length; i++){
			int score = Integer.parseInt(segs[i]);
			if (score >= 3*p && p >= 0)
				count++;
			else if (score >= (3*p - 2) && (p >= 1))
				count++;
			else if (score >= (3*p - 4) && (p >= 2))
				need++;
		}
		
		if (need <= s)
			count += need;
		else
			count += s;
		
		return count;
	}

	public static void main(String[] args) {

		try{
			BufferedReader br = new BufferedReader(new FileReader("B-small-attempt0.in"));
			BufferedWriter bw = new BufferedWriter(new FileWriter("outputB"));
			String line = br.readLine();
			int ans = 0;
			int num = Integer.parseInt(line);
			
			for (int i = 0; i < num; i++){
				line = br.readLine();
				ans = solve(line);
				bw.write("Case #" + (i+1) + ": " + ans + "\n");
			}
			
			br.close();
			bw.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
