package qualifying;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class C {

		public static void main(String[] args) throws Exception {
			
			String fs_in = "/Users/ctynan/Downloads/test.txt";
			String fs_out = "/Users/ctynan/Documents/C-out.txt";
			String line;
			BufferedReader br = new BufferedReader(new FileReader(fs_in));
			BufferedWriter bw = new BufferedWriter(new FileWriter(fs_out));
			
			line=br.readLine();
			line=line.toLowerCase();
			int tst = Integer.valueOf(line);
			
			for(int ii=0;ii<tst; ii++) {
				line=br.readLine();
				String output = "Case #" + Integer.toString(ii+1) +": ";
				String[] tem = line.split(" ");
				int A = Integer.valueOf(tem[0]);
				int B = Integer.valueOf(tem[1]);
				int cnt=0;
				
				for(int i=A; i<B; i++) {
					String s = Integer.toString(i);
					int[] got = new int[12];
					int goti=0;
					
					for(int j=0; j<s.length(); j++) {
						String t = s.substring(j)+s.substring(0, j);
						int tm = Integer.valueOf(t);
						if(tm>i&&tm<=B) {
							boolean have = false;
							for(int l=0;l<goti;l++) 
								if(got[l]==tm) { have=true; break; }
							if(!have) {
								got[goti]=tm;
								goti++;
								cnt++;
							}
						}
					}
				}
				bw.write(output);
				bw.write(Integer.toString(cnt));
				if(ii<tst-1) bw.write('\n');
			}
			bw.close();
			return;
		}
}
