import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class C {
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("C-small.in"));
		FileWriter fw = new FileWriter("C-small.out");
		
		int T = in.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int A = in.nextInt();
			int B = in.nextInt();
			int count = 0;
			for(int i = A; i < B; i++) {
				for(int j = i + 1; j <= B; j++) {
					if(isRecycledPair(i, j)) {
						count ++;
					}
				}
			}
			fw.write ("Case #" + tc + ": " + count + "\n");
		}
		fw.flush();
		fw.close();
	}
	
	public static boolean isRecycledPair(int a, int b) {
		boolean isRecycled = false;
		String str1 = Integer.toString(a);
		String str2 = Integer.toString(b);
		int len = str1.length();
		for(int i = 0; i < len - 1; i++ ) {
			str1 = str1.substring(len - 1) + str1.substring(0, len - 1);
			if(str1.equals(str2))
				isRecycled = true;
		}
		return isRecycled;
	}

}
