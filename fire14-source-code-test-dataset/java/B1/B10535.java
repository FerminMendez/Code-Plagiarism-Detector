import java.util.*;

public class RecycledNum
{
  private static int testCase;

  
  public static void main( String[] args )
  {
    Scanner s = new Scanner( System.in );
    RecycledNum r = new RecycledNum();
    r.setTestCase(Integer.parseInt(s.nextLine()));
    for( int i = 0; i < testCase; i++ )
    {
      int A = s.nextInt();
      int B = s.nextInt();
      s.nextLine();
      if( B/A < 10)
      {
        System.out.println( "Case #" +(i+1) +": " + r.recycle( A, B ) );
      }
    }
  }
  public RecycledNum()
  {
    this.testCase = 1;
  }
  public void setTestCase( int T )
  {
    if( T>=1 && T<=50 )
      this.testCase = T;
  }
  public int getTestCase()
  {
    return this.testCase;
  }
  public int recycle(int A, int B)
  {
    int n = 0;
    double j = A;

    int count = 0;
    while( j >= 1)
    {
      j = j/10;
      n = n + 1;
    }
    for( int i = A; i <= B; i++ )
    {
      //System.out.println("original "+ i);
      char[] array = new char[n];
      String numstri = i + "";
      for( int m = 0; m < n; m++)
      {
        array[m]=numstri.charAt(m);
      }
      int[] pair = new int[n];
      for( int q = 0; q< pair.length; q++)
      {
        pair[q] = 0; 
      }
      int count2 = 0;
      for ( int k = 0 ; k < n-1; k++ )
      {
        
        String str = "";
        String rts = "";
        for( int p = 0; p < n - k-1; p++ )
        {
          str = str + array[p];
          ///System.out.println( str );
        }
        for( int p = n-k-1; p < n; p++)
        {
          rts = rts + array[p];
           //System.out.println(rts );
        }
        String stri = rts + str;
        // System.out.println( stri);
        int num = Integer.parseInt(stri);
        boolean check = true;
        if( num <= B && num >= A && num != i )
        {
          
          for( int q = 0; q < pair.length;q++ )
          {
            if(pair[q] == num ){
              check = false;
            }
          }
          if( check )
          {
            count++;
            count2++;
           // System.out.println(count);
            pair[count2-1] = num;
            //System.out.println( num +" ");
          }
          
        }
      }
 
    }
    return count/2;
  }
  
  
}