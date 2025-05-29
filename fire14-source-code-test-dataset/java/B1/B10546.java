import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;


public class Recycled {
	private static int NN = 10010; 
	private static BufferedReader bf;
	private static File f;
	
	public static void main(String[] args) throws Exception {
		f = new File("rasdjfh.in");
		FileWriter out = new FileWriter(new File("recycled.txt"));
		if(f.exists())
			bf = new BufferedReader(new FileReader(f));
		else 
			bf = new BufferedReader(new InputStreamReader(System.in));
		String line = "", pars[],s ,x;
		ArrayList<HashSet<Integer>> recycled = new ArrayList<HashSet<Integer>>(NN);
		for(int i=0;i<NN;i++)
		{
			s = ""+i;
			recycled.add(new HashSet<Integer>());
			for(int j=1;j<s.length();j++)
			{
				x = s.substring(0, j);
				x = s.substring(j)+x;
				Integer I;
				if((I = Integer.parseInt(x)) > i)
					recycled.get(i).add(I);
			}
		}
		System.out.println("Ok, I'm ready…");
		int T = Integer.parseInt(bf.readLine()),  A , B;
		for(int t=1;t<=T;t++)
		{
			pars = bf.readLine().split("[ ]+");
			A = Integer.parseInt(pars[0]);
			B = Integer.parseInt(pars[1]);
			int ans = 0;
			for(int i=A;i<=B;i++)
			{
				for(Integer j : recycled.get(i))
					if(j >= A && j <=B)
						ans++;
			}
			out.write(String.format("Case #%d: %d\n",t,ans));
		}
		out.close();
	}
}
