package qualificationRound;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Q3Recycled {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("qualificationRound/C-small-attempt1.in"));
		PrintWriter out = new PrintWriter(new File("qualificationRound/out.txt"));

		int T = sc.nextInt();
		sc.nextLine();

		for (int tc = 1; tc <= T; tc++) {
			out.print("Case #"+tc+": ");
			System.out.print("Case #"+tc+": ");
			
			int A = sc.nextInt();
			int B = sc.nextInt();
			int count = 0;
			for (int n = A; n <= B; n++) {
				if (n >= 10) { // must be two digits at least
					String s = ""+n;

					/*boolean same = true;
					for (int j=1; j<s.length(); j++) {
						if (s.charAt(0) != s.charAt(j)) {
							same = false;
							break;
						}
					}
					if (!same) { // can't be a number like 88888
						if (s.length()%2 == 0 && s.substring(0,s.length()/2).equals(s.substring(s.length()/2,s.length()))) // if repeated sequence
							count += s.length()/2-1;
						else
							count += s.length()-1;
					} */

					String[] s2 = getStrings(s);
					for (int i=0; i<s2.length; i++) {
						try {
							int m = Integer.parseInt(s2[i]);
							if (n<m && m<=B)
								count++;
						} catch (Exception e) {
							break; // no more candidates
						}
					}
				}
			}
			out.println(count);
			System.out.println(count);
			out.flush();
		}
		out.close();
	}

	public static String[] getStrings(String s) {
		String[] out = new String[s.length()-1];
		for (int i=0; i<out.length; i++) {
			int split = s.length()-i;
			String newString = s.substring(split-1,s.length())+s.substring(0,split-1);
			boolean isnew = true;
			for (int j=0; j<i; j++)
				if (out[j].equals(newString)) {
					isnew = false;
					break;
				}
			if (isnew)
				out[i]=newString;
		}
		return out;
	}
}