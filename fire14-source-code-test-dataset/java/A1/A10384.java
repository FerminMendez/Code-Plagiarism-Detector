/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codejam;

/**
 *
 * @author Dylan
 */
public class GooglerDance {
    int suprises;
    public GooglerDance(int sup)
    {
        suprises = sup;
        
    }
    
    public int getNumAboveP(int[] scores, int p)
    {
        int rNum = 0;
        for(int i = 0; i < scores.length; i++)
        {
            if(testAbove(scores[i], p))
                rNum++;
        }
        return rNum;
    }
    
    public boolean testAbove(int total, int p)
    {
        if(p == 0)
            return true;
        if(total == 0)
            return false;
        total -= p;
        if(p - total/2 < 2)
            return true;
        if(p - total/2 < 3 && suprises > 0)
        {
            suprises--;
            return true;
        }
        return false;
            
    }
    
    public boolean aboveP(int total, int p)
    {
        
        int avg = total/3;
        if(suprises > 0){
            avg += 2;
            if(avg > p)
                suprises--;
        }
        if(avg > p)
            return true;
        return false;
    }
    
}
