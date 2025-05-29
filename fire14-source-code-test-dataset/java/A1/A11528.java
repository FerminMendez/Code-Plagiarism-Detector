import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class Solve1 {

	public static void main(String[] args) {

		FileReader fr;
		FileWriter fw;
		try {
			File fi = new File("input.txt");
			fr = new FileReader(fi);
			BufferedReader br = new BufferedReader(fr);
			fw = new FileWriter("output.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			boolean f = true;
			int tCount = Integer.MAX_VALUE;
			int c = 1;
			String line = null;
			while((line = br.readLine()) != null && c <= tCount) {
				if(f) {
					f = false;
					tCount = Integer.parseInt(line);
					continue;
				}

				int ans = getVal(line);
				String os = "Case #" + c + ": " + ans;


				bw.write(os);
				bw.newLine();
				c++;
			}
			bw.flush();
			bw.close();
			br.close();
		} catch (FileNotFoundException eg) {
			// TODO Auto-generated catch block
			eg.printStackTrace();
		} catch (IOException ed) {
			// TODO Auto-generated catch block
			ed.printStackTrace();
		}
	}

	public static int getVal(String line) {
		String[] sa = line.split(" ");
		int[]  vals = null;
		int s = 0;
		int p = 0;
		for(int i=0; i< sa.length; i++) {
			int v = Integer.parseInt(sa[i].trim());
			if(i == 0) {
				vals = new int[v];
				continue;
			}
			if(i == 1) {
				s = v;
				continue;
			}
			if(i == 2) {
				p = v;
				continue;
			}

			vals[i-3] = v;

		}


		int[] bs = new int[11];
		int[] pc = new int[11];

		for(int i=0; i<vals.length; i++) {
			int r = vals[i] % 3;
			int v = vals[i] / 3;
			if(r == 0) {
				bs[v] += 1;
				//bs[v + 1] += 1;
				if (v != 0)
				pc[v] += 1;
			}
			if(r == 1) {
				//bs[v] += 1;
				bs[v+1] += 1;
			}
			if(r == 2) {
				bs[v+1] += 1;
				//bs[v] += 1;
				pc[v+1] += 1;
			}
		}

		int ans = 0;
		for(int i=bs.length - 1; i>= p; i--) {
			ans += bs[i];
		}
		int ex = 0;
		if (p>0) {
			if (s > pc[p-1])
				return ans + pc[p-1];
			else
				return ans + s;

		}
		else
			return ans;

	}


}

