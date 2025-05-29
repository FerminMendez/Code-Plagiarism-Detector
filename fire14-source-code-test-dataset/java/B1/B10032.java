import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeSet;


public class Main {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static boolean isRecycledPair(String N, String M) {
		if (N.equals(M))
			return false;
		boolean retVal = false;
		
		for (int i=0; i<N.length(); i++) {
			String aux = N.substring(i, N.length()) + N.substring(0, i) ;
			if (aux.equals(M))
				return true;
		}
		
		return retVal;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		Scanner reader = new Scanner(new File("C-small-attempt2.in"));
		PrintWriter writer = new PrintWriter(new File("output.txt"));
		int cases = reader.nextInt();
		for (int i=0; i<cases; i++) {
			long A = reader.nextLong();
			long B = reader.nextLong();
			//TreeSet<String> set = new TreeSet<String>(); 
			int x = 0;
			for (long n=A; n<=B; n++) {
				for (long m=n; m<=B; m++) {
					String fN = Long.toString(n);
					String fM = Long.toString(m);
					if (Main.isRecycledPair(fN, fM)) {
						//set.add(fN + "," + fM);
						x++;
					}
				}
			}
			writer.println("Case #" + (i+1) + ": " + x);
		}
		System.out.println("done");
		reader.close();
		writer.close();
		
	}

}
