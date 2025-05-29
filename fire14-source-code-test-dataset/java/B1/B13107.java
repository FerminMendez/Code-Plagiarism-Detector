import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class GCJ3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] hold = new int[n];
		for (int i = 0; i < n; i++) {
			hold[i] = 0;
			int a = sc.nextInt();
			int b = sc.nextInt();
			int k = (int) Math.log10(a);
			HashSet<Integer> checked = new HashSet<Integer>();
			for (int j = a; j <= b; j++) {
				if(checked.contains(j))
					continue;
				HashSet<Integer> set = new HashSet<Integer>();
				set.add(j);
				int curr = j;
				for (int l = 0; l <= k; l++) {
					int firstDig = curr / (int) Math.pow(10, k);
					int mod = curr % (int) Math.pow(10, k);
					curr = mod * 10 + firstDig;
					if ((int) Math.log10(curr) == k) {
						if (a<=curr && curr <=b) {
							set.add(curr);
						}
					}
				}
				if (set.size() > 1){
					Iterator<Integer> p = set.iterator();
					for(int m = 0;m<set.size();m++){
						int P = p.next();
						checked.add(P);
					}
					hold[i] += set.size() * (set.size() - 1) / 2;
				}
			}
		}
		try {
			// Create file
			FileWriter fstream = new FileWriter("out.txt");
			BufferedWriter out = new BufferedWriter(fstream);
			for (int i = 0; i < n; i++) {
				out.write("Case #" + (1 + i) + ": " + hold[i]);
				if (i < n - 1)
					out.write("\n");
			}
			out.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
}
