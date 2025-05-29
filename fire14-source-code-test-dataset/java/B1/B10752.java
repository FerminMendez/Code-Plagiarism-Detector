/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package third;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Yogendra
 */
public class Third {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        File f = new File("input.txt");
        Scanner s = new Scanner(f);
       
        int [] check;
        int answer=0;
        int total=s.nextInt();
        for(int i=0;i<total;i++)
        {
            int first = s.nextInt();
            int last = s.nextInt();
            
                for(int j=first;j<=last;j++)
                {
                    int f1=0;
                    if(first>99 && last<=999)
                    {
                        check = new int [1000];
                        int temp1,temp2,temp21,temp3;
                        f1=1;
                        temp21=j/10;
                        temp2=temp21%10;
                        temp3=j%10;
                        temp1=temp21/10;
                        for(int l=0;l<=999;l++)
                        {
                            check[l]=0;
                        }
                        if(temp3>=temp1)
                        {
                            int tempnum=(temp3*100)+(temp1*10)+temp2;
                            if((tempnum <=last)&&(tempnum>j) && check[tempnum]!=1)
                            {
                                check[tempnum]=1;
                                answer++;
                            }
                        }
                         if(temp2>=temp1 )
                        {
                            int tempnum=(temp2*100)+(temp3*10)+temp1;
                            if((tempnum<=last)&&(tempnum > j) && check[tempnum]!=1 )
                            {
                                check[tempnum]=1;
                                answer++;
                            }
                        }
                    }
                    else if((first > 9 && last<=99))
                    {
                        check = new int [99];
                        for(int k=0;k<99;k++)
                        {
                            check[k]=0;
                        }
                        int temp1,temp2;
                        temp1= j/10;
                        temp2=j%10;
                        if(temp2>temp1)
                        {
                            int tempnum=(temp2*10)+temp1;
                            if((tempnum<=last)&&(check[tempnum]!=1))
                            {
                                answer++;
                                check[tempnum]=1;
                            }
                        }
                    }
                }
                 System.out.println("Case #"+(i+1)+": "+answer);
                 answer=0;
        }
    }
}
