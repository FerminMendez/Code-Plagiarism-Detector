package br.com;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ProblemaB {
	static String caminho = "/home/mateus/";

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File(caminho + "entrada.txt"));
		FileWriter writer = new FileWriter(new File("/home/mateus/saida.txt"), false);

		int cases = sc.nextInt();

		for (int i = 1; i <= cases; i++) {
			if (i == 3) {
				System.out.println("");
			}
			int n = sc.nextInt();
			int s = sc.nextInt();
			int p = sc.nextInt();
			int resposta = 0;
			ArrayList<Tripla> triplas = new ArrayList<Tripla>();

			for (int j = 0; j < n; j++) {
				triplas.add(new Tripla(sc.nextInt()));
			}
			for (int w = triplas.size() - 1; w >= 0; w--) {
				if (triplas.get(w).maximaPontuacao() >= p) {
					resposta++;
					triplas.remove(w);
				}
			}

			for (int w = 0; w < triplas.size() && s > 0; w++) {
				if (triplas.get(w).maximaPontuacaoEspecial() >= p) {
					s--;
					resposta++;
				}
			}
			writer.append(criarCase(i, resposta + ""));
		}
		writer.flush();
		writer.close();
	}

	public static String criarCase(int i, String s) {
		return "Case #" + i + ": " + s + "\n";
	}
}
