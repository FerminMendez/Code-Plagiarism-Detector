import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class DancingWithTheGooglers {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(args[0]));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(args[0]+".out")));
		String l = in.readLine();
		int N = Integer.parseInt(l);
		int i=1;
		while((l=in.readLine())!= null)
		{
			int cnt = 0;
			out.print("Case #"+i+++": ");
			String ll[] = l.split(" ");
			int S = Integer.parseInt(ll[1]);
			int p = Integer.parseInt(ll[2]);
			//da ll[3]; a ll[ll.length-1]; somme
			ArrayList<Integer> amb = new ArrayList<Integer>();
			int cntA=0;
			for(int z=3;z<ll.length;z++)
			{
				int sum = Integer.parseInt(ll[z]);
				if(p==0)
				{
					cnt++;
					continue;
				}
				if(p==1)
				{
					if(sum>0) cnt++;
					continue;
				}
				int foo = p+(p-1)+(p-1);
				int bar = p+(p-2)+(p-2);
				if(sum>=foo) cnt++;
				else if(sum>=bar) cntA++;
			}
			cnt+= Math.min(cntA,S);
			out.print(cnt);
			if(i<=N) out.println("");
		}
		in.close();
		out.close();
	}
}
