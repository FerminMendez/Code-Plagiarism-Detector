import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


public class GooglersDancer {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader converter = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(converter);
		if (in == null) {
		      return;
		    }
		String numTest = in.readLine();
		int maxCases = Integer.valueOf(numTest);
		for(int i=1;i<= maxCases;i++){
			String linea = in.readLine();
			String[] datos = linea.split(" ");
			Integer googlers = Integer.valueOf(datos[0]);
			Integer sospechosos = Integer.valueOf(datos[1]);
			Integer p = Integer.valueOf(datos[2]);
			Integer puntuacion;
			Integer personas = 0;
			ArrayList<Integer> puntuaciones = new ArrayList<Integer>();
			for(int j=0;j<googlers;j++){
				puntuacion = Integer.valueOf(datos[3+j]);
				puntuaciones.add(puntuacion);
			}
			Integer[] pOrdenado = null;
			pOrdenado = (Integer[]) puntuaciones.toArray(new Integer[puntuaciones.size()]);
			Arrays.sort(pOrdenado);
			int j;
			for(j=pOrdenado.length-1;j>=0;j--){
				if(pOrdenado[j] >= p*3-2){
					personas += 1;
				}else{
					break;
				}
			}
			int posibles = j+1-sospechosos;
			for(;j>=posibles && j>= 0;j--){
				if(pOrdenado[j] >= p*3-4 && pOrdenado[j] > p){
					personas += 1;
				}else{
					break;
				}
			}
			System.out.println("Case #"+i+": "+personas);
		}
	}

}
