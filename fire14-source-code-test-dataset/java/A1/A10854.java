package codeJam2011;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BufferedReader input = new BufferedReader (new InputStreamReader(new FileInputStream("./bin/codeJam2011/B-small-attempt0.in")));
			BufferedWriter output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("./bin/B.out")));
			
			int cases = Integer.parseInt(input.readLine());
			for ( int i =0; i < cases ;i++)
			{
				int bestCounter =0;
				String [] line = input.readLine().split(" ");
				int su = Integer.parseInt(line[1]);
				int best = Integer.parseInt(line[2]);
				
				
				for(int n =3; n<line.length; n++)
				{
					
					int score = Integer.parseInt(line[n]);
					if(score >= 3*best-2)
					{
						bestCounter++;
					}
					else if(3*best-4>0 & score >= 3*best-4   & su >0   )
					{
						bestCounter++;
						su --;
					}
					
				}
				output.write("Case #"+(i+1)+": "+bestCounter+"\n");
				System.out.println("Case #"+(i+1)+": "+bestCounter);
				
			}
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
