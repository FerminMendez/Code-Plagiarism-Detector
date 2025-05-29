/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author KAMIKATAZ
 */

    
    
    


//~--- JDK imports ------------------------------------------------------------

import dancit.*;
import dancit.*;
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
public class DanceGoogle {

    /**
     *  @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            FileInputStream fstream =
                new FileInputStream("C:\\Users\\KAMIKATAZ\\Desktop\\codejam\\p2\\input.in");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader  br = new BufferedReader(new InputStreamReader(in));
            String          strLine;
            BufferedWriter  out1 = new BufferedWriter(
                                      new FileWriter(
                                          "C:\\Users\\KAMIKATAZ\\Desktop\\codejam\\p2\\out1.ou",
                                          true));
            String times = br.readLine();
            int    n     = Integer.valueOf(times);

            System.out.println("number of test cases : " + n);

            // will be used vars
            
            int    currentCase = 0;
            int G;
            int S ;
            int P;
            int fav = 0;
            int s = 0;
            
            // processor starts 
            
            while ((strLine = br.readLine()) != null) {
                
                
                
                fav=0;
                
                ++currentCase;
                out1.write("Case #" + currentCase + ": ");
                
                // System.out.println(strLine);
                
                StringTokenizer st=new StringTokenizer(strLine," ");
                G=Integer.valueOf(st.nextToken());
                int scores[]=new int[G];
                S=Integer.valueOf(st.nextToken());
                P=Integer.valueOf(st.nextToken());
                int tmp=0;
                
                  System.out.println("\n"+G+" "+S+" "+P);
                
               while(st.hasMoreTokens()){
                
                scores[tmp]=Integer.valueOf(st.nextToken());
                System.out.print(scores[tmp]+" ");   
                ++tmp;
                
               }
               
               //  logic starts
               int favorable=0;
               int special=0;
               
               ///     var declaration ends
               
               
               for (int g =0;g<G;++g){
                   favorable=0;
                   
                   
                     //////////////////////////////////////////   NORMAL
                    for (int w=P;w<=10;++w)
                   {   
                       
                       {
                           if(w-1>=0){
                               
                               
                               if (((w)+(w)+(w-1))==scores[g]){             /////    3w-1
                                   ++favorable;System.out.println("Checking : "+scores[g] + " for : "+w +"by 3w-1");
                               }                              
                               if(((w)+(w-1)+(w-1))==scores[g]){            ////     3w-2
                                   
                                   ++favorable;System.out.println("Checking : "+scores[g] + " for : "+w +" by 3w-2");
                               }
                           }
                           
                           if((w+1)<=10){
                               
                               if(((w)+(w)+(w+1))==scores[g]){              ///// scores 3w+1
                                   ++favorable;System.out.println("Checking : "+scores[g] + " for : "+w +" by 3w+1");
                                   
                               }
                               
                               if(((w)+(w+1)+(w+1))==scores[g]){              ///// scores 3w+2
                                   ++favorable;System.out.println("Checking : "+scores[g] + " for : "+w +" by 3w +2");
                                   
                               }
                               
                           }
                           
                           if(((w)*3)==scores[g]){
                               
                                   ++favorable;System.out.println("Checking : "+scores[g] + " for : "+w +" by 3w");
                               
                           }
                           
                       
                       }}
                       
                       //////////   NORMAL ENDS
                   
                   //// loop d speciale
               for (int w=P;w<=10;++w)
                   {
                       
                            ////////////  TEST CASES
                       
                       
                       
                       
                        /////////////////////////////////////////////SPECIAL
                       
                       if(S>0 && special<S  && favorable==0){
                           System.out.println("checking special cases");
                           if(w-2>=0){
                               
                               if(((w)+(w-1)+(w-2))==scores[g]){        ////////////// 3w-3
                                   
                                   ++favorable;System.out.println("Checking : "+scores[g] + " for : "+w +" by 3w-3");
                                   ++special;
                                   
                               }
                               if((w)+(w-2)+(w-2)==scores[g]){          /////////////  3w-4
                                   
                                   ++favorable;System.out.println("Checking : "+scores[g] + " for : "+w +"  by 3w-4");
                                   ++special;
                                   
                               }
                               
                               
                           }
                           if ((w+2)<=10){
                           if(((w+2)+(w+2)+(w))==scores[g]){            //////  3w+4
                               
                               ++favorable;System.out.println("Checking : "+scores[g] + " for : "+w +"with 3w+4");
                               ++special;
                              
                           }
                           if(((w+2)+(w+1)+(w))==scores[g]){            ////   3w+3
                               
                               ++favorable;System.out.println("Checking : "+scores[g] + " for : "+w +" by 3w+3");
                               ++special;
                               
                           }
                                               
                       }
                       }
                   
                     
                       
                      
                       
                       ////////////  TEST CASES  END
                       
                       
                   }
               if (favorable >0){
                   ++fav;
               }
               //logic ends
               
               
               System.out.println("for score : " +scores[g]+"  values of favorable : "+fav +" value of special is : "+special);
               
              
               
               
            }
               out1.write(String.valueOf(fav));
               out1.newLine();
               
            }
            //out1.newLine();
            //out1.flush();

            // Close the input stream
            in.close();
            out1.close();
        } catch (Exception e) {    // Catch exception if any
            System.out.println("Error: " + e.getMessage() + "   " + e);
        }
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
