/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

/**
 *
 * @author Yogendra
 */
import java.io.*;
import java.util.Scanner;
public class second {
        static int x,y,z;
        
        public static void main(String[] args) throws IOException {
 
            File f = new File("input2.txt");
            Scanner s = new Scanner(f);
            int num = s.nextInt();
            for (int i=0;i<num;i++)
            {
                
                int gglr=s.nextInt(); // number of googlers 
                int surp=s.nextInt(); //number of surprising triplet
                int p=s.nextInt(); // least best score
                int result=0;
                int n,m=0;
                
                for(int j=0;j<gglr;j++)
                {
                    n=s.nextInt();
                    if(n%3==0)
                    {
                        x=y=z=n/3;
                        if(x>=p)
                        {
                            result++;
                        }
                        else
                        {
                            if(m<surp)
                            {
                                if(x!=0)
                                {
                                    x--;
                                    y++;
                                    if(y>=p)
                                    {
                                        result++;
                                        m++;
                                    }
                                }
                            }
                        }
                    }
                    else
                    {
                        x=y=z=n/3;
                        if((n-(x+y+z))==1)
                        {
                            y++;
                        }
                        else
                        {
                            if((n-(x+y+z))==2)
                            {
                                y++;
                                z++;
                            }
                        }
                        
                        if(y>=p)
                        {
                            result++;
                        } 
                        else
                        {

                            if(m<surp)
                            {
                                 if(x==z)
                                 {
                                    if(x!=0)
                                    {
                                        x--;
                                        z++;
                                        if(y >= p || z>=p)
                                        {
                                            result++;
                                            m++;
                                        } 
                                    }
                                }
                                 else
                                 {
                                     z--;
                                     y++;
                                     if(y >= p|z>=p)
                                     {
                                        result++;
                                        m++;
                                     } 
                                     
                                 }
                            }
                           
                        }
                    
                }
                    //System.out.println("X "+x +" y "+y+" z " +z+" #");
            }
                System.out.println("Case #"+(i+1)+": "+result);
            }}}
    
