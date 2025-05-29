
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author viswas
 */
public class Recycled {


    public static void main(String [] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = 1;

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){

            long count = 0;
            StringTokenizer str = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(str.nextToken());
            int B = Integer.parseInt(str.nextToken());

            ArrayList <Integer> Alist = new ArrayList<Integer>();

            for(int i = A; i <= B; i++){
                String s = i + "";
                String aa = s;
                int len = s.length();
                s += s;
                Alist.clear();
                for(int j = 0; j < len; j++){
                    String s1 = s.substring(j, j + len);
                    int s2 = Integer.parseInt(s1);
                    if(!Alist.contains(s2)){
                        s1 = s2 + "";
                        if(i < s2 && aa.length() == s1.length() && B >= s2){
                            count++;
                            //System.out.println(n.substring(0, len) + " " + m);
                        }
                        Alist.add(s2);
                    }
                }
            }
            System.out.printf("Case #%d: %d", t, count);
            System.out.println();
            t++;
        }
    }

}

