
public class Methode {
public boolean text(String n,String m)
{
	n=n.trim();
	m=m.trim();
	boolean bool=false;
	for(int j=1;j<n.length();j++)
	{
		String str=n.substring(j, n.length())+n.substring(0, j);
		
		if(m.equals(str))
		{
			bool=true;
			
			break;
		}
	}
	return bool;
}
}
