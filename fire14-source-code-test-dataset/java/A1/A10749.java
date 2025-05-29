package codejam.b;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		ProblemB b = new ProblemB();
		List<String> lines = CodejamFile.readLines("c:\\tmp\\B-small-attempt0.in");
		for (int i = 0; i < lines.size(); i++) {
			System.out.printf("Case #%d: %d\n", i + 1, b.process(lines.get(i)));
		}
	}
}

class ProblemB {
	
	private int S;	// the number of surprising triplets of scores
	private int p;	// threashold score
	
	// 3 1 5 15 13 11 -> 3
	// 3 0 8 23 22 21 -> 2
	public int process(String line) {
		int possiblity = 0;
		//System.out.println(line);
		
		String[] elements = line.split(" ");
		int N = Integer.parseInt(elements[0]);	// the number of Googlers
		S = Integer.parseInt(elements[1]);
		p = Integer.parseInt(elements[2]);
		
		for (int i = 0; i < N; i++) {
			int score = Integer.parseInt(elements[i + 3]);
			//System.out.printf("%d, %d\n", score / 3, score % 3);
			possiblity += getPossiblity(score) > 0 ? 1 : 0;
		}
		return possiblity;
	}
	
	private int getPossiblity(int score) {
		int r = 0;
		int avg = score / 3;
		
		switch (score % 3) {
		case 0:
			if (avg > p) {
				r = 3;
			} else if (avg == p) {
				//if (S > 0) {
					r = 2;
					//S--;
				//}
			} else if (avg == (p - 1)){
				if (avg == 0) {
					break;
				}
				
				if (S > 0) {
					r = 1;
					S--;
				}
			}
			break;
		case 1:
			if (avg >= p) {
				r = 3;
			} else if (avg == (p -1)) {
				//if (S > 0) {
					//S--;
					r = 2;
				//} else {
					//r = 1;
				//}
			}
			break;
		case 2:
			if (avg >= p) {
				r = 3;
			}
			if (avg == (p - 1)) {
				r = 2;
			}
			if (avg == (p -2)) {
				if (S > 0) {
					S--;
					r = 1;
				}
			}
			break;
		}
		
		return r;
	}
}

class CodejamFile {

	public static List<String> readLines(String path) {
		List<String> lines = new ArrayList<String>();
		
		try {
			FileReader in = new FileReader(path);
			BufferedReader br = new BufferedReader(in);
			String line;
			//
			br.readLine();	// line count
			//
			while ((line = br.readLine()) != null) {
				lines.add(line);
			}
			br.close();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return lines;
	}
}
