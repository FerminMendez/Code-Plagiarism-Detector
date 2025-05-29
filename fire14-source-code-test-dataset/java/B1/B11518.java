package qualificationround;

import java.io.*;
import java.util.*;

public class ProblemC {

	public static Set<Integer> h;
	/**
	 * @param args
	 */
	public static void main(String[] args)  throws IOException{
		Scanner sc = new Scanner(new FileReader("C.in"));
		PrintWriter out = new PrintWriter(new FileWriter("C.out"));
		int t = sc.nextInt();
		for (int caseNum = 1; caseNum <= t; caseNum++)
		{
			h = new HashSet<Integer>();
			int a = sc.nextInt();
			int b = sc.nextInt();
			int p = a;
			int count = 0;
			while (p<=b)
			{
				if (!h.contains(p))
				{
					count += rolling(p, a, b);					
				}
				p++;
			}
			out.println("Case #"+caseNum+": "+count);
		}
		out.close();
	}
	public static int rolling(int num,int a,int b)
	{
		h.add(num);
		String sNum = Integer.toString(num);
		String s = new String(sNum);
		int count = 1;
		for (int i = 0; i < sNum.length()-1; i++)
		{
			s = s.substring(s.length()-1).concat(s.substring(0,s.length()-1));
			//System.out.println(s);
			int p = Integer.parseInt(s);
			if (p == num)
				break;
			if (p >= a && p <= b )
			{
				h.add(p);
				count++;
			}
		}
		//return count;
		return (count-1)*count/2;
	}

}
