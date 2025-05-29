import java.util.List;


public class QC {
	public static void main( String args[])
	{
		LeerArchivo leer = new LeerArchivo();
		leer.abrirArchivo("C-small-attempt0.txt");
		
		EscribirArchivo escribir = new EscribirArchivo();
		escribir.abrirArchivo("respuesta.txt");
		
		List<String> lineasArchivo = leer.leer();
		
		int numeroDeCasos = Integer.parseInt(lineasArchivo.get(0));
		int contadorLineas =1;
		for(int contador=0; contador <= numeroDeCasos-1; contador++)
		{
			int A = Integer.parseInt(lineasArchivo.get(contadorLineas).split(" ")[0]);
			int B = Integer.parseInt(lineasArchivo.get(contadorLineas).split(" ")[1]);
			
			int respuesta = 0;
			for(int n = A; n <= B-1; n++)
			{
				for(int m = n+1; m<=B; m++)
				{
					//if(n<m)
					respuesta += solve(n,m);
					//System.out.println("Encontrado --> "+n+" "+m+" --> "+respuesta);
					//escribir.escribirLinea("Encontrado --> "+n+" "+m+" --> "+respuesta);
				}
			}
			
			escribir.escribirLinea("Case #"+(contador+1)+": "+respuesta);
			
			contadorLineas++;
			
		}
		escribir.cerrarArchivo();
	}
	
	public static int solve(int n, int m)
	{
		//Hago los shifts
		int temp = n;
		int tamano = Integer.toString(n).length();
		int contador = 0;
		for(int i = 0; i<=tamano-1; i++)
		{
			//if(i!=0)
			int prueba = shift(temp,i);
			if(prueba == m)
				contador++;
		}
		return contador;
	}
	
	public static int shift(int number,int times)
	{
		String numeroString = Integer.toString(number);
		String numeroStringNew = "";
		if(numeroString.length()>1)
		{
			for(int time = 0; time <= times-1; time++)
			{
				if(time>=1)
				{
					numeroString = numeroStringNew;
					numeroStringNew="";
				}
				for(int i = 1; i <= numeroString.length(); i++)
				{
					if(i!=numeroString.length())
						numeroStringNew+=Character.toString(numeroString.charAt(i));
					else
						numeroStringNew+=Character.toString(numeroString.charAt(0));
				}
			}
			if(numeroStringNew.length()>1)
			{
				return Integer.parseInt(numeroStringNew);
			}
			else
				return Integer.parseInt(numeroString);
		}
		return Integer.parseInt(numeroString);
	}
}
