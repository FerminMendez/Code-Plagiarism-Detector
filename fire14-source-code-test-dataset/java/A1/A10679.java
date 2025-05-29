import java.util.List;


public class QB {
	public static void main( String args[])
	{
		LeerArchivo leer = new LeerArchivo();
		leer.abrirArchivo("B-small-attempt1.txt");
		
		EscribirArchivo escribir = new EscribirArchivo();
		escribir.abrirArchivo("respuesta.txt");
		
		List<String> lineasArchivo = leer.leer();
		
		int numeroDeCasos = Integer.parseInt(lineasArchivo.get(0));
		int contadorLineas =1;
		for(int contador=0; contador <= numeroDeCasos-1; contador++)
		{
			String linea[] = lineasArchivo.get(contadorLineas).split(" ");
			int N = Integer.parseInt(linea[0]);
			int S = Integer.parseInt(linea[1]);
			int P = Integer.parseInt(linea[2]);
			int puntajeGooglers[] = new int[linea.length-2];
			int contadorPuntajes = 0;
			for(int i = 3; i<= linea.length-1; i++)
			{
				puntajeGooglers[contadorPuntajes] = Integer.parseInt(linea[i]);
				contadorPuntajes++;
			}
			
			int resultado = solve(N,S,P,puntajeGooglers);
			
			escribir.escribirLinea("Case #"+(contador+1)+": "+resultado);
			
			contadorLineas++;
			
		}
		escribir.cerrarArchivo();
	}
	
	public static int solve(int N, int S, int P, int puntajeGooglers[])
	{
		int success = 0;
		for(int googler = 0; googler<=N-1; googler++)
		{
			int puntaje = puntajeGooglers[googler];
			for(int i = 0; i<=puntaje; i++)
			{
				if(i+i+i==puntaje)
				{
					if(i>=P && i<=10)
					{
						System.out.println(i+" - "+i+" - "+i);
						success++;
						break;
					}		
				}
				if(i+i+i+1==puntaje && i+1<=10)
				{
					
					if(i+1>=P)
					{
						System.out.println(i+" - "+i+" - "+(i+1));
						success++;
						break;
					}
				}
				if(i+i+i-1==puntaje && i-1<=10)
				{
					
					if(i>=P)
					{
						System.out.println(i+" - "+i+" - "+(i-1));
						success++;
						break;
					}
				}
				
				if(i+i+i+2==puntaje && S>0)
				{
					if(i+2>=P && i+2<=10)
					{
						System.out.println(i+" - "+i+" - "+(i+2));
						S--;
						success++;
						break;
					}
				}
				if(i+i+i-2==puntaje && S>0)
				{
					if(i>=P  && i<=10)
					{
						System.out.println(i+" - "+i+" - "+(i-2));
						S--;
						success++;
						break;
					}
					
				}
				
				if(i+i+i-3==puntaje && S>0)
				{
					if(i>=P && i<=10)
					{
						System.out.println((i-2)+" - "+(i-1)+" - "+i);
						S--;
						success++;
						break;
					}
				}
			}
			
			
			
			
//			if(googlerCumple(puntaje,S,P))
//				success++;
			
		}
		return success;
	}
	
	public static Boolean googlerCumple(int puntaje, int S, int P)
	{
		for(int i = 0; i<=puntaje; i++)
		{
			if(i+i+i==puntaje)
			{
				if(i>=P && i<=10)
				{
					System.out.println(i+" - "+i+" - "+i);
					return true;
				}		
			}
			if(i+i+i+1==puntaje && i+1<=10)
			{
				
				if(i+1>=P)
				{
					System.out.println(i+" - "+i+" - "+(i+1));
					return true;
				}
			}
			if(i+i+i-1==puntaje && i-1<=10)
			{
				
				if(i>=P)
				{
					System.out.println(i+" - "+i+" - "+(i-1));
					return true;
				}
			}
			
			if(i+i+i+2==puntaje && S>0)
			{
				if(i+2>=P && i+2<=10)
				{
					System.out.println(i+" - "+i+" - "+(i+2));
					S--;
					return true;
				}
			}
			if(i+i+i-2==puntaje && S>0)
			{
				if(i>=P  && i<=10)
				{
					System.out.println(i+" - "+i+" - "+(i-2));
					S--;
					return true;
				}
				
			}
			
			if(i+i+i-3==puntaje && S>0)
			{
				if(i>=P && i<=10)
				{
					System.out.println((i-2)+" - "+(i-1)+" - "+i);
					S--;
					return true;
				}
			}
		}
		return false;
	}

}
