import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

public class ProblemC {

	public static void main(String[] args) {
		readin();

	}

	private static int count(int a, int b) {
		int numOfDigits = Integer.toString(a).length();
		
		if (numOfDigits == 1) {
				return 0;
		}

		HashSet<Integer> rangeFromAtoB = new HashSet<Integer>();

		for (int i = a; i <= b; i++) {
			rangeFromAtoB.add(i);
		}


		
		int count = 0;

		for (int i = a; i <= b; i++) {

			if (rangeFromAtoB.contains(i)) {
				
				HashSet<Integer> validReordering = new HashSet<Integer>();
				validReordering.add(i);
				rangeFromAtoB.remove(i);

						
				for (int s = 1; s < numOfDigits; s++) {
					
					
					int back =(i / (int)(Math.pow(10, s)) );
					int front = i % ((int)Math.pow(10, s));
					int scale = (int) Math.pow(10, (numOfDigits - s));
									
					
					int reorder = back + front * scale;

				
					if (reorder >= a && reorder <= b) {

						if (!validReordering.contains(reorder)) {
							rangeFromAtoB.remove(reorder);

							validReordering.add(reorder);
						}
					}
				}
				int numOfValidReordering =  validReordering.size();
				
				
				count = count +numOfValidReordering*(numOfValidReordering-1)/2;
				
			}
		}
		return count;
	}

	private static void readin() {

		try {
			BufferedReader in = new BufferedReader(new FileReader("C-small-attempt0.in.txt"));

			int numOfInput = Integer.parseInt(in.readLine());

			int[][] input = new int[numOfInput][2];
			String[] output = new String[numOfInput];

			for (int i = 0; i < numOfInput; i++) {
				String[] currentline = in.readLine().split("[\\s]+");
				int a = Integer.parseInt(currentline[0]);
				int b = Integer.parseInt(currentline[1]);
				input[i][0] = a;
				input[i][0] = b;
				output[i] = "Case #" + (i+1) + ": " + count(a, b);

			}
			
			BufferedWriter out = new BufferedWriter(new FileWriter(
			"outputC"));
			
			for (int i = 0; i < output.length; i++) {
				System.out.println(output[i]);
				out.write(output[i]+"\n");
			}
			out.flush();
			out.close();
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
