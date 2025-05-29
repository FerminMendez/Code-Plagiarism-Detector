import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DancingGooglers
{
    public int googlers( int surprise, int mincount, int[] scores )
    {
        int counter = 0;
        for( int i = 0; i < scores.length; i++ )
        {
            int s = scores[i] % 3;
            int base = scores[i] / 3;
            if( s == 0 )
            {
                if( base >= mincount )
                {
                    counter++;
                }
                else
                {
                    if( surprise > 0 && base > 0 && base + 1 >= mincount )
                    {
                        counter++;
                        surprise--;
                    }
                }
            }
            else if( s == 1 )
            {
                if(base >= mincount || base +1 >= mincount)
                {
                    counter++;
                }
                else
                {
                    if(surprise > 0 && base +1 >= mincount)
                    {
                        counter++;
                        surprise--;
                    }
                }    
                
            }
            else if( s == 2 )
            {
                if(base >= mincount || base +1 >= mincount)
                {
                    counter++;
                }
                else
                {
                    if(surprise > 0 && base +2 >= mincount)
                    {
                        counter++;
                        surprise--;
                    }
                }    
                
            }
        }
        return counter;
    }

    public static void main( String[] args )
    {
        DancingGooglers dg = new DancingGooglers();

        try
        {
            FileWriter fw = new FileWriter( "output.out" );
            BufferedWriter out = new BufferedWriter( fw );

            FileReader fr = new FileReader( "in.in" );
            BufferedReader br = new BufferedReader( fr );
            String size = br.readLine();

            String temp = "";
            int k = 0;
            while( ( temp = br.readLine() ) != null )
            {                
                String[] split = temp.trim().split( " " );
                int googlercount = Integer.parseInt( split[0] );
                int surprise = Integer.parseInt( split[1] );
                int mincount = Integer.parseInt( split[2] );
                int[] scores = new int[googlercount];
                for(int i = 0;i<googlercount;i++)
                {
                    scores[i] = Integer.parseInt( split[i + 3] );
                }
                out.write( "Case #" + ( ++k ) + ": " + dg.googlers( surprise, mincount, scores ) + "\n" );
            }
            
            fr.close();
            out.close();
        }
        catch( FileNotFoundException e )
        {
            e.printStackTrace();
        }
        catch( IOException e )
        {
            e.printStackTrace();
        }
    }
}
