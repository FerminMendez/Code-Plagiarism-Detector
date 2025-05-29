import java.io.*;
import java.util.*;

public class RecycledNumbers {
	public static void main(String[] args) {
		try {
			Scanner in = new Scanner(new File("C:/Users/Ross/Downloads/C-small-attempt1.in"));
			int T = in.nextInt();
			String out = "";
			for(int i = 0; i < T; i++) {
				int A = in.nextInt();
				int B = in.nextInt();
				int count = 0;
				for(int j = A; j < B; j++) {
					String num = Integer.toString(j);
					ArrayList<Integer> pairs = new ArrayList<Integer>();
					for(int k = 1; k < num.length(); k++) {
						String num2 = num.substring(num.length()-k,num.length())+num.substring(0,num.length()-k);
						int nnum = Integer.parseInt(num2);
						if(nnum > j && nnum <= B && Integer.toString(nnum).length()==num.length()){
							if(pairs.indexOf(nnum) == -1) {
								count++;
								pairs.add(nnum);
							}
						}
					}
				}
				out += "Case #" + (i+1) + ": ";
				out += count + "\n";
			}
			System.out.println(out);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
