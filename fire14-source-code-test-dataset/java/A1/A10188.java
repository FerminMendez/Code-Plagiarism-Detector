import javax.swing.*;
import java.util.Scanner;
import java.io.*;


public class ProblemCSmall {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String [] VectorString= new String [100];
		String chingon="";
		int T=0,N=0,S=0,P=0,i,X,Y,Z,u=0;
		
		Scanner leer;
		PrintWriter escribir;
		
		for(i=0; i<100; i++)
		{
			VectorString[i]="Case #"+(1+i)+": ";
		}
		try
		{
			leer = new Scanner(new File("/Users/joseandresfelixchavez/Documents/CETYS/3er Semestre/Sistemas Operativos/GoogleCodeJam/src/leee.txt"));
			escribir = new PrintWriter(new BufferedWriter(new FileWriter("/Users/joseandresfelixchavez/Documents/CETYS/3er Semestre/Sistemas Operativos/GoogleCodeJam/src/escribe.txt")));
			
			T=Integer.parseInt(leer.nextLine());
			for(int caca=1; caca<=T; caca++)
			{
				
				N=leer.nextInt();
				System.out.print(N);
				S=leer.nextInt();
				P=leer.nextInt();
				int [] vector= new int [N];
				for(i=0; i<N; i++)
				{
					vector[i]=leer.nextInt();
				}
			
			
			int temp =0;
            for ( i = 0; i < vector.length-1; i++)
            {
                for(int k = i+1; k < vector.length;k++)
                {
                    if(vector[k]<vector[i])
                    {
                        temp = vector[k];
                        vector[k]=vector[i];
                        vector[i]=temp;
                    }

                }
            }

            int total = 0;
            Z=P+(P-2)+(P-2);//ZZ
            Y=P+(P-1)+(P-2);//ZX
            X=P+(P-1)+(P-1);//Z

            for (int K = vector.length - 1; K >= 0; K--)
            {
                if(vector[K] >= X  &&  vector[K]>=P)
                {
                    total++;
                    continue;
                }

                if (vector[K] >= Y && S > 0 && vector[K] >= P)
                {
                    total++;
                    S--;
                    continue;
                }
                if (vector[K] >= Z && S > 0 && vector[K] >= P)
                {
                    total++;
                    S--;
                    continue;
                }
                
            }
            VectorString[u]=VectorString[u]+total;
            chingon+=VectorString[u]+"\r\n";
            if(leer.hasNextLine())
            {u++;}
			}
            System.out.print(chingon);
            escribir.print(chingon);
			/*for(i=0; i<T; i++)
			{
				escribir.println(VectorString[N]);
			}*/
			escribir.close();
			
		}
		catch(FileNotFoundException error)
		{
			System.out.println("no se encuentra el archivo");
		}
		catch (EOFException e)
		{
		    System.out.println("Final de Stream");
		}
	}
}

