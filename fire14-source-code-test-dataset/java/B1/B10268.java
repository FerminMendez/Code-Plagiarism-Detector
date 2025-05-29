
import java.util.HashSet;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;
import static java.lang.Math.*;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author milen.chechev
 */
public class RecycledNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input.txt"));
        Formatter out = new Formatter(new File("output.txt"));

        int t = in.nextInt();
        for(int k = 0; k < t ; k++){
            int a = in.nextInt();
            int b = in.nextInt();
            int digits = numberOfDigits(b);
            int accum = 0;
            for(int i = a ; i < b ; i++){
                int number = i;
                HashSet<Integer> visited = new HashSet<Integer>();
                for(int j = 1 ; j < digits; j++){                 
                    number = number/ 10 + (int)pow(10,digits-1)*(number%10);
                    if(number > i && number <= b && !visited.contains(number)){
                        accum++;
                        visited.add(number);
                    }
                }
            }
            out.format("Case #%d: %d\n",k+1,accum);
        }
        out.close();
    }
    public static int numberOfDigits(int number){
        int res = 0;
        while(number > 0){
            res++;
            number /=10;
        }
        return res;
    }

}
