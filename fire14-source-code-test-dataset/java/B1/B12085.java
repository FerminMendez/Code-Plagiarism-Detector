/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gcj;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author daniele
 */
public class GCJ_C {
    
    public static void main(String[] args) throws Exception{
        
        
        
        Scanner in = new Scanner(new File(args[0]));
        FileWriter out = new FileWriter("/home/daniele/Scrivania/Output");
        

        int prove=in.nextInt();
        int min,max;
        int cifre;
        int cifreaus;
        String temp;
        int aus;
        int count=0;
        ArrayList<Integer> vals = new ArrayList<Integer>();
        int jcount=0;
        ArrayList<Integer> perm = new ArrayList<Integer>();
        
        out.write("");
        out.flush();
        
        for(int i=1;i<=prove;i++){
            
            out.append("Case #" +i+": ");out.flush();
            
            min=in.nextInt();
            max=in.nextInt();
            
            for(int j=min;j<=max;j++){
               if(!vals.contains(j)){
                    temp=""+j;
                    cifre=temp.length();
                    aus=j;
                    perm.add(j);
                    for(int k=1;k<cifre;k++){
                        aus=rotateOnce(aus);
                        temp=""+aus;
                        cifreaus=temp.length();//elusione zeri iniziali
                        if(aus>=min && aus<=max && aus!=j && cifreaus==cifre && nobody(vals,perm)){ 
                            perm.add(aus);
                            jcount ++;
                            
                        }
                        
                    }
                    while(jcount>0){count+=jcount; jcount--;}
                    vals.addAll(perm);
                    perm= new ArrayList<Integer>();
                    
                }
            }
            out.append(count+"\n");out.flush();
            count=0;
            vals= new ArrayList<Integer>();
        }
        
        
        
    }
        static public int rotateOnce(int n){
            String s=""+n;
            if(s.length()>1){
                s=s.charAt(s.length()-1) + s.substring(0,s.length()-1);
                n=Integer.parseInt(s);
            }
            return n;
        }    
        
        static public boolean nobody(ArrayList<Integer> v,ArrayList<Integer> a){;
            for(int i=0;i<a.size();i++)
                if(v.contains(a.get(i))) return false;
            return true;
        } 
    
}

