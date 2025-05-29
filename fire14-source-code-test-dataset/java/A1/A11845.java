package Dancing;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.lang.Character;
import java.util.ArrayList;

public class DancingWithGooglers 
{
    static String path = "C:\\Users\\hao\\Documents\\NetBeansProjects\\CodeJam2012\\src\\Dancing\\Bs.in";
    static String out_path = "C:\\Users\\hao\\Documents\\NetBeansProjects\\CodeJam2012\\src\\Dancing\\Bs.txt";
    static BufferedReader inputStream;
    static PrintWriter outputStream;
    
    public static void main( String args[] )
    {
        try
        {
            inputStream = new BufferedReader( new FileReader(path));
            outputStream = new PrintWriter( new FileWriter(out_path));
            
            String num_tc = inputStream.readLine();
            int tc = Integer.parseInt(num_tc);
            
            for( int i = 0 ; i < tc ; i++ )
            {
                String get = inputStream.readLine();
                int info[] = ProcessInput(get);
                int fre = Process(info);
                String ot = "Case #"+(i+1)+": ";
                ot += fre;
                //System.out.println(ot);
                outputStream.write(ot+"\n");
            }
            
            if( outputStream != null )
                outputStream.close();
            if( inputStream != null )
                inputStream.close();
        }
        catch( IOException e )
        {
            ;
        }
    }
    
    private static int Process( int[] info )
    {
        int no_employee = info[0];
        int suprise = info[1];
        int points = info[2];
        
        for( int i = 3 ; i < info.length-1 ; i++ )
        {
            for( int j = i+1 ; j < info.length ; j++ )
            {
                if( info[i] < info[j] )
                {
                    int temp = info[i];
                    info[i] = info[j];
                    info[j] = temp;
                }
            }
        }
        
        int emp[][] = new int[no_employee][3];
        for( int i = 0 ; i < no_employee ; i++ )
        {
            for( int j = 0 ; j < 3 ; j++ )
            {
                emp[i][j] = 0;
            }
        }
        
        for( int i = 0 ; i < no_employee ; i++ )
        {
            int pts = info[3+i];
            for( int j = 0 ; j < pts ; j++ )
            {
                emp[i][j%3]++;
            }
        }
        
        for( int i = 0 ; i < no_employee ; i++ )
        {
            for( int j = 0 ; j < 3 ; j++ )
            {
                //System.out.print(emp[i][j]+" ");
            }
            //System.out.println();
        }
        
        //System.out.println("suprise");
        int count = 0;
        for( int i = 0 ; i < no_employee ; i++ )
        {
            if( count == suprise )
            {
                break;
            }
            
            if( !Check(emp[i],points))
            {
                int r[] = Suprise( emp[i]);

                if( r[0] != -1 && r[1] != -1 )
                {
                    if( r[0] == 0 && r[1] ==1 )
                    {
                        emp[i][0]++;
                        emp[i][1]--;
                    }
                    else if( r[0] == 0 && r[1] == 2)
                    {
                        emp[i][0]++;
                        emp[i][2]--;
                    }
                    else
                    {
                        emp[i][1]++;
                        emp[i][2]--;
                    }
                    count++;
                }
            }
        }
        
        /*
        for( int i = 0 ; i < no_employee ; i++ )
        {
            for( int j = 0 ; j < 3 ; j++ )
            {
                System.out.print(emp[i][j]+" ");
            }
            System.out.println();
        }
        * 
        */
        return CheckNum(emp,points);
        
    }
    
    private static int CheckNum( int[][] emp , int max )
    {
        //System.out.println("max: "+max);
        for( int i = 0 ; i < emp.length ; i++ )
        {
            for( int j = 0 ;j < emp[i].length ;j++)
            {
                //System.out.print(emp[i][j]+" ");
            }
            //System.out.println();
        }
        int fre = 0;
        for( int i = 0 ; i < emp.length ; i++ )
        {
            if( emp[i][0] >= max )
                {
                    fre++;
                }
        }
        //System.out.println(fre);
        return fre;
    }
    private static boolean Check( int[] pts, int max )
    {
        boolean valid = false;
        for( int i = 0 ; i < pts.length ; i++ )
        {
            if( pts[i] >= max )
            {
                valid = true;
                break;
            }
        }
        
        return valid;
    }
    
    private static int[] Suprise( int[] pts)
    {
        int r[] = new int[2];
        if( (Math.abs((pts[0]+1)-(pts[1]-1)) == 2) && (pts[1]>0) && (pts[0]>0))
        {
            r[0] = 0;
            r[1] = 1;
        }
        else if((Math.abs((pts[1]+1)-(pts[2]-1)) == 2)&& (pts[1]>0) && (pts[2]>0))
        {
            r[0] = 1;
            r[1] = 2;
        }
        else if((Math.abs((pts[0]+1)-(pts[2]-1)) == 2)&& (pts[0]>0) && (pts[2]>0))
        {
            r[0] = 0;
            r[1] = 2;
        }
        else
        {
            r[0] = -1;
            r[1] = -1;
        }
        
        return r;
    }
    private static int[] ProcessInput( String get )
    {
        String token = "";
        int N = 0;
        int S = 0;
        int P = 0;
        int i = 0;
        
        for( ; get.charAt(i) != ' '; i++)
        {
            token += get.charAt(i);
        }
        N = Integer.parseInt(token);
        token = "";
        i++;
        
        
        for( ; get.charAt(i) != ' '; i++ )
        {
            token += get.charAt(i);
        }
        S = Integer.parseInt(token);
        token = "";
        i++;
        
        for( ; get.charAt(i) != ' ';i++)
        {
            token += get.charAt(i);
        }
        P = Integer.parseInt(token);
        token = "";
        i++;
        
        int val[] = new int[N];
        int n = 0;
        for( ; i < get.length() ; i++ )
        {
            if( get.charAt(i) == ' ')
            {
                val[n] = Integer.parseInt(token);
                n++;
                token = "";
                i++;
            }
            token += get.charAt(i);
        }
        val[n] = Integer.parseInt(token);
        
        
        int r[] = new int[3+N];
        r[0] = N;
        r[1] = S;
        r[2] = P;
        
        /*
        System.out.println(N);
        System.out.println(S);
        System.out.println(P);
        
        * 
        */
        for(int z = 0,x=3 ; z < val.length ; z++,x++ )
        {
            //System.out.println(val[z]);
            r[x] = val[z];
        }
        
        return r;
    }
}
