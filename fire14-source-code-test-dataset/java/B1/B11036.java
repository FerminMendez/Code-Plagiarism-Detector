import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class RecycledNumbers {
	
	public static int nonbelong(int n, int [] T)
	{
		int j=1;
		int i;
		for (i=0;i<T.length;i++)
		{
			if (T[i]==n){j=0;}
		}
		return j;
	}

	public static  int longeur(int n )
	{
		String ch= new String();
		ch=String.valueOf(n);
		return ch.length();
	}
	public static  int rotation(int n, int p )
	{
		String ch=new String();
		String ch2=new String();
		String ch3=new String();
		ch=String.valueOf(n);
		int l=ch.length();
		if (p>l) return 0;
		else
		{
			ch2=ch.substring(l-p);
			if (Integer.valueOf(ch2)==0){ return 0;}
			else
			{
			ch3=ch.substring(0, l-p);
			ch=ch2+ch3;
			return Integer.valueOf(ch);
			}
		}
		
	}
	public static void main(String[] args) throws IOException{
		
		String fichierentree= "/home/marwen/Téléchargements/C-small-attempt0.in";
		String fichiersortie= "/home/marwen/Bureau/output.in";

		BufferedWriter	 wr= new BufferedWriter(new FileWriter(fichiersortie));
		DataInputStream	 rd= new DataInputStream(new FileInputStream(fichierentree));	
		
		
		int i,l,nb,r,j,a,b,k;
		
		
		String ligne= rd.readLine();
		int T= Integer.valueOf(ligne);		
		
		for (k=1;k<=T;k++)
		{
			nb=0;
			ligne=rd.readLine();
			a=Integer.valueOf(ligne.substring(0, ligne.indexOf(" ")));
			b=Integer.valueOf(ligne.substring(ligne.indexOf(" ")+1));
		
			l=RecycledNumbers.longeur(a);
			int [] Valr=new int[l-1];
			for(i=0;i<l-1;i++){Valr[i]=0;};
			for (i=a;i<b;i++)
			{
				for (j=1;j<=l-1;j++)
				{
					r=RecycledNumbers.rotation(i, j);
					if (RecycledNumbers.nonbelong(r, Valr)==1)
					{
						Valr[j-1]=r;
						if ((r>0)&&(r<=b)&&(r>a)&&(r>i)){nb++;}
					}
				}
			}
			
			wr.write("Case #"+k+": "+nb);
			wr.newLine();
			
		}
		
	wr.close();
	rd.close();
	}

}
