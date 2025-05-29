package codej;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class QualC {
	Scanner scanner;
		
	public static void main(String[] args) {
		QualC c = new QualC();
		c.go();
	}
	
	public void go() {		
		try {
			scanner = new Scanner(new File("input.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int N = scanner.nextInt();	
		for (int i=1; i <= N; i++) {
			scanner.nextLine();
			System.out.print("Case #" + i +": ");
			System.out.println(doCase());
		}
	}
	
	public int doCase() {
		int N = scanner.nextInt();
		int S = scanner.nextInt();
		int p = scanner.nextInt();
		int maxScores = 0;
		List<Integer> scores = new ArrayList<Integer>();
		
		for (int i=0; i < N; i++) {
			scores.add(scanner.nextInt());
		}
		Collections.sort(scores);
		
		for (int n : scores) {
			int spare = n - ((p-1) * 3);
			if (p > n)
				continue;
			if (spare >= 1) {
				maxScores++;
				continue;
			}
			if (spare >= -1 && S > 0) {
				S--;
				maxScores++;
			}					
		}
		return maxScores;
	}
}
