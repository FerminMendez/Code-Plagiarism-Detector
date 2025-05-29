package qualification.q2;

/**
 * Created by IntelliJ IDEA.
 * User: ofer
 * Date: 14/04/12
 * Time: 18:47
 * To change this template use File | Settings | File Templates.
 */
public class Q2Solver {
    
    public int solve(int n,int s,int p, int[] sums){
        
        int res = 0;
        int surprisesLeft = s;
        for (int sum : sums){
            int div = sum / 3;
            int mod = sum % 3;
            if (div >= p){
                res++;
            }
            else if( p - div == 1){
                if (div > 0 && mod == 0 && surprisesLeft > 0){
                    res++;
                    surprisesLeft--;
                }
                else if (mod > 0){
                    res++;
                }
            }
            else if (p -div ==2 && mod == 2 && surprisesLeft > 0){
                res++;
                surprisesLeft--;
            }
        }
        return res;
    }
}
