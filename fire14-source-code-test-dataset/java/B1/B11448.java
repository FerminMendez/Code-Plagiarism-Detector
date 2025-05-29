import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class RecycledNumbers {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(args[0]));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(args[0]+".out")));
		String l = in.readLine();
		int N = Integer.parseInt(l);
		int i=1;
		
		while((l=in.readLine())!= null)
		{
			int cnt = 0;
			String[] ll = l.split(" ");
			out.print("Case #"+i+++": ");
			int A = Integer.parseInt(ll[0]);
			int B = Integer.parseInt(ll[1]);
			for(int n=A;n<B;n++)
				for(int m=n+1;m<=B;m++)
				{
					String nS = ""+n;
					String mS = ""+m;
					if(nS.length()!=mS.length()) continue;
					boolean ok=false;
					for(int z=1;z<nS.length();z++)
						if(nS.equals(mS.substring(z)+mS.substring(0, z)))
						{
							ok=true;
							break;
						}
					if(ok) cnt++;
				}
			out.print(cnt);
			if(i<=N)	out.println("");
		}
		in.close();
		out.close();
	}
}
