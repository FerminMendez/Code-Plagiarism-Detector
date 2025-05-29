import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class ProblemC {

    public static int count(int A, int B) {
	int count = 0;
	for (int n = A; n < B; ++n) {
	    int l = (int) Math.log10(n) + 1;
	    int m = n;
	    HashSet<Integer> set = new HashSet<Integer>();
	    for (int i = 0; i < l; ++i) {
		m = m / 10 + ((int) Math.pow(10, l-1)) * (m % 10);
		if (m > n && m <= B) {
		    set.add(m);
		}
	    }
	    count += set.size();
	}
	return count;
    }

    public static void main(String[] args) throws IOException {
	String filename = args[0];
	BufferedReader br = new BufferedReader(new FileReader(filename));

	int T = Integer.parseInt(br.readLine());
	for (int i = 1; i <= T; ++i) {
	    String[] line = br.readLine().split(" ");

	    int A = Integer.parseInt(line[0]);
	    int B = Integer.parseInt(line[1]);
	    System.out.println("Case #" + i + ": " + count(A, B));
	}
    }
}