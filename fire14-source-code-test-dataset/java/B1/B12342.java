/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author harit
 */
public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int t1 = 1;
        int a, b;
        int count = 0;
        while (t1 <= t) {
            String s[] = br.readLine().split(" ");
            a = Integer.parseInt(s[0]);
            b = Integer.parseInt(s[1]);
            count=0;
            for (int i = a; i < b; i++) {
                List<Integer> lstR = getRnum(i);
                for (Integer j : lstR) {
                    if (j >= i && j <= b) {
                        count++;
                    }
                }

            }
            System.out.println("Case #"+ t1 + ": " + count);
            t1++;
        }

    }

    public static List<Integer> getRnum(int a) {
        List<Integer> lstRnum = new ArrayList<Integer>();
        String s = "" + a;
        int l = s.length();
        int modf = 10;
        int multf = (int) Math.pow(10, l - 1);
        int i = 1;
        boolean flag=true;
        while (i < l) {
            // System.out.println("modf "+modf);
            int x = ((a % modf) * multf) + a / modf;
            if (("" + x).length() == l && x!=a) {
                for(int xx:lstRnum){ if(xx==x) flag=false;}
                if(flag){
                    lstRnum.add(x);
                    
                }
                
            }
            modf = modf * 10;
            multf = multf / 10;
            i++;
        }

        return lstRnum;
    }
}
