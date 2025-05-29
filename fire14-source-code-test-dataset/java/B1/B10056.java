/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codejamc;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
/**
 *
 * @author usuario
 */
public class CodejamC {

    /**
     * @param args the command line arguments
     */
    public static int fun(int a,int b,int i){
      int cont=0,n=0,mod,res=i;
      boolean flag;
      String num=i+"";
      String aux;
      int tmp;
      tmp=num.length();
      while(n<tmp-1){
        flag=false;  
        n++;
        if(res<Math.pow(10,tmp-1))
         flag=true;
        mod=res%10;
        num=""+res;
        if(flag){
             num="0"+res;
        }    
        aux=""+mod;
        aux+=num.substring(0,num.length()-1);
        res=Integer.parseInt(aux);
        
        if(res>i && res<= b){
          cont++;
        }  
       }
      return cont;
    }
    public static void main(String[] args){ 
        int n,a,b,cont=0;
        try {
            System.setIn(new FileInputStream("file.in"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CodejamC.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scanner reader=new Scanner(System.in);
        n=reader.nextInt(); 
        for(int i=0;i<n;i++){
          cont=0;  
          a=reader.nextInt();
          b=reader.nextInt();
          for(int j=a;j<=b;j++){
            cont+=fun(a,b,j);  
          }
          System.out.println("Case #"+(i+1)+": "+ cont);
        }
      
    }
}
