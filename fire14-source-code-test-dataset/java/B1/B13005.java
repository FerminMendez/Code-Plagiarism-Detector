/*
 * recycle nums
 */
package google.code.jam;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Jake
 */


public class GoogleCodeJam {
    private static int Min;
    private static int Max;
    private static PrintWriter  out= null;
    private static File input;
    private static Scanner in;
    private static boolean used[];
    public static void main(String[] args) {
        input = new File("C:/Users/Jake/Documents/C-small-attempt1.in");
        String tmp ;
        int intTmp;
        int count = 1;
		try {
			out= new PrintWriter("C:/Users/Jake/Documents/out.txt");
                        in = new Scanner(input);
                        //in = new Scanner(System.in);
                        
                        in.nextLine();
                        while(in.hasNext()){
                            Min = in.nextInt();
                            Max = in.nextInt();
                            //in.nextLine();
                            intTmp = Runner();
                            out.println("Case #"+ count + ": " +intTmp);
                            count++;
                        }
                        out.flush();
                        
                        //tmp = in.nextLine();
                        
                        
                        //System.out.println(Runner());
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    private static int Runner(){
        //checks for the number of pairs between min and max
         used = new boolean[Max-Min];
        reset(used);
        int Count = 0;
        
        for(int a = Min; a < Max; a ++){
           reset(used);
           Count = Count + checker(a);
        }
        return Count;
    }
    private static int checker(int Try){
        //finds how many pairs are within the range
        int pairs= 0;
        int test=Try;
        String strtry = new String(Try +"");
        for(int a = 0; a <= strtry.length()-1; a ++){
            if(Integer.parseInt(strtry)<=Max && Integer.parseInt(strtry)>Try && !used[Integer.parseInt(strtry)-Min-1]){
                pairs ++;
                used[Integer.parseInt(strtry)-Min-1] = true;
                System.out.println("pair : "+Try+" < "+ strtry+ " < " + Max);
            }
        
            strtry = rotate(strtry);
        }
            
        return pairs;
    }
    private static String rotate(String num){
        //takes the end of the string and makes it the beging
        String tmp, last;
        last = ""+num.charAt(num.length()-1);
        tmp = num.substring(0,num.length()-1);
        num = last+ tmp;
        return num;
    }
    private static boolean[] reset(boolean a[]){
        //reset the check if used array
        for(int b = 0; b <a.length; b ++){
            a[b] = false;
        }
        return a;
    }
}
