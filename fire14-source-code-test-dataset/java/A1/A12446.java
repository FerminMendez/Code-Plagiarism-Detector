import java.util.*;
import java.io.*;

public class Palabras{

		static int T;
	    static BufferedReader input;
	    static int [][] matrix;   
	    static int [] valores;
   
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
	
	
	static int procesarDatos()
	{
		int val = 0;
		int tmp=0;
		int P =0;
		int S =0;
		int values[];
		valores = new int [T];
		for(int i=0; i<T; i++)
		{
			val=0;
			tmp=0;
			S = matrix[i][1];
			P = matrix[i][2];
			
			int m[][] = new int [(int)Math.pow(2, matrix[i][0])][matrix[i][0]];
			
			for(int k=0; k<m.length; k++)
			{
				
				for(int l=0; l<m[k].length; l++)
				{
					if(k==0)
					{
						m[k][l] = 1;
					}
					else
					{
						m[k][l] = m[k-1][l];
					}
				}
				m[k][m[k].length-1]++;
				int v=m[k].length-1;
				while(m[k][v]>2 && v>0)
				{
					m[k][v]=1;
					v--;
					m[k][v]++;
				}
			}
			//Ya tengo la tabla de todos los posibles valores
			int combinaciones=0;
			combinaciones = (int)factorial(matrix[i][0]);
			combinaciones /= (int)factorial(matrix[i][1]);
			combinaciones /= (int)factorial(matrix[i][0]-matrix[i][1]);
			
			int matrix2[][] = new int [combinaciones][matrix[i][0]];
			int c=combinaciones;
			//tengo el numero de combinaciones
			//ahora sacare dichas combinacinoes
			int pos=0;
			while(c>0 && pos<(int)Math.pow(2,matrix[i][0]))
			{
				int suma=0;
				for(int u=0; u<matrix[i][0]; u++)
				{
					suma= suma + m[pos][u];
				}
				suma = suma - matrix[i][0];
				///System.out.println("Suma ="+suma );
				if(suma == matrix[i][1])
				{
					for(int u=0; u<matrix[i][0]; u++)
					{
						matrix2[c-1][u] = m[pos][u];
						//System.out.println("M : ("+c+","+u+")="+matrix2[c-1][u] );
					}
					c--;
				///System.out.println("C ="+c );
				}
				 pos++;
				 ///System.out.println("pos ="+pos );
			}
			//ya tengo los valores combinados que son
			int sumaTotal=0;
			//ahora calculo los valores optimos
			for(int p=0; p<matrix2.length; p++)
			{
				for(int q=0; q<matrix2[p].length; q++)
				{
					System.out.print(" "+matrix2[p][q] );
				}
				System.out.println();
			}
			///System.out.println("Combi="+ combinaciones);
			for(int y=0; y<combinaciones; y++)
			{
				sumaTotal=0;
				values = new int[ matrix[i][0] ];
				for(int j=0; j<matrix[i][0]; j++)
				{
					if(matrix[i][j+3]%3==0 && (matrix2[y][j]==1 || matrix2[y][j]==0) )
					{
						values[j] = matrix[i][j+3]/3;
					}
					else if(matrix[i][j+3]%3==0 && matrix2[y][j]==2)
					{
						values[j] = 1 + (matrix[i][j+3]/3);
						if(matrix[i][j+3]==0)
						{ values[j]=0 ; }
					}
					else if(matrix[i][j+3]%3==1)
					{
						values[j] = (matrix[i][j+3]/3) + 1;
					}
					else if(matrix[i][j+3]%3==2 && (matrix2[y][j]==1 || matrix2[y][j]==0) )
					{
						values[j] = (matrix[i][j+3]/3) + 1;
					}
					else if(matrix[i][j+3]%3==2 && matrix2[y][j]==2)
					{
						values[j] = (matrix[i][j+3]/3) + 2;
					}
				}
					System.out.print(" !_ ");
					for(int p=0; p<values.length; p++)
					{
						System.out.print(" "+values[p]+ " ");
					}
					System.out.print(" _? ");
				for(int t=0; t<matrix[i][0]; t++)
				{
					if(values[t]>= matrix[i][2])
					{sumaTotal++;}
				}
				if(	val < sumaTotal)
				{val = sumaTotal;}
				
			}
			valores[i] = val;
			val=0;
		}
		
		
		return val;
	}
    
    static double factorial(int x)
    {
		double multiplicador=1;
		for(int i=x; i>1; i--){
		multiplicador = multiplicador * i;}
		return multiplicador;
	}
    
    public static void main(String[] args) throws IOException {

		input = new BufferedReader(new FileReader(new File("prueba.in")));
		//System.out.println("jd");
        T = Integer.parseInt(leerLinea());
        
        

        if(T<1 || T>100)
        {
			System.out.println("ERROR T");
			}
			valores = new int[T];
			matrix = new int[T][];
		for(int i=0; i<T; i++)
		{
			leerLinea();
			
			int N=0;
			N = siguienteInt();
			matrix[i] = new int[N+3];
			matrix[i][0]=N;
			for(int j=1; j<N+3; j++)
			{
				matrix[i][j] = siguienteInt();
			}
		}
		procesarDatos();
		
        escribirArchivo("prueba.out");
        
		
    }

}


