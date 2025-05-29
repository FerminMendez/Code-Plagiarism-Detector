package edu.nitin.codejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

public class Recycled {

	/**
	 * @param args
	 */
	public static long compute(long A, long B)
	{
		HashSet<String> setUnique = new HashSet<String>();
		long count = 0;
		long noOfDigits = 0;
		
		for(long i = A; i < B; i++)
		{
			noOfDigits = 1;
			long temp = i;
			while(temp/10 != 0)
			{
				noOfDigits++;
				temp = temp/10;
			}
			//System.out.println(i+" "+noOfDigits);
			long m, n;
			for(long k=1;k<noOfDigits;k++)
			{
				n = i;
				int divisor = (int) (Math.pow(10,k));
				int remainder = (int) (i % divisor);
				int quotient = (int) (i / divisor);
				//System.out.println("Results: "+divisor+" "+quotient+" "+remainder);
				m = (long) (remainder * Math.pow(10,(noOfDigits - k)) + quotient);
				if(A<=n && n < m && m <= B && (String.valueOf(n).length() == String.valueOf(m).length())){
					setUnique.add(n+" "+m);
				}
			}
			//System.out.println("Count: "+count);
		}
		return setUnique.size();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long A, B, count;
		
		File fin = new File("src/files/c.txt");
		File fout = new File("src/files/c1.txt");
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(fin));
			BufferedWriter bw = new BufferedWriter(new FileWriter(fout));
			long num = Integer.parseInt(br.readLine());
			for(int k=1;k<=num;k++)
			{
				String[] text = br.readLine().split(" ");
				A = Long.parseLong(text[0]);
				B = Long.parseLong(text[1]);
				count = compute(A,B);
				bw.write("Case #"+k+": "+count);
				bw.write("\n");
			}
			bw.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
