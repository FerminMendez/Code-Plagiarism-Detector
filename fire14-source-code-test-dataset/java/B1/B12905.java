import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class GCJ3 {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GCJ3 g = new GCJ3();

		// System.out.println();
		// long i1 = g.calculate(1, 9);
		// System.out.println();
//		 long i2 = g.calculate(10, 40);
		// System.out.println();
//		long i3 = g.calculate(100, 500);
//		long i4 = g.calculate(1111, 2222);
		
//		long i5 = g.calculate(28, 93);
		 
		// System.out.println(i1);
//		 System.out.println(i2);
//		 System.out.println(i3);
//		 System.out.println(i4);
//		System.out.println(i5);

		try {
			// Open the file that is the first
			// command line parameter
			FileInputStream fstream = new FileInputStream(
					"C:/PROG/java/work/tc/src/gcj3.txt");
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			// Read File Line By Line
			int lineNum = 1;
			br.readLine();

			while ((strLine = br.readLine()) != null) {
				// Print the content on the console

//				 System.out.print(strLine+"\t");
				String[] val = strLine.split("\\s");
				System.out.print("Case #" + lineNum + ": ");
				System.out.println(g.calculate(Integer.valueOf(val[0]),
						Integer.valueOf(val[1])));
				
				
				
				
				// System.out.println();

				// System.out.println(strLine.charAt(0));
				lineNum++;
			}
			// Close the input stream
			in.close();
		} catch (Exception e) {// Catch exception if any
			e.printStackTrace();
		}

	}

	public long calculate(int A, int B) {
		
		HashMap<String,HashSet<String>> map = new HashMap<String,HashSet<String>>();

		String a = String.valueOf(A);
		String b = String.valueOf(B);
		if (a.length() == b.length() && a.length() > 1) {
			long count = 0;

			for (long i = A; i <= B; i++) {

				for (long l = 1; l < a.length(); l++) {
					long n = 0;
					long m = i;

					String nS = String.valueOf(m);

					String nS2 = nS.substring((int) l, a.length())
							+ nS.substring(0, (int) l);

					n = Long.valueOf(nS2);

					String nS3 = String.valueOf(n);

					if (n < m && nS3.length() == a.length() && A<=n && m<=B) {
//						System.out.println(n + " " + m);
						count++;
						if (map.get(nS3) == null){
							HashSet<String> s = new HashSet<String>();
							s.add(nS);
							map.put(nS3, s);
						}else {
							map.get(nS3).add(nS);
						}
					}
				}
			}
			
			long count2 = 0;
			for (String s : map.keySet()){
				
				for (Object o: map.get(s).toArray()){
					count2++;
				}
				
			}

			return count2;
		}

		return 0;
	}

}
