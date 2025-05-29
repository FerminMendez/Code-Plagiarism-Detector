import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;


public class CSol {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Date d1 = new Date();
		solveC("C-small-attempt0.in", "C-small-attempt0.out");
		Date d2 = new Date();
		System.out.println("time: " + (d2.getTime() - d1.getTime()) + " ms");

	}

	private static void solveC(String in, String out) {
		try {
			FileReader fis = new FileReader(in);
			BufferedReader  dis = new BufferedReader (fis);
			
			FileWriter fw = new FileWriter(out);
			BufferedWriter bw = new BufferedWriter(fw);

			
			int t = Integer.parseInt(dis.readLine());
			for (int i = 0; i < t; i++) {
				String e = dis.readLine();
				String ee[] = e.split(" ");
				int a = Integer.parseInt(ee[0]);
				int b = Integer.parseInt(ee[1]);
				//System.out.println(a +  " " + b);
				
				
				String result = ""+solve(a,b);
				//System.out.println(result);
				
				bw.write("Case #" + (i+1) + ": " + result + "\n");
			}
			
			
			bw.flush();
			bw.close();
			fw.close();
			dis.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
		}
	}

	private static long solve(int a, int b) {
		long sum = 0;
		//System.out.println("solve: " + a+ " " + b);
		
		ArrayList<String> uniq = new ArrayList<String>();
		for (int ii = a; ii <= b; ii++) {
			//System.out.println(ii);

			String s = "" +ii;
			String rot = "" + s+s;
			
			for (int i = 1; i < s.length(); i++) {
				String r = rot.substring(i, i+s.length());
				if (r.charAt(0) == '0') 
					continue;
								
				if (s.compareTo(r) < 0) {
					if (r.compareTo(""+b) <= 0) {
						if (r.compareTo(""+a) >= 0) {
							if (!uniq.contains(s+r)) {
								uniq.add(s+r);
								//System.out.println(s + " " + r);
								sum++;
							}
						}
					}
				}
			}
			
		}
		
		return sum;
	}

}
