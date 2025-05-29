/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//c prob 
import java.io.*;
import java.util.StringTokenizer;

/**
 *
 * @author abood
 */
public class test {
  static  int count =0,s=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new FileReader("C-small-attempt0.in"));
   PrintWriter out =new PrintWriter(new BufferedWriter(new FileWriter("C-small-attempt0.out")));
        int loop=Integer.parseInt(br.readLine());
        for (int i = 1; i <=loop; i++) {
            count=0;
            StringTokenizer st=new StringTokenizer(br.readLine());
           int x=Integer.parseInt(st.nextToken());
           int y=Integer.parseInt(st.nextToken());
            for (int j = x; j < y; j++) {
                check(j,y);
            }
      out.println("Case #"+i+": "+count);
        }
        out.close();                                  // close the output file
    System.exit(0);  
    }
    public static void check(int xx,int yy){
        String res="";
        String x=""+xx;
        int l=x.length();
        String t="";
        for (int i = 1; i < l; i++) {
            t=x.substring(i, l)+x.substring(0,i);
            int m=Integer.parseInt(t);
            if(m<=yy&&m>xx){
               // System.out.println(xx+" "+t);
                if(res.contains(t))continue;
                res+=" "+t;
                count++;
                }
            
        }
    }
}
