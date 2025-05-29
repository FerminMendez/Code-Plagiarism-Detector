import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;


public class Dancing {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("./src/input.txt"));
		FileWriter fw = new FileWriter("./src/output.txt");
		int total = sc.nextInt();
		for(int turn = 1; turn <= total; turn++) {
			int res = 0;
			int pos = 0;
			int N = sc.nextInt(), S = sc.nextInt(), p = sc.nextInt();
//				fw.write(N + " " + S + " " + p + "\n");
			for(int i = 0; i < N; i++) {
				int next = sc.nextInt();
//				fw.write(next + " " + (3*p-2) + "\n");
				if (next >= (3*p-2)) {res++;}
				else
					if ((p>=2) && (next >= 3*p-4)) {pos++;}
			}
			if (pos < S){res = res+pos;}
			else {res = res + S;}
			
			fw.write("Case #" + turn + ": " + res + "\n");
		}
		fw.flush();
		fw.close();
	}
}
