/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gcj12_qc;

import java.io.FileOutputStream;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author youssefgamil
 */
public class Gcj12_qC {

    /**
     * @param args the command line arguments
     */
    public static String leading0(String txt)
    {
        while(txt.charAt(0)=='0')
            txt=txt.substring(1);
        return txt;
    }
    public static void main(String[] args) throws Exception {
        HashSet<String> hs=new HashSet<String>();
        Scanner sc=new Scanner(System.in);
        FileOutputStream out=new FileOutputStream("out.txt");
        int a,b,i,j,tc,T;
        long res=0;
        String tmp;
        T=sc.nextInt();
        for(tc=1;tc<=T;tc++)
        {
            a=sc.nextInt();
            b=sc.nextInt();
            res=0;
            for(i=a;i<=b;i++)
            {
//                if(hs.contains(i+""))
//                    continue;
                
                tmp=i+"";
                
//                hs.add(tmp);
  //              System.out.println(tmp+">");
                
                hs=new HashSet<String>();
                for(j=0;j<tmp.length();j++)
                {
                        tmp=tmp.substring(1)+tmp.charAt(0);

                        
                    if(!hs.contains(tmp))//+","+i) && !hs.contains(i+","+tmp))
                    {
                            hs.add(tmp);//+","+i);
                        if(a<=Integer.parseInt(tmp)&&Integer.parseInt(tmp)<=b && Integer.parseInt(tmp)!=i)
                        {
//                        System.out.println(i+","+tmp);
                            res++;
                        }
                    }
                }
            }
            res/=2L;
            System.out.print(("Case #"+tc+": "+res+"\n"));
            out.write(("Case #"+tc+": "+res+"\n").getBytes());
        }
        out.close();
        // TODO code application logic here
    }
}
