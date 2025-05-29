import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class RecycledNumbers {

	/**
	 * @param args
	 */
	static int a = -1;
	static int b = -1;
	static int T = -1;
	static int A = -1;
	static int B = -1;
	static File newFile = null;
	static Scanner scan = null;
	static int[] n = null;
	static int[] m = null;
	static int q = 1;
	static int num = 1;
	static int count = 0;

	public static void main(String[] args) throws IOException {


		try 
		{
			
			newFile = new File("C:/Users/PANKAJJAKHAR/Desktop/small.in");
			scan = new Scanner(newFile);
			scan.hasNextLine();
			T = scan.nextInt();
			while(scan.hasNextLine())
			{
				if(!scan.hasNextInt())
					return;
//				A = scan.nextInt();
//				B = scan.nextInt();
				
				for(int f = 0; f < 1; f++)
				{
					A = scan.nextInt();
					B = scan.nextInt();
				}
				int nMin = A;
				int nMax = B - 1;
				int mMax = B;
				int mMin = A + 1;
				
				int c = 0;
				n = new int[B - A];
				m = new int[B - A];
				//fill n values
				
				for(int i = nMin; i <= nMax; i++)
				{
					n[c] = i;
//					System.out.print(" " + n[c]);
					c++;
				}
				
				int x = 0;
				//fill m values
				for(int j = mMin; j <= mMax ; j++)
				{
					m[x] = j;
//					System.out.print(" " + m[x]);
					x++;
				}
				
				
				int lenNnum = -1;
				for(int i = 0; i < n.length; i++)
				{
					int numN = n[i];
					String numNStr = Integer.toString(numN);
					lenNnum = numNStr.length();
//					if(lenNnum == 1)
//					{
//						
//					}
//					else 
					for(int j = 0; j < m.length; j++)
					{
						int mNumber = m[j];
						if(n[i] < mNumber)
						{
							for(int k = 0; k < lenNnum - 1; k++)
							{
								String newNumLead = numNStr.substring(0, k + 1);
								String newNumTrail = numNStr.substring(k + 1);
								String finalStr = newNumTrail + newNumLead;
								int lenFinalStr = finalStr.length();
								int finalInt = Integer.parseInt(finalStr);
								
								String mNumStr = Integer.toString(m[j]);
								int lenmNumStr = mNumStr.length();
//								if(lenFinalStr == lenmNumStr)
//								{
									if(finalInt == mNumber)
									{
										count = count + 1;
									}
//								}
							}
						}
					}
				}
								
				System.out.println("Case #" + num + ": " + count);
				num++;
				count = 0;
//				System.out.println(count);
			}
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		
	}

}
