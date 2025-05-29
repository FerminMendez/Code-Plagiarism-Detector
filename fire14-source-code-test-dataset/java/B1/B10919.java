package codejam.qualification;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Recycled {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		String file = "input3small";
		Scanner in = new Scanner(new File(file));
		int tot = Integer.parseInt(in.nextLine());
//		System.out.println(tot);
		for(int i=0;i<tot;i++) {
			String line = in.nextLine();
			String[] data = line.split(" ");
			int A = Integer.parseInt(data[0]);
			int B = Integer.parseInt(data[1]);
			
			int output = 0;
			for(int j=A; j<=B; j++) {
//				System.out.println("("+j+")");
				String s = j+"";
				output += countRecycled(s, B);
			}
			
			System.out.println("Case #"+(i+1)+": "+output);			
		}

}

	private static int countRecycled(String s, int B) {
		ArrayList<String> rec = new ArrayList<String>();
		int count = 0;
		
		for(int i=s.length()-1; i>0; i--) {
			String r = s.substring(i) + s.substring(0, i);
//			System.out.println(r);
			int s_int = Integer.parseInt(s);
			int r_int = Integer.parseInt(r);
			if(r.charAt(0) != 0 && s_int < r_int && r_int <= B && !isIn(r,rec)) {
//				System.out.println("ok: "+s+"\t"+r);
				count++;
				rec.add(r);
			}
		}

		return count;
	}

	private static boolean isIn(String r, ArrayList<String> rec) {
		for(String r2 : rec)
			if(r.equals(r2))
				return true;
		return false;
	}
}