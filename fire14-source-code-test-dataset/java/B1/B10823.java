import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;


public class jamc {
public static boolean b=false;
public static Scanner in;
public   static PrintWriter out;



static boolean recycle(int i,int j)
{
	String n=""+i+"";
	String m=""+j+"";
	
	for(int k=0;k<n.length();k++)
	{
		
		if(m.equals(n.substring(1)+n.substring(0, 1)))
		{
			return true;
		}
		n=n.substring(1)+n.substring(0, 1);
		
		
	}
	
	
	
	
	return false;
}

	
	public static void ecrire(String s)
	{
		if(b)
		{
			out.println("");
		}
		b=true;
		out.print(s);
		
		
		
	}

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
         in=new Scanner(new File("C-small-attempt9.in"));
		 out=new PrintWriter("c.out");
	in.nextLine();
	int j=1;
	while(in.hasNext())
	{
		
		int compt=0;
		String s=in.nextLine();
		String resultat="";
		StringTokenizer tk=new StringTokenizer(s);
		String n=tk.nextToken();
		String m=tk.nextToken();
		int nint=Integer.parseInt(n);
		int mint=Integer.parseInt(m);
		for(int par=nint;par<=mint;par++)
		{
			for( int par1=nint;par1<=mint;par1++)
			{
				if(recycle(par,par1)&&(par!=par1))
					compt++;
				
				
			}
			
			
			
		}
		resultat="Case #"+j+": "+compt/2+"";
		ecrire(resultat);
		j++;
		
		
		}
		
		
	
	
	
	
	

	
	
	
	
	
	in.close();
	out.close();

	}

}
