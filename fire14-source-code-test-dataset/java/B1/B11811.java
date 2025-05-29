/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codejamc;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 *
 * @author strigazi
 */
public class CodejamC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        TextFile file = new TextFile("input.txt");
        Iterator<String> it = file.iterator();
        PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
        String next; next = it.next();
        Integer cases,t; cases = new Integer(Integer.parseInt(next));
        Integer counter=0,A,B,comb=0,nn,mm;
        String sA,sB,n,m;
        StringTokenizer st;
        Set<String> set = new HashSet();
        while(it.hasNext()){
            set.clear();
            counter++;
            next = it.next();
            st = new StringTokenizer(next," ");
            sA = st.nextToken();
            sB = st.nextToken();
            A = Integer.parseInt(sA);
            B = Integer.parseInt(sB);
            
            for(int i=A;i<B;i++){
                t=i;
                n = new String();
                n = t.toString();
                for(int j=0;j<n.length();j++){
                    m = new String();
                    m = n.substring(j, n.length())+n.substring(0, j);
                    mm = new Integer(Integer.parseInt(m, 10));
                    if(m.charAt(0)!='0' && n.charAt(0)!='0'){
                        if((mm<=B) && mm!=i && mm>i){
                            if(!set.contains(m+","+n)){
                                set.add(n+","+m);
                                System.out.println(n+","+m);
                            }
                                
                        }
                    }
                }
            }
            out.println("Case #"+counter+": "+set.size());
            
        }
        
        out.close();
    }
}
