import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainB {
	
	
	private static Integer maxDif(Integer n1,Integer n2,Integer n3)
	{
		
		return Math.max(Math.max(n1, n2),n3)-Math.min(Math.min(n1, n2), n3);
	}
	
	private static Integer maxDif(Integer n1,Integer n2)
	{
		if (n1>n2)
		{
			return n1-n2;
		}
		else
		{
			return n2-n1;
		}
	}
	
	private static Boolean esPosible(Integer p,Integer i)
	{
		Boolean res=false;
		if (p<i)
		{
			for (int j=p;j<11;j++)
			{
				for (int k=0;k<11 && (j+k)<i;k++)
				{
					for (int l=0;l<11 && (j+k+l)<=i;l++)
					{
						if (maxDif(j,k,l)<2 && j+k+l==i)
						{
							//System.out.println("Posible puntuacion "+j+" "+k+ " "+l + " para "+i);
							return true;
						}
					}
				}
			}
			
		}
		return res;
	}
	
	private static Boolean esPosibleSorp(Integer p,Integer i)
	{
		Boolean res=false;
		if (p<i)
		{
			for (int j=p;j<11;j++)
			{
				for (int k=0;k<11 && (j+k)<i;k++)
				{
					for (int l=0;l<11 && (j+k+l)<=i;l++)
					{
						if (maxDif(j,k,l)==2 && j+k+l==i)
						{
							//System.out.println("Posible puntuacion sorprendente "+j+" "+k+ " "+l+ " para "+i);
							return true;
						}
					}
				}
			}
			
		}
		return res;
	}
	
	public static void main(String[] args) {
		File archivo = null;
		FileReader fr = null;
		FileWriter wr = null;
		PrintWriter pw = null;
		BufferedReader br = null;
		Integer num = 0;
		String linea;
		Integer N,S,p;
		ArrayList<Integer> punt;
		ArrayList<Integer> noPos;
		String aux;
		Integer cont;
		StringTokenizer st;
		try {
			archivo = new File("C:/Users/Pc/Desktop/input.in");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			wr = new FileWriter("C:/Users/Pc/Desktop/output.out");
			pw = new PrintWriter(wr);
			// Lectura del fichero
			while ((linea = br.readLine()) != null) {
				if (num != 0) {
					aux = "Case #" + num.toString() + ": "; // Inicialización
															// del case #N:
					st=new StringTokenizer(linea," ");
					N=Integer.parseInt(st.nextToken());
					S=Integer.parseInt(st.nextToken());
					p=Integer.parseInt(st.nextToken());
					punt=new ArrayList<Integer>();
					noPos=new ArrayList<Integer>();
					while (st.hasMoreTokens())
					{
						punt.add(Integer.parseInt(st.nextToken()));
					}
					cont=0;
					for (Integer i:punt)
					{
						if (esPosible(p,i))
						{
							cont+=1;
						}
						else
						{
							noPos.add(i);
						}
					}
					//Ahora de los no posibles intentamos que sean posibles mediante sorprendente
					for(Integer i:noPos)
					{
						if (S!=0)
						{
							if (esPosibleSorp(p,i))
							{
								cont++;
								S--;
							}
						}
						else
						{
							break;
						}
					}
					aux+=cont;
					pw.println(aux);
				}
				num++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fr) {
					fr.close();
					wr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
