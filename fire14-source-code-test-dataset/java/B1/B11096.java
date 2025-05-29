import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Recycle {

	
	public static void main (String[] args) {
		int s, t;
		Scanner scanner;
		
		try {
			scanner = new Scanner(new File("C:\\a.in"));
			if(scanner.hasNextLine()) {
				scanner.nextLine();
			}
			int testCase = 1;
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				Scanner iscn = new Scanner(line);
				s = iscn.nextInt();
				t = iscn.nextInt();
				iscn.close();
				
				int counter = 0;
				for(int i=s; i<=t; i++) {
					for(int j=s; j<i; j++) {
						if(isRecycled(i+"", j+"")) {
							counter++;
						}
					}
				}
				
				System.out.println("Case #"+testCase+": " +counter);
				testCase++;
			}
		} catch (IOException e) {
			System.err.println("could not open file");
		}
		
		
	}


	private static boolean isRecycled(String a, String b) {
		for(int i=1; i<a.length(); i++) {
			if(cycleBy(a, i).equals(b)) {
				return true;
			}
		}
		return false;
	}
	
	public static String cycleBy(String str, int places) {
		return str.substring(places) + str.substring(0, places);
	}
	
}
