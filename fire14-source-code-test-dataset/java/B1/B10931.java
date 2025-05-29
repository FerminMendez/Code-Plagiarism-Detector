import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;


public class Main {
	public static int recycled (int A,int B)
	{
		
		if(B<10)return 0;
		String N,M;
		int taille=1,Nbr=0;
		for(int i=10;i<=B;i*=10)taille++;
		for(int i=A;i<=B;i++)
		{
			Vector<Integer> list = new Vector<Integer>();
			N=Integer.toString(i);
			//M=N.substring(1)+N.charAt(0);
			for(int k=0;k<N.length()-1;k++)
			{
				N=N.substring(1)+N.charAt(0);
				if(A<=Integer.parseInt(N)&&Integer.parseInt(N)<=B&&i<Integer.parseInt(N))
					{
					if(!list.contains(Integer.parseInt(N)))
						{
							list.add(Integer.parseInt(N));
							//System.out.println(N  +"       "+i);
							Nbr++;
						}
					}
			}
		}
		return Nbr;
	}
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in =new Scanner(new File("C-small.in"));
		PrintWriter out=new PrintWriter("C-small.out");
		int T,A,B;
		T=in.nextInt();
		for(int i=0;i<T;i++)
		{
			A=in.nextInt();
			B=in.nextInt();
			out.print("Case #"+(i+1)+": ");
			out.print(recycled(A, B));
			if(i+1!=T) out.println("");
		}
		out.close();
		in.close();
	}
}
