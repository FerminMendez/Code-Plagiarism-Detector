/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Happy;
import java.io.*;
import java.math.*;
import java.lang.*;
import java.util.*;
import java.util.Arrays.*;
import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.util.StringTokenizer;

/**
 *
 * @author ipoqi
 */
public class Happy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Happy().haha();
    }

    public void haha() {
        BufferedReader in = null;
        BufferedWriter out = null;
        try{
            in = new BufferedReader(new FileReader("B-small-attempt0.in"));
            out = new BufferedWriter(new FileWriter("B-small-attempt0.out"));
            int T = Integer.parseInt(in.readLine());
            System.out.println("T="+T);

            for(int i=0;i<T;i++){
                String[] line = in.readLine().split(" ");
                int N = Integer.parseInt(line[0]);
                int S = Integer.parseInt(line[1]);
                int p = Integer.parseInt(line[2]);
                //System.out.print(" N = "+N+"\n");
                //System.out.print(" S = "+S+"\n");
                //System.out.print(" p = "+p+"\n");
                int []t = new int[N];
                for(int j=0;j<N;j++){
                    t[j] = Integer.parseInt(line[3+j]);
                }
                //for(int j=0;j<N;j++){
                //    System.out.print(""+t[j]+" ");
                //}
                //System.out.print("\n");

                int ans = 0;

                for(int j=0;j<N;j++){
                    int base = t[j]/3;
                    int rest = t[j]%3;
 
                    if(rest == 0){
                        if(base >= p){
                            ans++;
                        } else {
                            if(S>0 && base>=1){
                                if((base+1) >= p){
                                    S--;
                                    ans++;
                                }
                            }
                        }
                    } else if(rest == 1){
                        if((base+1) >= p){
                            ans++;
                        }
                    } else {//rest == 2
                        if((base+1)>=p){
                            ans++;
                        } else {
                            if(S>0){
                                if((base+2)>=p){
                                    S--;
                                    ans++;
                                }
                            }
                        }
                    }
                    
                }


                out.write("Case #"+(i+1)+": "+ans+"\n");
                System.out.print("Case #"+(i+1)+": "+ans+"\n");
            }
            in.close();
            out.close();
        }catch(Exception e){
            e.printStackTrace();
            try{
                in.close();
                out.close();
            }catch(Exception e1){
                e1.printStackTrace();
            }
        }
        System.out.print("YES!\n");
    }

}
