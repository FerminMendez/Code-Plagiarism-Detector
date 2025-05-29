package rounds.qualification;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class B_dancing_with_the_googlers {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = null;
		BufferedWriter writer = null;
		
		try {
			reader = new BufferedReader(new FileReader("./input"));
			writer = new BufferedWriter(new FileWriter("output"));
			int numberOfCases = Integer.valueOf(reader.readLine());
			for (int i = 1; i <= numberOfCases; i++) {
				String line = reader.readLine();
				StringBuilder sb = new StringBuilder("Case #" + i + ": ");
				Scanner scanner = new Scanner(line);
				int result = 0;
				while(scanner.hasNextInt()) {
					int numberOfGooglers = scanner.nextInt();
					int numberOfSurprisings = scanner.nextInt();
					int scoreToReach = scanner.nextInt();
					
					while(numberOfGooglers>0) {
						int googlerScore = scanner.nextInt();
						int div = googlerScore/3;
						int mod =( googlerScore % 3 == 0) ? 0 : 1;
						int highest =  div + mod;
						if(highest>=scoreToReach) {
							result++;
						}
						else if(googlerScore > 0 && highest+1 == scoreToReach && numberOfSurprisings > 0) {
							result++;
							numberOfSurprisings--;
						}
						numberOfGooglers--;
					}
					sb.append(result);
				}
				sb.append("\n");
				writer.write(sb.toString());
			}
		} finally {
			if (reader != null) {
				reader.close();
			}
			if(writer!=null) {
				writer.flush();
				writer.close();
			}
		}
	}

	
}
