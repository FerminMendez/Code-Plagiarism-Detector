package codeJam2012;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

public class B {

	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("input.in", "r");
		PrintWriter raf2 = new PrintWriter("output.txt");
		int testCases = Integer.parseInt(raf.readLine());
		for(int i=0;i<testCases;i++)
		{
			String[] caseI = raf.readLine().split(" ");
			int N = Integer.parseInt(caseI[0]);
			int S = Integer.parseInt(caseI[1]);
			int p = Integer.parseInt(caseI[2]);
			int least = 3*p;
			int counter=0;
			for(int j=0;j<N;j++)
			{
				int currentScore = Integer.parseInt(caseI[j+3]);
				if(currentScore >= least - 2)
					counter++;
				else
					if(currentScore >= least - 4 && least-4>0 && S > 0)
					{
						counter++;
						S--;
					}
			}
			raf2.write("Case #"+(i+1)+": "+counter);
			if(i!=testCases-1)
				raf2.println();
		}
		raf.close();
		raf2.close();
		
	}
}
