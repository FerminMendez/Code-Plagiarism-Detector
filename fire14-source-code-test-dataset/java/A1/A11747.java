import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 * Input
 * @author jiptan
 *
 */

public class SolveB {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		
		int num = Integer.parseInt(br.readLine());
		
		FileWriter fw = new FileWriter(new File("test"));
		
		StringBuilder sb2 = new StringBuilder();
		
		String[] values = null;

		int maxSupNum = 0;
		int minScore = 0;
		
		int lowestScorfeWithSup = 0;
		int lowestScorfeWithOutSup = 0;
		
		
		for (int i=1; i<=num; i++) {
		
			int result = 0;
			
			values = br.readLine().split(" ");

			maxSupNum = Integer.parseInt(values[1]);
			minScore = Integer.parseInt(values[2]);
			
			lowestScorfeWithSup = minScore * 3 - 4;
			lowestScorfeWithOutSup = minScore * 3 - 2;

			lowestScorfeWithOutSup = lowestScorfeWithOutSup < 0 ? 0 : lowestScorfeWithOutSup;
			lowestScorfeWithSup = lowestScorfeWithSup < 0 ? 0 : lowestScorfeWithSup;
			
			
			String[] scoreAry = new String[values.length - 3];
			
			System.arraycopy(values, 3, scoreAry, 0, values.length - 3);

			for (String scoreStr : scoreAry) {
				
				if (Integer.valueOf(scoreStr) >= lowestScorfeWithOutSup) {
					result++;
				} else if (maxSupNum > 0 && Integer.valueOf(scoreStr) >= lowestScorfeWithSup && Integer.valueOf(scoreStr) >= 2) {
					result++;
					maxSupNum = maxSupNum - 1;
				}
			}
			
			String output = String.format("Case #%d: %d", i, result);
			sb2.append(output + "\n");
			System.out.println(output);
		}
		fw.write(sb2.toString());
		fw.close();
	}
}