import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class B {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("C:/Users/Farnoosh/Desktop/B-small.in"));
		FileWriter fw = new FileWriter("C:/Users/Farnoosh/Desktop/B-small.out");
		/*BufferedReader in = new BufferedReader(new FileReader("B-large.in"));
		FileWriter fw = new FileWriter("B-large.out");*/
		
		int N = 0;
		int S = 0;
		int P = 0;
		int num1 = 0;
		
		int Num = new Integer(in.readLine());
		for (int cases = 1; cases <= Num; cases++) 
		{	
			int count = 0;
			String[] ss = in.readLine().split(" ");
			N = Integer.parseInt(ss[0]);
			S = Integer.parseInt(ss[1]);
			P = Integer.parseInt(ss[2]);
			
			for(int i = 0 ; i < N ; i++){
				num1 = Integer.parseInt(ss[i+3]);
				
				if (P == 0 && num1 == 0){
					count++;
					continue;
				}
				if (num1 < Math.abs(P+2*(P-2)))
				{
					continue;
				}
				else if(num1 >= (P+2*(P-1)))
				{
					count++;
				}
				else {
					if (S > 0){
						count++;
						S--;
					}
				}// end of else
			}// end of for		 
			fw.write ("Case #" + cases + ": " + count + "\n");
		}
		fw.flush();
		fw.close();
	}

}