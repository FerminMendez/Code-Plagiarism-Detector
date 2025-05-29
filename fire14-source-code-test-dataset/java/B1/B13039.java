
public class RecycledNumbers {

	public RecycledNumbers() {
	}
	
	public int sumOfDigit (int x)
	{
		int sum = 0;
		while (x >0) 
		{
			sum+=x%10;
			x /=10;
		}
		return sum ;
	}
	
	String n ;
	String m ;
	String temp1_1 ;
	
	public boolean Recycled(int x,int y,int begin) // y > x 
	{
		if (x == y)
			return false ;
		
		if (sumOfDigit(x) != sumOfDigit(y))
			return false ;
		
		n = x+"" ;
		temp1_1 = x+"" ;
		m = y+"" ;
		
		
		while (begin< n.length() && n.charAt(begin) != m.charAt(0))
			begin++;
		
//		System.out.println("i = " + begin);
		
		if (begin == n.length())
			return false ;
		
		n = n.substring(begin);
		n += temp1_1.substring(0,begin);
		
//		System.out.println("1 = " + n);
//		System.out.println("2 = " +m);
		
		if (n.equals(m))
			return true ;
		if (begin<n.length())
			return Recycled(x, y, begin+1);
		else
			return false ;
	}
	
	public int numOfDisRecNum (int min , int max)
	{
		int counter = 0 ;
		
		for (int n =min;n<max;n++)
			for (int m=n+1 ;m<= max ;m++)
			{
				if (Recycled(n,m,0))
					counter ++ ;
			}
		
		return counter;
	}
	public static void main(String[] args) {
		
		RecycledNumbers obj = new RecycledNumbers();
		
		System.out.println(obj.numOfDisRecNum(1111 , 2222));
		
//		System.out.println(obj.Recycled(244,424,0));
		
//		System.out.println(obj.Recycled(12345,34512,0));
		
	}
}

