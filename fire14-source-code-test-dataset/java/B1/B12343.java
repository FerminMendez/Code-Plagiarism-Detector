/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gcodejam2012;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author alei
 */
public class C {
    public static void main(String[] Args) throws FileNotFoundException{
        Scanner sn = new Scanner(new FileInputStream("c.in"));
        System.setOut(new PrintStream("c.out"));
        int nCases = sn.nextInt();
        for(int i=0;i<nCases;i++){
            //System.out.println("Case #"+(i+1));
            sn.nextLine();            
            int A = sn.nextInt();
            int B = sn.nextInt();
            int nRec = calcRecycled(A,B);
            System.out.println("Case #"+(i+1)+": "+nRec);
        }
    }
    private static int calcRecycled(int A, int B) {
        int nRecycleds = 0;
        for(int n=A;n<=B;n++){
            String strNumber = n+"";            
            String curFt = "";
            LinkedList<String>pairs = new LinkedList<>();
            for(int j=0;j<strNumber.length()-1;j++){                                                        
                char curChar = strNumber.charAt(strNumber.length()-j-1);                
                if(curChar!='0'){
                    curFt =curChar + curFt;
                    String m = curFt+strNumber.substring(0,strNumber.length()-j-1);
                    int mint = Integer.parseInt(m);
                    if(mint>n){
                        if(mint>=A && mint <=B){
                            if(!pairs.contains(m)){
                                nRecycleds++;
                                pairs.add(m);
                            }
                            
                        }
                    }                   
                }              
                else{
                    curFt =curChar + curFt;
                }
            }
            
        }
        return nRecycleds;
    }
}
