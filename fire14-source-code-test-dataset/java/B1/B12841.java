import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;


public class RecycledNumbers {

	public static int getlength(int number)
	{
		int size = 1;
		number = number/10;
		while (number!=0)
		{
			size++;
			number = number/10;
		}
		
		return size;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner s = new Scanner (new File("C-small-attempt0.in")); 
//				(System.in);
		int i = s.nextInt();
		int a,b,sa,c,cnt,r;
		LinkedList<Integer> ll;
		for(int j = 0 ;  j < i ; j++)
		{
			a = s.nextInt();
			b = s.nextInt();
			sa = getlength(a);
			cnt = 0;
			for( int k = a ; k <= b; k++)
			{
				r = k;
				ll = new LinkedList<Integer>();
				if(getlength(r)>1)
				for (int l = 0 ; l < sa-1 ; l++)
				{
					c = r/(int)Math.pow(10, sa-1);
					r = (r-c*(int)Math.pow(10, sa-1))*10+c;
					if(r<=b&&r>k&&!ll.contains(r))
					{
					ll.add(r);	
					cnt++;
					}
				}
			}
			System.out.println("Case #"+(j+1)+": "+(cnt));
		}
		
		
	}
	
}
