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
public class DancingWithTheGooglers {

    public static void main(String[] args)
    {
        int res;
        int N,S,P,t,limit;
        int temp1,temp;
        PrintWriter pw = null;
        Scanner sc = null;
        try {
            sc = new Scanner(new FileReader("C:\\Users\\abdallah gaber\\Documents\\NetBeansProjects\\CodeJam2012\\src\\Qualification\\danceinput.in"));
            pw = new PrintWriter(new FileWriter("C:\\Users\\abdallah gaber\\Documents\\NetBeansProjects\\CodeJam2012\\src\\Qualification\\danceoutput.out"));
            int casCnt=Integer.parseInt(sc.nextLine());
            for(int cnt=0;cnt<casCnt;cnt++)
            {
                res = 0;
                N=sc.nextInt();
                S=sc.nextInt();
                P=sc.nextInt();
                if (P>1)
                    limit=P+((P-2)*2);
                else
                    limit=P;
                for(int i=0;i<N;i++)
                {
                    t=sc.nextInt();
                    if(t>=limit&&t<=30)
                    {
                        if(t>=0&&t<=2)
                        {
                            if(t==0&&P==0)
                                res++;
                            if(t==1&&P<=1)
                                res++;
                            if(t==2&&P<=2)
                            {
                                if(S==0&&P==1)
                                    res++;
                                if(S>0&&P==2)
                                {
                                    res++;
                                    S--;
                                }
                                
                            }
                        }
                        else
                        {
                            temp1=t%3;
                            temp=t/3;
                            if(temp1==0)
                            {System.out.println("Case #"+(cnt+1)+": "+temp);
                                if(Math.max(Math.max((temp-1), (temp)),(temp+1))>=P&&S>0)
                                {
                                    res++;
                                    if(!(temp>=P))
                                        S--;
                                }
                                else
                                {
                                    if(temp>=P)
                                        res++;
                                }
                                    
                            }
                            if(temp1==1)
                            {System.out.println("Case #"+(cnt+1)+": "+temp);
                                if((temp+1)>=P&&S>0)
                                {
                                    res++;
                                    if(!((temp+1)>=P))
                                        S--;
                                }
                                else
                                {
                                    if((temp+1)>=P)
                                        res++;
                                }
                                
                            }
                            if(temp1==2)
                            {System.out.println("Case #"+(cnt+1)+": "+temp);
                                if((temp+2)>=P&&S>0)
                                {
                                    res++;
                                    if(!((temp+1)>=P))
                                        S--;
                                }
                                else
                                {
                                    if((temp+1)>=P)
                                        res++;
                                }
                            }
                        }
                    }
                }
                pw.println("Case #"+(cnt+1)+": "+res);
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
