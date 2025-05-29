package br.com.problema.c;

import java.util.HashSet;

public class Numero {

	int num;

	public Numero(int num) {
		this.num = num;
	}

	public HashSet<Integer> numRecycled(int B) {
		String s = num + "";
		HashSet<Integer> recycleds = new HashSet<Integer>();
		int numeroCasas = s.length();
		System.out.print(num + "(");
		for (int i = 1; i < numeroCasas; i++) {
			String novoNum = s.substring(s.length() - i, s.length()) + s.substring(0, s.length() - i);
			int aux = Integer.parseInt(novoNum);

			if (aux <= B && aux > num) {
				recycleds.add(aux);
				System.out.print(" " + aux);
			}
		}
		System.out.print(")\n");

		return recycleds;
	}

	public int quantNumRecycled(int B) {
		return numRecycled(B).size();
	}
}
