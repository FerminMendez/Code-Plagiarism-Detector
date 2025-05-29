/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Round0;

import custom.Output;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 *
 * @author shyam
 */
public class B {
    static String inputfile="./src/Small.in";
    static String outputfile="./src/Small.out";
    //static String inputfile="./src/Large.in";
    //static String outputfile="./src/Large.out";

     public static void main(String args[])throws Exception{
        BufferedReader br=new BufferedReader(new FileReader(inputfile));
        PrintWriter pw = new PrintWriter(new FileWriter(outputfile));

        String row="";
        StringTokenizer st;

        // first line to count no of records
        row=br.readLine();
        int T=Output.ipri(row);

        
        // initial variables


        for(int count=1;count<=T;count++){
            row=br.readLine(); // read each record
            // tokenize: default space
            st=new StringTokenizer(row);
            int N = Output.ipri(st.nextToken());
            int S = Output.ipri(st.nextToken());
            int p = Output.ipri(st.nextToken());



            // variables
            int GT;
            int x,y,z;
            int sup=0;
            int[][] G = new int[N][3];
            // operations

            for(int i=0;i<N;i++){
                GT = Output.ipri(st.nextToken());
                x = Math.min(GT, GT/3 + Math.max(GT%3, 1));
                if(x==11) x=10;
                y = GT/3;
                z = GT-x-y;
                G[i][0] = x;
                G[i][1] = y;
                G[i][2] = z;
                if(x-z == 2) sup++;
                //Output.sopl(x+" "+y+" "+z);
            }

            java.util.Arrays.sort(G, new java.util.Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return b[0] - a[0];
                }
            });

            int max_G = 0;

            for(int i=N-1;i>=0;i--){
                if( G[i][0] == p ) break;

                if(sup > S && (G[i][0]-Math.min(G[i][1],G[i][2]))==2){
                    G[i][0]--;
                    G[i][2]++;
                    sup--;
                    
                }
            }
            for(int i=0;i<N;i++){
                if(sup > S && (G[i][0]-Math.min(G[i][1],G[i][2]))==2){
                    G[i][0]--;
                    G[i][2]++;
                    sup--;

                }
                if(G[i][0] >= p)
                   max_G++;
            }

            // printing output
            //Output.sopl("Case #"+count+": "+max_G);
            pw.println("Case #"+count+": "+max_G);


            // reset variables

        }

        br.close();
        pw.close();
    }

}
