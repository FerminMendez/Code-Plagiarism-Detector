/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package t2;

/**
 *
 * @author KAMIKATAZ
 */

    
    
    


//~--- JDK imports ------------------------------------------------------------


import intjungle.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 *
 * @author KAMIKATAZ
 */
public class IntJungle {

    /**
     *  @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int ans=0;
       
        
        try {
            FileInputStream fstream =
                new FileInputStream("C:\\Users\\KAMIKATAZ\\Desktop\\codejam\\p3\\input.in");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader  br = new BufferedReader(new InputStreamReader(in));
            String          strLine;
            BufferedWriter  out1 = new BufferedWriter(
                                      new FileWriter(
                                          "C:\\Users\\KAMIKATAZ\\Desktop\\codejam\\p3\\out-p3.ou",
                                          true));
            String times=br.readLine();
            int T = Integer.valueOf(times);
            ToInteger converter=new ToInteger();
            int currentCase=0;
 /////////////////////////////////////////////////////////////////////////////           
            while ((strLine = br.readLine()) != null) {
/////////////////////////////////////////////////////////////////////////////                
                
                ++currentCase;
                out1.write("Case #" + String.valueOf(currentCase) + ": ");
                
                ans=0;
               Map<String, String> map = new HashMap<String, String>();
            StringTokenizer st=new StringTokenizer(strLine," ");    
               
                String a=st.nextToken();
                String b=st.nextToken();
                
                a=a.trim();
                b=b.trim();
                
                int A=Integer.valueOf(a);
                int B=Integer.valueOf(b);
               // //System.out.println("A read is : "+ A + "B read is  : "+ B);
                
                /////////////////////   LOGIC STARTS HERE //////////
                
                int nLen=0;
                //System.out.println("starting processing set : A : "+A+" B : "+ B);
                
                for (int n=A;n<B;++n){
                    
                String nStr=String.valueOf(n);
                nLen=nStr.length();
                
                String tmp=nStr;
                
                for(int i=1;i<nLen;++i){
                        
                       
                        tmp=nStr.substring(i)+nStr.substring(0, i);
                      ////System.out.println(tmp);
                        
                        if(tmp.charAt(0)!='0'){
                            
                            int r1=Integer.valueOf(tmp);
                            
                            if(r1>n  &&  r1<=B){
                                
                                if(r1!=n){
                                    //System.out.println("creating from : "+nStr+" : "+r1);
                                    
                      ++ans;         
                      
                   //  //System.out.println( map.put(String.valueOf(n), String.valueOf(r1)));
                     
                      String opop = "gigger";
                              opop=map.put(String.valueOf(n), String.valueOf(r1));
                      String op=null;
                      try{
                      if (opop.length()>0)op=opop;
                            if(op.equals(String.valueOf(r1)) ){
                                //System.out.println("\n8888888888888\n888888888888888\n\n");
                                --ans;
                            }
                      }catch(Exception e){
                          //System.out.println(e);
                      }
                                }
                                
                            }
                            
                        }
                    
                    } 
                
                }
         ///////////////////////  LOGIC ENDS HERE ////////////
             
         
         //System.out.println("ans is : "+ans + " map " +map.size() );
               
         out1.write(String.valueOf(ans));
         out1.newLine();
            }
         
            // Close the input stream
            in.close();
            out1.close();
            
            
            
            
        } catch (Exception e) {    // Catch exception if any
            //System.out.println("Error: " + e.getMessage() + "   " + e);
        }
        
         //System.out.println("*******************************\n\n");
                
         
         
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
