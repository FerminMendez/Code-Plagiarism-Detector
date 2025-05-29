import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProblemB {

    public static int count(int s, int p, int[] notes) {
	int count = 0;
	for (int note : notes) {
	    if (note + 2 >= 3 * p) {
		count++;
	    } else if (note + 4 >= 3 * p && s > 0 && note >= p) {
		count++;
		s--;
	    }
	}
	return count;
    }

    public static void main(String[] args) throws IOException {
	String filename = args[0];
	BufferedReader br = new BufferedReader(new FileReader(filename));

	int T = Integer.parseInt(br.readLine());
	for (int i = 1; i <= T; ++i) {
	    String[] line = br.readLine().split(" ");

	    int N = Integer.parseInt(line[0]);
	    int s = Integer.parseInt(line[1]);
	    int p = Integer.parseInt(line[2]);
	    int[] notes = new int[N];

	    for (int j = 0; j < N; ++j) {
		notes[j] = Integer.parseInt(line[3+j]);
	    }

	    System.out.println("Case #" + i + ": " + count(s, p, notes));
	}

	br.close();
    }

}