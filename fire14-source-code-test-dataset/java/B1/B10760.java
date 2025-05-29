package codeJam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> numeros= new ArrayList();
		StringBuffer num, copia;
		String aux;
		int test= sc.nextInt(), min, max, largo, cuenta;
		for (int i=1; i<=test; i++){
			numeros.clear();
			cuenta= 0;
			System.out.print("Case #"+i+": ");
			min= sc.nextInt();
			max= sc.nextInt();
			for (int j=min; j<=max; j++){	
				num= new StringBuffer(Integer.toString(j));
				largo= num.length();
				for (int k= 1; k<largo; k++){
					copia= new StringBuffer("");
					copia.append(num.substring(k));
					copia.append(num.subSequence(0, k));
					aux= copia.toString();
					if ((Integer.parseInt(aux) <= max) && (Integer.parseInt(aux) >= min) && (Integer.parseInt(aux) != j) && (!numeros.contains(aux+ ","+ Integer.toString(j)))){
						numeros.add(aux+ ","+ Integer.toString(j));
						numeros.add(Integer.toString(j)+ ","+ aux);
						cuenta++;
					}
				
				}
			}
			System.out.println(cuenta);
		}
	}
}