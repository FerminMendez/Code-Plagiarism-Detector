import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Scanner;


public class EjercicioA {
	public static boolean prueba = false;
	public static void main(String args[]){
		
 		try {
 			FileOutputStream fos = new FileOutputStream(new File("solucion.txt"));
 			OutputStream os = System.out;
 			if (!prueba)
 				os = fos;
			Scanner s = new Scanner(new File("problema.txt"));
			int a = s.nextInt();
			for(int i = 0; i < a; i++){
				int cantP = s.nextInt();
				int sorpresa = s.nextInt();
				int puntos = s.nextInt();
				int total = 0;
				int minP  = 0;
				
				int maxSin = puntos + ((puntos -1) > 0 ? (puntos -1) : 0)*2;
				int maxSorp = puntos + ((puntos -2) > 0 ? (puntos -2) : 0)*2;
				for (int j = 0; j< cantP; j++){
					int totP = s.nextInt();
					if (totP < puntos)
						continue;
					if (totP >= maxSin)
						total++;
					else if (sorpresa > 0 &&  totP >= maxSorp){
						sorpresa --;
						total++;
					}
						
				}
				
				os.write(("Case #" + (i + 1) + ": " + (total) + "\n").getBytes());
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
