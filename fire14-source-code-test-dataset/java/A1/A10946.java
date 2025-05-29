import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class ProblemB {
	public static void main(String[] args) throws IOException{
		FileInputStream fstream = new FileInputStream("B-small-attempt0.in");
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String result ="";
		int num = Integer.parseInt(br.readLine());
		for (int i = 0; i < num; i++) {
			result += "Case #"+(i+1)+": ";
			String input[] = br.readLine().split(" ");
			int numGooglers = Integer.parseInt(input[0]);
			int numSurprising = Integer.parseInt(input[1]);
			int p = Integer.parseInt(input[2]);
			int greaterThanP = 0;
			int surprisingGreaterThanP = 0;
			for (int j = 0; j < numGooglers; j++) {
				int googler = Integer.parseInt(input[j + 3]);
				if (googler >= p + 2*(p-1))
					greaterThanP++;
				else if(googler >= p + 2*(p-2) && googler >= p)
					surprisingGreaterThanP++;
			}
			result += (greaterThanP+(int)Math.min(numSurprising, surprisingGreaterThanP));
			if (i != num - 1)
				result += "\n";
		}
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new FileWriter(new File("out.txt"))));
		out.print(result);
		out.flush();
		out.close();
		System.out.print(result);
	}

}
