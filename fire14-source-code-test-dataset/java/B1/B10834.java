
import java.util.ArrayList;
import java.util.Scanner;

public class CodeJam3 {

	public static void main(String[] args) {
		Scanner kb=new Scanner(System.in);
		int cases=kb.nextInt();
		for(int i=0;i<cases;i++)
		{
			long count=0;
			long value1=kb.nextInt();
			long value2=kb.nextInt();
			ArrayList<String> al=new ArrayList<String>();
			for(long k=value1;k<value2;k++)
			{
				String start=new Long(k).toString();
				long back=0;
				long next=0;
				for(int j=1;j<start.length();j++)
				{ 
					String temp=start.substring(j)+start.substring(0,j);
					long temp1=Long.parseLong(temp);
					next=temp1;
					if(value1<=k && k<temp1 && temp1<=value2)
					{
						/*al.add(temp);int m;
						for(m=0;m<al.size();m++)
						{
							if(temp1==Long.parseLong(al.get(m)))
							{
								
							}
						}
						if(m==al.size())
						{
							count++;
						}*/
						if(next!=back)
						{
							count++;
						}
						back=next;
						
						//System.out.println(k+"  "+temp1);
					}
				}					
			}
			System.out.println("Case #"+(i+1)+": "+count);
		}
		

	}

}
