package googlers;

import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Comparator;
public class Googlers {
	
	public static void main(String[] args) {
		
		int n,s,p,count=0,t;		
		Scanner sin=new Scanner(System.in);
		
		t=Integer.parseInt(sin.nextLine());
		
		
		int result[]=new int[t];
		int j=0;
		
		if(t>=1 && t<=100)
		{
		for (int k = 0; k < t; k++) {
		count=0;	
		
			
        String ip = sin.nextLine();
        
        String[]tokens=ip.split(" ");
		
		
		n=Integer.parseInt(tokens[0]);
		s=Integer.parseInt(tokens[1]);
		p=Integer.parseInt(tokens[2]);
		
		if( (s>=0 && s<=n) && (p>=0 && p<=10) )
		{
		int[] total=new int[n];
		
		
		for (int i = 0; i < n; i++)
        {
            total[i] = Integer.parseInt(tokens[i+3]);
        }
		
		Comparator comparator=new PointComparator();
		PriorityQueue pq=new PriorityQueue<Point>(1, comparator);
		
		for (int i = 0; i < n; i++)
		{
			
			int x=total[i]/3;
			int r=total[i]%3;
			if(x>=p)
				count++;
			else if(x<(p-2))
				continue;
			else
			{
				//System.out.println("enter "+x+" "+(p-2));
				if(p-x==1)
				{
					Point temp=new Point();
					temp.q=x;
					temp.r=r;
					pq.add(temp);
				}
				else  // p-x=2
				{
					if(r==0)
						continue;
					else
					{
						Point temp=new Point();
						temp.q=x;
						temp.r=r;
						pq.add(temp);
					}				
					
				}
					
			}
			//System.out.println("hi "+pq.size());
			
		}
		
		
		
		while(pq.size()!=0)
		{
			Point temp=(Point)pq.remove();
			if(p-temp.q==1 && temp.q!=0)
			{
				if(temp.r>=1)
					count++;
				else
				{
					if(s!=0)
					{
						s--;
						count++;
					}
				}
			}
			else if(p-temp.q==2)
			{
				if(s!=0 && (temp.q+temp.r)>=p)
				{
					s--;
					count++;
				}
			}
			
				
		}
		
		//System.out.println(p);
		
		result[j++]=count;
		
		}
		}
		
		for (int i = 0; i < t; i++) 
		{
			System.out.println("Case #"+(i+1)+": "+result[i]);
		}
		}
		
	}
        
        
		
		/*Point x=new Point();
		x.q=8;
		Point y=new Point();
		y.q=6;
		Point z=new Point();
		z.q=7;
		
		pq.add(x);
		pq.add(y);
		pq.add(z);
		*/
		
		
		
		
	

}

class PointComparator implements Comparator<Point>
{
    @Override
    public int compare(Point x, Point y)
    {
        // Assume neither string is null. Real code should
        // probably be more robust
        if (x.q < y.q)
        {
            return 1;
        }
        if (x.q  > y.q)
        {
            return -1;
        }
        return 0;
    }
}



class Point
{
	int q,r;

	public int getQ() {
		return q;
	}

	public void setQ(int q) {
		this.q = q;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}
	
	
}
