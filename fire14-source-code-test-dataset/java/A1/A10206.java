 import java.io.*;
import java.util.*;

class d{
  File ffff;
  FileReader fr;
  BufferedReader br;
 
  File fout;       
  FileWriter fw;
  BufferedWriter bw; 
  
 public void run(){
    try{
        
   ffff=new File("C:\\Users\\Dimitris\\Documents\\NetBeansProjects\\jam\\src\\B-small-attempt0.in");
   fr=new FileReader(ffff);
   br=new BufferedReader(fr);
    
   fout=new File("C:\\Users\\Dimitris\\Documents\\NetBeansProjects\\jam\\src\\output.out");
   fw=new FileWriter(fout);
   bw=new BufferedWriter(fw);
        
    
    
    int ipol;
    int diair;
    
    int loop=new Integer(br.readLine());
    int ii=1;
    
   for(int j=0;j<loop;j++){
    int res=0;
    int fail=0;
    
    
    String ss=br.readLine();
    String [] b=ss.split(" ");
    int[]a=new int[b.length];
    for(int i4=0;i4<b.length;i4++) a[i4]=new Integer(b[i4]);
     
    int t=a[2];
    int f=a[1];
    
    for(int i=3;i<a.length;i++){
        
        diair=a[i]/3;
        ipol=a[i]%3;
         
        
        if(a[i]==0){
            if(t==0) res++;
            continue;
        }
        
        
        if(diair>=t){
            res++;
        }
        
        
        else{
         
           if(ipol==0){
               if(fail!=f){
                   int j1=diair+1;
                   if(j1>=t){
                   res++;
                   fail++;
                   continue;
                   }
               }
           }
           if(ipol==1){
               int j2=diair+1;
               if(j2>=t){
                   res++;
                   continue;
               }
           }
           
           if(ipol==2){
               int j3=diair+1;
               if(j3>=t){
                   res++;
                   continue;
               }
               
               if(fail!=f){
                   int j4=diair+2;
                   if(j4>=t){
                   res++;
                   fail++;
                   continue;
                   }
               }
           }
           
           if(ipol>2) continue;
            
        }
             
    }//for
    String r=Integer.toString(res);
    bw.write("Case #"+ii+": "+r);
    bw.write('\n');
    ii++;
    
   }
   bw.close();
   br.close();
   }
    catch(Exception e){
        e.printStackTrace();
    }
 
    
}  //run
 
   
 public static void main(String[]args){
     d dd=new d();
     dd.run();
        
 }
} //class
