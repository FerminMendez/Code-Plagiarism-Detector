/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package codejam;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;

/**
 *
 * @author Mash
 */
public class Main {
  
  public static void main(String args[]) throws FileNotFoundException {

      Scanner in = new Scanner(new FileReader("C:\\ima\\ans.txt"));
                int T=in.nextInt();
                int A,B;

                String a,b,perm;
                char[] per;

                String filler="0000000";

                for(int i=1;i<=T;i++){
                    int res=0;

                    A=in.nextInt();
                    B=in.nextInt();

                    b=Integer.toString(B);

                    for(int j=A;j<=B;j++){
                        int ans;
                   // Set list= new HashSet<Character[]>();
                     Set<String> list=new HashSet<String>();
                    a=Integer.toString(j);
                    int des=b.length()-a.length();
                    perm=filler.substring(0, des)+j;
                    //System.out.println(perm);
                    //per=perm.toCharArray();
                    //permute(per, 0, b.length());
                    String add;
                    for(int s=0;s<=perm.length();s++){
                        add=perm.substring(s)+perm.substring(0,s);
                        list.add(add);
                    }
                    ans=0;
                    Iterator it=list.iterator();
                    //System.out.println("j is"+j);
                    while(it.hasNext())
                    {
                     String comp=(String) it.next();
                     //System.out.println(comp);
                     int com=Integer.parseInt(comp);
                     if(com>j&&com<=B)ans++;
                      }
                    //System.out.println("answer is"+ans);
                    res+=ans;
                    }
                    System.out.println("Case #"+i+": "+res);
                }
    
  }

}
