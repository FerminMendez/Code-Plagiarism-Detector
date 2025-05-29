import java.util.Scanner;
import java.io.*;
import java.lang.Math;


public class C{
	public static int recycle(String str){
		String[] numbers = str.split(" ");
		int min = Integer.parseInt(numbers[0]);
		int max = Integer.parseInt(numbers[1]);
		int ret = 0;

		for(int i = min; i < max; i++){
			String num = i + "";
			int len = num.length();
			int k = i;
			for(int j = 1; j < len; j++){
				k = (k/10) + (int)java.lang.Math.pow(10.0,(double)(len-1))*(k%10);
				if (k > i && k <= max)
					ret++;
				else if(k == i)
					break;
			}
		}

		return ret;
	}

	public static void main(String[] args){
		Scanner sc = null;
		String next;
		int out;
		try{
			sc = new Scanner(new File("C-small-attempt0.in"));
			int cases = Integer.parseInt(sc.nextLine());
			int current = 0;
			

			FileWriter fs = new FileWriter("output.txt");
			BufferedWriter buff = new BufferedWriter(fs);
			while(current < cases){
				next = sc.nextLine();
				current++;
				out = recycle(next);
				buff.write("Case #" + current + ": " + out + "\n");
			}
			buff.close();
		}
		catch(Exception ex){}
	}
}