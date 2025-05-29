import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Principal 
{
	public static void main(String [] args) throws IOException
	{
		Secundaria sec = new Secundaria();
		
		FileReader fr = new FileReader("C-small-attempt1.in");
		BufferedReader bf = new BufferedReader(fr);
		
		FileWriter bw = new FileWriter("C-small-attempt1.out");
		
		int res;
		int times = Integer.parseInt(bf.readLine());
		
		String str = bf.readLine();
		int i = 1;
		while(i <= times)
		{
			StringTokenizer st = new StringTokenizer(str);	
			int primero = Integer.parseInt(st.nextToken());
			int segundo = Integer.parseInt(st.nextToken());
			bw.write("Case #");
			bw.write(String.valueOf(i));
			bw.write(": ");
			res = sec.nVeces(primero, segundo);
			bw.write(Integer.toString(res));
			bw.write("\n");
			str = bf.readLine();
			i++;
		}
		bw.close();
	}
}
