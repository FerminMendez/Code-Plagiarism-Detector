import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


public class googlers {
	
	private static String[] casos;
	
	private static String[] respuestas;
	
	private static int cantidadPuntajesSorprendentes;
	
	private static boolean pudoObtenerPuntaje(int puntaje, int total)
	{
		if(total == 0)
			return puntaje == 0;
		int umbralNormal = (puntaje-1) * 3 + 1;
		int umbralSorprendente = (puntaje-1) * 3 - 1;
		if(total >= umbralNormal)
			return true;
		if(cantidadPuntajesSorprendentes > 0 && total >= umbralSorprendente)
		{
			cantidadPuntajesSorprendentes --;
			return true;
		}
		return false;
	}
	
	private static int maximaCantidadConMinimoPuntaje(int minimoPuntaje, int[] puntajes) {
		int respuesta = 0;
		for(int i=0; i<puntajes.length; i++) {
			if(pudoObtenerPuntaje(minimoPuntaje, puntajes[i]))
				respuesta ++;
		}
		return respuesta;
	}
	
	private static String resolver(String caso) {
		String[] datos = caso.split(" ");
		int cantidad = Integer.parseInt(datos[0]);
		cantidadPuntajesSorprendentes = Integer.parseInt(datos[1]);
		int minimoPuntaje = Integer.parseInt(datos[2]);
		
		int[] totales = new int[cantidad];
		for(int i=0; i<cantidad; i++) {
			totales[i] = Integer.parseInt(datos[3+i]);
		}
		int resultado = maximaCantidadConMinimoPuntaje(minimoPuntaje, totales);
		return String.valueOf(resultado);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		leerArchivo();
		respuestas = new String[casos.length];
		for(int i = 0; i<casos.length; i++) {
			String respuesta = resolver(casos[i]);
			respuestas[i] = respuesta;
		}
		escribirRespuesta();
	}
	
	private static void leerArchivo() {
		try {
			FileInputStream fstream;
			fstream = new FileInputStream("input.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			int numeroCasos = Integer.parseInt(br.readLine());
			casos = new String[numeroCasos];
			
			for(int i = 0; i < numeroCasos; i++) {
				casos[i] = br.readLine();
			}
			
			in.close();
		} catch (IOException e) {
			e.printStackTrace();			
		}
	}
	
	private static void escribirRespuesta() {
		try {
			FileWriter fstream = new FileWriter("output.txt");
			BufferedWriter out = new BufferedWriter(fstream);
			for(int i=0; i<respuestas.length; i++) {
				out.write("Case #" + (i + 1) + ": " + respuestas[i] + "\n");
			}
			out.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
