/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codejam;

import java.util.Scanner;

/**
 *
 * @author Abdo
 */
public class problemb {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        int[] a=new int[n];
        int[] b=new int[n];
        for(int k=0;k<n;k++)
        {
             a[k]=sc.nextInt();
             b[k]=sc.nextInt();
             sc.nextLine();
        }
        for(int k=0;k<n;k++)
        {
            int count=0;
            int i=-1;
            int num=0;
            while(a[k]+i <= b[k])
            {
                i++;
                String temp=new String();
                int alo=a[k]+i;
                temp=String.valueOf(alo);
                char[] abdo=temp.toCharArray();
                if(abdo.length<2)
                    break;
                else if(abdo.length ==2)
                {
                    char temp2=abdo[0];
                    abdo[0]=abdo[1];
                    abdo[1]=temp2;
                    String aaa= String.valueOf(abdo[0])+ String.valueOf(abdo[1]);
                    
                    num=Integer.parseInt(aaa);
                    if(num <= b[k] && num > a[k]+i)
                        count++;
                    
                }
                else
                {
                   char[] temp5=abdo;
                    char temp2=abdo[0];
                    char temp3=abdo[1];
                    abdo[0]=abdo[2];
                   abdo[1]=temp2;
                   abdo[2]=temp3;
                    
                    String aaa= String.valueOf(abdo[0])+ String.valueOf(abdo[1])+String.valueOf(abdo[2]);
                    
                    num=Integer.parseInt(aaa);
                    if(num <= b[k] && num >= a[k] && num >a[k]+i)
                        count++;
                    
                  char[] abdo2=temp.toCharArray();
                      temp2=abdo2[0];
                     temp3=abdo2[2];
                    abdo2[0]=abdo2[1];
                    abdo2[1]=temp3;
                    abdo2[2]=temp2;
                    
                       aaa= String.valueOf(abdo2[0])+ String.valueOf(abdo2[1])+String.valueOf(abdo2[2]);
                    
                    num=Integer.parseInt(aaa);
                    if(num <= b[k] && num >= a[k] && num > a[k]+i)
                        count++;
                    
                }
                
               
            }
            System.out.format("Case #%d: %d\n", k+1, count);
        }
    }
    
}
