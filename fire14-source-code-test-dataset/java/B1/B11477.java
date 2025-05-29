import java.io.File;
import java.util.HashMap;
import java.util.Scanner;


public class ProblemC {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
		Scanner leitor = new Scanner(new File("problemC.in"));
		int n = leitor.nextInt(); leitor.nextLine();
		for (int caso = 0 ; caso < n; caso++) {
			int a = leitor.nextInt();
			int b = leitor.nextInt();
			leitor.nextLine();
			/* A ≤ n < m ≤ B. */
			if (b > 10) { 
				int resultado[] = new int[b+1];
				for (int i = 0; i < 11; i++) {
					resultado[i] = 0;
				}
				for (int i = a; i <= b; i++) {
					String number = Integer.toString(i);
					int resultadoParcial = resultado[i-1];
					String numberToChange = Integer.toString(i);
					HashMap<Integer, Integer> tiraRepetidos = new HashMap<Integer, Integer>();
					for (int j = 0; j < number.length()-1; j++) {
						String novoNumeroString = numberToChange.substring(j+1) + numberToChange.substring(0,j+1);
						while (novoNumeroString.startsWith("0")) novoNumeroString = novoNumeroString.substring(1);
						int novoNumero = new Integer( novoNumeroString);
						//System.out.println(i + " -> " + novoNumero);
						if (!tiraRepetidos.containsKey(novoNumero)) {
							if ((a <= i ) && 
							(i < novoNumero) && (novoNumero <= b)) {
								resultadoParcial += 1;
							}
							tiraRepetidos.put(novoNumero, novoNumero);
						}
					}
					resultado[i] = resultadoParcial;	
				}
				System.out.println("Case #"+ (caso+1) + ": " + (resultado[b])); 
			} else {
				System.out.println("Case #"+ (caso+1) + ": 0"); 

			}

		}
	}

}
