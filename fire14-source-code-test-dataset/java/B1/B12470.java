import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.io.*;

public class Rec {
	public static void main(String args[]) throws IOException {
		//Scanner in = new Scanner(System.in);
		//int n = in.nextInt();
		//in.nextLine();
		
		BufferedReader br = new BufferedReader(new FileReader("C-small-attempt0.in"));
		PrintWriter pw = new PrintWriter("output1.in");
		
		String sss = "";
		sss = br.readLine();
		
		int num = Integer.parseInt(sss);
		
		List<String> l = new ArrayList<String>();
		
		while((sss = br.readLine()) != null)
			l.add(sss);
		
		int count = 0;
		
		for (String s : l) {
			count++;
			
			Set<String> set = new HashSet<String>();
			
			String val[] = s.split(" ");
			int rear = Integer.parseInt(val[0]);
			int max = Integer.parseInt(val[1]);
			
			if (String.valueOf(rear).length() == 1) {
				if (count == 0)
					pw.print("Case #" + count + ": " + 0);
					//System.out.print("Case #" + count + ": " + 0);
				else
					pw.print("\n" + "Case #" + count + ": " + 0);
					//System.out.print("\n" + "Case #" + count + ": " + 0);
			} else {
				int len = String.valueOf(rear).length();
				
				for (int c = rear; c <= max; c++) {
					String ss = String.valueOf(c);
					for (int u = 1; u < len; u++) {
						String sub = ss.substring(u);
						int f_s = Integer.parseInt(String.valueOf(sub.charAt(0)));
						
						if (f_s > Integer.parseInt(String.valueOf(String.valueOf(max).charAt(0))))
							continue;
						if (f_s == 0)
							continue;
							
						sub = sub.concat(ss.substring(0,u));
						
						if ((Integer.parseInt(sub) > c) && (Integer.parseInt(sub) <= max))
							if (c < Integer.parseInt(sub) && c >= rear) {
								set.add(String.format("%s %s", c, sub));
							}
					}
				}
				
				if (count == 0)
					pw.print("Case #" + count + ": " + set.size());
					//System.out.print("Case #" + count + ": " + set.size());
				else
					pw.print("\n" + "Case #" + count + ": " + set.size());
					//System.out.print("\n" + "Case #" + count + ": " + set.size());
				pw.flush();
			}
		}
		
		pw.close();
		
	}
}