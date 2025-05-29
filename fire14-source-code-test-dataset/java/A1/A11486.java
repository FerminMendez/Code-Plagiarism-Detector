import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Dancing {

	public static void main(String[] args) throws IOException {

		int count = 0;
		int special = 0;
		int googler = 0;
		int best = 0;
		int sp_co = 0;
		int sat = 0;
		
		Scanner scanInput = new Scanner(System.in);
		String target = scanInput.next();

		File inputFile = new File(target);
		Scanner fileScan = new Scanner(inputFile);

		String outpFileName = "output.txt";
		FileWriter googlewriter = null;
		googlewriter = new FileWriter(outpFileName);

		PrintWriter diskFile = new PrintWriter(googlewriter);

		count = fileScan.nextInt();


		for (int i = 0; i < count; i++) {
			googler = fileScan.nextInt();
			special = fileScan.nextInt();
			best = fileScan.nextInt();
			sp_co = 0;
			sat = 0;

			int[][] scores = new int[googler][3];
			int[] totscores = new int[googler];

			for (int j = 0; j < googler; j++)
				totscores[j] = fileScan.nextInt();

			for (int j = 0; j < googler; j++) {
				scores[j][0] = totscores[j] / 3;
				scores[j][1] = totscores[j] / 3;
				scores[j][2] = totscores[j] / 3;
			}

			for (int j = 0; j < googler; j++) {
				if (scores[j][0] + scores[j][1] + scores[j][2] != totscores[j]) {
					if (totscores[j] - scores[j][0] - scores[j][1]
							- scores[j][2] == 2) {
						scores[j][0]++;
						scores[j][2]++;
					}
					if (totscores[j] - scores[j][0] - scores[j][1]
							- scores[j][2] == 1) {
						scores[j][0]++;
					}
				}
			}


			for (int m = 0; m < googler; m++) {
				if (scores[m][0] >= best || scores[m][1] >= best
						|| scores[m][2] >= best) {
				} 
				else if (sp_co < special && scores[m][0] != 0 && scores[m][0] + 1 == best){
					scores[m][0]--;
					scores[m][2]++;
					sp_co++;
				}
			}
			
			
			for (int m = 0; m < googler; m++) {
				if (scores[m][0] >= best || scores[m][1] >= best || scores[m][2] >= best )
					sat++;
			}

			
			
			
			
			
			
			
			diskFile.print("Case #" + (i + 1) + ": " + sat + "\n");
			
			
			
		}
		
		
	
		diskFile.close();

	} // end of main

} // end of class
