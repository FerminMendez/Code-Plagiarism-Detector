package gcj2012.qr;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ProblemB {
	public static void main(String[] args) throws FileNotFoundException, IOException{		
		BufferedReader br = new BufferedReader(new FileReader("B-small-attempt0.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("B-small-attempt0.out"));
		int t = Integer.parseInt(br.readLine());
		int n, surpresas, melhor;
		for (int i=1; i<=t; i++){
			String campos[] = br.readLine().split(" ");
			n = Integer.parseInt(campos[0]);
			surpresas = Integer.parseInt(campos[1]);
			melhor = Integer.parseInt(campos[2]);
			int total = 0;
			for (int j=0; j<n; j++){
				int resultado = Integer.parseInt(campos[3 + j]);
				int media = resultado / 3;
				int sobra = resultado % 3;
				if (media >= melhor){
					total++;
				}else if (sobra >= 1 && media + 1 <= 10 && media + 1 >= melhor){
					total++;
				}else if (sobra == 2 && surpresas > 0 && media + 2 <= 10 && media + 2 >= melhor){
					total++;
					surpresas--;
				}else if (media >= 1 && media + 1 <= 10 && surpresas > 0 && media + 1 >= melhor){
					total++;
					surpresas--;					
				}
			}
			bw.write("Case #" + i + ": " + total + "\n");
		}
		br.close();
		bw.close();
	}
}
