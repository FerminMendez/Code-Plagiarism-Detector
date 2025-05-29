import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
public class Main2
{
	public static void main(String[] args) throws IOException
	{
		String line = " ";
		String line2 = " ";
		String line3 = " ";
		FileReader reader = new FileReader("B-small-attempt2.in");
		Scanner in = new Scanner(reader);
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> list2 = new ArrayList<String>();
		int number = 0;
		int numb = 0;
		int index = 0;
		
		int c;
		int N;
		int nprob;
		int hnum;
		int calc;
		boolean suc;
		int p;
		int[] num = new int[103];
		
		int count = in.nextInt();
		in.nextLine();
		
		for(int i = 0; i < count; i++)
		{
			line = in.nextLine();
			list.add(line);
		}
			
		while(count > 0)
		{
			p = 0;
			line2 = list.get(numb);
			number = 0;
			
			while(line2.length() > 0)
			{
				index = line2.indexOf(' ');
				if(index > 0)
				{
					line = line2.substring(0,index);
					num[number] = Integer.parseInt(line);
					line2 = line2.substring(index);
					line2 = line2.trim();
				}
				else if(index == -1)
				{
					num[number] = Integer.parseInt(line2);
					line2 = "";
				}
				number++;
			}
			
			
			
			N = num[0];
			nprob = num[1];
			hnum = num[2];
			suc = false;
			
			for(int j = 0; j < N; j++)
			{
				c = 3;
				calc = num[j+3];
				while(c > 0)
				{
					calc -= hnum;
					c--;
				}
			
				if(calc >= 0)
					suc = true;
				else if(calc == -1)
					suc = true;
				else if(calc == -2)
					suc = true;
				else if(nprob > 0 && calc == -3 && num[j+3] > 0)
				{
					suc = true;
					nprob--;
				}
				else if(nprob > 0 && calc == -4 && num[j+3] > 0)
				{
					suc = true;
					nprob--;
				}
				else
					suc = false;
					
				if(suc)
					p++;	
			}
			
										
			line3 = "Case #" + (numb+1) + ": " + p;
			list2.add(line3);
			count--;
			numb++;
			
		}
		
		for(String a : list2)
			System.out.println(a);
		
						
	}
}