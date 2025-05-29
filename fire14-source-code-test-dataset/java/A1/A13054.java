package _2011.qualification;

import java.util.Scanner;

public class DancingWithTheGooglers {
	
	public static void main(String[] args) {
		Scanner consola = new Scanner(System.in);
		int nGooglers, nSurprise, top, total, cont, times = consola.nextInt();
		for(int t = 1; t <= times; t++){
			nGooglers = consola.nextInt();
			nSurprise = consola.nextInt();
			top = consola.nextInt();
			cont = 0;
			for(int i = 0; i < nGooglers; i++){
				total = consola.nextInt();
				if(total < top)
					continue;
				if(total >= (top * 3) - 2)
					cont++;
				else if(nSurprise > 0 && total >= (top * 3) - 4){
					cont++;
					nSurprise--;
				}
			}
			System.out.println("Case #" + t + ": " + cont);
		}
	}
}