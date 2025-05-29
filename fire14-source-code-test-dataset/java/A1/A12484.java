/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author leonardo
 */
public class Dance {
    
    static boolean canBeSurprising(int x1, int x2, int x3) {                
        if (x1 > 10 || x2 > 10 || x3 > 10)
            return false ;
        
        return (Math.abs(x1 -x2) >= 2) || (Math.abs(x1 -x3) >= 2) || (Math.abs(x2 -x3) >= 2) ;
    }
    
    /*static boolean canBeSurprising(int r, int x, int p) {                
        boolean[] res = new boolean[2] ;
        
        if (r == 0) {
            return canBeSurprising(x, x, x) || canBeSurprising(x-1, x+1, x) ;           
        }        
        else if (r == 1) {
            return canBeSurprising(x+1, x, x, p, res) || canBeSurprising(x+1, x+1, x-1) ;
        }
        else {
            canBeSurprising(x+2, x, x, p, res);
            canBeSurprising(x, x+1, x+1, p, res) ;        
        }
        return (! res[0] && res[1]) ? 1 : 0;
    }*/

    public static void main(String[] args) {               
        Scanner scanner = new Scanner(System.in) ;
        int inputSize = Integer.parseInt(scanner.nextLine()) ;
                
        for(int i = 1; i <= inputSize; i++) {
            String[] numbers = scanner.nextLine().split(" ") ;
                    
            int n = Integer.parseInt(numbers[0]) ;
            int s = Integer.parseInt(numbers[1]) ;
            int p = Integer.parseInt(numbers[2]) ;
            
            int count = 0 ;
            for(int googler = 0; googler < n; googler++) {
                int score = Integer.parseInt(numbers[googler + 3]) ;
                
                int r = score % 3 ;
                int x = score / 3 ;
                
                if (r == 0) {
                    
                    // possible maxs: x and x + 1
                    
                    if (x >= p)
                        count++ ;
                    else if ((score > 0) && s > 0 && (x + 1) >= p) {
                        s-- ;
                        count++ ;
                    }
                        
                }
                
                // r == 1 -> max = x + 1
                else if (r == 1 && (x + 1 >= p))
                    count++ ;
                
                else {
                                        
                   // possible maxs: x + 1 and x + 2 
                    
                   if ((x + 1) >= p)
                        count++ ;
                   else if ((x+2 <= 10) && (x+2 >= p) && (s > 0)) {
                        count++ ;
                        s-- ;
                    }
                }
            }
            System.out.println("Case #" + i + ": " + count) ;
        }                
    }
}

