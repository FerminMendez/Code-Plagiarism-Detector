/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package google_code_jam;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 *
 * @author lenovo
 */
public class C {


    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        BufferedReader br = new BufferedReader(new FileReader("C-small-attempt1.in"));
        PrintWriter pw = new PrintWriter("C.out" );
        StringTokenizer st=new StringTokenizer(br.readLine());
       // System.out.println(st);
        int x = Integer.parseInt(st.nextToken());
        a1:for (int i = 0; i < x; i++) {
           st = new StringTokenizer(br.readLine());
           int min = Integer.parseInt(st.nextToken());// number of players
           int max = Integer.parseInt(st.nextToken());//number of surprising
           int res = solve(min , max);
           pw.append("Case #"+(i+1)+": "+res+"\n");
      }
        pw.close();
    }
    public static int solve(int a , int b){
        int count=0;
        int x ,y;
        for (int i = a; i < b; i++) {
            String item=i+"";
            int len=item.length();
            x=i;
            HashSet<Integer> hs = new HashSet<Integer>();
            for (int j = 0; j < len; j++) {
                y=x%10;
                y=y*(int)(Math.pow(10, len-1))+(x/10);
                if( y<=b && y>i ){
                    if(hs.add(y))
                    count++;
                }
                x=y;
            }

        }
        return count;
        }


}

