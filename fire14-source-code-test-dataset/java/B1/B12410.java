/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codejamproblem2;

import java.util.Scanner;
import sun.tools.jar.resources.jar;

/**
 *
 * @author khalid
 */
public class CodeJamProblem2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CodeJamProblem2 jam=new CodeJamProblem2();
        jam.solve();
      
    }
    
    public void solve() {
          
         Scanner in=new Scanner(System.in);
        int count=in.nextInt();
        in.nextLine();
        String res="";
        int numOfRe;
        for(int i=1;i<=count;i++)
        {
            numOfRe=numOfRecycled(in.nextInt(),in.nextInt());
            res+="Case #"+i+": "+numOfRe+"\n";
        }
        System.out.print(res);
    }
    public int numOfRecycled(int a,int b)
    {
        int counter=0;             
        for(int i=a;i<b;i++)
        {
            for(int c=b;c>i;c--)
                if(isRecycled(i+"", c+""))
                    counter++;            
        }

        return counter;
    }
    public boolean isRecycled(String num1,String num2)
    {
        if(num1==null||num2==null)
            return false;
        if(num1.length()!=num2.length())
            return false;
        String tmp;
        int leftStart;//,leftEnd;
        int rightStart,rightEnd;
        leftStart=0;
        rightEnd=num1.length();
       for(int i=0;i<num1.length()-1;i++)
       {
           rightStart=rightEnd-i-1;
           tmp="";
           tmp+=num1.substring(rightStart, rightEnd);
           tmp+=num1.substring(leftStart, rightStart);
           
           if(tmp.equals(num2))
               return true;           
       }
       return false;
    }
}