// Mario Morales

import java.util.*;
import java.io.*;

public class p3{
  public static void main(String[] args) throws Exception{
  	BufferedReader f = new BufferedReader(new FileReader("input3small.txt"));
  	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("answer3small.txt")));

    //Brute Force Solution
    int t = Integer.parseInt(f.readLine()); //# of test cases
    StringTokenizer st;
    int a, b, d, res;
    String aNew;
    for(int i=0; i<t; i++){
        st = new StringTokenizer(f.readLine());
        a = Integer.parseInt(st.nextToken());//bounds
        b = Integer.parseInt(st.nextToken());
        d = (""+a).length();//number of digits
        res = 0;

        for(int a1=a; a1<b; a1++){
            for(int b1=a1+1; b1<=b; b1++){
                //move n rightmost digits
                for(int n=1; n<d; n++){
                    aNew = (""+a1).substring(d-n, d) + (""+a1).substring(0, d-n);
                    if(aNew.equals(""+b1)){
                        res++;
                        break;
                    }
                }
            }
        }
    	out.println("Case #" + (i+1) + ": " + res);
    }

    out.close();
    System.exit(0);
  }
}
