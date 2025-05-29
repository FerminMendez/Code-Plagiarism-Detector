
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Akash Agrawal
 */
public class RN {
    
    public static boolean check(int n , int []arr)
    {
        for(int i=0;i<arr.length;i++)
        {
            if(n==arr[i])return false;
        }
        return true;
    }
    
    public static void main(String [] args) throws FileNotFoundException, IOException
    {
        Scanner scan= new Scanner(new File("Input.in"));
        int n=scan.nextInt();
        int cas=1;
        while(n--!=0)
        {
            String s1 = scan.next() , s2 = scan.next();
            int A=Integer.parseInt(s1);
            int B=Integer.parseInt(s2);
            //System.out.println(A+B);
            int count = 0;
            
            for(int i=A;i<B;i++)
            {//System.out.println(i);
                String temp = Integer.toString(i);
                int ar[] = new int[s1.length()-1];
                int ind=0;
                for(int a=0;a<ar.length;a++)
                {
                    ar[a]=-1;
                }
                for(int j=1;j<s1.length();j++)
                {
                    
                    String temps = temp.substring(j) + temp.substring(0,j);
                    int C=Integer.parseInt(temps);
                    //System.out.println(s1.substring(0,j));
                    if(C>i && C<=B && check(C,ar))
                       {
                           count++;
                           //System.out.println(i+" "+C);
                           ar[ind++]=C;
                       }
                    
                }
                
                
            }
            System.out.println("Case #"+cas+++": "+count);
            
        }
        
    }
    
}
