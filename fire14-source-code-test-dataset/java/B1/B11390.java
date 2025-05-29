import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Recycled_Numbers {
	public static int recycled(int A, int B) {
		int n = 0, j = 0, m = 0, c = 0;
		String tmp = "", subB = "", subE = "", recycled = "";
		for (n = A; n <= B; n++) {
			// System.out.println("");
			tmp = String.valueOf(n);
			for (j = 0; j < tmp.length(); j++) {
				subB = tmp.substring(0, j + 1);
				subE = tmp.substring(j + 1);
				recycled = subE + subB;
				m = Integer.parseInt(recycled);
				if ((m > n) && (m <= B)) {
					c++;
					//System.out.println(n+","+m);
				}
				// System.out.println(recycled);
			}
		}
		return c;
	}

	public static void main(String[] args) {
		String filename = "/myown/developpement/Google_Code_Jam/recycled_numbers.in";
		String ligne = "";
		StringTokenizer st1;
		int i = 0, j = 0;
		int nbrLigne = 0;
		String tmp = "";
		int A = 0, B = 0;
		try {
			FileInputStream fStream = new FileInputStream(filename);
			BufferedReader in = new BufferedReader(new InputStreamReader(
					fStream));
			if (in.ready()) {
				ligne = in.readLine();
				nbrLigne = Integer.parseInt(ligne);
				for (j = 0; j < nbrLigne; j++) {
					ligne = in.readLine();

					st1 = new StringTokenizer(ligne, " ");
					A = Integer.parseInt(st1.nextToken());
					// tmp = "";
					B = Integer.parseInt(st1.nextToken());
					//System.out.println(A + "," + B);
					System.out.println("Case #"+(j+1)+": " + recycled(A, B));
				}
			}
		} catch (IOException e) {
			System.out.println("File input error");
		}
	}
}
