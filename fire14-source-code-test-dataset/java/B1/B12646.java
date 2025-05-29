/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package googlecodequalificationround;

import java.util.Scanner;

/**
 *
 * @author LeongYan
 */
public class RecycledNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        int[] out = new int[t];
        for (int i = 0; i < t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            for (int j = a; j <= b; j++) {
                String test = String.valueOf(j);
                String temp = " ";
                for (int k = 0; k < test.length(); k++) {
                    test = test.substring(1) + test.charAt(0); 
                    if(Integer.parseInt(test) > j && Integer.parseInt(test) <= b && !test.equals(temp)){
                        temp = test;
                        out[i]++;
                    }
                }
            }
        }
        for (int i = 0; i < t; i++) {
            System.out.println("Case #" + (i + 1) + ": " + out[i]);
        }
    }
}
