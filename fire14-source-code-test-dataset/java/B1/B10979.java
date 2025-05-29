import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class recycled {


	public static void main(String[] args) throws IOException	
	{
		
		BufferedReader in = new BufferedReader(new FileReader("C-small-attempt0.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
		int nc = Integer.parseInt(in.readLine().trim());



		for (int z=1; z<=nc; z++){
			String[] line = in.readLine().trim().split("\\s+");
			int a = Integer.parseInt(line[0]);
			int b = Integer.parseInt(line[1]);
			boolean[] flgs = new boolean[2000000+1];
			int count = 0;
			for (int i = a; i <=b; i++)
			{
				
				List<Integer> list = new ArrayList<Integer>();
				list.add(i);
				if (flgs[i]) continue;
				
				int val = 1;
				String num1 = i+"";
				for (int j = 1; j <=num1.length(); j++)
				{

					String num2 = num1.substring(j) + num1.substring(0, j);
					int num = Integer.parseInt(num2);
					if (num2.charAt(0)!='0') if (num<=b&&num!=i&&num>a)  if (!flgs[num])
					{		
						list.add(num);
						val++;
						flgs[num] = true;
					}



				}
				val = val*(val-1);
				val>>=1;
				//if (val>0)tr(list);
				
				count+=val;	
				//if (val>0) System.out.println(count);

			}





			//MODIFY
			out.println(String.format("Case #%d: %d", z,count));
		}
		out.close();
	}
	public static void tr(Object...objects)
	{
		System.out.println(Arrays.deepToString(objects));
	}
}
