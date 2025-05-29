import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class RecycledNumbers {
	
	public static long shift(long a, byte n){
		return ((a % (long)Math.pow(10, n-1)) * 10 + (a / (long)Math.pow(10, n-1)));
	}
	
	public static byte numberOfDigits(long a){
		byte n = 0;
		while (a > 0){
			n++;
			a /= 10;
		}
		return n;
	}
	
	public static void main(String[] args){
		File in = new File(args[0]);
		File out = new File("b.out");
		FileOutputStream w = null;
		Scanner s = null;
		try{
			w = new FileOutputStream(out);
			s = new Scanner(in);
		} catch (FileNotFoundException e) {}
		int n = s.nextInt();
		for (int i = 1; i <= n; i++){
			long a = s.nextLong();
			long b = s.nextLong();
			byte an = numberOfDigits(a);
			long count = 0;
			
			for(long j = a; j<=b; j++){
				List<Long> l = new LinkedList<Long>();
				long num = j;
				for (byte k = 1; k < an; k++){
					num = shift(num, an);
					if ((num > j) && (num <= b) && !l.contains(num)){
						//System.out.println(j+", "+num);
						l.add(num);
						count++;
					}
				}
			}
			try {
				w.write(("Case #"+ i +": "+count+"\r\n").getBytes());
			} catch (IOException e) {
			}
		}
		try {
			w.close();
			s.close();
		} catch (IOException e) {}
	}

}
