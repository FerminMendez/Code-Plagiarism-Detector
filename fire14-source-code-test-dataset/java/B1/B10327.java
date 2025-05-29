import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class three {
	public static void main(String[] args) {
		try {
			Scanner in = new Scanner(new File(args[0]));
			PrintWriter out = new PrintWriter( new FileWriter(args[1]));
			int T = in.nextInt();
			for(int i=0;i<T;i++)
			{
				int res = 0;
				String A = in.next();
				int a = Integer.parseInt(A);
				int b = in.nextInt();

				int l = A.length();

				for(int n=a;n<b;n++)
				{
					HashMap<String,Integer> ms;
					ms=shift(n,l);
			        for(String key : ms.keySet()) {
			            int m = ms.get(key);
						if(n<m && m<=b)
							res++;
			        }
				}
				out.println("Case #"+(i+1)+": "+res);
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static HashMap<String,Integer> shift(int n, int l) {
		HashMap<String,Integer> ms = new HashMap<String,Integer>();
		String N = String.valueOf(n);
		String m;
		for(int j=1;j<l;j++)
		{
			m = N.substring(j)+N.substring(0,j);
			ms.put(m,Integer.parseInt(m));
		}
		return ms;
	}
}
