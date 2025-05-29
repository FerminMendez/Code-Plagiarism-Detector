import java.util.*;
import java.io.*;

public class Palabras{

		static int T;
		static int matrix[][];
		static int valores[];
	    static BufferedReader input;
   
		static StringTokenizer token;
		static String leerLinea() throws IOException 
		{
		        String linea = input.readLine();
				if(linea!=null)
				{
					token = new StringTokenizer(linea," ");
				}
				return linea;
		}
		
    static String siguiente() 
    {
		return token.nextToken(); 
	}
	
	static void escribirArchivo(String data) throws IOException
	{
		PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(data)));

		for(int i=0; i<T; i++)
		{
			output.println("Case #"+(i+1)+": "+valores[i]);
		}
		
		output.close();
	}
	
    static int siguienteInt() 
    { 
		return Integer.parseInt(siguiente()); 
	}
	
	
	static void procesarDatos()
	{
		for(int i=0; i<T; i++)
		{
				for(int k=matrix[i][0]; k<=matrix[i][1]; k++)
				{
					String num=k+"";
					String alt="";
					int tam=num.length();
					int numero=0;
					boolean repetido=true;
					
					
					for(int l=0;l<tam-1 && tam>1; l++)
					{
						alt=num.substring(l+1, tam)+num.substring(0,l+1);
						numero = Integer.parseInt(alt);
						//System.out.println("alt "+numero);
						if(numero >= matrix[i][0] && numero <= matrix[i][1] && !num.equals(alt)){valores[i]++;}
					}
			/*		for(int l=0;l<tam-1 && tam>1; l++)
					{
						if(!num.substring(l+1, l+2).equals(num.substring(l,l+1)))
						{
							repetido = false;
						}
					}
					if(repetido && tam>1){valores[i]--;}
			*/	}
			valores[i] = valores[i]/2;
		}
	}
    
    
    public static void main(String[] args) throws IOException {

		input = new BufferedReader(new FileReader(new File("prueba.in")));
		//System.out.println("jd");
        T = Integer.parseInt(leerLinea());
        
        

        if(T<1 || T>1000)
        {
			System.out.println("ERROR T");
			}
		matrix = new int[T][2];
		valores = new int[T];
		for(int i=0; i<T; i++)
		{
			leerLinea();
			matrix[i][0] = siguienteInt();
			matrix[i][1] = siguienteInt();
		}
		procesarDatos();
		
        escribirArchivo("prueba.out");
        
		
    }

}


