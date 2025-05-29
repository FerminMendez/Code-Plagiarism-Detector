import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class GCJ12QRB
{
	private static int n, s, p, count, x, y;
	private static String output, newline = System.getProperty("line.separator");

	private static void fun(String src) throws IOException
	{
		output = "";
		Scanner sc = new Scanner(new File(src));
		int i, ntc = sc.nextInt();

		for(int w=1; w<=ntc; w++)
		{
			n = sc.nextInt();
			s = sc.nextInt();
			p = sc.nextInt();
			count = 0;

			for(i=0; i<n; ++i) {
				x = sc.nextInt();
				if(x == 0) {
					if(p == 0)
						count++;
					continue;
				}
				y = x % 3;
				if(y == 0) {
					y = x / 3;
					if(y >= p)
						count++;
					else if(s > 0 && y + 1 >= p) {
						s--;
						count++;
					}
				}
				else if(y == 2) {
					y = x / 3;
					if(y + 1 >= p)
						count++;
					else if(s > 0 && y + 2 >= p) {
						s--;
						count++;
					}
				}
				else {
					y = x / 3;
					if(y + 1 >= p)
						count++;
				}
			}

			output += "Case #" + w + ": " + count + newline;
		}
		sc.close();
	}

	public static void main(String[] args) throws IOException
	{
		fun("B-small-attempt0.in");
		OutputStream fo = new FileOutputStream("B-small-attempt0.out");
		fo.write(output.getBytes());
		fo.close();
	}
}
