package googlejam.qualification2012;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Dancing {

	
	public static void main(String[] args) throws FileNotFoundException {
		List<String> input = readSourceLinePerLine(new FileReader(new File("/Users/bronzi/Desktop/input.txt")));

		StringBuilder result = new StringBuilder();
		int testSize = Integer.valueOf(input.get(0));
		int index = 1;
		for (int i = 0; i < testSize; i++) {
			List<Integer> l = toInteger(input.get(index++).split(" "));
			result.append("Case #" + (i+1) + ": " +
					solveIt(l) + "\n");
			System.out.println("done " + i + " of " + testSize);
		}
		//		System.out.println(result.toString());
		writeFile(result.toString(), new File("/Users/bronzi/Desktop/output.txt"));
	}
	
	
	
	
	
	
	
//	The first integer will be N, the number of Googlers, 
//	and the second integer will be S, the number of surprising triplets of scores. 
//	The third integer will be p, as described above. 
//	Next will be N integers ti: the total points of the Googlers.
	
	public static int solveIt(List<Integer> l) {
		
		int N = l.get(0);
		int S = l.get(1);
		int p = l.get(2);
		
		List<Integer> scores = l.subList(3, l.size());
		assert scores.size() == N;
		
		int candidateHighScore = 0;
		
		Iterator<Integer> i = scores.iterator();
		while (i.hasNext()) {
			int score = i.next();
//			System.out.println("doing " + score);
			
			if (score == 0) {
				if (p == 0) {
					candidateHighScore++;
				}
				continue;
			}
			
			if (score % 3 == 0) {
//				System.out.println("\t% 3 == 0");
				int avg = score / 3;
				if (avg >= p) {
//					System.out.println("\talready more than " + p);
					candidateHighScore++;
					continue;
				}
				if (S > 0 && avg >= (p - 1)) {
//					System.out.println("\tsurprising (" + S + ") left");
					S--;
					candidateHighScore++;
					continue;
				}
			}
			
			if (score % 3 == 1) {
//				System.out.println("\t% 3 == 1");
				int avg = score / 3;
				if (avg >= (p - 1)) {
//					System.out.println("\talready more than " + p);
					candidateHighScore++;
					continue;
				}
			}
			
			//redundant check
			if (score % 3 == 2) {
//				System.out.println("\t% 3 == 2");
				int avg = score / 3;
				if (avg >= (p - 1)) {
//					System.out.println("\talready more than " + p);
					candidateHighScore++;
					continue;
				}
				if (S > 0 && avg >= (p - 2)) {
//					System.out.println("\tsurprising (" + S + ") left");
					S--;
					candidateHighScore++;
					continue;
				}
			}
			
//			if (score >= (p - 1)) {
//				//score is already ok
//				candidateHighScore++;
//				continue;
//			}
//			if (S > 0 && score >= (p - 2)) {
//				//score is surprising
//				candidateHighScore++;
//				S--;
//			}
		}
		
		
		return candidateHighScore;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	public static List<String> readSourceLinePerLine(Reader fileReader) {
		try {
			List<String> result = new ArrayList<String>();
			BufferedReader in = new BufferedReader(fileReader);
			String line;
			while ((line = in.readLine()) != null) {
				result.add(line);
			}
			in.close();
			return result;
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}
	
	public static List<Integer> toInteger(List<String> l) {
		List<Integer> result = new ArrayList<Integer>();
		for (String string : l) {
			result.add(string != null ? Integer.valueOf(string) : null);
		}
		return result;
	}
	public static List<Integer> toInteger(String...ss) {
		return toInteger(Arrays.asList(ss));
	}
	
	private static void writeFile(String content, File file) {
		try {
			writeFile(content,new FileWriter(file));
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}
	private static void writeFile(String content, FileWriter fstream) {
		try {
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(content);
			out.close();
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}
	
	
}
