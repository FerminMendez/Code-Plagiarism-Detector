import java.util.*;

public class RecycledNumber {
	int digits;
	Collection<String> set = new HashSet<String>(); 
	public int countInInterval(int a, int b)
	{
		int count = 0, rotation;
		String temp = ""+ a;
		this.digits = temp.length();
		
		
		for(int i = a; i<b; i++)
		{
			for(int j = 1; j<digits;j++)
			{
				rotation = rotate(i, j);
				if(rotation<=b&&rotation>i&&!set.contains(i+" "+rotation)){ 
					count++;
					set.add(i + " " + rotation);
				}
			}
		}
		return count;

	}
	
	private int rotate(int num, int distance)
	{
		String temp = ""+num;
		temp = temp.substring(distance)+temp.substring(0,distance);
		num = Integer.parseInt(temp);
		return num;
	}
}
