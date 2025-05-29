/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codejam2012;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Luis Sergio Curay
 */
public class c {

    public c() {
        Scanner in= new Scanner(System.in);
        int t= in.nextInt();
        for (int i = 0; i < t; i++) {
            int a= in.nextInt();
            int b= in.nextInt();
            HashSet<Integer> nums= new HashSet<Integer>();
            int res= 0;
            for (int j = a; j <= b; j++) {
                HashSet<Integer> comb= combinaroty(j);
                for (Integer num : comb) {
                    if(num >= a && num <= b && num != j) {
                        if(!nums.contains(num)) {
                            nums.add(j);
                            res++;
                        }
                    }
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + res);
        }
    }
    
    public int reverse(int n) {
        String num= String.valueOf(n);
        for (int i = 0; i < num.length() - 1; i++) {
            num= num.substring(num.length() - 1) + num.substring(0, num.length() - 1);
        }
        return Integer.parseInt(num);
    }
    
    private HashSet<Integer> combinaroty(int n) {
        HashSet<Integer> res= new HashSet<Integer>();
        String num= String.valueOf(n);
        for (int i = 0; i < num.length() - 1; i++) {
            num= num.substring(num.length() - 1) + num.substring(0, num.length() - 1);
            res.add(Integer.parseInt(num));
        }
        return res;
    }
}