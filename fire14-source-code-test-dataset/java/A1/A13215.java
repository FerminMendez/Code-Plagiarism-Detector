import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;


public class Recycle {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("B-small-attempt2.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));

		String line = "";
		line = br.readLine();
		int number = Integer.valueOf(line);
		for(int i = 1; i<= number; i++){
			line = br.readLine();
			String[] tokens = line.split(" ");
			int result = 0;
			int n = Integer.valueOf(tokens[0]);
			int surprising = Integer.valueOf(tokens[1]);
			int p = Integer.valueOf(tokens[2]);
			if(p == 0){
				result = n;
			}
			else{
			for(int a = 1;a<=n;a++){
				int score = Integer.valueOf(tokens[2+a]);
				int d = score/3;
				if(score == 0)
					continue;
				if(d >=p){
					result++;
				}
				else{
					int m = score%3;
					if((m == 1||m==2) && d+1 == p)
						result++;
					else if(m == 0 && d+1 == p && surprising !=0){
						result++;
						surprising--;
					}
					if(m == 2&&	d+2 ==p &&surprising !=0){
						result++;
						surprising--;
					}
				}
			}
			}
			System.out.println(result);
			bw.append("Case #"+i+": "+result);
			bw.newLine();
		}
		br.close();
		bw.close();
	}
}
