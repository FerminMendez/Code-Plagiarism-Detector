/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Qualification;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author abdallah gaber
 */
public class RecycledNumbers {
      ///////////////////////////variables////////////////
   

    public static void main(String[] args)
    {   
        int res= 0 ,A,B,counter,number;
        String sA,sB,temp;
        int[] array = new int[7];
        int cntarray=0;
        boolean flag = true;
        PrintWriter pw = null;
        Scanner sc = null;
        try {
                sc = new Scanner(new FileReader("C:\\Users\\abdallah gaber\\Documents\\NetBeansProjects\\CodeJam2012\\src\\Qualification\\Recinput.in"));
                pw = new PrintWriter(new FileWriter("C:\\Users\\abdallah gaber\\Documents\\NetBeansProjects\\CodeJam2012\\src\\Qualification\\Recoutput.out"));
                int casCnt=Integer.parseInt(sc.nextLine());
                for(int cnt=0;cnt<casCnt;cnt++)
                {
                    A=sc.nextInt();
                    B=sc.nextInt();
                    //System.out.println(A+"  "+B);
                    sB=String.valueOf(B);
                    //System.out.println(sB.substring(1));
                    for(int j=A;j<=B;j++)
                    {
                        sA=String.valueOf(j);
                        counter=sA.length();
                        int count=counter;
                        array[cntarray]=j;
                        cntarray++;
                        temp=sA;
                        while(count>1)
                        {
                            //System.out.println(sA.substring(((counter-count)+1), (counter))+" "+sA.substring((counter-count)));
                            temp =  temp.substring(1,counter) + temp.charAt(0);
                            number = Integer.parseInt(temp);
                            for (int t=0;t<cntarray;t++)
                                if(number==array[t])
                                {
                                    flag=false;
                                    break;
                                }
                            if(flag==true)
                            {
                                array[cntarray]=number;
                                cntarray++;
                            }
                            //System.out.println("aa"+j+" "+number);
                            if(number<=B&&number>=A&&j<number&&flag)
                            {
                               // System.out.println(j+" "+number);
                                res++;
                            }
                            count--;
                            flag=true;
                        }
                        cntarray=0;
                        flag=true;
                    }
                    pw.println("Case #"+(cnt+1)+": "+res);
                    res=0;
                    cntarray=0;
                }
        } catch (IOException ex) {
            Logger.getLogger(Speaking_in_Tongues.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pw.flush();
            pw.close();
            sc.close();
        }
    }
    
}
