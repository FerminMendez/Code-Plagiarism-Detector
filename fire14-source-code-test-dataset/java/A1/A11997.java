import java.util.Scanner;
import java.io.*;
public class Dancing {

	public static void main(String [ ] args) throws Exception{
		Scanner in = new Scanner(new File(args[0]));
		PrintStream Output = new PrintStream(new FileOutputStream("soluzione.txt"));
		int n = in.nextInt();
		for(int i = 1; i <= n; i++){
			int tot, a, b, c;
			int contatore = 0;
			int partecipanti  = in.nextInt();
			int triplSorp = in.nextInt();
			int punteggio = in.nextInt();
			for(int j = 0; j < partecipanti; j++){
				tot = in.nextInt();
				a = tot/3;
				b = a;
				c = a;
				if (a > punteggio) contatore++;
				else{
					if (tot == (a + b + c)){ // solo in questo caso si puo avere un risultato sorpreendente
						if (a >= punteggio) contatore++;

						else if (triplSorp != 0 && a > 1){
							a++;
							if (a >= punteggio){
								contatore++;
								triplSorp--;
							}
						}
					}
					else {
						b++;
						if (tot == (a + b + c)){
							if (a >= punteggio) contatore++;
							else if (b >= punteggio) contatore++;
						}
						else{
							c++;
							if (tot == (a + b + c)){
								if (a >= punteggio) contatore++;
								else if (b >= punteggio) contatore++;
								else if(triplSorp != 0) {
									c--;
									b++;
									if (tot == (a + b + c)){							
										if (b >= punteggio) {
											triplSorp--;
											contatore++;
										}
									}

								}
							}
						}	
					}
				}
				
			}
			String x = "Case #" + i + ": "+ contatore;
			Output.println(x);
		}
	}
}
