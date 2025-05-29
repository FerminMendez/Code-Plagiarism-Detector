package recycled;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Recycle {
	public static void main(String[] args)throws IOException {
		BufferedWriter saida = new BufferedWriter(new FileWriter("saida.out"));
		File file = new File("C-small-attempt0.in");
		Scanner scan = new Scanner(file);
		int casos;
		String a;
		String b;
		String linha;
		String[] divisao;
		String novo;
		ArrayList<String> list = new ArrayList<String>();
		int tamanhoN;
		casos = Integer.parseInt(scan.nextLine());
		String n;
		String m;
		for (int  i =1; i <= casos;i++){
			saida.write("Case #" + i + ": ");
			int pares = 0;
			linha = scan.nextLine();
			divisao = linha.split("\\s+");

			a = divisao[0];
			b = divisao[1];

			n = a;
			do{
				m = n;
				tamanhoN = n.length();
				for(int j = 0; j < tamanhoN;j++){
					m = desloca(m);
					novo = ("(" + n + "," + m + ") ");
					if(!(list.contains(novo))){
						if(Long.parseLong(a) <= Long.parseLong(n) && Long.parseLong(n) < Long.parseLong(m) && Long.parseLong(m) <= Long.parseLong(b)){
							pares++;
						}
					}
				}
				n = String.valueOf(Long.parseLong(n) + 1);
			}while(Long.parseLong(n) < Long.parseLong(b));
			System.out.println(pares);
			saida.write(pares + "");
			saida.newLine();
		}
		
		if (saida != null){
			saida.flush();
			saida.close();
		}

	}
	
	public static String desloca(String n){
		StringBuffer temp = new StringBuffer(n);
		char primeiro = n.charAt(0);
		for (int j=1; j < temp.length(); j++)
		{
			char c = n.charAt(j);
			temp.setCharAt(j-1, c);
		}
		temp.setCharAt(n.length()-1, primeiro);
		
		n = temp.toString();
		return n;
	}
	
}
