package qualification.q3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: ofer
 * Date: 14/04/12
 * Time: 20:31
 * To change this template use File | Settings | File Templates.
 */

public class Q3Solver {
    
    private Set<String> mapping;

    public Q3Solver(){
        mapping = new HashSet<String>();
    }
    
    public int solve(int a,int b){
        int res = 0;
        for (int i = a ; i <= b ; i++){
            res+= getNumberOfLegalRecycled(  b,  i);
        }
        return res;
    }

    private int getNumberOfLegalRecycled( int b, int num) {
        String numString = ""+num;
        int numDigits = numString.length();
        int res = 0;
        for (int i = 0 ; i < numDigits - 1 ; i++){
            String perm = numString.substring(numDigits - i - 1) + numString.substring(0,numDigits - i -1 );
            Integer newNum = Integer.parseInt(perm);
            String test = newNum+"";
            if (test.length() == numDigits){          //checks that there are no leading zeros
                if ( num != newNum  && newNum > num && newNum <= b){
                    if (!mapping.contains(newNum+","+num) && !mapping.contains(num+","+newNum))    {
                        res++;
                        mapping.add(num+ "," +newNum);
                        mapping.add(newNum +"," +num);
                    }

                }

            }
        }
    return res;
    }

}
