import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class recycled_numbers 
{
	public static class Test
	{
		int a;
		int b;
		String a_str;
		String b_str;
	}
	
	public static boolean contains(ArrayList<Tuple> a,Tuple tuple)
	{
		boolean contain=false;
		for(int i=0;i<a.size();i++)
		{
			if(a.get(i).a==tuple.a && a.get(i).b==tuple.b)
			{
				contain=true;
				break;
			}
		}
		return contain;
	}
	
	public static Test getTest(Scanner a)
	{
		Test test=new Test();
		String str=a.nextLine();
		String str_array[]=str.split(" ");
		test.a_str=str_array[0];
		test.b_str=str_array[1];
		test.a=Integer.parseInt(test.a_str);
		test.b=Integer.parseInt(test.b_str);
		return test;
	}
	
	public static class Tuple
	{
		int a;
		int b;
	}
	
	public static int recycled(Test test)
	{
		int recycle=0;
		ArrayList<Tuple> array=new ArrayList<Tuple>();
		Tuple tuple=new Tuple();
		for(int j=test.a;j<=test.b;j++)
		{
			for(int i=1;i<test.a_str.length();i++)
			{			
				String str=Integer.toString(j).substring(i, test.a_str.length()) + Integer.toString(j).substring(0, i);
				int number=Integer.parseInt(str);
				if(number>=test.a && number<=test.b && number>j)
				{
					tuple.a=j;
					tuple.b=number;
					boolean bool=contains(array,tuple);
					if(!bool)
					{
						Tuple temp=new Tuple();
						temp.a=j;
						temp.b=number;
						recycle++;
						array.add(temp);
					}
				}
			}
		}
		return recycle;
	}
	
	public static void main(String[] args) throws FileNotFoundException 
	{
		Scanner input=new Scanner(new File("C-small-attempt0.in"));
		input.nextLine();
		int i=1;
		while(input.hasNextLine())
		{
			System.out.print("Case #" + i + ": ");
			Test test=getTest(input);
			int number=recycled(test);
			System.out.print(number + "\n");
			i++;
		}
	}
}
