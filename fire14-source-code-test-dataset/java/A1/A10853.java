package jam2012.qround;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class PB {
	public static void main(String args[])
	{
		int line = 0;
		try{
			BufferedReader br = new BufferedReader(new FileReader("B-small-attempt0.in"));
			BufferedWriter bw = new BufferedWriter(new FileWriter("B-small-attempt0.out"));
			String str;
			String[] strIn;
			Integer.parseInt(br.readLine());
			while ((str = br.readLine()) != null){
				strIn = str.split(" ");
				int i=0;
				int N = Integer.parseInt(strIn[i++]);
				int S = Integer.parseInt(strIn[i++]);
				float p = Integer.parseInt(strIn[i++]);
				int cases = 0;
				while(N>0){
					float score = Integer.parseInt(strIn[i++]);
					N--;
					if (score >= (3*p-2))
						cases++;
					else 
						if (score >= (3*p-4) && S>0 && score >=2){
							cases++;
							S--;
						}	
				}
				line++;
				bw.write("Case #"+line+": "+cases);
				bw.newLine();
			}
			br.close();
			bw.close();
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
}
