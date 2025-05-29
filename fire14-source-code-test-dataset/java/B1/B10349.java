import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;


public class ProblemC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Problem A enter input file:");
		Scanner scan = new Scanner(System.in);
		String sFile = scan.nextLine();
		File f = new File(sFile);
		try {
			BufferedReader r  = new BufferedReader(new FileReader(sFile));
			String current;
			int cnum = 0;
			while((current = r.readLine())!=null) {
				if(cnum>0) {
					System.out.println("Case #"+cnum+": "+solve(current));
				}
				cnum ++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static int solve(String current) {
		StringTokenizer tok = new StringTokenizer(current);
		int a = 0, b = 0, i = 0, s=0;
		while(tok.hasMoreElements()){
			switch(i) {
			case 0: a = Integer.parseInt((String) tok.nextElement());
			break;
			case 1: b = Integer.parseInt((String) tok.nextElement());
			}
			i++;
		}
		for(int n = a; n<b; n++) {
			for(int m = b; m > n; m--) {
				int t = m;
				int digits = String.valueOf(t).length();
				for(i = 1; i<digits; i++) {
					t = (int) ((t % 10)*Math.pow(10, digits-1) + t/10);
					if(t == n)
						s++;
				}
			}
		}
		return s;
	}

}
