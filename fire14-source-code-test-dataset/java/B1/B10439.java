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
				int limI = s.nextInt();
				int limS = s.nextInt();
				int k = 0;
				for (int j = limI; j<limS;j++){
					int e = 0;
					String p = j + "";
					do{						
						p = p.substring(p.length()-1) + p.substring(0,p.length() -1);
						e = Integer.parseInt(p);
						if (e > j && e <= limS){
							k++;
						}
					}while(e != j);
					
					
				}
				os.write(("Case #" + (i + 1) + ": " + k+  "\n").getBytes());
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
