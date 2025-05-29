import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		FileReader in = new FileReader("F:\\download\\B-small-attempt0.in");
		BufferedReader br = new BufferedReader(in);
		FileWriter out = new FileWriter("F:\\download\\out.txt");
		BufferedWriter bw = new BufferedWriter(out);

		int t = Integer.parseInt(br.readLine());
		for (int c = 0; c < t; c++){
			String line = br.readLine();
			StringTokenizer aSt = new StringTokenizer(line, " ");
			int number = Integer.valueOf(aSt.nextToken()).intValue();
			int surprise = Integer.valueOf(aSt.nextToken()).intValue();
			int p = Integer.valueOf(aSt.nextToken()).intValue();

			int sum_ok = 0;
			int sum_surprise = 0;
			for (int n = 0; n < number; n++){
				int ti = Integer.valueOf(aSt.nextToken()).intValue();
				int judge = judge(ti, p);
				switch (judge){
				case 2:
					sum_ok++;
					break;
				case 1:
					sum_surprise++;
					break;
				default:
					break;
				}
			}
			
			int result;
			if (sum_surprise <= surprise){
				result = sum_ok + sum_surprise;
			}
			else{
				result = sum_ok + surprise;
			}

			bw.write(String.format("Case #%d: %d\n", c+1, result));
		}
		
		br.close();
		in.close();
		bw.close();
		out.close();

	}
	
	private static int judge(int score, int p){
		int p1 = (p-1 >= 0) ? p-1: 0;
		if (score >= p + p1 + p1){
			return 2;
		}
		int p2 = (p-2 >= 0) ? p-2: 0;
		if (score >= p + p2 + p2){
			return 1;
		}
		return 0;
	}

}
