import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class RecycledNumbers {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Scanner in;
		in = new Scanner(new FileReader("C-small.in"));
		FileWriter output = new FileWriter("C-small.out");
		/*in = new Scanner(new FileReader("C-large.in"));
		FileWriter output = new FileWriter("C-large.out");*/
		
		int T = in.nextInt();

		for(int i = 1; i <= T; i++) {
			int a = in.nextInt();
			int b = in.nextInt();

			int recycle = 0;
			for(int n = a; n < b; n++) {
				StringBuffer sb = new StringBuffer(Integer.toString(n));
				sb.trimToSize();
				int m = -1;
				
				for(int j = 1; j < sb.length(); j++) {
					sb.append(sb.charAt(0));
					sb.deleteCharAt(0);
					sb.trimToSize();

					if ( m != Integer.parseInt(sb.toString()) ) {
						int check = m;
						m = Integer.parseInt(sb.toString());

						if(m <= b && m>n) {
							//System.out.println(a + " " + n + " " + m + " " + b);
							recycle++;
						} else m = check;
					}
					
				}
			}
			
			output.write("Case #" + i + ": " + recycle + "\n");
			
		}
		
		in.close();
		output.flush();
		output.close();

	}

}
