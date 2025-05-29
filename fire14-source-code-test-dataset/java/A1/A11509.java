/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adream;

import java.util.Scanner;

/**
 *
 * @author sarah
 */
public class GoogleDancers {

    public int max(int[] googs , int p , int s){
        int surp = 0;
        int max  = 0;
        if(p == 0)
            return googs.length;
        for(int i = 0 ; i < googs.length ; i++){
            int g1=0,g = googs[i];   
            if(g == 0)continue;
            if(g%3 == 0){
                if(surp < s && g/3 < p && g/3 +1 >= p){
                    g1 = g/3 +1;
                    surp++;
                }else
                    g1 = g/3 ;
            }else{
                if((g+1) % 3 == 0){
                    if(surp < s &&(g+1)/3 <p && (g+1)/3 + 1 >= p){
                        g1 = (g+1)/3 + 1;                   
                        surp++;
                    }else
                        g1 = (g+1)/3;
                }else{
//                     if(surp < s &&(g-1)/3 + 1 < p && (g-1)/3 + 1 >= p){
//                        g1 = (g+1)/3 + 1;                   
//                        surp++;
//                    }else
                        g1 = (g-1)/3 +1;
                }
            }
            if(g1 >= p)
                max++;

        }

        return max;
    }


    public static void main(String args[]){
        GoogleDancers gd = new GoogleDancers();
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        int i = 0 ;
        while(i++ < tc){
            int n = sc.nextInt(); // dancers
            int s = sc.nextInt(); //surprising
            int p = sc.nextInt(); //max
            int[] dancers = new int[n];
            for(int j = 0 ; j < n ; j++)
                dancers[j] = sc.nextInt();
            int res = gd.max(dancers,p,s);
            System.out.println("Case #"+i +": "+res);
        }
    }
}
