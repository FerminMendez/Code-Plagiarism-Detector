package gcj2012;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Google Code Jam 2012 C - Recycled Numbers
 * 
 * @author Ruli Manurung (maruli@cs.ui.ac.id)
 */
public class QC
{
	public static void main(String[] args) throws FileNotFoundException,
			IOException
	{
		String fileName = args[0];
		BufferedReader input = new BufferedReader(new FileReader(fileName));

		StringTokenizer token = new StringTokenizer(input.readLine());
		int t = Integer.parseInt(token.nextToken());

		for (int ii = 0; ii < t; ii++)
		{
			token = new StringTokenizer(input.readLine());
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
			
			int recycled = 0;
			
			for(int jj=a; jj<b; jj++)
				for(int kk=jj+1; kk<=b; kk++)
					if(recyclable(jj,kk)) recycled++;
					
			System.out.println("Case #" + (ii + 1) + ": "
					+ recycled);
		}
		input.close();
	}
	
	static boolean recyclable(int jj, int kk)
	{
		String sjj = jj+"";
		int length = sjj.length();
		for(int ii=1; ii<sjj.length(); ii++)
		{
			String nu = sjj.substring(length-ii) + sjj.substring(0, length-ii);
			if(Integer.parseInt(nu)==kk) return true;
		}
		return false;
	}
}
