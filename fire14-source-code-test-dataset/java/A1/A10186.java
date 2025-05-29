package CodeJam2012.Qualification;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class ProblemB {

	private static final String DIRECTORIO = "D:\\CodeJam\\CodeJam2012\\Qualification\\ProblemB\\";

	private static final String FILE_IN = "ejemplo.in";
	//private static final String FILE_IN = "A-small-practice.in";
	// private static final String FILE_IN = "A-small-attempt0.in";
	// private static final String FILE_IN = "A-large.in";

	private static final String FILE_OUT = "ejemplo.out";
	//private static final String FILE_OUT = "a-small-practice.out";
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
			
			int concursantes = Integer.parseInt(entrada[0]);
			int numeroSorpresas = Integer.parseInt(entrada[1]);
			int notaCorte = Integer.parseInt(entrada[2]);
			
			ArrayList<Integer> puntuacionesTotales = new ArrayList<Integer>();

	
			int cumplidores=0;
			int posiblesSorpresas=0;
			
			for (int i = 0; i < concursantes; i++) {
				int puntuacionConcursante = Integer.parseInt(entrada[3 + i]);
				
				int parejaMenos = puntuacionConcursante - notaCorte;
				
				if (parejaMenos >=  (notaCorte-1)*2 && parejaMenos >=0){
					cumplidores++;
				}else if (parejaMenos >= (notaCorte-2)*2 && parejaMenos >=0){
					posiblesSorpresas++;
				}
			}	
			
			
			int maximasSorpresas =0;
			if (posiblesSorpresas >= numeroSorpresas){
				maximasSorpresas = numeroSorpresas;
			}else{
				maximasSorpresas = posiblesSorpresas;
			}
		
			
		
			
			// Se escribe la solución del caso en pantalla y en fichero
			String solucion = "Case #" +index +": " + (maximasSorpresas+cumplidores);
			bw.write(solucion);
			bw.newLine();
			System.out.println(solucion);
		}

		// Se cierra el buffer de escritura
		bw.close();
	}


	
	
}


