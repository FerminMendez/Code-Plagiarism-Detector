/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package a2012;

import java.util.*;
import java.io.*;
/**
 *
 * @author G
 */
public class C {

    static int[] pot10=new int[]{1,10,100,1000,10000,100000,1000000,10000000};
    static File home=new File("F:/Documents/Downloads/");
    public static void main(String...arg)throws Exception{
        Scanner sc = new Scanner(new File(home,"C-small-attempt0.in"));
        System.setOut(new PrintStream(new File("c.out")));
        final int casos=sc.nextInt();
        for(int caso=1;caso<=casos;caso++){
            int A=sc.nextInt(),B=sc.nextInt();
            final int digits=(""+A).length();
            int tot=0;
            HashSet<Long> encontrados=new HashSet<Long>(1000);
            for(int n=A;n<=B;n++){
                //System.out.println(e);
                for(int i=1;i<digits;i++){
                    int j=n/pot10[i]+(n%pot10[i])*pot10[digits-i];
                    long t=Math.max(j,n);
                    t*=pot10[digits];
                    t+=Math.min(j,n);
                    if(j>=A&&j<=B&&j!=n&&!encontrados.contains(t)){
                        tot++;
                        encontrados.add(t);
                    }
                    //System.out.println(j);
                }
            }
            System.out.println("Case #"+caso+": "+tot);
        }
        System.out.close();
    }
}
