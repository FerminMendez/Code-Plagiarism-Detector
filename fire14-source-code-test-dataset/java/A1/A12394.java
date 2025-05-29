
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
public class DWG {
    
    public static void main(String [] args) throws FileNotFoundException, IOException
    {
        Scanner scan= new Scanner(new File("inp.txt"));
        
        int n=scan.nextInt();
        //System.out.println(n);
        int cas=1;
        while(n--!=0)
        {
            int t=scan.nextInt();
            int s=scan.nextInt();
            int p=3*scan.nextInt();
            
            int count =0;
            for(int i=0;i<t;i++)
            {
                int temp = scan.nextInt();
                //System.out.println(temp);
                if(temp == 0 )continue;
                else if(temp==1 && p==1) count++; 
                if(temp>=p-2)count++;
                else if(temp>=p-4 && s>0 )
                {count++;s--;}
                
            }
            
            System.out.println("Case #"+cas+++": "+count);
            
        }
        }
    
}
