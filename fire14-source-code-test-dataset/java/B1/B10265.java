/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package C;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Novin Pendar
 */
public class C {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        File fi=new File("C-small-attempt0.in");
        FileReader fr=new FileReader(fi);
        Scanner con=new Scanner(fr);
        int n=Integer.valueOf(con.nextLine()).intValue();
        int a,b;
        File fo=new File("C-small-attempt0.out");
        PrintWriter pr=new PrintWriter(fo);
        for(int i=0;i<n;i++){
            String st=con.nextLine();
            String[] starr=st.split(" ");
            a=Integer.valueOf(starr[0]).intValue();
            b=Integer.valueOf(starr[1]).intValue();
            pr.println("Case #"+(i+1)+": "+g(a,b));
            System.out.println("Case #"+(i+1)+": "+g(a,b));
        }
        fr.close();
        pr.close();
        
    }
    public static boolean f(String s1,String s2){
        int n=s1.length();
        String t,t1,t2;
//        n--;
        for(int i=1;i<n;i++){
            t1=s1.substring(0, i);
            t2=s1.substring(i);
            t=t2+t1;
            if(t.equals(s2)){
                return true;
            }
        }
        return false;
    }
    public static int g(int a,int b){
        int count=0;
        for(int i=a;i<=b;i++){
            for(int j=i+1;j<=b;j++){
                if(f(String.valueOf(i),String.valueOf(j))==true){
                    count++;
                }
            }
        }
        return count;
    }
}
