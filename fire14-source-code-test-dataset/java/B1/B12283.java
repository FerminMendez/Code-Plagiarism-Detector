import java.util.LinkedList;
import java.util.List;


public class Secundaria 
{
	public Secundaria()
	{
		
	}
	
	public int nVeces(int primero, int ultimo)
	{
		int i = 0;
		
		if(primero <= 9 && ultimo <=9)
			return 0;
		
		LinkedList<Integer> lista;
		for(int j = primero; j <= ultimo; j++)
		{
			lista = deparse(j);
			for(int k = j+1; k <= ultimo; k++)
			{
				for(int r = 0; r < lista.size(); r++)
				{
					int prueba = monta(lista);
					if(k == prueba)
						i++;
					int x = lista.pop();
					lista.addLast(x);
				}
			}
		}
				
		return i;
	}
	
	public int monta(LinkedList<Integer> l)
	{
		int res = 0;
		int a = 1;
		for(int i = 0; i < l.size(); i++)
		{
			for(int k = i;k < l.size(); k++)
				a *= 10;
			
			res += l.get(i) * a;
			a = 1;
		}
		res = res / 10;
		return res;
	}
	
	public LinkedList<Integer> deparse(int k)
	{
		LinkedList<Integer> ret = new LinkedList<Integer>();
		
		int r = k;
		while(r != 0)
		{
			ret.addFirst(r % 10);			
			r = r / 10;
		}
				
		return ret;
	}
}
