import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Dancing {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br= new BufferedReader(new FileReader("C:\\codejam\\B-small-attempt0.in"));
		int cases=Integer.parseInt(br.readLine());
		int i=0;
		FileWriter wr=new FileWriter("c:\\codejam\\output.txt");
		for(;cases>0;cases--)
		{
			StringTokenizer values=new StringTokenizer(br.readLine());
			int n=Integer.parseInt(values.nextToken());
			int s=Integer.parseInt(values.nextToken());
			int p=Integer.parseInt(values.nextToken());
			int c=0;
			int bestscore=p*3-2>0?p*3-2:0;
			int surprisingscore=p*3-4>1?p*3-4:1;

			while(n>0)
			{
				int t=Integer.parseInt(values.nextToken());
				if(bestscore<=t)
				{
					c++;
				}
				else if(s!=0&&surprisingscore<=t)
				{
					s--;
					c++;
				}
				n--;
			}
			i++;
			wr.write("Case #"+i+": "+c+"\n");
		}
		wr.close();

	}

}
