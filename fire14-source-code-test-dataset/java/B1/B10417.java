package com.google.codjam.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class RecycledNumbers implements ProblemInterface {
    
    
    public String run(ArrayList dataCase) {
        ArrayList numbers= dataCase;
        String aString = numbers.get(0).toString().split(" ")[0];
        String bString = numbers.get(0).toString().split(" ")[1];
        HashMap map = new HashMap();
        
        int A = Integer.parseInt(aString) ;
        int B = Integer.parseInt( bString) ;
       
        int counter =0;
        int minMov=1;
        int currentM=minMov;
        int maxMov=aString.length();
        System.out.println("***************INICIO");
            while(maxMov>currentM)
            {
                for ( int i=A ; i <B+1 ; i++ )  
                {
                    if(findM(i,A,B,currentM,maxMov,map))
                    {
                        counter++;
                    }
                }currentM++;
            }
        
        System.out.println("***************FIN");
        return counter+"";
    }
    
    public boolean findM(int n,int A,int B, int movs,int max,HashMap map)
    {
        String nS=n+"";
        String finalS="";
        String tempS="";
        String endS="";
        nS=n+"";
        tempS = nS.substring(0,max-movs);
        endS =nS.substring(max-movs,max);
        finalS= endS+tempS;
        int m =Integer.parseInt(finalS);
        if((m>A-1&&m<B+1)&&n<m)
        {
            System.out.println("( "+n+" , " +m+")");
            String key = n+""+m;
            if(!map.containsKey(key))
            {
                map.put(key,null);
                return true;
            }
        }
    
        
        return false;
    }
}
