package qualification;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.BitSet;
import java.util.Scanner;

public class RecycledNumbers {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new FileInputStream("/home/meha/eclipse-android-workspace/Code Jam/Testcase/RecycledNumbers/C-small-attempt0.in"));
		
		FileWriter out = new FileWriter("/home/meha/eclipse-android-workspace/Code Jam/Testcase/RecycledNumbers/A-small.out");
		
		int T = in.nextInt();
		for(int i = 0; i < T; i++)
		{
			int A = in.nextInt();
			int B = in.nextInt();
			int count = 0;
			
			//for(int n=A, m=B; n < m; n++,m--)
			for(int n=A; n < B; n++)	
			{
				for(int m=B; n < m; m--)
				{
					if(areRecycled(n,m))
						count++;
				}
			}
			
			int tmp = i + 1;
			out.write("Case #" + tmp + ": " + count + "\n");
			System.out.print("Case #" + tmp + ": " + count + "\n");
		}
		out.close();
		//System.out.print(areRecycled(12345, 34512));
	}

	private static boolean areRecycled(int N, int M) {
		// TODO Auto-generated method stub
		String n = Integer.toString(N);
		String m = Integer.toString(M);
		
		if(n.length() != m.length())
			return false;
		
		BitSet sChar = new BitSet(m.length());
		for(int i = 0; i < m.length(); i++)
		{
			if(m.charAt(i) == n.charAt(0))
			{
				sChar.set(i);
			}
		}
		
		
		for(int i = sChar.nextSetBit(0); i >=0; i = sChar.nextSetBit(i+1))
		{
			String mstart = m.substring(0, i);
			String mend = m.substring(i, m.length());
			String nstart =  n.substring(0, n.length() - i);
			String nend = n.substring(n.length() - i, n.length());
			
			if(nstart.equalsIgnoreCase(mend) && nend.equalsIgnoreCase(mstart))
			{
				return true;
			}
		}
		
		return false;
	}

}
