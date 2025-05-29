import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;



public class Recycled extends TemplateClass {

	public Recycled() {
	}

	public Recycled(String nombreficheroEntrada, String nombreFicheroSalida) throws Exception {
		super(nombreficheroEntrada, nombreFicheroSalida);
	}
	
	protected void procesaTestCase() throws Exception {

		// Variables
		int testCase = 0;
		ArrayList lista = new ArrayList();
		long a;
		long b;
		long casos;
		
		for (testCase = 0; testCase < testCases; testCase++) {
			a = sc.nextInt();
			b = sc.nextInt();
			
			casos = numeroCasos(a,b);
			bw.write("Case #" + (testCase + 1) + ": " + casos + "\n");		
		} 
		bw.close();
	}
	
	private long numeroCasos(long a, long b){
		long casos = 0;
//		long medio = (long)(Math.ceil(((b - a)/2)) + a);
		char c[];
		long arrayCombinaciones[];
		long temp = 0;
		long base = 0;
		
		for(long i = a; i <= b; i++){
			base = i;
			c = (Long.toString(i)).toCharArray();
			//comprueba numero
//			for (int j = 0; j < c.length; j++) {
				arrayCombinaciones = traeCombinaciones(c);
				siguiente:
				for (int k = 0; k < arrayCombinaciones.length; k++) {
					temp = arrayCombinaciones[k];
					if (temp > base){
						base = temp;
					}else{
						continue siguiente;
					}
					if (temp <= b){
						casos += 1;
					}
				}
//			}
		}
		return casos;
	}
	
	private long[] traeCombinaciones(char c[]){
		long array[] = new long[c.length];
		char temp[] = c;
		char temp2[] = c;
		int k = 0;
		String s;
		s = String.valueOf(temp);
		array[0] = Long.parseLong(s);
		
		for (int i = 1; i < array.length; i++) {
			temp = new char[c.length];
			for (int j = 0; j < c.length; j++) {
				if (j == 0){
					k = c.length - 1;
				}else{
					k = j - 1;
				}
				temp[k] = temp2[j];
			}
			temp2 = temp;
			array[i] = Long.parseLong(String.valueOf(temp));
		}
		Arrays.sort(array);
		return array;
	}
}
