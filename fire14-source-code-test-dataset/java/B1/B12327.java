import java.io.*;
import java.util.*;

public class Java{

	public static void main(String[] args) {
		try {
			BufferedReader in = new BufferedReader(new FileReader("C-small-attempt1.in"));
			int cases = Integer.parseInt(in.readLine());
			for (int i = 1; i <= cases; i ++){
				String[] temp = (in.readLine()).split(" ");
				int A = Integer.parseInt(temp[0]);
				int B = Integer.parseInt(temp[1]);
				logic(A, B, i);
			}
			in.close();
		} catch (IOException e) {
			System.out.println("INPUT ERROR");
		}
	}

	public static void logic(int A, int B, int caseNum){
		int num = A, result = 0;
		while (num < B){
			int factor = 10;
			int toFront = num%factor;
			int toBack = num/factor;
			int prev = -1;
			while (toFront < num){
				int x = Integer.parseInt(toFront+""+toBack);
				if (x > num && x <= B && x != prev){
					result ++;
					prev = x;
				}
				factor *= 10;
				toFront = num%factor;
				toBack = num/factor;
			}
			num ++;
		}
		System.out.println("Case #" + caseNum + ": " + result);
	}
}