import java.io.*;
import java.util.Scanner;

public class Main {
	public static void main (String[] args) {
		int i = 1;
		try{
			BufferedReader in = new BufferedReader(new FileReader("input.txt"));
			String ligne;
			ligne = in.readLine();
			ligne = in.readLine();
			while (ligne != null) {
				System.out.print("Case #" + i + ": ");
				Scanner sc = new Scanner(ligne);
				int nbDanseurs = sc.nextInt();
				int nbSurprises = sc.nextInt();
				int objectif = sc.nextInt();
				int rep = 0;
				int minSansSurprise = objectif + 2*Math.max(0, objectif-1);
				int minAvecSurprise = objectif + 2*Math.max(0, objectif-2);
				for (int j=0;j<nbDanseurs;j++) {
					int score = sc.nextInt();
					if (score >= minSansSurprise) {
						rep++;
					} else if (score >= minAvecSurprise && nbSurprises > 0) {
						rep++;
						nbSurprises--;
					}
				}
				i++;
				System.out.println(rep);
				ligne = in.readLine();
			}
			in.close();
		}
		catch (Exception e){
			System.err.println("Erreur !");
		}
	}
}
