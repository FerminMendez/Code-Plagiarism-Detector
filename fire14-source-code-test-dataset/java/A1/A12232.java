/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

import java.util.Scanner;

/**
 *
 * @author Kristanto
 */
public class Practice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int test = s.nextInt();
        int[] result = new int[test];
        for (int x=0; x<test; x++){
            result[x] = 0;
            int googlers = s.nextInt();
            int surprising = s.nextInt();
            int limit = s.nextInt();
            for (int y=0; y<googlers; y++){
                int points = s.nextInt();
                if (points/3 >= limit){
                    result[x] = result[x]+1;
                } else if (points%3 >= 1){
                    if ((points/3)+1 == limit){
                        result[x] = result[x]+1;
                    }
                    else {
                        if (surprising != 0){ 
                            if ((points/3) + 2 == limit){
                                result[x] = result[x]+1;
                                surprising--;
                            }
                        }
                    }                 
                } else{
                    if (surprising != 0){
                        if ((points/3) + 1 == limit && points != 0){
                            result[x] = result[x] + 1;
                            surprising--;
                        }
                    }
                }
                
            }
        }
        
        for (int x=0; x<test;x++){
            System.out.println("Case #"+(x+1)+": "+result[x]);
        }
    }
}
