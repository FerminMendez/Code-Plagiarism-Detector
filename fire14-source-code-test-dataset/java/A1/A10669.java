import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class DancingGoogle {

	/**
	 * @param args
	 * @throws IOException 
	 */

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new FileReader("./test2.txt"));
		FileWriter fstream = new FileWriter("./out2.txt");
		BufferedWriter out = new BufferedWriter(fstream);
		
		String str,str2;
		
		int i = 0;
		
		DancingGoogle mydg = new DancingGoogle();
		
		int numTestCase = Integer.parseInt(in.readLine());
		while ((str = in.readLine()) != null) {
			str2="";
			int numOK = 0;
			String[] toks;
			toks = str.split(" ");
			int numGoogles = Integer.parseInt(toks[0]);
			int numSP = Integer.parseInt(toks[1]);
			int criteria = Integer.parseInt(toks[2]);
			for(int j =3;j<toks.length;j++)
			{
				int temp = Integer.parseInt(toks[j])/3;
				int rm = Integer.parseInt(toks[j])%3;
				if(temp >= criteria) {
					numOK++;
					continue;
				}
				int diff = criteria - temp;
				if(rm > diff){
					numOK++;
					continue;
				} 
				else if( rm == 1 && diff == 1)
				{
					numOK++;
					continue;
				} 
				else if(rm == 2 && diff == 2 && numSP > 0)
				{
					numOK++;
					numSP--;
					continue;
				}
				else if(rm < diff && diff ==1 && numSP > 0 && temp-diff >=0)
				{
					numOK++;
					numSP--;
					continue;
				}

			}
			str2 = "Case #" + (++i) + ": " + numOK + "\n";
			out.append(str2);
			System.out.print(str2);
		}
		in.close();
		out.close();
	}

}
