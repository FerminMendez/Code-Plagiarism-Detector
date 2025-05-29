package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RecycledNumbers {

	public static void main(String... args) throws NumberFormatException, IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
		
		int qtd = Integer.parseInt(buffer.readLine());
		
		List<String> saida = new ArrayList<String>();
		for (int i = 1; i <= qtd; i++) {
			combinacoesFeitas = new HashSet<String>();
			saida.add("Case #" + i + ": " + qtsTemNoIntervalo(buffer.readLine()));
		}
		
		buffer.close();
		
		escrevaNoArquivoASaida("output.txt", saida);
	}

	private static void escrevaNoArquivoASaida(String nomeArquivo, List<String> saida) throws IOException {
		BufferedWriter br = new BufferedWriter(new FileWriter(new File(nomeArquivo)));  
		
		for (String string : saida) {
			br.write(string + "\n");
		}
		  
		br.close(); 
	}
	
	public static int qtsTemNoIntervalo(String linha) {
		String[] valores = linha.split(" ");
		return qtsTemNoIntervalo(Integer.valueOf(valores[0]), Integer.valueOf(valores[1]));
	}
	
	static Set<String> combinacoesFeitas = new HashSet<String>();
	public static int qtsTemNoIntervalo(int inicio, int fim) {
		int tamanhoString = String.valueOf(inicio).length();
		
		int count = 0;
		for (int numeroAtual = inicio; numeroAtual <= fim; numeroAtual++) {
			String numeroAtualString = String.valueOf(numeroAtual);
			
			for(int indiceSubs = 1; indiceSubs < tamanhoString; indiceSubs++) {
				String rabo = numeroAtualString.substring(indiceSubs);
				String cabeca = numeroAtualString.substring(0, indiceSubs);
				
				String novoNumeroString = rabo + cabeca;
				int novoNumero = Integer.valueOf(novoNumeroString);
				novoNumeroString = String.valueOf(novoNumero);
				
				if (inicio <= novoNumero 
					&& numeroAtual < novoNumero 
					&& novoNumero <= fim
					&& numeroAtualString.length() == novoNumeroString.length()
					&& !combinacoesFeitas.contains(numeroAtual + novoNumeroString)) {
					count++;
					combinacoesFeitas.add(numeroAtual + novoNumeroString);
				}
			}
		}

		return count;
	}

}
