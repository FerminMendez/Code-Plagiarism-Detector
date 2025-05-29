import java.util.*;
public class triple
{
	public HashSet<Integer> theset=new HashSet<Integer>();
	public int first;
	public int second;
	public int third;
	public int total;
	public int p;
	public int state;//1 is norm, 2 is surp, 3 is noway
	public triple(int f, int s, int t)
	{
		theset.add(f);
		theset.add(s);
		theset.add(t);
		first=f;
		second=s;
		third=t;
		total=f+s+t;
		if((Math.abs(f-s)>2)||(Math.abs(f-t)>2)||(Math.abs(s-t)>2))
		{
			state=3;
		}
		else if(((Math.abs(f-s)<=1)&&(Math.abs(f-t)<=1)&&(Math.abs(s-t)<=1)))
		{
			state=1;
		}
		else
		{
			state=2;
		}
		p=Math.max(f, Math.max(s,t));
	}
	public String toString()
	{
		return first+"+"+second+"+"+third+"="+total+", max="+p+", state="+state;
		
	}
}
