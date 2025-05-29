package code12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Googlers {

	public static void main(String[] args) {
		
		try {
			BufferedReader fileGoo = new BufferedReader(new FileReader("B-small-attempt5.in"));
			FileWriter miArchivo = new FileWriter("B-small-attempt5.out");
			
			List<String> listaCasos = new ArrayList<String>();
			String linea;
			while ((linea = fileGoo.readLine()) != null) {
				listaCasos.add(linea);
			}
			int casos = new Integer(listaCasos.get(0));
			
			listaCasos.remove(0);
			int indc=1;
			
			if (casos>0 && casos<=100){
				for (String cadenas: listaCasos) {
					String [] valores= cadenas.split(" ");
					int n= new Integer (valores[0]);
					int s= new Integer (valores[1]);
					int p= new Integer (valores[2]);
					if(s<0 || s>n)
						continue;
					if(p<0 || p>10)
						continue;
					if(n<1 || n>3)  // SmallData
						continue;
					
					int contador = 0;
					int casoEsp=1;
					for (int i = 3; i < valores.length; i++) {
							Integer p1= p-1<0?0:p-1;
							Integer p2= p-2<0?0:p-2;
							Integer valor =new Integer(valores[i]);
							Integer caso1 = p+ p+ p;
							Integer caso2 = p+ p+ p1;
							Integer caso3 = p+ p1+ p1;
							Integer caso4 = p+ p1+ p2;
							Integer caso5 = p+ p2+ p2;
							Integer caso6 = p+ p+ p2;
							
							if(valor<0 || valor>30)
								continue;
							
							if (caso1<valor ||caso2<valor || caso1.equals(valor) || caso2.equals(valor)|| caso3.equals(valor)){
								contador++;
							}
							else if ((s>0 && casoEsp<=s) &&  (caso4.equals(valor) || caso5.equals(valor)|| caso6.equals(valor))){
								contador++;
								casoEsp++;
							}
					}
					miArchivo.write("Case #" + indc + ": " + contador+"\n");
					indc++;
				}	
			}
			
			
			
			miArchivo.flush();
			miArchivo.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
