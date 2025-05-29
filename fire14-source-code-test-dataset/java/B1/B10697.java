import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class RecycledNumber {

	/**
	 * @param args
	 * @throws IOException 
	 */

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new FileReader("./test3.txt"));
		FileWriter fstream = new FileWriter("./out3.txt");
		BufferedWriter out = new BufferedWriter(fstream);
		
		String str,str2;
		
		int i = 0;
		int numTestCase = Integer.parseInt(in.readLine());
		
		while ((str = in.readLine()) != null) {
			str2="";
			int numOK = 0;
			String[] toks;
			toks = str.split(" ");
			int LB = Integer.parseInt(toks[0]);
			int UB = Integer.parseInt(toks[1]);
			int numDigit = toks[0].length();
			int []prev = new int[numDigit-1];
			if(numDigit >1){
				for(int k = LB; k < UB;k++)
				{
					for(int j = 1; j< numDigit; j++)
					{				
						String temp = Integer.toString(k);
						String temp1 = temp.substring(0,j);
						String temp2 = temp.substring(j,numDigit);
						String result = temp2+temp1;
						int res = Integer.parseInt(result);
						
						if(res > k && res <= UB)
						{
							numOK++;
							for(int l = 0;l<j;l++)
							{
								if(res == prev[l]) numOK--;
							}	
						}
						prev[j-1] = res;
					}
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
