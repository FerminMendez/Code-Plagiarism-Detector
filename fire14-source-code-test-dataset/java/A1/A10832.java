package practice.GC2012;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dancers {
	
	public static void main(String args[]) throws IOException {
		Scanner s = new Scanner(new File("Z:\\junkyard\\practice\\resources\\input2.txt"));
		FileWriter fo = new FileWriter(new File("Z:\\junkyard\\practice\\resources\\output2.txt"));
		int num = s.nextInt();
		for(int i = 1; i<= num; i++) {
			fo.write("Case #" + i + ": ");
			int nd = s.nextInt();
			int ns = s.nextInt();
			System.out.println("\n"+ i + " - " + nd + " , "+ ns);

			int p = s.nextInt();
			int alreadyhigh = Math.max(p, 0) + Math.max(p-1, 0) + Math.max(p-1, 0);
			int surpriseScore = Math.max(p, 0) + Math.max(p-2, 0) + Math.max(p-2, 0);
			int bestScorers = 0;
			int canSurprise = 0;
			for(int j = 1; j<=nd; j++) {
				int score = s.nextInt();
				System.out.print(score + " - ");
				if (score == 0) {
					continue;
				}
				if (score >= alreadyhigh) {
					bestScorers ++;
				} else if(score >= surpriseScore) {
					canSurprise ++;
				}
			}
			if (canSurprise < ns) {
				bestScorers += canSurprise;
			} else {
				bestScorers += ns;
			}
			if(p==0) {
				fo.write(nd + "\n");
			} else {
				fo.write(bestScorers + "\n");
			}
		}
			fo.close();
			s.close();
	}
}
