import java.io.*;
import java.util.*;

public class recycled {

	private static int digits(int num) {
		
		int sol = 1;

		while (num / 10 != 0) {
			sol *= 10;
			num /= 10;
		}

		return sol;
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		Scanner fe = new Scanner(new FileInputStream("/home/gllera/Desktop/data.in"));
		FileWriter fs = new FileWriter("/home/gllera/Desktop/data.out");

		int cases = fe.nextInt();

		for (int i = 0; i < cases; i++) {
			int a = fe.nextInt();
			int b = fe.nextInt();

			int sol = 0;

			TreeSet<Integer> tree = new TreeSet<Integer>();
			
			for (int n = a; n < b; n++) {
				
				tree.clear();
				int digits = digits(n);
				int idigits = 10;
				int n1 = n / digits;
				int n2 = n % digits;
				
				while ( digits != 1 )
				{
					int m = n2 * idigits + n1;
					if ( n < m && m <= b && !tree.contains(m) )
					{
						tree.add(m);
						sol++;
					}
					
					digits /= 10;
					idigits *= 10;
					
					n1 = n / digits;
					n2 = n % digits;
				}
			}

			fs.write("Case #" + (i + 1) + ": " + sol + '\n');
		}

		fe.close();
		fs.flush();
		fs.close();
	}
}
