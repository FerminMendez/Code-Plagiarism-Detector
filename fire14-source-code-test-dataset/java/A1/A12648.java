/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codejam2012;

import java.util.Scanner;

/**
 *
 * @author Matt
 */
public class ProbB {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Integer cases = scan.nextInt();
        for(int i = 0; i < cases; i++){
            Integer contestants = scan.nextInt();
            Integer surprising = scan.nextInt();
            Integer num = scan.nextInt();
            Integer count = 0;
            //System.out.print(surprising);
            for(int j = 0; j < contestants; j++){
                Integer current = scan.nextInt();
                Double average = current/3.0;
                if(average >= num){
                    count++;
                }else if(average == 0 || average == 10){
                    
                }else if(average.intValue() == average.doubleValue()){
                    if(surprising > 0 && (average+1) >= num){
                        count++;
                        surprising--;
                        //System.out.print(surprising);
                    }
                }else if(average.intValue()+1 >= num) {
                    count++;
                }else if(average > 0.5 && surprising > 0 && average.intValue()+2 >= num) {
                    count++;
                    surprising--;
                    //System.out.print(surprising);
                }
            }
            //System.out.print(surprising);
            System.out.println("Case #"+(i+1)+": "+count);
        }
    }
}
