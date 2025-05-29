
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author andy
 */
public class RecycledNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        //char sd = '1';
        //int[] sdf = new int[ 10 ];
        
        //System.out.println( sdf[ 0 ] );
        
        
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
        
        String s = in.readLine();
        
        int numTestCases = Integer.parseInt(s);
        
        int a;
        int b;
        
        int len;
        
        for( int testCase = 1 ; testCase <= numTestCases ; testCase ++ )
        {
            int count = 0;
            
            String ab = in.readLine();
            
            String[] arrAB = ab.split(" ");
            a = Integer.parseInt(arrAB[0]);
            b = Integer.parseInt(arrAB[1]);
            
            //System.out.println( "ab: " + a + " " + b);
            
            int[] appearedInThisCycle = new int[numTestCases];
            
            char[] arrA;
            // arrA = arrAB[0].toCharArray();
            
            //len = arrA.length;
            
            for( int n = a ; n < b ; n ++ )
            {
                arrA = String.valueOf(n).toCharArray();
                len = arrA.length;
                
                int[] cycleArr = new int[ len ];
                
                for( int c = 0 ; c < len ; c ++)
                {
                    int aValue = 0;
                    
                    for( int ai = 0 ; ai < len ; ai ++)
                    {
                        aValue += Math.pow(10, ai) * Character.digit(arrA[ (c - ai + len) % len ],10);
                    }
                    
                    cycleArr[ c ] = aValue;
                    
                    boolean hasntAlreadyAppeared = true;
                    
                    for( int i = 0 ; i < c ; i ++ )
                    {
                        if( cycleArr[i] == aValue )
                        {
                            //System.out.println(":" + cycleArr[c] + " " + aValue);
                            hasntAlreadyAppeared = false;
                            //break;
                        }
                    }
                    
                    
                    
                    if( hasntAlreadyAppeared && aValue > n && aValue <= b )
                    {
                        //System.out.println(n + " and " + aValue );
                        
                        count ++;
                    }
                    
                    
                }
                
                
                
                
                
                
                
                
            }
            
            
            System.out.println("Case #" + testCase + ": " + count );
            
        }
    }
}
