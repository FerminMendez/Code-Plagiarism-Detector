/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Recycle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 *
 * @author hemal
 */
public class Main {

    public static void main(String[] args) {
        try {
            BufferedReader bf = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/src/Recycle/" + "input.in"));
            String s = bf.readLine();
            int t = Integer.parseInt(s);
//            for (int i = 1; i <= t; i++) {
//                int count = 0;
//                String s1 = bf.readLine();
//                String s2[] = s1.split(" ");
//                int a = Integer.parseInt(s2[0]);
//                int b = Integer.parseInt(s2[1]);
//                int size = s2[0].length();
//                System.out.println("size " + size);
//                for (int j = a; i <= b; j++) {
////                    for(int k=0;k<size;k++){
////                        String m=String.valueOf(j).charAt(k)
////                    }
////                    System.out.println(a + "  " + b);
////                    for (int k = 1; k <= size; k++) {
//                        int m = (int) (((j % (Math.pow(10, 1))) * Math.pow(10, size - 1)) + j / Math.pow(10, 1));
//                        System.out.println(m);
//                        m = (int) (((j % (Math.pow(10, 2))) * Math.pow(10, size - 2)) + j / Math.pow(10, 2));
//                        System.out.println(m);
////                        m = (int) (((j % (Math.pow(10, 3))) * Math.pow(10, size - 3)) + j / Math.pow(10, 3));
////                        System.out.println(m);
////                        m = (int) (((j % (Math.pow(10, 4))) * Math.pow(10, size - 4)) + j / Math.pow(10, 4));
////                        System.out.println(m);
////                        if (m > b) {
////                            break;
////                        }
////                    }
//                }
//                System.out.println("Case #" + i + ": " + count);
//            }
            PrintWriter pw = new PrintWriter("output.out");
            pw.println("Omg! It works!");
            ArrayList ar=new ArrayList();
            ar.add("1");
            ar.add("1");
            HashMap hm=new HashMap();
            hm.put("1", 12);
            hm.put("1", 32);
            System.out.println(hm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
