import java.util.*;
import java.io.*;

public class googleC {
	
	public static void main(String[] args) throws IOException 
			{
				Scanner scan = new Scanner(new File("inputC.txt")); 
				FileWriter stream = new FileWriter("outputC.txt");
				BufferedWriter out = new BufferedWriter(stream);
				
				int cases = scan.nextInt();
				for (int i = 0; i < cases; i++)
				{
					int A = scan.nextInt();
					int B = scan.nextInt();
					int pairs = 0;
					
					for (int n = A; n < B; n++)
					{
						for (int m = n+1; m <=B; m++)
						{
							String first = "" + m;
							String second = "" + n;
							
							if (isRecycled(first, second) == true)
								pairs++;
							
						}
							
					}
					
					out.write("Case #" + (i+1) + ": " + pairs + "\n");
					
				}
				out.close();
			}

	public static boolean isRecycled(String s1, String s2) {
		return (s1.length() == s2.length()) && ((s1+s1).indexOf(s2) != -1);
	}
}
