

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class TemplateClass {

	protected Scanner sc;
	protected BufferedWriter bw;
	protected int testCases = 0;
	File ficheroEntrada;
	File ficheroSalida;

	public TemplateClass() {

	}

	public TemplateClass(String nombreFicheroEntrada, String nombreFicheroSalida)
			throws Exception {
		
		ficheroEntrada = new File (nombreFicheroEntrada);
		ficheroSalida = new File (nombreFicheroSalida);
		sc = new Scanner(ficheroEntrada);
		testCases = sc.nextInt();
		bw = traeBufferSalida(ficheroSalida);
	}

	protected BufferedWriter traeBufferSalida(File ficheroSalida)
			throws Exception {
		return new BufferedWriter(new FileWriter(ficheroSalida));

	}
	
	protected void procesaTestCase() throws Exception{
		
	}

}
