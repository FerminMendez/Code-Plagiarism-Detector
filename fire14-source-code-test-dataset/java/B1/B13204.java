import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader bu = null;
		PrintWriter pr = null;
		int T, A, B, counter, m, check;
		String in, con, sub, S;
		try {
			bu = new BufferedReader(new FileReader(args[0]));
			pr = new PrintWriter(new FileWriter("out.out"));
			
			T = Integer.parseInt(bu.readLine());
			
			for(int i = 0; i < T; i++) {
				S = "Case #" + (i + 1) + ": ";
				in = bu.readLine();
				String[] sp = new String[in.length()];
				sp = in.split("\\s+");
				A = Integer.parseInt(sp[0]);
				B = Integer.parseInt(sp[1]);
				counter = 0;
				check = 0;
				m = 0;
				for(int n = A; n <= B ; n++) {
					con = "";
					sub = "";
					for(int k = 0; k < sp[0].length(); k++) {
						con = ""+n;
						StringBuilder sb = new StringBuilder(con);
						sb.append(sb.substring(0, k)).delete(0, k);
						sub = sb.toString();
						//pr.println(sub);
						m = Integer.parseInt(sub);
						
						if((n >= A) && (n < m) && (B >= m) && (check != m)) {
							counter++;
							check = m;
							
						}
					}
				}
				pr.println(S + counter);
				pr.flush();
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
