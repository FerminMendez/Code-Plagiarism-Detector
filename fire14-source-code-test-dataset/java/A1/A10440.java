import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Dance {
	private static int raw_num;
	private static int pot_num;
	public static void main(String[] args) throws FileNotFoundException{
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter("dance_out.txt");
		int t = in.nextInt();
		for (int i = 0; i < t; i++){
			raw_num = pot_num = 0;
			int n = in.nextInt();
			int s = in.nextInt();
			int p = in.nextInt();
			for (int j = 0; j < n; j++){
				process(in.nextInt(), p);
			}
			if (pot_num < s)
				raw_num += pot_num;
			else
				raw_num += s;
			out.printf("Case #%d: %d%n", i+1, raw_num);
		}
		out.close();
	}
	private static void process(int score, int p){
		switch (score % 3) {
		case 0:
			if (score / 3 >= p)
				raw_num++;
			else {
				if (score / 3 + 1 >= p && score / 3 - 1 > 0)
					pot_num++;
			}
			break;
		case 1:
			if (score / 3 + 1 >= p)
				raw_num++;
			break;
		case 2:
			if (score / 3 + 1 >= p)
				raw_num++;
			else {
				if (score / 3 + 2 >= p)
					pot_num++;
			}
		default:
			break;
		}
	}
}
