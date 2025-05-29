import java.util.Scanner;
import java.util.ArrayList;


public class RecycledNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String st = in.nextLine();
		
		int n = Integer.parseInt(st);
		int a[][] = new int[n][2];
		int ans[] = new int[n];
		for(int i = 0; i< n;i++)
		{
			st = in.nextLine();
			String s[] = st.split(" ");
			
			a[i][0] = Integer.parseInt(s[0]);
			a[i][1] = Integer.parseInt(s[1]);
			
			ans[i] = getValue(a[i]);
		}
		
		for(int i=0;i<n;i++)
		{
			System.out.println("Case #"+(i+1)+": " + ans[i]);
		}	

	}
	
	private static int getValue(int a[])
	{
		int count =0;
		int m,n,k,l;
		ArrayList<String> arr = new ArrayList<String>();
		for(int i =a[0];i<= a[1];i++)
		{
			m=i;
			k=10;
			n=0;
			arr.clear();
//			System.out.print( m + "  : ");
			while(m != 0)
			{
				l = m%10;
				m=m/10;
				n=(l*k/10)+n;
				l=Integer.parseInt((String.valueOf(n) + String.valueOf(m)));
				if(l>=a[0] && l <= a[1] && l > i && !arr.contains(String.valueOf(l))) 
				{					
//					System.out.print(l +"  ");
					arr.add(String.valueOf(l));
					count++;
				}
				k*=10;
			}
//			System.out.println();
		}
		return count;
		
	}

}
