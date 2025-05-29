/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package solution;

import com.sun.xml.internal.ws.server.InvokerTube;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

/**
 *
 * @author Aditya
 */

import java.io.*;
import javax.print.DocFlavor;

class Test{
    int high,low;
    int ret=0;
    
    Vector<Integer> vi =new Vector<Integer>();
    
    public int[] getAsIntegerArray(String line){
        String[] elems=line.split(" ");
        int[] ret=new int[elems.length];
        
        for(int i=0;i<elems.length;i++){
            ret[i]=Integer.parseInt(elems[i]);
        }
        
        return ret;
    }
    
    Test(String line){
        int[] ia=getAsIntegerArray(line);
        
        low=ia[0];
        high=ia[1];
    }
    
    
    public void process(){
        int k=0;
        System.out.println("Got here");
        for(int i=low;i<=high;i++){
            String s=new Integer(i).toString();
            
            char[] ca= s.toCharArray();
            
            do{
                char temp=ca[ca.length-1];
                for(int j=ca.length-1;j>0;j--){
                    ca[j]=ca[j-1];
                }
                ca[0]=temp;
                
                k= new Integer(new String(ca));
                if((k>i) && (k<=high)){
                    ret++;
                    System.out.println(i+" "+ k);
                }
                
                
            }while(k!=i);
            
        }
    }
    
    
}

public class Question3 {
    public static int numInputs;
    
    public static Vector<Test> cases= new Vector<Test>();
    
    public static BufferedReader br ;   
    
    public static void readInput(){
        String s;
        try{
            br=new BufferedReader(new InputStreamReader(System.in));//new BufferedReader(new FileReader("f:\\test\\asdasd.in"));   
            if((s=br.readLine())!=null)
                numInputs=Integer.parseInt(s);
            while((numInputs-->0) && (s=br.readLine())!=null){ 
                cases.add(new Test(s));
            }
        }catch(IOException ioex){
            ;
        }
    }
    
    public static void process(){
        for(Test t:cases){
            t.process();
        }
    }
    
    public static void printOutput(){
        for(int i=0;i<cases.size();i++){
            System.out.println("Case #"+(i+1)+": "+cases.get(i).ret);
        }
    }
    
    public static void main(String[] args){
        readInput();
        process();
        printOutput();
    }
}
