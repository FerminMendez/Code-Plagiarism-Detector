import java.io.*;
import java.util.*;

public class RecycledNumbers
{
    static String moveToFront (String nStr, int size){
        return nStr.substring(nStr.length()-size, nStr.length()) + nStr.substring( 0, nStr.length() - size);
    }
    static boolean isRecycle (int n, int m){
        String nStr = Integer.toString( n );
        String mStr = Integer.toString( m );
        for (int size = 1; size < nStr.length(); size++){
            if (moveToFront(nStr,size).equals(mStr))
                return true;
        }
        return false;
    }
    static HashMap<Integer, LinkedList<Integer>> possibleNM (int a, int b)
    {
        String bStr = Integer.toString( b );
        HashMap<Integer,LinkedList<Integer>> map = new HashMap<Integer,LinkedList<Integer>>();
        for ( int i = a; i < b; i++){
            LinkedList<Integer> list = new LinkedList<Integer>();
            if ( Integer.toString(i).length() > bStr.length())
                break;
            for ( int j = i + 1; j <= b; j++)
                list.add( j );
            map.put( i, list);
        }
        return map;
    }
    public static void main (String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader("recycle.in"));
        int T = Integer.parseInt(reader.readLine());
        int output = 0;
        int a,b;
        HashMap<Integer,LinkedList<Integer>> possibleNM;
        LinkedList<Integer> list;
        for ( int i = 0; i < T; i++){
            StringTokenizer st= new StringTokenizer(reader.readLine());
            a = Integer.parseInt( st.nextToken() );
            b = Integer.parseInt( st.nextToken() );
            possibleNM = possibleNM(a,b);
            for ( int j = a; j <b; j++){
                try{
                    list = possibleNM.get(j);
                    for (int k = 0; k < list.size(); k++){
                        //if (j == 146 && list.get(k) == 461)
                            //System.out.println("j = " + j);
                        if ( isRecycle(j,list.get(k))){
                            //System.out.println(j+","+list.get( k ));
                            output++;
                        }
                    }
                }
                catch (NullPointerException e){
                }
            }
            System.out.println("Case #" +(i+1) + ": " + output);
            output = 0;
        }   
    }
}