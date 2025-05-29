import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.text.html.MinimalHTMLWriter;


public class B {

	
	public static void main(String[] args) throws FileNotFoundException {
		
		//File fich = new File("C:\\b-teste.in");
		File fich = new File("C:\\B-small-attempt5.in");
		Scanner input = new Scanner(fich);

		int num_googlers, num_surp, score_min;
		
		int num_casos, resultado, tmp, resto;

		num_casos = input.nextInt();
		
		for(int i = 0; i < num_casos; i++){
			resultado = 0;
			
			num_googlers = input.nextInt(); 
			num_surp = input.nextInt();
			score_min  = input.nextInt();

			int googlers[] = new int[num_googlers];
			
			for(int j = 0; j < num_googlers; j++){
				googlers[j] = input.nextInt();
			
				if (score_min == 0){
					resultado++;
					continue;
				}
				
				if (googlers[j] == 0) 
					continue;
				
				
				tmp = googlers[j] / 3;
				resto = googlers[j] % 3;
		
				if (resto == 0){
				
					if (tmp >= score_min)
						resultado++;
					else if (num_surp > 0 && tmp + 1 >= score_min){
						resultado++;
						num_surp--;
					}
				}else if (resto == 1 ){
					
					if (tmp + 1 >= score_min)
						resultado++;
					else if (num_surp > 0 && tmp + 1 >= score_min){
						resultado++;
						num_surp--;
					}	
					
				}else if (resto == 2){
					
					if (tmp + 1 >= score_min)
						resultado++;
					else if (num_surp > 0 && tmp + 2 >= score_min){
						resultado++;
						num_surp--;
					}
					
				}
	
			}
			
			System.out.println("Case #" + (i+1) + ": " + resultado);
			
		}
		
	}

}
