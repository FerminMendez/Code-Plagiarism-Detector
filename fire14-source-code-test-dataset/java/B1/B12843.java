import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class G3 {
	private static Scanner inp;
	private static Formatter out;
	private static int T = 0;
	private static int A = 0;
	private static int B = 0;
	private static int cnt = 0;
	private static ArrayList<Integer> arr;
	private static ArrayList<String> arr2;
	
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
		arr = new ArrayList<Integer>();
		arr2 = new ArrayList<String>();
		for(int i = 0; i < T; i++) {
			out.format("Case #%d: ", i+1);
			A = inp.nextInt();
			B = inp.nextInt();
			cnt = 0;
			arr.clear();
			arr2.clear();
			for(int j = A; j <= B; j++) {
				for(int k = 1; k < Math.ceil(Math.log10(j)); k++) {
					int tmp = move(j,k);
					//(arr.indexOf(tmp) == -1 || arr.indexOf(j) == -1)
					if(tmp >= A && tmp <= B && (arr2.indexOf(tmp+""+j) == -1 || arr2.indexOf(j+""+tmp) == -1) && tmp != j) {
						cnt++;
						arr.add(j);
						arr.add(tmp);
						arr2.add(tmp+""+j);
						arr2.add(j+""+tmp);
						//System.out.println(j+":"+tmp);
						//break;
					}
				}
			}
			out.format("%d\r\n", cnt);
			//System.out.println("Case #"+(i+1)+": "+cnt);
		}
		inp.close();
		out.close();
	}
	
	public static int move(int n1, int n0) {
		int n2 = n1 % (int) Math.pow(10, n0);
		double n3 = Math.floor(Math.log10(n1));
		int n4 = (n1 - n2) / (int) Math.pow(10, n0);
		double n5 = Math.pow(10, n3+1-n0) * n2;
		double n6 = n5 + n4;
		return (int) n6;
	}
}
