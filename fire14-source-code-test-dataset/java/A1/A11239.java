import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B {
	Map<String, String> mapLenguaje;

	public static void main(String arg[]) {
		try {
			StringBuffer line;
			
			File file = new File("C:/Documents and Settings/jjmamby/Mis documentos/Descargas/B-small-attempt1.in");
			int T = 0, N = 0, S = 0, maxP, t, bestResult, p;
			StringBuilder output = new StringBuilder();
			if (file.exists()) {
				BufferedReader input = new BufferedReader(new FileReader(file));
				
				T = Integer.valueOf((input.readLine()));
				for (int i = 0; i < T; i++) {
					line = new StringBuffer(input.readLine());
					StringTokenizer st = new StringTokenizer(line.toString(), " ");
					N = Integer.valueOf(st.nextToken());
					S = Integer.valueOf(st.nextToken());
					maxP = Integer.valueOf(st.nextToken());
					p = 0;
					for(int j = 0; j < N; j++){
						t = Integer.valueOf(st.nextToken());
						int aux1 = t / 3 ;
						bestResult = aux1;
						int aux2 = (t - aux1) / 2 ;
						
						if(aux2>bestResult){
							bestResult = aux2;
						}
						int aux3 = (t - aux1 - aux2) ;
						if(aux3>bestResult){
							bestResult = aux3;
						}
												
						if(maxP<=aux3){
							p++;
						}else if (t > 2 && t < 28){
							aux2--;
							aux3++;
							if(maxP<=aux3&& S>0 ){
								S--;
								p++;
							}
						}
					}
					output.append("Case #");
			    	output.append((i+1));
			    	output.append(": ");
			    	output.append(p);
			    	output.append("\n");
				}
				System.out.println(output.toString());
			}else{
				output.append("No hay Archivo");
			}
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
