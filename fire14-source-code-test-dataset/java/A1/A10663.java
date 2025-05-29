
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Dancers {
	
	public static void main(String args[]) throws IOException {
		Scanner s = new Scanner(new File("D:\\input2.txt"));
		FileWriter fo = new FileWriter(new File("D:\\workspace\\GC12\\src\\output2.txt"));
		int num = s.nextInt();
		for(int i = 1; i<= num; i++) {
			fo.write("Case #" + i + ": ");
			int nd = s.nextInt();
			int ns = s.nextInt();
			//System.out.println("\n"+ i + " - " + nd + " , "+ ns);

			int p = s.nextInt();
			int aHigh = Math.max(p, 0) + Math.max(p-1, 0) + Math.max(p-1, 0);
			int surpScore = Math.max(p, 0) + Math.max(p-2, 0) + Math.max(p-2, 0);
			int bScore = 0;
			int canSurprise = 0;
			for(int j = 1; j<=nd; j++) {
				int score = s.nextInt();
				//System.out.print(score + " - ");
				if (score == 0) {
					continue;
				}
				if (score >= aHigh) {
					bScore ++;
				} else if(score >= surpScore) {
					canSurprise ++;
				}
			}
			if (canSurprise < ns) {
				bScore += canSurprise;
			} else {
				bScore += ns;
			}
			if(p==0) {
				fo.write(nd + "\n");
			} else {
				fo.write(bScore + "\n");
			}
		}
			fo.close();
			s.close();
	}
}
