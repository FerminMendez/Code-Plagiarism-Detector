import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Dance {
	
	public static void main(String[] args) {
		BufferedReader reader = null;
		BufferedWriter writer = null;
		try {
            
			if (args.length == 0) {             
				System.out.println("Usage Dance <input_file>");
				System.exit(0);
			}
			
			File inputFile = new File(args[0]);

            if (!inputFile.exists())
            	System.out.println(String.format("File {0} not found in the current directory", args[0]));
            
     
            
			FileReader fileReader = new FileReader(inputFile.getAbsolutePath());
			reader = new BufferedReader(fileReader);
			FileWriter fileWriter = new FileWriter("Output.txt");
			writer = new BufferedWriter(fileWriter);
			String line = reader.readLine();			
			int numberOfTestCases = Integer.parseInt(line);
			for (int i = 0; i < numberOfTestCases; i++) {
				line = reader.readLine();
				String[] tokens = line.split(" ");
				int N = Integer.parseInt(tokens[0]);
				int S = Integer.parseInt(tokens[1]);
				int P = Integer.parseInt(tokens[2]);
				int[] totalScores = new int[N]; 
				for (int j = 3; j < tokens.length; j++) {
					totalScores[j - 3] = Integer.parseInt(tokens[j]);
				}
				writer.write("Case #" + (i + 1) + ": " + maxWithScoreGreaterThanP(P,S,totalScores));
				writer.newLine();
			}
						
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
			if (reader!=null) {
				reader.close();
			}
			if (writer!=null) {
				writer.close();
			}
			} catch(Exception e) {}
		}		
	}

	private static int maxWithScoreGreaterThanP(int p, int s, int[] totalScores) {
		int count = 0;
		int remainingSurprises = s;
		for (int i = 0; i < totalScores.length; i++) {
			boolean found = false;
			int required = totalScores[i];
			for (int x=p; x<=10 && !found;x++) {
				for (int y = x; y >= x - 2 && y>= 0 && !found;y--) {
					for (int z = x; z >= y && z >=0 ;z--) {				
						if (x + y + z == required ) {
							int min = Math.min(y, z);
							if (min == x - 2 && remainingSurprises > 0){
								found = true;
								count++;
								remainingSurprises--;
								break;
							} else if (min > x-2) {
								found = true;
								count++;
								break;
							}						
						}
					}
				}
			}
		}
		return count;
	}
	
	


}
