import java.util.Scanner;


public class JuanjeProblemaB 
{
	/*
	 * Juan Jesus Gutierrez
	 * Solucion al problema - B
	 */
	public static void main(String[] args)
	{
		//lector de la entrada
		Scanner in = new Scanner(System.in);
		//in.nextLine();
		//numero de frases en Googlerese
		int T = in.nextInt();
		in.nextLine();
		for(int con = 1; con <=T; con++)
		{
			String concurso = in.nextLine();
			int result = tratarConcurso(concurso);
			System.out.format("Case #%d: %d\n", con, result);
		}
	}
	
	public static int tratarConcurso(String concurso)
	{
		int result = 0;
		//System.out.println(concurso);
		String[] datos = concurso.split(" ");
		int N = Integer.parseInt(datos[0]);
		int s = Integer.parseInt(datos[1]);
		int p = Integer.parseInt(datos[2]);
		int[] puntuaciones = new int[N];
		for(int i = 3; i<datos.length; i++)
		{
			puntuaciones[i-3] = Integer.parseInt(datos[i]);
		}
		int[] Pmax = new int[N];
		int[] PmaxS = new int[N];
		for(int i = 0; i<N; i++)
		{
			Pmax[i] = maximoPosible(puntuaciones[i]);
			PmaxS[i] = maximoPosibleConSorpresa(puntuaciones[i]);
		}
		for(int i = 0; i<N; i++)
		{
			if(Pmax[i] >= p)
			{
				result++;
			}
			else
			{
				if(PmaxS[i] >= p && s>0)
				{
					result++;
					s--;
				}
			}
		}
		return result;
	}
	
	public static int maximoPosible(int total)
	{
		if(total == 0) return 0;
		if(total == 30) return 10;
		int d = (int) total / 3;
		int resto = total % 3;
		if(resto == 0) return d;
		return d+1;
	}
	public static int maximoPosibleConSorpresa(int total)
	{
		if(total == 0) return 0;
		if(total == 30) return 10;
		int d = (int) total / 3;
		int resto = total % 3;
		if(resto == 2) return d+2;
		return d+1;
	}
}
