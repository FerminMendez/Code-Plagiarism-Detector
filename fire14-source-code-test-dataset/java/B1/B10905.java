import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;

class c {
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(new File("1.in"));
		PrintStream out = new PrintStream(new File("1.out"));
		int T = Integer.parseInt(in.nextLine());

		for (int tt = 0; tt < T; tt++) {

			int a=in.nextInt(),b=in.nextInt();
			HashSet<Long> sols=new HashSet<Long>();
			for(int n=a;n<=b;n++)
			{

				String str="";
				str+=n;
				int len=str.length();
				for(int j=1;j<len;j++)
				{
					
					int p1,p2,m;
					p1=Integer.parseInt(str.substring(0,j));
					p2=Integer.parseInt(str.substring(j));
					m=p1=Integer.parseInt(""+p2+p1);
					if(m>n && m<=b )
						sols.add(n*2000001l+m);
				}
			}
			out.printf("Case #%d: %d\n", tt + 1, sols.size());

		}
	}
}