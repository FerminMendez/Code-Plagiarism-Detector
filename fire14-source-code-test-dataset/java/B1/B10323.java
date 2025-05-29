import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * 
 */

/**
 * @author Bageshwar
 * 
 */
public class Recycle {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		long[] p = new long[] { 10, 100, 1000, 10000, 100000, 1000000, 10000000 };
		// HashSet<Long> set=new HashSet<Long>();

		// HashSet<String> set1=new HashSet<String>();

		BufferedReader fr = new BufferedReader(new FileReader(new File(args[0])));
		String str = fr.readLine();
		//System.out.println(str);
		int lines = Integer.parseInt(str);
		FileWriter writer = new FileWriter(new File(args[1]));
		StringTokenizer stk;
		for (int l = 0; l < lines; l++) {

			writer.write("Case #"+(l+1)+": ");
			str = fr.readLine();
			stk = new StringTokenizer(str," ");			
			
			long a = Integer.parseInt(stk.nextElement().toString());
			long b = Integer.parseInt(stk.nextElement().toString());
			int total = 0;
			long t = 0;
			int k = 0;
			int c = ("" + b).length() - 1;
			for (long i = a; i <= b; i++) {

				for (int j = 0; j < c; j++) {
					// rotate by j
					// j=j-1;
					k = c - j - 1;
					t = (i % p[j]) * p[k] + (i / p[j]);
					 System.out.print(" "+i+":"+t);
					if (t <= b && t >= a && i != t) {
						 System.out.print("!");
						// set.add(i);
						total++;
						//System.out.println("##########" + i + ">>" + t);
						// set1.add(e)
					}
				}
				System.out.println("");
			}

			System.out.println(total);
			System.out.println(total / 2);
			writer.write(total/2+"\r\n");
		}
		writer.close();
		fr.close();
	}

}
