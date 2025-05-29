package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DancingWithTheGooglers {

	public static void main(String... args) throws NumberFormatException, IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
		
		int qtd = Integer.parseInt(buffer.readLine());
		
		List<String> saida = new ArrayList<String>();
		for (int i = 1; i <= qtd; i++) {
			saida.add("Case #" + i + ": " + qtdMelhoresResultados(buffer.readLine()));
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
	
	public static int qtdMelhoresResultados(String entrada) {
		String[] argumentos = entrada.split(" ");
		
		int qtdGooglers = Integer.valueOf(argumentos[0]);
		int notasSurpresas = Integer.valueOf(argumentos[1]);
		int notaCorte = Integer.valueOf(argumentos[2]);
		
		int qtdMelhoresResultados = 0;
		int surpresasUtilizados = 0;
		for (int i = 0; i < qtdGooglers; i++) {
			int notaGoogler = Integer.valueOf(argumentos[3+i]);
			
			int mediaNota = notaGoogler / 3;
			
			int nota1 = mediaNota;
			int nota2 = mediaNota;
			int nota3 = mediaNota;
			
			if (nota1 + nota2 + nota3 != notaGoogler) {
				nota3++;
			}
			
			if (nota1 + nota2 + nota3 != notaGoogler) {
				nota2++;
			}
			
			if (nota1 + nota2 + nota3 != notaGoogler) {
				throw new RuntimeException("Something went terribly wrong: " + entrada );
			}
			
			if (nota1 >= notaCorte || nota2 >= notaCorte || nota3 >= notaCorte) {
				qtdMelhoresResultados++;
				continue;
			}

			if (surpresasUtilizados == notasSurpresas) {
				continue;
			}
			
			if (nota2 > 0 && (nota3+1) - (nota2 - 1) <= 2) {
				nota2--;
				nota3++;
				
				if (nota1 >= notaCorte || nota2 >= notaCorte || nota3 >= notaCorte) {
					qtdMelhoresResultados++;
					surpresasUtilizados++;
				}
			}
		}
		
		return qtdMelhoresResultados;
	}


}
