/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package google_code_jam;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 *
 * @author lenovo
 */
public class B {


    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        BufferedReader br = new BufferedReader(new FileReader("B-small-attempt0.in"));
        PrintWriter pw = new PrintWriter("B.out" );
        StringTokenizer st=new StringTokenizer(br.readLine());
       // System.out.println(st);
        int x = Integer.parseInt(st.nextToken());
        a1:for (int i = 0; i < x; i++) {
           st = new StringTokenizer(br.readLine());
           int n = Integer.parseInt(st.nextToken());// number of players
           int s = Integer.parseInt(st.nextToken());//number of surprising
           int p = Integer.parseInt(st.nextToken());// best degree required
           int count=0;//
           for (int j = 0; j < n; j++) {
               int temp=Integer.parseInt(st.nextToken());
               int rem=temp%3;
               int div=temp/3;
               if(temp==0 && p!=0)continue;
               else if(temp==0 && p==0){
                   count++;
                   continue;
               }
               if(rem==0){
                   if(div>=p){
                       count++;
                       continue;
                   }
                 else if(div+1>=p && s>0){
                      count++;
                      s--;
                      continue;
                }
               }// end of this condition
               else{
                   if(rem==1){
                    if(div+1 >=p)count++;
                   }
         else if(rem==2){
        if(div+1 >= p)count++;
        else if (div+2  >=p && s>0){
            count++;
            s--;
            continue;
        }
          }
               }
            }// End of converting
           pw.append("Case #"+(i+1)+": "+count+"\n");
      }
        pw.close();
    }

}

