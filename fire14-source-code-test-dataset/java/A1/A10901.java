import java.io.* ;
import java.util.Scanner;
public class Main2 {
	public static void main(String argsp[]) throws FileNotFoundException{
		
		Scanner in = new Scanner(new FileReader("input.in"));
		PrintWriter out = new PrintWriter("output.txt");
		int T = 0;
		String S1 = in.nextLine() ;
		T = Integer.parseInt(S1);
		for(int i=0;i<T;i++)
		{
			S1 = in.nextLine();
			out.print("Case #"+ (i+1) +": ");
			int space = S1.indexOf(" ");
			int N = Integer.parseInt(S1.substring(0, space));
			S1 = S1.substring(space+1);
			space = S1.indexOf(" ");
			int S = Integer.parseInt(S1.substring(0, space));
			S1 = S1.substring(space+1);
			space = S1.indexOf(" ");
			int p = Integer.parseInt(S1.substring(0, space));
			int a[] = new int[N];
			for(int j=0;j<N-1;j++)
			{
				S1 = S1.substring(space+1);
				space = S1.indexOf(" ");
				a[j] = Integer.parseInt(S1.substring(0, space));
			}
			a[N-1] = Integer.parseInt(S1.substring(space+1));
			int checker = 0;
			if (p>1)
				checker = 3*p - 4;
			else
				checker = 0;
			int great = 0;
			int surprise = 0;
			for(int k=0;k<N;k++)
			{
				if(a[k]>=checker)
					great++;
				if((a[k]==checker || a[k] == checker+1) && p>1)
					surprise++;
				if(p==1 && a[k] == 0)
					great--;
			}
//			System.out.println(great+ " " + surprise);
			int answer = 0;
			if((S-surprise)<=0)
				answer = great+S-surprise;
			else
				answer = great;
			out.println(answer);
		}
		out.close();
	}
}