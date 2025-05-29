import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Set;


public class GCJ3 {
	
	public static int pow(int num, int p) {
		int n = 1;
		while (p > 0) {
			p--;
			n *= num;
		}
		return n;
	}
	
	public static int exp(int num) {
		int e = 0;
		while (num > 0) {
			e++;
			num /= 10;
		}
		return e;
	}
	
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File("output.txt")));
			String firstLine = br.readLine();
			int lineNum = Integer.parseInt(firstLine);
			for (int i=0; i<lineNum; i++) {
				Set<Long> set = new HashSet<Long>();
				String line = br.readLine();
				String[] segs = line.split(" ");
				int a = Integer.parseInt(segs[0]);
				int b = Integer.parseInt(segs[1]);
				int result = 0;
				int exp = exp(a);
				long off = (long)(b+1);
				for (int num=a; num<b; num++) {
					for (int j=1; j<exp; j++) {
						int key = pow(10, j);
						int key2 = pow(10, exp-j);
						int first = num / key;
						int second = num % key;
						int recycle = second * key2 + first;
						if (recycle > num && recycle <= b) {
							if (set.contains(off*num+recycle)) {
							} else {
								set.add(off*num+recycle);
								result++;
							}
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
