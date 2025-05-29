import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws Throwable {
		long init = System.currentTimeMillis();
		int MAX = 2000001;
		//int MAX = 201;
		int arr[][] = new int[MAX][];
		{
			for (int i = 1; i < MAX; i++) {
				TreeSet<Integer> set = new TreeSet<Integer>();
				set.add(i);
				String num = Integer.toString(i);
				for (int j = 1; j < num.length(); j++) {
					String newNum = num.substring(j) + num.substring(0, j);
					if (newNum.charAt(0) != '0') {
						int n = Integer.parseInt(newNum);
						if (n > i && !set.contains(n)) {
							set.add(n);
						}
					}
				}
				set.remove(i);
				arr[i] = new int[set.size()];
				{
					int j = 0;
					for (Integer n : set) arr[i][j++] = n;
				}
			}
		}
		
		long end = System.currentTimeMillis();
		BufferedReader in = new BufferedReader(new FileReader("C-small-attempt0.in"));
		
		for (int i = 0, n = Integer.parseInt(in.readLine().trim()); i < n; i++) {
			String s[] = in.readLine().trim().split(" +");
			int a = Integer.parseInt(s[0]), b = Integer.parseInt(s[1]);
			int c = 0;
			for (int j=a; j<=b; j++) {
				for (int k=0, d; k<arr[j].length && (d=arr[j][k]) <= b; k++) c++;
			}
			System.out.println("Case #"+(i+1)+": "+c);
		}
		//System.out.printf("%.2f seconds%n", (end - init) / 1000.);
	}
}
