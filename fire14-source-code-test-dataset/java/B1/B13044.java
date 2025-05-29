import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class MainC {
	
	private static boolean esValido(Integer n,Integer A,Integer B,boolean comp)
	{
		
		int i=0;
		boolean valido=false;
		if (!comp || (n>=A && n<B))
		{
			if (n>9)
			{
				while((i+1)<n.toString().length() && valido==false)
				{
					if (n.toString().charAt(i)!=n.toString().charAt(i+1))
					{
						valido=true;
					}
					i++;
				}
			}
		}
		return valido;
	}
	
	private static String rotar(String i)
	{
		return (i.charAt(i.length()-1)+i.substring(0, i.length()-1));
	}
	
	private static void combValidas(Integer i,Integer A,Integer B,HashSet<Par> conj)
	{
		String aux=rotar(i.toString());
		Integer num=Integer.parseInt(aux);
		if (esValido(num,A,B,true))
		{
			if (!i.equals(num))
			{
				conj.add(new Par(i,num));
			}
			//System.out.println("Se encuentra el par " + i + ", "+num + " ya que esValido "+num+" en el intervalo "+ A+ "-"+B);
		}
		for (int j=0;j<i.toString().length()-2;j++)
		{
			aux=rotar(aux);
			num=Integer.parseInt(aux);
			if (esValido(num,A,B,true))
			{
				//System.out.println("Se encuentra el par " + i + ", "+num + " ya que esValido "+num+" en el intervalo "+ A+ "-"+B);
				if (!i.equals(num))
				{
					conj.add(new Par(i,num));
				}
			}
		}
	}
	
	private static Integer calcularResultado(Integer A, Integer B)
	{
		//Para cada número hay tantas combinaciones como su longitud menos 1 (podemos rotarlo n-1 veces)
		HashSet<Par> conj=new HashSet<Par>();
		for (int i=A;i<B;i++)
		{
			if (esValido(i,A,B,false))
			{
				combValidas(i,A,B,conj);
			}
		}
		//Imprimimos resultados
		for (Par p:conj)
		{
			System.out.println(p + " en "+A+"-"+B);
		}
		
		return conj.size();
	}
	
	public static void main(String[] args) {
		File archivo = null;
		FileReader fr = null;
		FileWriter wr = null;
		PrintWriter pw = null;
		BufferedReader br = null;
		Integer A,B;
		Integer num = 0;
		String linea;
		String aux;
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
					aux = "Case #" + num.toString() + ": ";	//Inicialización del case #N: 
					st=new StringTokenizer(linea," ");
					A=Integer.parseInt(st.nextToken());
					B=Integer.parseInt(st.nextToken());
					aux+=calcularResultado(A,B).toString();
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
