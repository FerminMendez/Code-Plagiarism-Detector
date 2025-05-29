import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Dancing {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Dancing();
	}
	
	public Dancing ()
	{
		solve();
	}
	
	/**
	 * Solves Problem A. Speaking in Tongues
	 */
	private void solve() {
		try {
			File f = new File("./in.txt");
			File output = new File("./p.dat");

			if (output.exists())
				output.delete();

			output.createNewFile();

			PrintWriter pw = new PrintWriter(output);
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);

			String linea = br.readLine();
			linea = br.readLine();

			ArrayList<Integer> ps = new ArrayList<Integer>();
			ArrayList<Integer> ss = new ArrayList<Integer>();
			
			ArrayList<ArrayList<Integer>> ts = new ArrayList<ArrayList<Integer>>();
			
			while (linea != null) {
				String [] instancia = linea.split(" ");
				int n = Integer.parseInt(instancia[0]);
				int s = Integer.parseInt(instancia[1]);
				int p = Integer.parseInt(instancia[2]);
				ArrayList<Integer> temp = new ArrayList<Integer>();
				
				ps.add(p);
				ss.add(s);
				
				for(int i=3;i<3+n;i++)
				{
					int t = Integer.parseInt(instancia[i]);
					temp.add(t);
				}
				ts.add(temp);
				
				linea = br.readLine();
			
			}

			br.close();
			fr.close();
			pw.println("maxscore:[");
			for(int i=0;i<ps.size();i++)
			{
				pw.println("("+(i+1)+")"+ps.get(i));
			}
			pw.println("]");
			
			pw.println("suprizing:[");
			for(int i=0;i<ss.size();i++)
			{
				pw.println("("+(i+1)+")"+ss.get(i));
			}
			pw.println("]");
			
			pw.println("scores:[");
			for(int i=0;i<ts.size();i++)
			{
				ArrayList<Integer> scores = ts.get(i);
				for(int j=0;j<scores.size();j++)
				{
					pw.println("("+(j+1)+","+(i+1)+")"+scores.get(j));
				}
			}
			pw.println("]");
			
			pw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
