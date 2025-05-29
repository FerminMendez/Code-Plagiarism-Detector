package dancingWithTheGooglers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.Writer;
import java.util.Arrays;
import java.util.Scanner;

public class DancingWithTheGooglers {

	public static String processaCaso(String linha, int i) {
		Scanner scan = new Scanner(new StringReader(linha));
		int numGooglers = scan.nextInt();
		int numSurprising = scan.nextInt();
		int p = scan.nextInt();
		int [] scores = new int[numGooglers];
		for (numGooglers--; numGooglers >= 0; numGooglers--) {
			scores[numGooglers] = scan.nextInt();
		}
		Arrays.sort(scores);
		int maxBestResult = 0;
		int idxMaiorQP = scores.length -1;
		for (; idxMaiorQP >= 0; idxMaiorQP--) {
			int resto = scores[idxMaiorQP]%3;
			int bestResult = scores[idxMaiorQP]/3;
			if (resto > 0) bestResult += 1;
			if (bestResult < p) break;
			maxBestResult++;
		}
		while (numSurprising > 0 && idxMaiorQP >= 0) {
			int resto = scores[idxMaiorQP]%3;
			int bestResult = scores[idxMaiorQP]/3;
			if (bestResult > 0 && resto == 0) bestResult += 1;
			else bestResult += resto;
			if (bestResult < p) break;
			maxBestResult++;
			numSurprising--;
			idxMaiorQP--;
		}
		return String.format("Case #%d: %d", i, maxBestResult);
	}
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File(args[0]));
        int numTestCases = scan.nextInt();
        scan.nextLine();
        Writer saida = new FileWriter(args[0]+".out");
		for (int i = 1 ; i <= numTestCases; i++) {
			saida.write(processaCaso(scan.nextLine(),i)+"\n");
		}
		saida.close();
	}

}
