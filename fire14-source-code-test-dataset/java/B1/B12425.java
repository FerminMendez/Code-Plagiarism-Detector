package hipotenusas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> aparecidos= new ArrayList();
		StringBuffer aux1;
StringBuffer aux2;
		String aux;
		int test= sc.nextInt(), min, max, longitud, suma;
		for (int i=1; i<=test; i++){
			aparecidos.clear();
			suma= 0;
			System.out.print("Case #"+i+": ");
			min= sc.nextInt();
			max= sc.nextInt();
			for (int j=min; j<=max; j++){	
				aux1= new StringBuffer(Integer.toString(j));
				longitud= aux1.length();
				for (int k= 1; k<longitud; k++){
					aux2= new StringBuffer("");
					aux2.append(aux1.substring(k));
					aux2.append(aux1.subSequence(0, k));
					aux= aux2.toString();
					if ((Integer.parseInt(aux) <= max) && (Integer.parseInt(aux) >= min) && (Integer.parseInt(aux) != j) && (!aparecidos.contains(aux+ ","+ Integer.toString(j)))){
						aparecidos.add(aux+ ","+ Integer.toString(j));
						aparecidos.add(Integer.toString(j)+ ","+ aux);
						suma++;
					}
				
				}
			}
			System.out.println(suma);
		}
	}
}
