import java.io.*;

public class Recycle {
	public static void main(String args[]) {
		try {
			InputStreamReader inReader = new InputStreamReader(new FileInputStream("input.txt"));
			BufferedReader br = new BufferedReader(inReader);
			
			File out = new File("output.txt");
			Writer output = new BufferedWriter(new FileWriter(out));
			
			int amount = Integer.parseInt(br.readLine());
			
			for (int i=0; i < amount; i++) {
				output.write("Case #" + (i+1) + ": ");
				String line = br.readLine();
				
				int min = Integer.parseInt(line.split(" ")[0]);
				int max = Integer.parseInt(line.split(" ")[1]);
				
				int result = 0;
				int digits = 1;
				int tmp = max;
				
				while (tmp/10 > 0) {
					tmp /= 10;
					digits++;
				}
				
				int[] assist = new int[digits];
				for (int l=0; l < digits; l++)
					assist[l] = 0;
				
				for (int j=min; j <= max; j++) {
					int number = j;
					int counter = 0;
					for (int k=1; k < digits; k++) {
						int newNumber = (int) ((int) (number%Math.pow(10, k)) * Math.pow(10, digits-k) + (number/Math.pow(10, k)));
						if (newNumber > number && newNumber <= max) {
							for (int l=0; l < counter; l++) {
								if (assist[l] == newNumber)
									result--;
							}
							
							assist[counter++] = newNumber;
							result++;
						}
					}
				}
				
				output.write(result + "\n");
			}
			
			output.close();
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}