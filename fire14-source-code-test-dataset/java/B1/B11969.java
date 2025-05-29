/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author rama
 */
public class Codejam1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=Integer.parseInt(in.nextLine());
        for(int i=1;i<=n;++i)
            System.out.println("Case #"+i+": "+trans(in.nextLine()));
    }
    
    public static int trans(String ss){
        int ans=0,p1,p2;
        StringTokenizer tok=new StringTokenizer(ss," ");
        int A=Integer.parseInt(tok.nextToken());
        int B=Integer.parseInt(tok.nextToken());
        int digit=dig(A);
        if(digit==1)
            return 0;
        
        for(int n=A;n<=B;++n){
            int arr[]={0,0,0,0,0,0,0,0,0};
           //System.out.println("*");
            boolean state=true;
            for(int j=1;j<=digit-1;++j){
                p1=(int)(n%Math.pow(10,j));
                //System.out.println("**"+p1);
                p2=(int)(n/Math.pow(10,j));
                //System.out.println("***"+p2);
                int m=p1*(int)(Math.pow(10,(digit-j)))+p2;
                
                if(m>n&&m<=B){
                    int k=0;
                    while(arr[k]!=0){
                        if(arr[k]==m){
                            state=false;
                        }
                        ++k;
                    }
                    if(state==true){
                    ++ans;
                    arr[k]=m;
                    }
                }
            }
        }
        return ans;
    }
    public static int dig(int num){
        if(num/10==0)
            return 1;
        else if(num/100==0)
            return 2;
        else if(num/1000==0)
            return 3;
        else if(num/10000==0)
            return 4;
        else if(num/100000==0)
            return 5;
        else if(num/1000000==0)
            return 6;
        else if(num/10000000==0)
            return 7;
        else if(num/100000000==0)
            return 8;
        else
            return 9;
    }
       
}

