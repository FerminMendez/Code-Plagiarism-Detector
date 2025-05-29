import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;

public class Main {

	public static int keta;
	public static void main(String[] args) throws Exception {

		FileReader in = new FileReader("F:\\download\\C-small-attempt0.in");
		BufferedReader br = new BufferedReader(in);
		FileWriter out = new FileWriter("F:\\download\\out.txt");
		BufferedWriter bw = new BufferedWriter(out);

		int t = Integer.parseInt(br.readLine());
		for (int c = 0; c < t; c++){
			String line = br.readLine();
			StringTokenizer aSt = new StringTokenizer(line, " ");
			int a = Integer.valueOf(aSt.nextToken()).intValue();
			int b = Integer.valueOf(aSt.nextToken()).intValue();

			keta = (int)Math.log10(a) + 1;
			int pairs = 0;
			for (int n = a; n <= b; n++){
				pairs += pairs(a, b, n);
			}

			bw.write(String.format("Case #%d: %d\n", c+1, pairs));
		}
		
		br.close();
		in.close();
		bw.close();
		out.close();

	}

	public static int pairs(int a, int b, int num){
		int numbers = 1;
		int[] stock = new int[keta];
		stock[0] = num;
		
		for (int x = 1; x < keta; x++){
			int recycle = (num % (int)Math.pow(10, keta - x)) * (int)Math.pow(10, x) + (int)(num / (int)Math.pow(10, keta - x));
			if ((a <= recycle)&&(recycle <= b)){
				if (recycle < num) return 0;
				boolean flag = false;
				for (int st = 0; st < numbers; st++){
					if (stock[st] == recycle) flag = true;
				}
				if (!flag){
					stock[numbers] = recycle;
					numbers ++;
				}
			}
		}

		return numbers * (numbers - 1) / 2;
	}
}
