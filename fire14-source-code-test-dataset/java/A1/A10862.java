package score;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Score1 {
	public static void main(String[] args)throws IOException {
		File file = new File("B-small-attempt0.in");
		BufferedWriter saida = new BufferedWriter(new FileWriter("saida.out"));
		Scanner scan = new Scanner(file);
		int casos;
		String[] divisao = {};
		String linha;
		
		casos = Integer.parseInt(scan.nextLine());
		
		
		for (int  i =1; i <= casos;i++){
			saida.write("Case #" + i + ": ");			int alcancou = 0;
			int podeSurpresa = 0;
			linha = scan.nextLine();
			divisao = linha.split("\\s+");
			int competidores = Integer.parseInt(divisao[0]);
			int surpresas = Integer.parseInt(divisao[1]);
			int notaMin = Integer.parseInt(divisao[2]);

			
			ArrayList<Integer> placar = new ArrayList<Integer>(competidores);
			
			for(int j = 0; j < competidores ; j++){
				placar.add(j, Integer.parseInt(divisao[3+j]));
			}
			for(int j = 0;j < competidores;j++){
				if(placar.get(j) == 3*notaMin-4 || placar.get(j) == 3*notaMin-3 && 3*notaMin - 4 >= 0 ){
					if(podeSurpresa < surpresas){
						podeSurpresa++;
						alcancou++;
					}
				}
				else if(placar.get(j) > 3*notaMin-3){
					alcancou++;
				}
			}
			saida.write(alcancou + "");
			saida.newLine();
		}
		
		if (saida != null){
			saida.flush();
			saida.close();
		}

	}

}
