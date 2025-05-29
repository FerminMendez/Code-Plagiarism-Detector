import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class RecycledNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		File inDir = new File("RecycledNumbers/input");
		File outDir = new File("RecycledNumbers/output");
		File[] inFiles = inDir.listFiles();
		for (File inFile : inFiles) {
			BufferedReader br = new BufferedReader(new FileReader(inFile));
			PrintWriter pw = new PrintWriter(new File(outDir, inFile.getName()+".out"));
			long numLines = Long.valueOf(br.readLine());
			for (long i = 1; i <= numLines; i++) {
				Set<RecycledSet> recycledPairs = new HashSet<RecycledSet>();
				String[] limits = br.readLine().split(" ");
				long a = Long.valueOf(limits[0]);
				long b = Long.valueOf(limits[1]);
				long num = a;
				while (num <= b) {
					String numString = String.valueOf(num);
					int numDigits = numString.length();
					for (int idx = 0; idx < numDigits; idx++) {
						String recycledString = numString.substring(idx) + numString.substring(0, idx);
						System.out.println("Number: " + numString + " | Recycled: " + recycledString);
						long recycled = Long.valueOf(recycledString);
						if (recycled >= a && recycled <= b && num != recycled) {
							System.out.println("Adding");
							RecycledSet rs = new RecycledSet(num, recycled);
							recycledPairs.add(rs);
						}
					}
					num++;
				}
				System.out.println("Num Recycled Pairs: " + recycledPairs.size());
				pw.print("Case #"+i+": ");
				pw.println(recycledPairs.size());
			}
			br.close();
			pw.flush();
			pw.close();
		}
	}
}

class RecycledSet {
	
	long num1;
	long num2;

	public RecycledSet(long num1, long num2) {
		if (num1 < num2) {
			this.num1 = num1;
			this.num2 = num2;
		} else {
			this.num1 = num2;
			this.num2 = num1;
		}
	}
	
	public int hashCode() {
		return (int) (num1 & num2);
	}
	
	public boolean equals(Object o) {
		if (o instanceof RecycledSet) {
			RecycledSet rs = (RecycledSet) o;
			if (this.num1 == rs.num1 && this.num2 == rs.num2) {
				return true;
			}
		}
		return false;
	}
	
}
