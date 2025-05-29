package CodeJam2012.Qualification;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class ProblemC {

	private static final String DIRECTORIO = "D:\\CodeJam\\CodeJam2012\\Qualification\\ProblemC\\";

	private static final String FILE_IN = "ejemplo.in";
	// private static final String FILE_IN = "A-small-practice.in";
	// private static final String FILE_IN = "A-small-attempt0.in";
	// private static final String FILE_IN = "A-large.in";

	private static final String FILE_OUT = "ejemplo.out";

	// private static final String FILE_OUT = "a-small-practice.out";
	// private static final String FILE_OUT = "a-small.out";
	// private static final String FILE_OUT = "a-large.out";

	public static void main(String[] args) throws Exception {

		// Se prepara para leer del fichero y escribir
		FileReader fr = new FileReader(DIRECTORIO + FILE_IN);
		BufferedReader bf = new BufferedReader(fr);
		File ficheroOut = new File(DIRECTORIO + FILE_OUT);
		ficheroOut.delete();
		BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroOut));

		int casosPrueba = Integer.parseInt(bf.readLine());

		// Se hace cada caso de prueba
		for (int index = 1; index <= casosPrueba; index++) {
			
			String[] entrada = bf.readLine().split(" ");
			long A = Integer.parseInt(entrada[0]);
			long B = Integer.parseInt(entrada[1]);
			
			
			int parejasEncontradas = 0;
			for (long i=A; i<=B; i++){
				
			
				long digitos = (long) Math.ceil(Math.log10(B));

				ArrayList<Long> listaFijos = new ArrayList<Long>();

				for (int j = 1; j < digitos; j++) {
					long maximo = (long) Math.pow(10, j);
					long candidato = (long) Math.floor((i / maximo));
					candidato = (long) (candidato + (i % maximo)
							* Math.pow(10, digitos - j));

	

					
					
					if (candidato <= B && candidato > i	&& !listaFijos.contains(candidato)) {
						listaFijos.add(candidato);
						parejasEncontradas++;
					}

				}

				
				
			}


			
			
			
			
			

			// Se escribe la solución del caso en pantalla y en fichero
			String solucion = "Case #" + index + ": " + parejasEncontradas;
			bw.write(solucion);
			bw.newLine();
			System.out.println(solucion);
		}

		// Se cierra el buffer de escritura
		bw.close();
	}
}
