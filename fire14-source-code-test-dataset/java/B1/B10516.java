import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class QuestionC {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		File fileread = new File("C-small-attempt0.in.txt");
		File filewrite = new File(QuestionC.class.getName() + "output.txt");
		GCIFileReader fr = new GCIFileReader(fileread);
		GCIFileWriter fw = new GCIFileWriter(filewrite);
		GCIResult res = new GCIResult();
		String s = fr.getLine();
		int n = Integer.parseInt(s);
		List<Integer> m = new LinkedList<Integer>();
		for (int i=0; i < n ; i++)
		{
			String l = fr.getLine();
			Scanner sc = new Scanner(l);
			int tres = 0;
			int tn = 0;
			int tm = 0;
			int newnum = 0;
			int A = sc.nextInt();
			int B = sc.nextInt();
			int length = Integer.toString(A).length();
			length--;
			for(int j=A ; j <= B ; j++)
			{
				int tlength = length;
				m.clear();
				while(tlength>0)
				{
					tn = (int) (j % (Math.pow(10,tlength)));
					tm = (int) (j / (Math.pow(10,tlength)));
					newnum = (int) (tn*(Math.pow(10, Integer.toString(tm).length())) + tm);
					if (!m.contains(newnum) &&newnum <= B  && j < newnum && Integer.toString(tn).length() == tlength && Integer.toString(tm).length() == (length+1 - tlength))
					if (newnum <= B && tn!=0 && j < newnum)
					{
						tres++;
						m.add(newnum);
					}
					tlength--;
				}
			}
			res.addCase(String.valueOf(tres));
		}
		fw.writeResult(res);
	}

}
