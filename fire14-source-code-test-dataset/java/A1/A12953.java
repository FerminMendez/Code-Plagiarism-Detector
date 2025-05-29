import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;


public class ProblemB {
	public static void main(String [] args) throws NumberFormatException, IOException
	{
		BufferedReader r = new BufferedReader( new FileReader("C:\\Users\\ÐÐÐ\\Downloads\\B-small-attempt1.in"));
		ArrayList<String> s = new TestCaseReader().read(r);
		s = new ProblemB().remap(s);
		OutputPrinter p = new OutputPrinter();
		for (String str : s)
			p.print(str);
		p.m_writer.flush();
		p.m_writer.close();
		
	}

	private ArrayList<String> remap(ArrayList<String> s) {
		ArrayList<String> remapped = new ArrayList<String>();
		for (String str : s)
		{
			
			StringTokenizer tk = new StringTokenizer(str, "  ");
			
			int n_googlers = Integer.parseInt(tk.nextToken());
			int n_surprises = Integer.parseInt(tk.nextToken());
			int target_score = Integer.parseInt(tk.nextToken());
			int total = 0;
			
			for (int i = 0 ; i < n_googlers ; i ++ )
			{
				int score = Integer.parseInt(tk.nextToken());
				int score_div = score % 3;
				int score_avg = score /3;
				
				if (score < target_score)
					continue;
				
				if (score_avg  >= target_score&& score_div == 0)
					total++;
				else
				if (score_div > 0 && score_avg  >= target_score -1 )
				{
					total++;
				}
				else
				if (n_surprises > 0)
				{
					int avg_rest_of_score = (score - target_score)/2;
					if (score_avg >= target_score -2 && (target_score - avg_rest_of_score) <= 2)
					{
						total ++;
						n_surprises --;
					}
				}
				
			}
			remapped.add("" +total);
		}
		return remapped;
	}
}
