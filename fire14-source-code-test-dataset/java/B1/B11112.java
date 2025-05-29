package CodeJam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class RecycledNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("D:\\workspace\\GoogleCodeJam\\data\\C-small-attempt0.in"));
			String line;
			BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\workspace\\GoogleCodeJam\\data\\C-small-attempt0.out"));
			
			line=reader.readLine();
			int c = Integer.parseInt(line);
			int i = 1;
			while ((line=reader.readLine()) != null) 
			{
				String[] ints = line.split(" ");
				int a,b;
				a = Integer.parseInt(ints[0]);
				b = Integer.parseInt(ints[1]);
				int cnt = countNumber(a,b);
				writer.write(String.format("Case #%s: %s", i, cnt));
				System.out.println(String.format("Case #%s: %s", i, cnt));
				if (i<c)
					writer.newLine();
				i++;
			} 
			writer.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static int countNumber(int a, int b)
	{
		int cnt = 0;
		for (int i=a;i<b;i++)
		{
			String is = String.valueOf(i);
			String ii = is + is;
			for (int j=i+1;j<=b;j++)
			{
				String js = String.valueOf(j);
				if (ii.contains(js))
					cnt++;
			}
		}
		
		return cnt;
	}
}
