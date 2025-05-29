/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author fawad
 */
public class codejam2 {
    static char arr[]={'a',98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122};
    static char res[] = {'y','h','e','s','o','c','v','x','d','u','i','g','l','b','k','r','z','t','n','w','j','p','f','m','a','q'};
    static int ar[] =   {0, 1, 1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,9,9, 9, 10,10,10};
    static int arsur[] ={-1,-1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,9,9,9,10,10,10,-1,-1}; 
    public static void main(String args[]){
        
        try{
            FileReader fr = new FileReader("B-small-attempt0.in");
            //FileReader fr = new FileReader("New.txt");
            BufferedReader br = new BufferedReader(fr);
            int size = Integer.parseInt(br.readLine());
            for(int i=0;i<size;i++){
                String str = br.readLine();
                
                String strarray[] = str.split(" ");
                int N = Integer.parseInt(strarray[0]);
                int S = Integer.parseInt(strarray[1]);
                int P = Integer.parseInt(strarray[2]);
                //System.out.println(N + " " + S + " " + P + " ");
                int arrayint[] = new int[N];
                for(int j=0;j<N;j++){
                    arrayint[j] = Integer.parseInt(strarray[j+3]);
                    //System.out.println(arrayint[j] + "  SUM" );
                }
                Arrays.sort(arrayint);                
                int result = 0;
                
                for(int j1=0;j1<N;j1++){
                    if(arrayint[j1]>1 && arrayint[j1]<29){
                        if(S>0){
                            if(arsur[arrayint[j1]] >= P){
                                S--;
                                result++;
                            }else if(ar[arrayint[j1]] >= P){
                                result++;
                            }
                        }else if(ar[arrayint[j1]] >= P){
                            result++;
                        }
                    }else{
                        if( ar[arrayint[j1]] >= P){
                            result++;
                        }
                    }
                }
                
                
                System.out.println("Case #"+(i+1)+": "+result);
            }
            
            br.close();
            fr.close();
        
        }catch(IOException ex){
            ex.printStackTrace();
        }
        
        //System.out.println(arr[25]+"");
    }
    
}
