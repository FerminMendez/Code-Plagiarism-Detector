/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qualificationRound2012;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author AHMED
 */
public class RecycledNumbers {
    public static void main(String[] args)throws Exception{
        RecycledNumbers r = new RecycledNumbers();
        //System.out.println(isRecycledPair(12345 , 51234));
        //System.out.println("0123456".substring(2,6));
        //414144414
        //441414441        
    }
    
    public RecycledNumbers() throws Exception{
        Scanner sc = new Scanner(new File("C-small-attempt0.in"));
        PrintWriter pin = new PrintWriter(new File("C-small-attempt0.out"));
        int T = Integer.parseInt(sc.nextLine());
        int A,B;
        int counter = 0;
        int x = 0;
        for(int testCaseIndex = 1 ; testCaseIndex <=T ; testCaseIndex++){
            A = sc.nextInt();
            B = sc.nextInt();
            //System.out.println(A+" "+B);
            for(int n = A ; n <= B ;n++){
                for(int m = (n+1) ; m<=B ;m++){
                    //pin.print(n+" "+m);
                    if(isRecycledPair(n,m))counter++;  
                }
            }
            pin.print("Case #"+testCaseIndex+": "+counter);
            if(testCaseIndex!=T)pin.print("\n");
            counter = 0;
        }
        pin.close();
        sc.close();
    }
    
    private static boolean isRecycledPair(int n, int m){
        if(n<10 && m<10)return false;//all digits < 10 cannto be recycled.
        
        String nString = Integer.toString(n);
        String mString = Integer.toString(m);
        int length = nString.length();
        int starting_mIndex = 0;
        String temp;
        
        for(int index = 0 ; index < length ; index++){
            for(starting_mIndex = 0 ; starting_mIndex < length ; starting_mIndex++){
                temp = mString.substring(starting_mIndex);
                temp+=mString.substring(0, starting_mIndex);
                if(temp.equals(nString))return true;
            }
        }
        
        return false;
        /*
        String nString = Integer.toString(n);
        String mString = Integer.toString(m);
        int length = mString.length();
        int nStringIndex;
        int mStrinIndex = mString.indexOf(nString.charAt(0)+"");//starting index
        
        //System.out.println(mStrinIndex);
        
        if(mStrinIndex == -1)return false;
        
        for(nStringIndex = 0 ; nStringIndex < length ; nStringIndex++){
            if(nString.charAt(nStringIndex)!=mString.charAt(mStrinIndex))return false;
            mStrinIndex = (mStrinIndex+1)%length;
        }
        
        return true;*/
    }
}
