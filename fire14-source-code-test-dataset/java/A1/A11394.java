
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import javax.imageio.IIOException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author abood
 */
public class proba {
    public static void main(String[] args) throws IIOException, FileNotFoundException, IOException{
        //String alpha="abcdefghojklmnopqrstuvwxyzabcdefghojklmnopqrstuvwxyz";
        BufferedReader br =new BufferedReader(new FileReader("A-small-attempt0.in"));
        PrintWriter out =new PrintWriter(new BufferedWriter(new FileWriter("A-small-attempt0.out")));
        int loop=Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 1; i <= loop; i++) {
            int res=0;
            st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int s=Integer.parseInt(st.nextToken());
            int p=Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                int x=Integer.parseInt(st.nextToken());
          
             
             if(x<p)continue;
                x-=p;
                x/=2;
                if(x>=p-1)res++;
                else if(x==p-2){
                    if(s>0){res++;s--;}
                }
            }
            //System.out.println("Case #"+i+": "+res);
            out.println("Case #"+i+": "+res);
        }
        out.close();
        System.exit(0);
    }
    
}
