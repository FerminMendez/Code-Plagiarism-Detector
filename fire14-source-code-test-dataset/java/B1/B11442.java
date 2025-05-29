import java.util.LinkedList;
import java.util.HashMap;
import java.util.Scanner;

public class Recycled
{
	public static void main(String[] args) throws Exception
	{
        HashMap<Integer,LinkedList<String>> lol = new HashMap<Integer,LinkedList<String>>(); 
        
        for( int i = 1 ; i <= 2500; i++ )
        {
            LinkedList<String> ll = new LinkedList<String>();
            String _i = i + "";
            for( int k = 0 ; k < _i.length();k++)
            {
                String t = _i.substring( k , _i.length() ) + _i.substring( 0 , k );
                for( int j = 4 - t.length(); j >= 0; j-- )
                {
                    ll.add( t );
                    t = t + "0";
                }
            }
            
            lol.put( i , ll );
                
        }
    
		Scanner in = new Scanner( System.in );
		
		int size = in.nextInt();
        
		for( int pos = 1 ; pos <= size ;pos++ )
		{
			int A = in.nextInt();
			int B = in.nextInt();
			
			String _A = A + "";
			String _B = B + "";
			
            int count = 0;
            
			for( int i = A ; i < B ; i++ )
			{
				String a = i + "";
				if( a.length() != _A.length() ) continue;
				for( int j = i + 1; j <= B; j++ )
				{
					String b = j + "";
					if( b.length() != _B.length() ) continue;
                    
                    LinkedList<String> ll = lol.get( i );
                    if( ll.contains( b ) )
                    {
                        count++;
                    }	
				}
			}
			
			
			System.out.println("Case #" + pos + ": " + count);
		}
	}
}