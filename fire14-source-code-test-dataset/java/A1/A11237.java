import java.io.*;


public class DancingWithGooglers {
	
	static int max;
	
	public static void main(String[] args) {
		
		BufferedReader in;
		BufferedWriter out;
		int T, i;
		String line;
		
		try {
			in = new BufferedReader(new FileReader("input.txt"));
			out = new BufferedWriter(new FileWriter("output.txt"));
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			return;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return;
		}

		try {
			T = Integer.parseInt(in.readLine());

			for (i = 0; i < T; i++) {
				line = in.readLine();
				
				String lineToWrite = "Case #" + (i+1) + ": ";
				
				lineToWrite += String.valueOf(solve(line));
				
				out.write(lineToWrite + "\n");
				
			}
			in.close();
			out.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return;
		}
	}
	
	public static int solve(String input) {
		int N, S, p;
		
		String[] inData = input.split(" ");
		N = Integer.parseInt(inData[0]);
		S = Integer.parseInt(inData[1]);
		p = Integer.parseInt(inData[2]);
		
		int[] totals = new int[N];
		boolean[] suprises = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			totals[i] = Integer.parseInt(inData[i+3]);
		}
		
		/*for (int i = 0; i < S; i++) {
			suprises[i] = true;
		}
		for (int i = S; i < N; i++) {
			suprises[i] = false;
		}*/
		
		max = 0;
		
		f(totals, suprises, p, 0, S);
		
		return max;
		
		
	}
	
	public static int getBestResult(int total, boolean suprising) {
		int mod3 = total%3;
		if ((total < 2 || total > 28) && suprising) return -1; //can't happen
		
		switch(mod3) {
		case 0:
			if (suprising) return (total/3 + 1);
			return total/3;
		case 1:
			return (total/3 + 1);
		case 2:
			if (suprising) return (total/3 + 2);
			return (total/3 + 1);
		default:
			System.out.println("WTF!?");
			return 0;
		}
		
	}
	
	public static void f(int[] totals, boolean[] suprises, int p, int position, int sToGo) {
		if (sToGo == 0) {
			check(totals, suprises, p);
			return;
		}
		
		
		for (int i = position; i <= (suprises.length - sToGo); i++) {
			suprises[i] = true;
			for (int j = 0; j < suprises.length; j++) {
				System.out.print(suprises[j] ? 1 : 0);
			}
			System.out.print("\n");
			f(totals, suprises, p, i+1, (sToGo-1));
			suprises[i] = false;
		}
		
	}

	private static void check(int[] totals, boolean[] suprises, int p) {
		int counter = 0;
		for (int i = 0; i < totals.length; i++) {
			if (getBestResult(totals[i], suprises[i]) >= p) counter++;
		}
		if (counter > max) max = counter;
	}
}
