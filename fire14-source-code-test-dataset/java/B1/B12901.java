package qualr2012.problemC;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.springframework.util.Assert;

public class RecycledNumbers {

	static Logger log = Logger.getLogger(RecycledNumbers.class.getName());
	final static String fileName = "C-small-attempt0";
	final static String inputFileName = fileName + ".in";
	final static String outputFileName = fileName + ".out";
	final static String pkgName = RecycledNumbers.class.getPackage().getName().replaceAll("\\.", "/");
	final static String inputFile = "src/main/java/" + pkgName + "/" + inputFileName;
	final static String outputFolder = "target/" + pkgName;
	
	public static void main(String[] args) throws IOException {
		
		
		FileUtils.forceMkdir(new File(outputFolder));
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		PrintWriter writer = new PrintWriter(outputFolder + "/" + outputFileName);
		int numCase = Integer.parseInt(reader.readLine());
		
		for(int _case = 1; _case <= numCase; ++_case) {
			int i, j, k, l, m, ans = 0;
			String[] s = reader.readLine().split(" ");
			int A = Integer.parseInt(s[0]), B = Integer.parseInt(s[1]);
			
			boolean[][] visited = new boolean [B + 1][B + 1];
			for (i = 0; i < B + 1; ++i) {
				for (j = 0; j < B + 1; ++j) {
					visited[i][j] = false;
				}
			}
			
			l = (B+"").charAt(0) - '0';
			for (i = A; i <= B; ++i) {
				
				// from right, find first digit > 0 and <= first digit on B, only swap
				// if i > 0
				String i_str = i + "";
				for (j = i_str.length() - 1; j > 0; --j) {
					k = i_str.charAt(j) - '0';
					
					if (k > 0 && k <= l) {
						m = Integer.parseInt(i_str.substring(j) + i_str.substring(0, j));
						if (m != i && m <= B && i < m && !visited[i][m] /*&& !visited[m][i]*/) {
							visited[i][m] = true;
							/*visited[m][i] = true;*/
							ans++;
						}
					}
				}
			}
			
			log.info("Case #" + _case + ": " + ans);
			writer.println("Case #" + _case + ": " + ans);
		}
		
		reader.close();
		writer.close();
	}

}
