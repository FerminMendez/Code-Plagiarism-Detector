import java.io.*;
import java.util.*;

public class C extends CodeJammer {

	public void process() throws IOException {
		long[] input = reader.readLongArray();
		long a = input[0];
		long b = input[1];
		int digits = 0;
		long a1 = a;
		while (a1>0) {
				  a1 /= 10;
				  digits++;
		}
		long total = 0;
		for (long x=a; x<=b; x++) {
			total += count(x,a,b, digits);
		}
		output(total);
	}

	public long count(long x, long a, long b, int d) {
		Set<Long> s = new HashSet<Long>();
		long y = x;
		for (int i=1; i<d; i++) {
			y = rotate(y,d);
			if (y>x && y>=a && y<=b) s.add(y);
  		}
		return s.size();		
	}

	public long rotate(long y, int d) {
		long digit = y%10;
		long rest = y/10;
		digit *= Math.pow(10,d-1);
		return digit + rest;
	}

	public static void main(String[] args) {
			  C c = new C();
			  c.run(args);
	}

}
