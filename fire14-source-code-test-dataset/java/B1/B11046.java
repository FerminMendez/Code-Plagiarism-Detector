/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

/**
 *
 * @author kutub
 */
public class rn {
    public static void main(String args[]) throws FileNotFoundException
    {
        File f=new File("C:/Users/kutub/Documents/NetBeansProjects/JavaApplication1/src/javaapplication1/input2.txt");
        Scanner s=new Scanner(f);
        int n=0,a=0,b=0,count=0;
        while(s.hasNext())
        {
            n=s.nextInt();
            
            for(int i=1;i<=n;i++)
            {
                s.nextLine();
                a=s.nextInt();
                b=s.nextInt();
                count=0;
                
                for(int j=a;j<=b;j++)
                {
                    //System.out.println(j);
                    if(j>1000)
                    {
                        
                        int k=j%10;
                        int l=j/10;
                        int m=l%10;
                        int no=l/10;
                        int ko=no%10;
                        int lo=no/10;
                                
                                
                        int mo=k*1000+l;
                        
                        if(mo>j && mo<=b && mo>a)
                        {
                            //System.out.println("mo: "+mo);
                            count++;
                        }
                        
                        mo=m*1000+k*100+no;
                        if(mo>j && mo<=b && mo>a)
                        {
                            //System.out.println("mo: "+mo);
                            count++;
                        }
                        
                        mo=ko*1000+m*100+k*10+lo;
                        if(mo>j && mo<=b && mo>a)
                        {
                            //System.out.println("mo: "+mo);
                            count++;
                        }
                        
                       
                        
                    }
                    
                    if(j<=1000 && j>100)
                    {
                        
                        int k=j%10;
                        int l=j/10;
                        int m=l%10;
                        int no=l/10;
                        
                        int mo=k*100+l;
                        
                        if(mo>j && mo<=b && mo>a)
                        {
                            //System.out.println("j: "+j+"  mo: "+mo);
                            
                            count++;
                        }
                        
                        mo=m*100+k*10+no;
                        if(mo>j && mo<=b && mo>a)
                        {
                            //System.out.println("j: "+j+"  mo: "+mo);
                            count++;
                        }
                    }
                    else if(j<=100 && j>=10 )
                    {
                        
                        int k=j%10;
                        int l=j/10;
                        int m=(k*10)+l;
                        
                        
                        if(m<=b && m>a && m>j)
                        {
                            
                            //System.out.println("j: "+j+"  mo: "+m);
                            count++;
                        }
                            
                    }
                }
                System.out.print("Case #"+i+": ");
                System.out.println(count);
            }
        }
    }
}
