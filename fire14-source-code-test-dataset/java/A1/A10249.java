
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author milen.chechev
 */
public class Dancing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input.txt"));
        Formatter out = new Formatter(new File("output.txt"));

        int t = in.nextInt();
        for(int k = 0; k < t ; k++){
            int n = in.nextInt();
            int surprizing = in.nextInt();
            int limit = in.nextInt();
            int accum = 0;
            for(int i = 0 ; i < n ; i ++){
                int sum = in.nextInt();
                if(sum/3 >= limit){
                    accum ++;
                }else if( sum%3 == 0 ){
                    if(sum/3> 0 && sum/3+1 >=limit && surprizing>0){
                        accum ++;
                        surprizing--;
                    }
                }else if ( sum%3==1){
                    if(sum/3+1 >=limit){
                        accum++;
                    }else if(sum/3> 0 && surprizing > 0 && sum/3+2 >=limit){
                        accum++;
                        surprizing--;
                    }
                }else if(sum%3==2){
                    if(sum/3+1 >=limit){
                        accum++;
                    }else if(surprizing >0 && sum/3+2 >=limit){
                        accum++;
                        surprizing--;
                    }
                }
            }
            out.format("Case #%d: %d\n",k+1,accum);
        }
        out.close();
    }

}
