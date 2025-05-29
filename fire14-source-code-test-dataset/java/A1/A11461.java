import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class problem {

	public static void main(String[] args)  throws IOException{
		final String filein = "C:\\Users\\BYTE\\Downloads\\b-small-attempt0.in";
		//final String filein = "C:\\Users\\byte\\Downloads\\NewFolder\\C-small-attempt6.txt";
	    BufferedReader in = new BufferedReader(new FileReader(filein));
	    
	    
		int tests=Integer.parseInt(in.readLine());
		
		int n=0,s=0,p=0,num=0;
		
		for(int i=0;i<tests;i++)
		{
			String s1[]=in.readLine().split(" ");
						
			n=Integer.parseInt(s1[0]);
			s=Integer.parseInt(s1[1]);
			p=Integer.parseInt(s1[2]);
			
			int sur=0;
			
			for(int j=3; j<n+3;j++)
			{
				int g = Integer.parseInt(s1[j]);
				
				if(g==0)
				{
					if(p==0)
						num++;
					continue;
				}
				int q= g/3,r = g%3;
				
				if(r==0)
				{	
					if(q>=p )
						num++;
					else if((q+1)>=p && !((q+1)>10))
					{
						num++;
						sur++;
					}
					
				}
				
				else if(r==1)
				{
					if((q+1)>=p && !((q+1)>10))
						num++;
					
				}
				
				else if(r==2)
				{
					if(q>=p )
						num++;
					else if((q+1)>=p && !((q+1)>10))
						num++;
									
					else if((q+2)>=p && !((q+2)>10))
					{
						num++;
						sur++;
					}
					
				}
				
			}
			int temp =0;
			
			if(num<=s) temp=num;
			else
				temp = num-(sur-s);
			
			System.out.println("Case #"+(i+1)+": "+temp);
			num=0;
			
		}
	}

}
