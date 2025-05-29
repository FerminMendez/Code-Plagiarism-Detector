import java.util.*;

public class Recycle {
	
	public static void main(String[] args) {
		
		Scanner br=new Scanner(System.in);
		int test=br.nextInt();
		int i,j,k,total=0,start,end,temp;
		String s,t;
		ArrayList<Integer> a=new ArrayList<Integer>();
		
		for(i=0;i<test;i++)
		{
			start=br.nextInt();
			end=br.nextInt();
			total=0;
			for(j=start;j<end;j++)
			{
				a.clear();
				s=String.valueOf(j);
				for(k=1;k<s.length();k++)
				{
					t=s.substring(k)+s.substring(0,k);
					temp=Integer.parseInt(t);
					if(temp>j && temp<=end) 
					{
						if(!a.contains(temp))
						{
							total++;
							a.add(temp);
						}
					}
				}				
			}
			System.out.println("Case #"+(i+1)+": "+total);			
		}		
	}
}
