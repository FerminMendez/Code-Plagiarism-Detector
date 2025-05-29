/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qualification;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author anvarik
 */
public class dancers {
    
    public static void main(String[] args) throws FileNotFoundException {
        
        int t,n,s,p,x,i,res,j;
        File input = new File("C:\\Users\\anvarik\\Desktop\\old\\in.txt");
        Scanner sc = new Scanner(input);
        t = sc.nextInt();
        for(i=1;i<=t;i++){
            n = sc.nextInt();
            s = sc.nextInt();
            p = sc.nextInt();
            res=0;
            for(j=0;j<n;j++){
                x = sc.nextInt();
                if(x>=3*p-2)
                    res++;
                else if(s>0&&(x>=3*p-4)&&((x>0)||p==0)){
                    res++;s--;
                }
            }
            System.out.println("Case #" + i + ":"+ " " + res);
        }
    }
    
}
