import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

public class Main {
	public static int problemC(Vector<Integer> V,int N,int S,int P)
	{
		int Nbr=0;
		for(int i=0;i<N;i++)
		{
			if((3*P-2)<=V.elementAt(i))
				Nbr++;
			else if((3*P-4)<=V.elementAt(i)&&0<S&&0<=(3*P-4))
			{
				Nbr++;
				S--;					
			}
		}
		return Nbr;
	}
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in =new Scanner(new File("B-small.in"));
		PrintWriter out=new PrintWriter("B-small.out");
		int T,N,S,P;
		T=in.nextInt();
		for(int i=0;i<T;i++)
		{
			N=in.nextInt();
			S=in.nextInt();
			P=in.nextInt();
			Vector<Integer> V = new Vector<Integer>();			
			for(int j=0;j<N;j++)
				V.add(in.nextInt());
			out.print("Case #"+(i+1)+": ");
			out.print(problemC(V,N,S,P));
			if(i+1!=T) out.println("");
		}
		out.close();
		in.close();
	}
}