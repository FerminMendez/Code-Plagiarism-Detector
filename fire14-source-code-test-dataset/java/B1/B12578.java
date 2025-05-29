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
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author shyam
 */
public class C {
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

            // variables
            int A= Output.ipri((st.nextToken().toString()));
            int B= Output.ipri((st.nextToken().toString()));
            int c_pairs = 0;
            List pairs = new ArrayList();

            // operations
            for(int i=A;i<=B;i++){
                String dig = ""+i;
                if(dig.length() == 1){
                    break;
                }
                int pos=0;

                for(int j=0;j<dig.length()-1;j++){
                    pos=j+1;
                    for(int n=i+1;n<=B;n++){
                        int m = Output.ipri(dig.substring(pos)+dig.substring(0,pos));
                        if(n == m
                           && n != Output.ipri(dig.substring(0,pos)+dig.substring(pos))
                           && n != i
                           && i < m){

                            if(pairs.contains(i+"-"+m))
                                continue;
                            c_pairs++;
                            //Output.sopl(i+" - "+m);
                            pairs.add(i+"-"+m);
                            break;
                        }
                    }
                }
            }




            // printing output
            Output.sopl("Case #"+count+": "+c_pairs);
            pw.println("Case #"+count+": "+c_pairs);


            // reset variables

        }

        br.close();
        pw.close();
    }

}
