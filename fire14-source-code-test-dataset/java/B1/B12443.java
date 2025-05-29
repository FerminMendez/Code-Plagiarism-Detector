import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("input"));
		PrintWriter out =  new PrintWriter(new BufferedWriter
				   (new FileWriter("output")));
		int T = scan.nextInt();
		int compteur =1;
		while(T-->0){
			int A = scan.nextInt();
			int B=scan.nextInt();
			int nbDig = (A+"").length();
			int pui = 1;
			for(int i=0;i<nbDig-1;i++){
				pui*=10;
			}
			int rec = 0;
			int[] tab  = new int[nbDig-1];
			for(int i=A;i<B;i++){
				int u=i;
				for(int n=0;n<nbDig-1;n++){
					int mod = u%10;
					u = (u/10)+mod*pui;
					tab[n]=u;
					boolean deja = true;
					for(int j=0;j<n;j++){
						if(tab[j]==u){
							deja=false;
						}
					}
					if(u>i&&u<=B&&deja){
						rec++;
					}
				}
			}
			out.println("Case #"+compteur+": "+rec);
			compteur++;
		}
		out.close();
	}

}
