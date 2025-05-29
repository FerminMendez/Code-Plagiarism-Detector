/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Prabhath
 */
public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = null;
        PrintWriter writer=null;
        try{
             scanner = new Scanner(new FileInputStream("E:\\c.in"));
        writer=new PrintWriter(new FileOutputStream("E:\\c.out"), true);
        }catch(Exception e){

        }
        int n = Integer.parseInt(scanner.nextLine());
        for (int k = 0; k < n; k++) {
            String temp[]=scanner.nextLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
            int count = 0;

            for (int i = a; i <= b; i++) {
                for (int j = i + 1; j <= b; j++) {
                    if (check(String.valueOf(i), String.valueOf(j))) {
                        count++;
                    }
                }
            }

            writer.println("Case #"+(k+1)+": "+count);

            

        }
writer.close();




    }

    public static boolean check(String x, String y) {
        String a = "";
        String b = "";

        for (int i = 1; i < x.length(); i++) {
            a = x.substring(0, i);
            b = x.substring(i, x.length());
            if (y.equals(b + a)) {
                return true;
            }
        }
        return false;
    }
}
