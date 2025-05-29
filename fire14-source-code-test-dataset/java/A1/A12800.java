/**
 * B.java
 * @author Joel C. Soares
 */
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Collections;
 
class Googlers implements Comparable<Googlers>
{
	int n1, n2, n3;
	int restando;
	
	Googlers( int a, int b, int c, int r)
	{
		n1 = a; n2 = b; n3 = c; restando = r;
	} 
	
	public int compareTo( Googlers g )
	{
		if( n3 > g.n3 )
			return 1;
		else if( n3 < g.n3 )
			return -1;
		else
			return 0;
	} 
	
} // fim de classe

public class B
{
	// remove grupos que tem notas maiores que p
	public static int countGooglers( LinkedList<Googlers> lista, int p )
	{
		int count = 0;
		
		for( int i = 0; i < lista.size(); i++ )
		{
			if( lista.get( i ).n3 >= p )
				count++;
		}
		
		return count;
	} 

	// faz ajuste para casos surpreendentes
	public static void ajusteGooglersSurpreendentes( LinkedList<Googlers> lista, int p, int s )
	{
		Googlers g;
		
		// coloca em ordem
		Collections.sort( lista );
		
		for( int i = lista.size() - 1; i >= 0; i-- )
		{
			g = lista.get( i );
			if( s > 0 && g.n3 < p )
			{
				if( g.restando >= 2 )
				{
					g.restando -= 2;
					g.n3 += 2;
					if( g.restando > 0 )
					{
						g.restando--;
						g.n2++;
					}
					s--;
				}				
			}
		} // fim de for
	} 
	
	public static void ajusteGooglers( LinkedList<Googlers> lista, int p, int s )
	{
		for( Googlers g : lista )
		{
			if( g.n3 + 1 >= p || g.n3 + 2 < p || g.restando == 1 ||
				s == 0 )
			{
				if( g.restando > 0 )
				{
					g.restando--;
					g.n3++;
				}
				if( g.restando > 0 )
				{
					g.restando--;
					g.n2++;
				}
				if( g.restando > 0 )
				{
					g.restando--;
					g.n1++;
				}
			} // fim de if
		} // fim de for
	} // fim de método
	
	public static boolean existeResto( LinkedList<Googlers> lista )
	{
		for( Googlers g : lista )
			if( g.restando > 0 )
				return true;
		
		return false;
	}
	
	public static void main( String args[] )
	{
		Scanner input = new Scanner( System.in );
		int t, n, s, p, x, v;
		LinkedList<Googlers> lista = new LinkedList<Googlers>();
		
		t = input.nextInt();
		for( int i = 0; i < t; i++ )
		{
			n = input.nextInt();
			s = input.nextInt();
			p = input.nextInt();
			lista.clear();
			for( int j = 0; j < n; j++ )
			{
				x = input.nextInt();
				v = x / 3;
				x = x % 3;
				
				// ajusta
				if( x == 0 && v > 0 )
				{
					x = 3;
					v = v - 1;
				} 
				
				lista.add( new Googlers( v, v, v, x ) );					
			} // fim de for
			
			// faz ajuste triviais
			ajusteGooglers( lista, p, s );
			
			// faz ajuste surpreendentes
			ajusteGooglersSurpreendentes( lista, p, s );
			
			System.out.printf( "Case #%d: %d\n", i + 1, countGooglers( lista, p ) );
		} // fim de for externo
	}
}