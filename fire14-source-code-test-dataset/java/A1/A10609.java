import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author andy
 */
public class DancingWithGooglers {

    public static void main(String[] args) throws Exception {
        
        //char sd = '1';
        //int[] sdf = new int[ 10 ];
        
        //System.out.println( Math.ceil( 17 / 3.0 ) );
        
        String map = "yhesocvxduiglbkrztnwjpfmaq";
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
        
        String s = in.readLine();
        
        int numTestCases = Integer.parseInt(s);
        
        for( int testCase = 1 ; testCase <= numTestCases ; testCase ++ )
        {
            String strCase = in.readLine();
            
            String[] arrCase = strCase.split(" ");
            
            int count = 0;
            
            int numDancers = Integer.parseInt( arrCase[ 0 ] );
            int numSurprises = Integer.parseInt( arrCase[ 1 ] );
            int cutoff = Integer.parseInt( arrCase[ 2 ] );
            
            for( int i = 0 ; i < numDancers ; i ++ )
            {
                int score = Integer.parseInt(arrCase[ i + 3 ]);
                
                int modThree = score % 3;
                
                int divThree = score / 3;
                
                if( modThree > 0 ) divThree ++;
                
                if( divThree >= cutoff )
                {
                    count ++;
                }else if( numSurprises > 0 && (modThree == 0 || modThree == 2) && divThree > 1 && divThree + 1 >= cutoff)
                {
                    numSurprises --;
                    count ++;
                }
                
            }
            
            System.out.println("Case #" + testCase + ": " + count);
            
        }
    }
}