package gcj2012.qr;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ProblemC {
	public static void main(String[] args) throws FileNotFoundException, IOException{
		String nomeArquivo = "C-small-attempt0";
		
		BufferedReader br = new BufferedReader(new FileReader(nomeArquivo + ".in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter(nomeArquivo + ".out"));
		int t = Integer.parseInt(br.readLine());
		for (int i=1; i<=t; i++){
			String campos[] = br.readLine().split(" ");
			int na = Integer.parseInt(campos[0]);
			int nb = Integer.parseInt(campos[1]);
			int total = 0;
			for (int m=na; m<nb; m++){
				for (int n=m+1; n<=nb; n++){
					String a = String.valueOf(m);
					String b = String.valueOf(n);
					int pb = b.indexOf(a.charAt(0));
					boolean achou = false;
					while (pb >= 0){
						int pa = 0;
						int x = pb;
						while (a.charAt(pa++) == b.charAt(pb++)){
							if (pb >= b.length()) pb = 0;
							if (pa >= a.length()){
								achou = true;
								break;
							}
						}
						if (achou){
							total++;
							break;
						}
						pb = b.indexOf(a.charAt(0), x+1);
					}
				}
			}
			bw.write("Case #" + i + ": " + total + "\n");
		}
		br.close();
		bw.close();
	}

}
