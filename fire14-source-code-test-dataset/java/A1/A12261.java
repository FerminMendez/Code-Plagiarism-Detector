import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Principal 
{
	public static void main(String [] args) throws IOException
	{
		
		FileReader fr = new FileReader("B-small-attempt0.in");
		BufferedReader bf = new BufferedReader(fr);
		
		FileWriter bw = new FileWriter("B-small-attempt0.out");
		
		int res;
		int times = Integer.parseInt(bf.readLine());
		
		LinkedList<Integer> l = new LinkedList<Integer>();
		String str = bf.readLine();
		int i = 1;
		StringTokenizer st;
		while(i <= times)
		{
			st = new StringTokenizer(str);	
			while(st.hasMoreTokens())
			{
				l.add(Integer.parseInt(st.nextToken()) );
			}
			bw.write("Case #");
			bw.write(String.valueOf(i));
			bw.write(": ");
			l.pop();
			int s = l.pop();
			int p = l.pop();
			res = Triplet.triplete(l, p, s);
			bw.write(Integer.toString(res));
			bw.write("\n");
			str = bf.readLine();
			i++;
			l = new LinkedList<Integer>();
		}
		bw.close();
		bf.close();
	}
}
