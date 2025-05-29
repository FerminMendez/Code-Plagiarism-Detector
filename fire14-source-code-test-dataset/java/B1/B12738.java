import java.io.*;


public class q3 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String input = in.readLine();
		int numCases = Integer.valueOf(input);
		
		for (int caseCount = 1; caseCount <= numCases; caseCount++) {
			input = in.readLine();
			String A_string = input.split(" ")[0];
			String B_string = input.split(" ")[1];
			int A = Integer.valueOf(A_string);
			int B = Integer.valueOf(B_string);
			int n_int;
			int m_int;
			int recycledPairCount = 0;
			for (n_int = A; n_int < B; n_int++) {
				for (m_int = n_int + 1; m_int <= B; m_int++) {
					String n = Integer.toString(n_int);
					String m = Integer.toString(m_int);
					boolean found = false;
					for (int i = (n.length() - 1); i > 0 && found == false; i--) {
						String sub = n.substring(i);
						char[] array = n.toCharArray();
						String shortened = new String(array, 0, i);
						sub = sub.concat(shortened);
			
						if (sub.equals(m)) {
							found = true;
							recycledPairCount++;
						}
					}
				}
			}
			System.out.println("Case #" + caseCount + ": " + recycledPairCount);
		}
	}

}
