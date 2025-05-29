/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package solution;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 *
 * @author Aditya
 */

//A simple observation is:
//
class TestCase{
    int N;
    int S;
    
    int p;
    
    int[] scores;
    boolean[] ok;
    
    
    public TestCase(String line){
        int[] ia=getAsIntegerArray(line);
        
        N=ia[0];
        S=ia[1];
        p=ia[2];
        
        scores=new int[ia.length-3];
        ok=new boolean[ia.length-3];
        
        for(int i=3;i<ia.length;i++){
            scores[i-3]=ia[i];
        }
    }
    
    public int[] getAsIntegerArray(String line){
        String[] elems=line.split(" ");
        int[] ret=new int[elems.length];
        
        for(int i=0;i<elems.length;i++){
            ret[i]=Integer.parseInt(elems[i]);
        }
        
        return ret;
    }
    
    public void setOk(){
        
        System.out.println("---------------------------------------------------");
        for(int i=0;i<scores.length;i++){
            //Simple arrangements are:
            //1. scores[i]/3,scores[i]/3,scores[i]/3 with a non surprising score of scores[i]+1, if scores[i]%3==0
            //2. scores[i]/3,scores[i]/3+1, scores[i]/3 with a non surprising score of scores[i]+1, if scores[i]%3==1
            //3. scores[i]/3,scores[i]/3+1, scores[i]/3+1 with a non surprising score of scores[i]+1, if scores[i]%3==2
            //4. scores[i]/3,scores[i]/3+1,scores[i]/3-1  with a surprising score of scores[i]+1, if scores[i]%3==0
            //5. scores[i]/3,scores[i]/3+2,scores[i]/3 with a surprising score of scores[i]+2, if scores[i]%3==2
            //case 1:
            
            System.out.println("->"+scores[i]+" " + S + " "+ p);
            //case 1:
            if((scores[i]/3) >= p){
                System.out.println((scores[i]/3)+" "+(scores[i]/3) + " "+ (scores[i]/3));
                ok[i]=true;
            }
            //cases 2 and 3:
            else if(((scores[i]%3) > 0) && (((scores[i]/3) +1)>=p)){
                if(scores[i]%3==1)
                    System.out.println((scores[i]/3+1)+" "+(scores[i]/3) + " "+ (scores[i]/3));
                else
                    System.out.println((scores[i]/3+1)+" "+(scores[i]/3 +1) + " "+ (scores[i]/3));
                ok[i]=true;
                
            }
            
            //case 4:
            else if(((scores[i]%3) == 0) && (((scores[i]/3)+1)>=p)){
                if(S>0 && (scores[i]/3>0)){
                    S--;
                    System.out.println((scores[i]/3+1)+" "+(scores[i]/3-1) + " "+ (scores[i]/3) + " *");
                
                    ok[i]=true;
                }
            }
            
            //case 5:
            else if(((scores[i]%3) == 2) && (((scores[i]/3)+2)>=p)){
                if(S>0){
                    S--;
                    System.out.println((scores[i]/3+2)+" "+(scores[i]/3) + " "+ (scores[i]/3) + " *");
                
                    ok[i]=true;
                }
            }
        }
        System.out.println("---------------------------------------------------");
    }
    
    public int getNumOks(){
        int ret=0;
        for(int i=0;i<ok.length;i++){
            if(ok[i])
                ret++;
        }
        return ret;
    }
}



//Simple processing logic:

public class Question2 {
    public static int numInputs;
    
    public static Vector<TestCase> cases= new Vector<TestCase>();
    
    public static BufferedReader br ;   
    
    public static void readInput(){
        String s;
        try{
            br= new BufferedReader(new InputStreamReader(System.in));//new BufferedReader(new FileReader("f:\\test\\asdasd.in"));   
            if((s=br.readLine())!=null)
                numInputs=Integer.parseInt(s);
            while((numInputs-->0) && (s=br.readLine())!=null){ 
                cases.add(new TestCase(s));
            }
        }catch(IOException ioex){
            ;
        }
    }
    
    public static void process(){
        for(TestCase t:cases){
            t.setOk();
        }
    }
    
    public static void printOutput(){
        for(int i=0;i<cases.size();i++){
            System.out.println("Case #"+(i+1)+": "+cases.get(i).getNumOks());
        }
    }
    
    public static void main(String[] args){
        readInput();
        process();
        printOutput();
        
    }
}
