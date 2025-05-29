import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Dancing {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("B-small-attempt0.in"));
		FileWriter fstream = new FileWriter("Bout.txt");
		BufferedWriter outp = new BufferedWriter(fstream);
		int cases = sc.nextInt();
		for (int r = 0; r < cases; r++) {
			int total = 0;
			int totalS = 0;
			int N = sc.nextInt();
			int S = sc.nextInt();
			int p = sc.nextInt();
			int[] NN = new int[N];
//			System.out.println("Surprising: =" + S);
			for (int rr = 0; rr < N; rr++) {
				NN[rr] = sc.nextInt();
				int a = NN[rr] / 3;
				int b = (NN[rr] - a) / 2;
				int c = NN[rr] - a - b;
				// find surprising score
				// int lowest=a<b?a:b;
				// lowest=lowest<c?lowest:c;
				// int highest=b>a?b:a;
				// highest=highest>c?highest:c;

				// a- b+
				int max = max(a, b, c);
				int maxS = max;

				int a1 = a - 1;
				int b1 = b + 1;
				int c1 = c;
				if (maxDiff(a1,b1,c1)<3&&max(a1, b1, c1) > maxS)
					maxS = max(a1, b1, c1);

				// a- c+
				a1 = a - 1;
				b1 = b;
				c1 = c + 1;
				if (maxDiff(a1,b1,c1)<3&&max(a1, b1, c1) > maxS)
					maxS = max(a1, b1, c1);

				// a+ b-
				a1 = a + 1;
				b1 = b - 1;
				c1 = c;
				if (maxDiff(a1,b1,c1)<3&&max(a1, b1, c1) > maxS)
					maxS = max(a1, b1, c1);

				// a+ c-
				a1 = a + 1;
				b1 = b;
				c1 = c - 1;
				if (maxDiff(a1,b1,c1)<3&&max(a1, b1, c1) > maxS)
					maxS = max(a1, b1, c1);

				// b- c+
				a1 = a;
				b1 = b - 1;
				c1 = c + 1;
				if (maxDiff(a1,b1,c1)<3&&max(a1, b1, c1) > maxS)
					maxS = max(a1, b1, c1);

				// b+ c-
				a1 = a;
				b1 = b + 1;
				c1 = c - 1;
				if (maxDiff(a1,b1,c1)<3&&max(a1, b1, c1) > maxS)
					maxS = max(a1, b1, c1);

				if (max >= p)
					total++;
				if (maxS >= p)
					totalS++;
//				System.out.println(a+" "+b+" "+c+" "+max+" "+maxS);
			}
//			System.out.println(total + " " + totalS);
			int fin=total;
			if (total+S>totalS)fin=totalS;
			else fin=total+S;
            
			System.out.println("Case #" + (r + 1) + ": " + fin);
			outp.write("Case #" + (r + 1) + ": " + fin+"\n");
		}
		outp.flush();
		fstream.close();
	}

	public static int maxDiff(int a, int b, int c) {
		if (a<0||b<0||c<0||a>10||b>10||c>10)return 100;
		double diff1 = Math.abs(a - b);
		double diff2 = Math.abs(a - c);
		double diff3 = Math.abs(b - c);
		return (int) Math.max(Math.max(diff1, diff2), diff3);
	}

	public static int max(int a, int b, int c) {
		return (a > b ? a : b) > c ? (a > b ? a : b) : c;
	}

}
