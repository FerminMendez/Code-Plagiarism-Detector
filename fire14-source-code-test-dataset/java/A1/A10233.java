import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class Dancing
{
	public int specials = 0;
	
	public int p = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		 BufferedReader stdin = new BufferedReader
	     (new InputStreamReader(System.in));
		 int n = Integer.parseInt(stdin.readLine());
	     int j = 0;
	     
	     while(j<n)
	     {
	    	 String read = stdin.readLine();
	    	 String arr[] =  read.split("\\s");
	    	 int qty = Integer.parseInt(arr[0]);
	    	 int s = Integer.parseInt(arr[1]);
	    	 int p = Integer.parseInt(arr[2]);
	    	 Dancing dancing = new Dancing();
	    	 dancing.specials = s;
	    	 dancing.p = p;
	    	 int total = 0;
	    	 
	    	 for(int i = 3; i<qty+3; i++ )
	    	 {
	    		total += processGoogler(Integer.parseInt(arr[i]) , dancing);
	    	 }
	    	 StringBuffer sb = new StringBuffer();
	    	 sb.append("Case #"+(j+1)+": ");
	    	 sb.append(Integer.toString(total));
	    	 j++;
	    	 System.out.println(sb.toString());
	     }
		
	}



	private static int processGoogler(int t, Dancing dancing ) 
	{
		if( t == 0 && dancing.p == 0)
			return 1;
		int k = 0;
		if( t != 0)
		{
			if((t-1) % 3 == 0)
			{
				k = (t-1)/3;
				if(k+1>=dancing.p)
					return 1;
				return 0;
			}
			if(t % 3 == 0)
			{
				k = t/3;
				if(k>= dancing.p)
					return 1;
				if(dancing.specials>0)
				{
					if(k+1>=dancing.p)
					{
						dancing.specials--;
						return 1;
					}
				}
			}
			if( (t-2) % 3 == 0)
			{
				k =(t-2)/3;
				if(k+1>= dancing.p)
				{
					return 1;
				}
				if(dancing.specials>0)
				{
					if(k+2>=dancing.p)
					{
						dancing.specials--;
						return 1;
					}
				}
			}
		}
		return 0;
	}
}
