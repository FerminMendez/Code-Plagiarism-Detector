package br.com.problema.c;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class ProblemaC {
	static String caminho = "/home/mateus/";

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File(caminho + "entrada.txt"));
		FileWriter writer = new FileWriter(new File("/home/mateus/saida.txt"), false);

		int cases = sc.nextInt();

		for (int i = 1; i <= cases; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int resposta = 0;
			for (int num = A; num <= B; num++) {
				resposta += new Numero(num).quantNumRecycled(B);
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
