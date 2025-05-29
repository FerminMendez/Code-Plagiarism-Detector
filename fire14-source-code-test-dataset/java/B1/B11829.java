import java.util.Arrays;
import java.util.Scanner;


//Recycle
public class Main
{
	public static void main(String[] args)
	{
		Main main = new Main();
		main.run();
		
		//main.checkRecycle(123, 233);
	}
	
	
	public void run()
	{
		
		Scanner input = new Scanner(System.in); 
		
		int cases = input.nextInt();
		
		
		for(int i = 0; i < cases; i++)
		{
			int a  = input.nextInt();
			int b  = input.nextInt();
			
			//countRecycle(a,b);
			
			System.out.println("Case #" + (i+1) + ": " + countRecycle(a,b));
		}
		
		
	}
	
	public int countRecycle(int a, int b)
	{
		int count = 0;
		
		for(int i = a; i < b; i++)
		{
			int []alist = new int[10];
			//get the count of the digits in a
			String inum = Integer.toString(i);
			for(int w = 0; w < inum.length(); w++)
			{
				alist[Integer.parseInt(inum.substring(w,w+1))]++;
			}
			
			for(int j = i+1; j <= b; j++)
			{
				
				int []blist = new int[10];
				inum = Integer.toString(j);
				for(int x = 0; x < inum.length(); x++)
				{
					blist[Integer.parseInt(inum.substring(x,x+1))]++;
				}
				
				if(Arrays.equals(alist, blist) && checkRecycle(i,j))
				{
					//System.out.println(i + " " + j);
					count++;
				}
				
			}
			
		}
		
		return count;
	}
	
	public boolean checkRecycle(int a, int b)
	{
		String anum = Integer.toString(a);
		String bnum = Integer.toString(b);
		
		
		for(int i = 0; i < anum.length() - 1;i++)
		{
			//System.out.println(anum + " " +anum.substring(i+1, anum.length()) + "|" + anum.substring(0, i+1));
			if(bnum.equals(anum.substring(i+1, anum.length()) + anum.substring(0, i+1)))
				return true;
			
		}
		
		
		return false;
	}
	
	
}
