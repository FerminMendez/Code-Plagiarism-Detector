import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class GCJ12QRC
{
	private static int a, b, d;
	private static long c;
	private static String output, newline = System.getProperty("line.separator");

	public static void fun()
	{
		String s;
		int i, j, k;
		c = d = 0;
		for(i=a; i>0; i/=10)
			d++;

		for(i=a; i<b; i++) {
			s = "" + i;
			for(j=1; j<d; j++) {
				k = Integer.parseInt(s.substring(j) + s.substring(0, j));
				if(k>i && k<=b) {
					System.out.println(i + " " + k);
					c++;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException
	{
		long t2, t1 = System.currentTimeMillis();
		output = "";
		Scanner sc = new Scanner(new File("C-small-attempt0.in"));
		int ntc = sc.nextInt();

		for(int w=1; w<=ntc; w++)
		{
			a = sc.nextInt();
			b = sc.nextInt();
			fun();
			output += "Case #" + w + ": " + c + newline;
		}
		sc.close();

		OutputStream fo = new FileOutputStream("C-small-attempt0.out");
		fo.write(output.getBytes());
		fo.close();
		t2 = System.currentTimeMillis();
		System.out.println( "Time in millis : " + (t2-t1) );
	}
}
