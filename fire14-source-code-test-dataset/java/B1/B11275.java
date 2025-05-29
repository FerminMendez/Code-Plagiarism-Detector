import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Ejercicio31 {

	DataInputStream entrada;
	ArrayList<String> datos;

	public Ejercicio31() {
		// TODO Auto-generated constructor stu

		datos = new ArrayList<String>();

	}

	public void extraer() {

		try {
			entrada = new DataInputStream(new FileInputStream("C-small-attempt0.in"));

			String cadena = "";

			while ((cadena = entrada.readLine()) != null) {

				datos.add(cadena);
			}

			entrada.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void encontrar() {

		 int entradas = Integer.parseInt(datos.get(0));
		//int entradas = 2;

		for (int i = 1; i <= entradas; i++) {

			String partes[] = datos.get(i).split(" ");

			int a = Integer.parseInt(partes[0]);
			int b = Integer.parseInt(partes[1]);

			int n = a;
			int m = a + 1;

			//System.out.print(n + " ");
			//System.out.println(m);
			//System.out.println();

			int nr = 0;

			while (n < m) {

				int mAuxNum = m;

				while (m <= b) {

				
					String mAux = m + "";
					char cmAux[] = mAux.toCharArray();

					String nAux = n + "";

					for (int j = 0; j < cmAux.length; j++) {
						
						char primero = cmAux[0];

						int x;

						for (x = 0; x < cmAux.length - 1; x++)
							cmAux[x] = cmAux[x + 1];

						cmAux[x] = primero;

						mAux = "";

						for (int k = 0; k < cmAux.length; k++) {

							mAux += cmAux[k] + "";

						}

						if (mAux.equals(nAux)) {

							nr++;

						}

					}


					m++;

				}

				n++;

				if (mAuxNum < b)
					m = mAuxNum + 1;

			}

			System.out.println("Case #"+i+": "+nr);

		}

		
		System.out.println("listo");
	}

	public static void main(String[] args) {

		Ejercicio31 ej3 = new Ejercicio31();
		ej3.extraer();
		ej3.encontrar();

	}

}
