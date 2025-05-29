import java.io.*;
import java.util.*;
public class BSmall {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("B-small-attempt1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("B-Small.out")));
		
		int T = Integer.parseInt(in.nextLine());
		
		for (int i = 0; i < T; i++) {
			String[] Line = in.nextLine().split(" ");
			int counter = 0;
			int surprising = Integer.parseInt(Line[1]);
			int thresh = Integer.parseInt(Line[2]);
			
			int len = Line.length;
			
			for (int j = 3; j < len; j++) {
				int score = Integer.parseInt(Line[j]);
				
				if (score == 0) {
					if (score >= thresh) {
						counter++;
					}
					Line[j] = null;
					continue;
				}
				
				int mod3 = score % 3;
				switch (mod3) {
					case 2: if ((score/3) + 1>= thresh) {
						counter++;
						Line[j] = null;
						break;
					}
					case 1: if ((score/3) + 1 >= thresh) {
						counter++;
						Line[j] = null;
						break;
					}
					case 0: if ((score/3) >= thresh) {
						counter++;
						Line[j] = null;
						break;
					}
				}
			}
				for (int l = 3; l < len && surprising > 0; l++) {
					if (!(Line[l] == null)) {
						int score = Integer.parseInt(Line[l]);
						int mod3 = score % 3;
						switch (mod3) {
							case 2: if ((score/3) + 2 >= thresh) {
								counter++;
								surprising--;
								break;
								
							}
							case 1: if ((score/3) + 1 >= thresh) {
								counter++;
								surprising--;
								break;
							}	
							case 0: if ((score/3) + 1 >= thresh) {
								counter++;
								surprising--;
								break;
							}
						}
					}	
				}
				
			out.write("Case #"+ (i+1) +": " + counter);
			if (i != T-1)
				out.write("\n");
			//System.out.println(counter);
			//System.out.println(Arrays.toString(Line));
		}
		
		out.close();
		System.exit(0);
	}
}
