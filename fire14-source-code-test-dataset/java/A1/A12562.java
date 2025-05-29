import java.io.*;

public class B extends CodeJammer {

	public void process() throws IOException {
		int[] input = reader.readArray();
		int n = input[0];
		int s = input[1];
		int p = input[2];
		int auto =0; //scores that reach p automatically
		int poss = 0; //scores that can reach p with surprise
		for (int i=3; i<n+3; i++) {
			int score = input[i];
			int def = (score/3);
			int mod = (score%3);
			if (mod != 0) def++;//ceiling, not floor
			if (def >= p) auto++;
			else if (def == p-1 && def > 0 && mod != 1) poss++;
		}
		if (poss > s) poss = s; //cap number of surprising scores that reach p
		output(auto+poss);
	}

	public static void main(String[] args) {
		B b = new B();
		b.run(args);
	}

}
