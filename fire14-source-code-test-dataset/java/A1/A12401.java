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
			int N = scan.nextInt();
			int S = scan.nextInt();
			int p = scan.nextInt();
			int max = 0;
			while(N-->0){
				int u = scan.nextInt();
				int quo = u/3;
				int mod = u%3;
				switch(mod){
					case 0:{
						if (quo>=p){
							max++;
						}
						else if(quo+1>=p&&S>0&&quo-1>=0){
							max++;
							S--;
						}
						break;
					}
					case 1:{
						if (quo+1>=p){
							max++;
						}
						break;
					}
					case 2:{
						if (quo+1>=p){
							max++;
						}
						else if(quo+2>=p&&S>0){
							max++;
							S--;
						}
						break;
					}
				}
				
			}
			out.println("Case #"+compteur+": "+max);
			compteur++;
		}
		out.close();
	}

}
