/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dimitris
 */
import java.io.*;

public class trito {
    
  File ffff;
  FileReader fr;
  BufferedReader br;
 
  File fout;       
  FileWriter fw;
  BufferedWriter bw; 
  
    public static void main(String [] args){
        trito t=new trito();
      //  System.out.println(t.convert(109,121)); 
        t.run();
       
    }
    
 public void run(){
     try{
        ffff=new File("C:\\Users\\Dimitris\\Documents\\NetBeansProjects\\jam\\src\\C-small-attempt0.in");
        fr=new FileReader(ffff);
        br=new BufferedReader(fr);
    
        fout=new File("C:\\Users\\Dimitris\\Documents\\NetBeansProjects\\jam\\src\\output.out");
        fw=new FileWriter(fout);
        bw=new BufferedWriter(fw);
        
        
        int lo=new Integer(br.readLine());
        
        for(int i=1;i<=lo;i++){
            String s=br.readLine();
            String [] s2=s.split(" ");
           
            int [] tok=new int[s2.length];
            for(int iii=0;iii<s2.length;iii++) tok[iii]=new Integer(s2[iii]) ;
            
            String r=Integer.toString(convert(tok[0],tok[1]));
            bw.write("Case #"+i+": "+r);
            bw.write('\n');
            
        }
       br.close();
       bw.close();
     }
     catch(Exception e){
         e.printStackTrace();
     }
 }   

 
 public int convert(int aa,int bb){
  int A=aa;
  int B=bb;
  int res=0;
  
  for(int m=B;m>A;m--){  
    
    for(int n=A;n<m;n++){   
        
        
                 
        String s=Integer.toString(n);
         
        char[] c=new char[s.length()];
        for(int i=0;i<s.length()-1;i++){
          
           c[0]=s.charAt(s.length()-1);
           
           for(int i2=1;i2<s.length();i2++){
             c[i2]=s.charAt(i2-1);
             
           }
           s=new String(c);
           
           int neo=new Integer(s);
          if(c[0]==0) continue;
            
           if(neo==m){
                 
                 res++;
                 break;
           }
        }
     
     } 
    }
    
    return res;
   
  }
}
    