package duarte.codejam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Googlers {

	private static int caseNumber = 1;
	
	public static void main(String[] args) throws IOException{

		List<String> entradas  = new ArrayList<String>();
		BufferedReader input =  new BufferedReader(new FileReader(new File("B-small-attempt3.in")));
		input.readLine();
		while(input.ready())
			entradas.add(input.readLine());
		for(String s : entradas){
			String[] argumentos = s.split(" ");
			String[] notas = Arrays.copyOfRange(argumentos, 3, argumentos.length);
			System.out.println("Case #" + caseNumber++ + ": "+top(Integer.valueOf(argumentos[0]),Integer.valueOf(argumentos[1]),Integer.valueOf(argumentos[2]),notas));
		}
	}
	
	public static int top(int qtdGooglers, int surpresas, int notaMinima, String... notasMaximas){
		int[][] triplets = new int[qtdGooglers][3];
		int googler = 0;
		for(String notaMax : notasMaximas){
			int notaMaxi = Integer.valueOf(notaMax);
			triplets[googler][0] = notaMaxi/3;
			triplets[googler][1] = notaMaxi/3;
			triplets[googler][2] = notaMaxi/3;
			int diff = notaMaxi - (triplets[googler][0] + triplets[googler][1] + triplets[googler][2]);
			if(diff > 0){
				triplets[googler][0] += Math.min(1, diff--);
				triplets[googler][1] += diff;
			}
			googler += 1;
		}
		
		List tripletsTop = new ArrayList();
		for(int[] triplet : triplets){
			if(temNotaMaiorOuIgual(triplet, notaMinima)){
				tripletsTop.add(triplet);
			}
		}
		
		List tripletsAltas = new ArrayList();
		
		for(int[] triplet : triplets){
			if(tripletPossivel(triplet, notaMinima - 1) && !tripletsTop.contains(triplet)){
				tripletsAltas.add(triplet);
			}
		}
		
		
		
		return tripletsTop.size() + Math.min(tripletsAltas.size(), surpresas);
	}

	private static boolean tripletPossivel(int[] triplet, int i) {
		int notasProximas = 0;
		if(triplet[0] == i) notasProximas++;
		if(triplet[1] == i) notasProximas++;
		if(triplet[2] == i) notasProximas++;
		if (notasProximas < 2) return false;
		return (triplet[0] + triplet[1] + triplet[2] > i );
	}

	private static boolean temNotaMaiorOuIgual(int[] triplet, int notaMinima) {
		return (triplet[0] >= notaMinima || triplet[1] >= notaMinima || triplet[2] >= notaMinima );
	}

	public static int top(int qtdGooglers, int surpresas, int notaMinima, int... i) {
		String[] notas = new String[i.length];
		for(int j = 0 ; j < i.length; j++)
			notas[j] = String.valueOf(i[j]);
		return top(qtdGooglers, surpresas, notaMinima, notas);
	}
	
}
