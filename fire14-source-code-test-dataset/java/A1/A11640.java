package exercicio.b;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ExerciocioB {

	public static void main(String args[]) throws IOException {

		int[][] combinacoes = new int[1331][3];

		for (int i = 0; i <= 10; i++) {
			for (int j = 0; j <= 10; j++) {
				for (int k = 0; k <= 10; k++) {
					combinacoes[i * 121 + j * 11 + k][0] = i;
					combinacoes[i * 121 + j * 11 + k][1] = j;
					combinacoes[i * 121 + j * 11 + k][2] = k;
				}
			}
		}

		File fileInput = new File("src/exercicio/b/input.txt");

		FileReader fileReaderInput = new FileReader(fileInput);

		BufferedReader leitorInput = new BufferedReader(fileReaderInput);

		String numeroLinhas = leitorInput.readLine();
		Integer numero = new Integer(numeroLinhas);

		String linhaInput = null;
		for (int j = 0; j < numero; j++) {
			linhaInput = leitorInput.readLine();
			String[] linha = linhaInput.split(" ");

			Integer numeroGoo = new Integer(linha[0]);
			Integer numeroSurp = new Integer(linha[1]);
			Integer minScore = new Integer(linha[2]);

			int[] pontos = new int[numeroGoo];
			
			for(int b = 0; b< numeroGoo; b++){
				pontos[b] = new Integer(linha[b+3]);
			}

			boolean[] semSurp = new boolean[numeroGoo];
			boolean[] comSurp = new boolean[numeroGoo];
			for (int k = 0; k < numeroGoo; k++) {
				comSurp[k] = false;
				semSurp[k]=false;
				for (int i = 0; i < combinacoes.length; i++) {
					if (Math.abs(combinacoes[i][0] - combinacoes[i][1]) <= 1
							&& Math.abs(combinacoes[i][0] - combinacoes[i][2]) <= 1
							&& Math.abs(combinacoes[i][1] - combinacoes[i][2]) <= 1
							&& (combinacoes[i][0] + combinacoes[i][1] + combinacoes[i][2]) == pontos[k]
							&& (combinacoes[i][0] >= minScore || combinacoes[i][1] >= minScore || combinacoes[i][2] >= minScore)) {
						semSurp[k] = true;
						break;
					}
				}
				
				for (int i = 0; i < combinacoes.length; i++) {
					if (Math.abs(combinacoes[i][0] - combinacoes[i][1]) <= 2
							&& Math.abs(combinacoes[i][0] - combinacoes[i][2]) <= 2
							&& Math.abs(combinacoes[i][1] - combinacoes[i][2]) <= 2
							&& (combinacoes[i][0] + combinacoes[i][1] + combinacoes[i][2]) == pontos[k]
							&& (combinacoes[i][0] >= minScore || combinacoes[i][1] >= minScore || combinacoes[i][2] >= minScore)) {
						comSurp[k] = true;
						break;
					}
				}
			}
			
			int contaMaior = 0;
			for(int a = 0; a < numeroGoo; a++){
				if(semSurp[a] == true)
					contaMaior++;
			}
			for(int a = 0; a < numeroGoo; a++){
				if(comSurp[a] == true && numeroSurp >0 && !semSurp[a]){
					contaMaior++;
					numeroSurp--;
				} else if (numeroSurp == 0){
					break;
				}
			}
			
			System.out.println("Case #" + (j + 1) + ": "+contaMaior);
		}
	}
}
