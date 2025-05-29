/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package codejam2012;

import java.util.Scanner;

/**
 *
 * @author Kumudu
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String out="";
        Scanner in = new Scanner(System.in);
        String read = in.nextLine();
        int N = Integer.valueOf(read);
        for (int i = 0; i < N; i++) {
            read = in.nextLine();
            String [] str_vals = read.split(" ");
            int sup = Integer.valueOf(str_vals[1]);
            int min = Integer.valueOf(str_vals[2]);
            int min_tot = 3*min - 4;
            if(min<=1){
                min_tot = min;
            }
            int both=0;
            int non_sup=0;
            for (int j = 3; j < str_vals.length; j++) {
                if(Integer.valueOf(str_vals[j]) >= min_tot){
                    both++;
                }
                if(Integer.valueOf(str_vals[j]) >= (min_tot+2)){
                    non_sup++;
                }
            }
            if(min>=2){
                System.out.println("Case #"+(i+1)+": "+(non_sup  + Math.min(sup, (both-non_sup))));
            }
            if(min<=1){
                //System.out.println("ddr");
                System.out.println("Case #"+(i+1)+": "+both);
            }
        }
            
    }

}
