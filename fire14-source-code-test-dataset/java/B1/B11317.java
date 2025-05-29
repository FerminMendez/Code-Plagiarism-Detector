package recycledNumbers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RecycledNumbers {
	public static void main(String[] args) {
		File inFile = new File(
				"C:\\Users\\Stef\\workspace\\Google Code Jam\\src\\recycledNumbers\\small.in");
		FileInputStream fis = null;
		Scanner in = null;

		FileWriter outFile;
		try {
			outFile = new FileWriter(
					"C:\\Users\\Stef\\workspace\\Google Code Jam\\src\\recycledNumbers\\small.out");
			BufferedWriter out = new BufferedWriter(outFile);

			try {
				fis = new FileInputStream(inFile);

				in = new Scanner(fis);
				int cases, a, b, no;
				cases = in.nextInt();

				for (int i = 0; i < cases; i++) {
					no=0;
					a=in.nextInt();
					b=in.nextInt();
					
					for (int k=a;k<=b-1;k++)
						for (int j=k+1;j<=b;j++) {
							if (recycled(k,j))
								no++;
						}
					out.write("Case #" + (i + 1) + ": " +no+ "\n");
				}

				fis.close();
				in.close();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			out.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private static boolean recycled(int k, int j) {
		int digits=0;
		int kc=k;
		int last;
		int multiply=1;
		while (kc>0) {
			digits++;
			multiply*=10;
			kc/=10;
		}
		multiply/=10;
		for (int i=0;i<digits;i++) {
			last=k%10;
			k/=10;
			k+=last*multiply;
			if (k==j)
				return true;
		}
		return false;
	}
}
