import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Author: Lloyd Mckenzie
 * Google code jam
 * 04/13/12
 * dancing problem: take in input of a series of numbers, find set of 
 * a series of 3 numbers that one series of numbers adds up to a given number
 * and the set contains the greatest number of series of numbers 
 * where a single number of a series is >= a specified number
 */
public class ProblemB {
	//possibly over a billion different permutations! whoopie!
	static int maximum;
	public static void main(String[] args)
	{
		if(args.length < 1)
		{
			System.out.println("Usage: filename");
			return;
		}
		
		Scanner scan;
		File filename;
		if(args.length == 2)
		{
			filename = new File(args[1]);
			try {
				scan = new Scanner(filename);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
		}
		else
		{
			filename = new File(args[0]);
			try {
				scan = new Scanner(filename);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return;
			}
		}
		int lines=0, caseNum=1;
		int amount, surprise, highmark, current;
		maximum=0;
//		do
	//	{
			lines = scan.nextInt();
			scan.nextLine();
			
			caseNum = 1;
			while(lines > 0)
			{
				System.out.print("Case #" + caseNum + ": ");
				maximum = 0;
				amount = scan.nextInt();
				Node [] list = new Node[amount];
				surprise = scan.nextInt();
				highmark = scan.nextInt();
//				if(highmark == 0)
//					System.out.print(amount);
//				else
//				{
					for(int i = 0; i < amount; i++)
					{
						current = scan.nextInt();
						list[i] = new Node(current);
					}
					recurse(list, 0, surprise, highmark, 0);
					System.out.print(maximum);
				//}
				System.out.println();
				lines--;
				caseNum++;
				scan.nextLine();
			}//if(true)return;
	//	}while(scan.hasNext());
		
	}
	
	public static void recurse(Node[] list, int count, int surprise, int highmark, int index)
	{
		//recursion loop through array, on each new element call recursive function
		if(index == list.length)
		{
			
			if(surprise == 0 && count > maximum)//System.out.println("here");
				maximum = count;
			return;
		}
		
		if(list[index].hasNext && surprise > 0)
		{
			if(list[index].great[1] >= highmark)
			{
				count++;
				surprise--;
				index++;
				recurse(list, count, surprise, highmark, index);
				count--;
				surprise++;
				index--;
			}
			else
			{
				index++;
				surprise--;
				recurse(list, count, surprise, highmark, index);
				index--;
				surprise++;
			}
		}
		
		if(list[index].great[0] >= highmark)
		{
			count++;
			index++;
			recurse(list, count, surprise, highmark, index);
			count--;
			index--;
		}
		else
		{
			index++;
			recurse(list, count, surprise, highmark, index);
			index--;
		}
		
	}
	
	public static class Node
	{
		int [] normal = new int[3];
		int [] spec = new int[3];
		int total;
		boolean hasNext = false;
		int [] great = new int[2];
		
		public Node(int total)
		{
			this.total = total;
			findNormal();
			great[0] = normal[0];
			if(normal[0] > 0)
			{
				hasNext = true;
				findSpec();
			}
		//	System.out.println("norm: " +normal[0]+" "+normal[1]+" "+normal[2]+"\nspec: " +spec[0] + " "+spec[1]+" "+spec[2]+"\ngreat: "+great[0]+" "+great[1]);
			else
			{
				spec[0] = normal[0];
				spec[1] = normal[1];
				spec[2] = normal[2];
				great[1] = great[0];
			}
		}
		
		private void findSpec() {
			if(normal[0]>normal[1])
			{
				spec[0]=normal[0]-2;
				spec[1]=normal[1]+1;
				spec[2]=normal[1]+1;
				great[1] = spec[1];
			}
			else if(normal[0] != 10)
			{
				spec[0]=normal[0]+1;
				spec[1]=normal[1]-1;
				spec[2]=normal[2];
				great[1] = spec[0];
			}
		}
		private void findNormal() {
			int val = (total/3);
			if(val*3 == total)
			{
				normal[0] = val;
				normal[1] = val;
				normal[2] = val;
		//		System.out.println("total "+total+"val "+val+"\n");
			}
			else if(val*3 == total-2)
			{
				normal[0] = (val+1);
				normal[1] =  (val+1);
				normal[2] =  val;
			}
			else
			{
				normal[0] = (val+1);
				normal[1] = val;
				normal[2] = val;
			}
		}		
	}
}



