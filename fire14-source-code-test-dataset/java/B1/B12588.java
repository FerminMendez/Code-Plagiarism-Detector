import java.util.*;
import java.io.*;

public class Recycled {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();

		for (int i = 1; i<=cases; i++) {
			int n = in.nextInt();
			int m = in.nextInt();

			int count = 0;
			for (int b = m; b>n; b--) {
				for (int a = n; a<b; a++) {
					String nStr = String.valueOf(a);
					String mStr = String.valueOf(b);

					for (int j = 1; j<nStr.length(); j++) {
						if ((nStr.substring(j) + nStr.substring(0, j)).equals(mStr)) {
							count++;
							break;
						}
					}
				}
			}

			System.out.println("Case #"+i+": "+count);
		}
	}
}
