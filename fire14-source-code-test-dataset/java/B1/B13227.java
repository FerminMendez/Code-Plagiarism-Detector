import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class recycle {
	static int lower = 0;
	static int upper = 0;
	static int count = 0;
	static HashSet<String> num_list = new HashSet<String>();
	public static void PerformShift(int number) {
		int start = number;
		int numdigits = (int) Math.log10((double) number);
		int multiplier = (int) Math.pow(10.0, (double) numdigits);
		while (true) {
			//int q = number / 10;
			int r = number % 10;			
			number = number / 10;
			number = number + multiplier * r;			
					
			boolean flg = true;
			int bits = 0;			
			
			if(number != start && number >= lower && number <=upper) {
				num_list.add(number+":"+start);
				num_list.add(start+":"+number);	
			}
			
			if (number == start)
				break;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("input.txt"));
		BufferedWriter out = new BufferedWriter(new FileWriter("output.txt"));
		int no_cases = Integer.parseInt(in.readLine());
		for (int index = 0; index < no_cases; ++index) {
			StringTokenizer limits = new StringTokenizer(in.readLine()," ");
			lower = Integer.parseInt(limits.nextToken());
			upper = Integer.parseInt(limits.nextToken());
			int start = (int) System.currentTimeMillis();
			for (int i = lower; i <= upper; ++i) {
				if(i<9)
					continue;
				PerformShift(i);
			}
			if(index==no_cases-1)
				out.write("Case #" + (index + 1) + ": " + num_list.size()/2);
			else out.write("Case #" + (index + 1) + ": " + num_list.size()/2 + "\n");
			num_list.clear();
		}
		out.close();
	}
}
