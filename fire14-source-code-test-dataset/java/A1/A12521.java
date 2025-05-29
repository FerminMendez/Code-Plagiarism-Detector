import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
public class DancingWiththeGooglers {
 
        public static void main(String[] args) throws Exception {
                PrintWriter out = new PrintWriter("output.out");
                Scanner in = new Scanner(new File("B-small-attempt19.in"));
        int testCases = in.nextInt();
        for (int i = 1; i <= testCases; i++){
                int N = in.nextInt(),counter=0;
                int S = in.nextInt();
                int P = in.nextInt();
                for(int j = 0 ; j < N ;j++){
                        int googler= in.nextInt();
                        if(googler%3 == 0 && googler!=0){
                                if(googler/3 >= P){
                                        counter++;
                                }
                                else if(googler/3 + 1 >= P && S!=0){
                                        counter++;
                                        S--;
                                }
                        }
                        else if (googler==0 && P==0){
                        	counter++;
                        }
                        else if(googler%3==1){
                                if(googler/3 + 1 >= P){
                                        counter++;
                                }
                        }
                        else if(googler%3==2){
                                if(googler/3 + 1 >= P){
                                        counter++;
                                }
                                else if(googler/3 + 2 >= P && S!=0){
                                        counter++;
                                        S--;
                                }
                        }
                }
                out.printf("Case #%d: %d",i,counter);
                out.printf("\n");
        }
        out.close();
        in.close();
 
        }
 
}