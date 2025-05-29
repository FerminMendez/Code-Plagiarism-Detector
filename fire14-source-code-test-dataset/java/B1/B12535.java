/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codejam3;

import java.io.File;
import java.io.*;
import java.util.*;

/**
 *
 * @author saad
 */
public class Codejam3 {

    /**
     * @param args the command line arguments
     */
    static int convert(Integer min,Integer max){
        int n=min.toString().length() ;
        int res=0 ;
        List<Integer> l=new LinkedList<Integer>() ;
       for(int i=min;i<max;i++){
           String fait=i+"" ;
           l.clear();
         for(int j=0;j<n-1;j++){
             
             String s="" ;
             for(int k=j+1;k<n+j+1;k++){
                 s+=fait.charAt(k%n) ;
             }
             int a=Integer.parseInt(s) ;
             if(a>i&&a<=max){
                 if(!l.contains(a)){
                     res++ ;
                     l.add(a) ;
                 }
                 
                 
             }
         }
    }
       return res ;
    }
  
    
    
    public static void main(String[] args) throws FileNotFoundException {
         Scanner in=new Scanner(new File("C-small-attempt1(1).in")) ;
        PrintWriter out=new PrintWriter("C-small-attempt1.out") ;
        int n=in.nextInt() ;
       
        for(int i=0;i<n;i++){
            out.print("Case #"+(i+1)+": "+convert(in.nextInt(), in.nextInt())) ;
            if(i!=n-1) out.println();
        }
        in.close();
       out.close();
       
    }
}
