import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;


public class G2 {
	private static Scanner inp;
	private static Formatter out;
	private static int T = 0;
	private static int g = 0;
	private static int s = 0;
	private static int p = 0;
	private static int cnt = 0;
	private static int tmp = 0;
	
	public static void main(String[] args) {
		try {
			inp = new Scanner(new File("test.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
		try {
			out = new Formatter("out.txt");
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
		T = inp.nextInt();
		inp.nextLine();
		for(int i = 0; i < T; i++) {
			out.format("Case #%d: ", i+1);
			cnt = 0;
			g = inp.nextInt();
			s = inp.nextInt();
			p = inp.nextInt();
			for(int j = 0; j < g; j++) {
				tmp = inp.nextInt();
				if(tmp >= p*3-2) {
					cnt++;
				} else if(tmp >= p*3-4 && s > 0 && tmp > 0){
					cnt++;
					s--;
				}
			}
			out.format("%d\r\n", cnt);
		}
		inp.close();
		out.close();
	}
}
