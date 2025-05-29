import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class recycle {
	
	public static void main(String args[]) throws IOException {
		Scanner s = new Scanner(new File("D:\\workspace\\GC12\\src\\input2.txt"));
		FileWriter fo = new FileWriter(new File("D:\\workspace\\GC12\\src\\output2.txt"));
		int number = s.nextInt();
		for(int i = 1; i<= number; i++) {
			fo.write("Case #" + i + ": ");
			int a = s.nextInt();
			int b = s.nextInt();

			Set<String> aCounted = new HashSet<String>();
			for (int j = a;j<=b;j++) {

				StringBuffer n = new StringBuffer(String.valueOf(j));
				for (int p = 0; p < n.length(); p++) {
					n.append(n.charAt(0));
					n.deleteCharAt(0);
					
					if (j < Integer.parseInt(n.toString()) && Integer.parseInt(n.toString()) <= b) {
						aCounted.add(String.valueOf(j) + n.toString());

					}
				
				}

			}

				fo.write(aCounted.size() + "\n");

		}
			fo.close();
			s.close();
	}
}
