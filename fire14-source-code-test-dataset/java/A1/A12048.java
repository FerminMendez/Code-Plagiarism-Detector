/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gcj;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author daniele
 */
public class GCJ_B {
    
    
    static private class Cp{
        public int p;
        public Boolean s;
        
        public  Cp(int a, Boolean b){p=a; s=b;}
        
        public String toString(){
         return p+","+s;
        }
        
    }
    
    public static void main(String[] args) throws Exception{
        
        
        Scanner in = new Scanner(new File(args[0]));
        FileWriter out = new FileWriter("/home/daniele/Scrivania/Output");
        
        int n,p,s;
        int countp=0,counts=0;
        int prove=in.nextInt();
        ArrayList<Integer> tp;
        
        
        
        
        //ArrayList<Integer> perm = new ArrayList<Integer>();
        
        out.write("");
        out.flush();
        
        for(int i=1;i<=prove;i++){
            out.append("Case #" +i+": ");out.flush();
            n=in.nextInt();
            s=in.nextInt();
            p=in.nextInt();
            tp= new ArrayList<Integer>();
            for(int j=0;j<n;j++)
                tp.add(in.nextInt());
            
            for(int j=0;j<tp.size();j++){
                int f=tp.get(j)-p;
                if( f>=0 && f/2>=p-2){
                    countp++;
                    if( f/2==p-2 && s==0 )
                      countp--;
                    else if(f/2==p-2 && s>0)
                        s--; 
                }
                
            }
            System.out.println("countp="+countp+" counts="+counts+" s="+s);
            //if((counts - s)>0)
            //    countp= countp - (counts - s);
            out.append(countp+"\n");out.flush();
            countp=0; counts=0;
            System.out.println("**************");
            //

        }
     
        
        
    }
    
    
    
}
