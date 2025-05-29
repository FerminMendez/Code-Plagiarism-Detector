import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


public class GCJ2 {
	
	public GCJ2() {
	}
	
	public static void main(String[] args) {
		GCJ2 gcj = new GCJ2();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File("output.txt")));
			String firstLine = br.readLine();
			int lineNum = Integer.parseInt(firstLine);
			for (int i=0; i<lineNum; i++) {
				String line = br.readLine();
				
				String[] segs = line.split(" ");
				int googlerNum = Integer.parseInt(segs[0]);
				int surpriseNum = Integer.parseInt(segs[1]);
				int maxScore = Integer.parseInt(segs[2]);
				int[] scores = new int[googlerNum];
				for (int j=0; j<googlerNum; j++) {
					int s = Integer.parseInt(segs[3+j]);
					scores[j] = s;
				}

				int result = 0;
				for (int j=0; j<googlerNum; j++) {
					int s = scores[j];
					int min = (maxScore-1) >= 0 ? (maxScore-1) : 0;
					if (s >= min + min + maxScore) {
						result++;
					} else if (surpriseNum > 0) {
						min = (maxScore-2) >= 0 ? (maxScore-2) : 0;
						if (s >= min + min + maxScore) {
							result++;
							surpriseNum--;
						}
					}
				}
				bw.write("Case #" + (i+1) + ": " + result);
				if (i != (lineNum-1))
					bw.newLine();
			}
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
