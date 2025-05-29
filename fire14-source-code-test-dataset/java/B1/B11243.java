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
            in = new BufferedReader(new FileReader("C-small-attempt0.in"));
            out = new BufferedWriter(new FileWriter("C-small-attempt0.out"));
            int T = Integer.parseInt(in.readLine());
            System.out.println("T="+T);

            //LinkedList<Integer> mm = new LinkedList<Integer>();
            //mm.add(new LinkedList<Integer>());
           //int[][] mm;
           //for(int ii=0;ii<mm.length;ii++){
           //     mm[0][ii] = 1;
           //}


            for(int i=0;i<T;i++){
                String[] line = in.readLine().split(" ");
                int A = Integer.parseInt(line[0]);
                int B = Integer.parseInt(line[1]);
                //System.out.print(" A = "+A+"\n");
                //System.out.print(" B = "+B+"\n");

                int ans = 0;

                if(A>=10){
                    for(int j=A;j<B;j++){
                        int n=j;
                        String N = Integer.toString(n);
                        int nlen = N.length();
                        List<Integer> oks = new ArrayList<Integer>();
                        for(int k=0;k<nlen-1;k++){
                            String M = "";
                            for(int kk=1;kk<=nlen;kk++){
                                 M = M + N.charAt((k+kk)%nlen);
                            }
                            int m = Integer.parseInt(M);
                            
                            if(m>n && m<=B) {
                                boolean isNewOne = true;
                                for(int kkk=0;kkk<oks.size();kkk++){
                                    //System.out.print(" KKK = "+oks.get(kkk)+"\n");
                                    if(m==oks.get(kkk)){
                                        isNewOne = false;
                                    }
                                }
                                if(isNewOne){
                                    //System.out.print(" N = "+N+"\n");
                                    //System.out.print(" M = "+M+"\n");
                                    oks.add(m);
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