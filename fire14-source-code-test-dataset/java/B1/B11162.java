import java.util.*;

public class JuanjeProblemaC 
{
	public static void main(String[] args){
		Scanner entrada = new Scanner(System.in);
		int tam = entrada.nextInt();
		for(int problema = 1; problema <= tam;problema++)
		{
			int A = entrada.nextInt();
			int B = entrada.nextInt();
			int resultado = 0;
			for(int indice=A;indice<=B;indice++) 
			{
			
				ArrayList<Integer> pares = new ArrayList<Integer>();
				String ns = indice+"";
				for (int j=ns.length()-1;j>0;j--) {
					String k = ns.substring(j);
					String nuevoVal = k + ns.substring(0,j);
					int m = Integer.parseInt(nuevoVal);
					if (m>indice && A<m && B>=m) 
					{ 
						if (pares.indexOf(m)==-1)
							pares.add(m);
					}
				}
				int tamPares = pares.size();
				resultado += tamPares;
			}
			
			System.out.format("Case #%d: %d\n", problema, resultado);
		}
	}
	
}