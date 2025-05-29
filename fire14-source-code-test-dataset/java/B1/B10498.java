import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		int c = 1;
		while(scan.hasNextLine()) {
			Scanner ls = new Scanner(scan.nextLine());
			System.out.println("Case #" + c++ + ": " + process(ls.nextInt(), ls.nextInt()));
		}
	
	}
	
	public static int process(int a, int b) {
		int count = 0;
		for(int n = a; n < b; n++) {
			for(int m = n + 1; m <= b; m++) {
				count += isRecyclable(n, m);
			}			
		}
		return count;
	}
	
	public static int isRecyclable(int n, int m) {
		//System.err.println("testing " + n + ", " + m);
		String ns = "" + n;
		String ms = "" + m;
		
		//find start
		int id = 0;
		int c = 0;
		while(id >= 0 && c < ns.length()) {
			id = ns.indexOf(ms.charAt(0), c);
			if(id >= 0) {
				int i = 0;
				boolean worked = true;
				for(int firstPass = id; firstPass < ns.length(); firstPass++) {
					if(ms.charAt(i++) != ns.charAt(firstPass)) {
						worked = false;
						break;
					}
				}
				if(worked) {
					for(int secondPass = 0; secondPass < id; secondPass++) {
						if(ms.charAt(i++) != ns.charAt(secondPass)) {
							worked = false;
							break;
						}
					}
				}
				if(worked) {
					System.err.println("found: " + ns + ", " + ms);
					return 1;					
				}
				c = id + 1;
			}
		}
		return 0;
	}
}
