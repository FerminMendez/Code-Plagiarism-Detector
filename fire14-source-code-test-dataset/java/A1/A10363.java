import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class DancingWithTheGooglers {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		// TODO Auto-generated method stub

		FileInputStream fstream = new FileInputStream("C:\\input.txt");
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));

		int cases = Integer.parseInt(br.readLine());
		String mainOutput = "";

		for (int c = 0; c < cases; c++) {

			String str = br.readLine();
			//mainOutput = mainOutput + str + "\n";
			StringTokenizer stringTokenizer = new StringTokenizer(str);

			int n = Integer.parseInt(stringTokenizer.nextToken());
			int s = Integer.parseInt(stringTokenizer.nextToken());
			int p = Integer.parseInt(stringTokenizer.nextToken());
			int count = 0;
			int equal = 0;
			int surpriseElement = 0;
			int nonSurpriseElement = 0;
			
			int surpriseElements[] = new int[n];
			int nonSurpriseElements[] = new int[n];
			int i;
			for (i = 0; i < n; i++) {

				int x = Integer.parseInt(stringTokenizer.nextToken());
				
				int j1 = 0, j2 = 0, j3 = 0;
				boolean surpriseFlag = false;

				int k = 0;
				while (k < x) {
					j1 = p + k;
					j2 = (x - j1) / 2;
					j3 = x - (j1 + j2);
					
					if (j1 == j3 && j1 == j2 && j2 == j3 && p == j3) {
						equal++;
					}
					if (j1 > 10 || j2 > 10 || j3 > 10 || j1 < 0 || j2 < 0
							|| j3 < 0)
						break;

					if (checkForSurprise(j1, j2, j3)) {
						// System.out.println(s);
						surpriseFlag = true;
						surpriseElements[i] = 1; 
						break;
					}
					k++;
				}

				//Non Surprised Element					
				j1 = x / 3;
				j2 = (x - j1) / 2;
				j3 = x - j1 - j2;

				if (j1 >= p || j2 >= p || j3 >= p) {
					nonSurpriseElements[i] = 1;
				}
			}
			for(int d = 0;d<i;d++){
				if(s>0)
				if(surpriseElements[d] == 1 && nonSurpriseElements[d] == 0){
					nonSurpriseElements[d] = 1;
					s--;
				}
			}
			for(int d = 0;d<i;d++){
				if(nonSurpriseElements[d] == 1){
					count++;
				}
			}
			mainOutput = mainOutput + "Case #"+(c+1)+": "+ count + "\n";
		}

		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(
				"C:\\output.txt"), true));

		bw.write(mainOutput);
		bw.close();

		in.close();

	}

	public static boolean checkForSurprise(int a, int b, int c) {
		boolean surpriseFlag = false;

		int diff_AB = a - b;
		if (diff_AB < 0) {
			diff_AB = diff_AB * -1;
		}
		int diff_AC = a - c;
		if (diff_AC < 0) {
			diff_AC = diff_AC * -1;
		}
		int diff_BC = b - c;
		if (diff_BC < 0) {
			diff_BC = diff_BC * -1;
		}

		if ((diff_AB == 2 && diff_AC == 2 && diff_BC == 0)
				|| (diff_AB == 0 && diff_AC == 2 && diff_BC == 2)
				|| (diff_AB == 2 && diff_AC == 0 && diff_BC == 2)) {
			surpriseFlag = true;
		} else if ((diff_AB == 1 && diff_BC == 1 && diff_AC == 2)
				|| (diff_AB == 1 && diff_BC == 2 && diff_AC == 1)
				|| (diff_AB == 2 && diff_BC == 1 && diff_AC == 1)) {
			surpriseFlag = true;
		}
		return surpriseFlag;

	}
}
