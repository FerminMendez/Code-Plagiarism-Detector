import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Recycle 
{
	public static void main(String[] args) throws IOException 
	{
		Scanner s = new Scanner(new File("C-small-attempt0.in"));
		FileWriter strm = new FileWriter("out1.txt");
		BufferedWriter out = new BufferedWriter(strm);
		int cases = s.nextInt();
		s.nextLine();
		int count = 1;
		while(count - 1 < cases)
		{
			int A = s.nextInt();
			int B = s.nextInt();
			out.write("Case #" + count + ": " + calc(A,B) + "\n");
			count++;
		}
		out.close();
	}
	private static int calc(int a, int b)
	{
		int count = 0;
		for(int i = a; i<=b;i++)
		{
			count+=numPairs(i,a,b);
		}
		return count;
	}
	private static int numPairs(int i,int a, int b)
	{
		char[] arr = Integer.toString(i).toCharArray();
		char[] newArr = new char[arr.length];
		ArrayList<Integer> list = new ArrayList<Integer>();
		int count = 0;
		for(int j= 1;j<arr.length;j++)
		{
			for(int k = 0;k<arr.length;k++)
			{
				newArr[k] = arr[(k+j)%arr.length];
			}
			int res = Integer.parseInt(String.copyValueOf(newArr));
			if(a <= i && i < res && res <=b && !list.contains(res))
			{
				count++;
				list.add(res);
			}
			for(int k = 0;k<arr.length;k++)
			{
				newArr[k] = arr[(arr.length-j+k)%arr.length];
			}
			res = Integer.parseInt(String.copyValueOf(newArr));
			if(a <= i && i < res && res <=b && !list.contains(res))
			{
				count++;
				list.add(res);
			}
		}

		return count;
	}
}
