package qualr2012.problemB;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.util.Assert;

public class DancingWithGooglers {

	static Logger log = Logger.getLogger(DancingWithGooglers.class.getName());
	final static String inputFileName = "B-small-attempt1.in";
	final static String outputFileName = "B-small-attempt1.out";

	public static void main(String[] args) throws IOException {
		String pkgName = DancingWithGooglers.class.getPackage().getName().replaceAll("\\.", "/");
		String inputFile = "src/main/java/" + pkgName + "/" + inputFileName;
		String outputFile = "target/" + pkgName + "/" + outputFileName;
		FileUtils.forceMkdir(new File("target/" + pkgName));
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		PrintWriter writer = new PrintWriter(outputFile);
		int numCase = Integer.parseInt(reader.readLine());
		
		int i, j;
		String[] str;
		
		int[] maxNoSurprise = new int [31];
		int[] maxSurprise = new int [31];
		
		for (i = 0; i < 31; ++i) {
			 maxNoSurprise[i] = (int)Math.ceil(i/3.0);
			 maxSurprise[i] = (int)Math.ceil(i/3.0 + 0.5);
		}
		maxSurprise[0] = 0;
		
		for(int _case = 1; _case <= numCase; ++_case) {
			LinkedList<Integer> t_LL = new LinkedList<Integer>();
			Integer[] t = null;
			str = reader.readLine().split(" ");
			
			
			int N, S, p;
			N = Integer.parseInt(str[0]);
			S = Integer.parseInt(str[1]);
			p = Integer.parseInt(str[2]);
			
			for (i = 3; i < str.length; ++i) {
				t_LL.add(Integer.parseInt(str[i]));
			}
			Collections.sort(t_LL);
			
			t = t_LL.toArray(new Integer[0]);
			
			Assert.isTrue(t.length == N);
			
			// move i to the first no-surprise triplet which has max score >= p
			for (i = 0; i < t.length; ++i) {
				if (maxNoSurprise[t[i]] >= p) { break; }
			}
			
			// for each available S, use it to maximize the number of Googlers to the left of i
			for (; i >= 1 && S > 0 && maxSurprise[t[i-1]] >= p; i--, S--) {
				
			}
			
			int answer = t.length - i;
			log.info(answer+"");
			
			writer.println("Case #" + _case + ": " + answer);
		}
		
		reader.close();
		writer.close();
	}

}
