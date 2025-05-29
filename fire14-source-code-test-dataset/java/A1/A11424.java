import java.io.File;
import java.util.Arrays;
import java.util.Scanner;


public class ProblemB {

	public static void main(String[] args) throws Exception {
		
		Scanner leitor = new Scanner(new File("problemBTest.in"));
		int n = leitor.nextInt(); leitor.nextLine();
		for (int i = 0; i < n; i++) {
			int dancers = leitor.nextInt();
			int surp = leitor.nextInt();
			int min = leitor.nextInt();
			int notas[] = new int[dancers];
			for (int j = 0; j < dancers; j++) {
				notas[j] = leitor.nextInt();
			}
			leitor.nextLine();
			Arrays.sort(notas);
			
			int resultado = 0;
			
			int j = 0;
			for (j = dancers-1; j >=0; j--) {
				if (notas[j] > (3 * (min-1))) {
					resultado++;
				} else {
					break;
				}
			}
			
			while (surp > 0 && j >= 0) {
				if ((min-2) >= 0) { 
					if (((notas[j] - min - (min-2)) >= (min-2)) &&
						((notas[j] - min - (min-2)) < (min+2))	) {
						resultado++;
						surp--;
					}
				}
				j--;
			}
			System.out.println("Case #" + (i+1) + ": " + resultado);
		}
	}

}
