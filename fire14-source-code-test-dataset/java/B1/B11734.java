/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test3;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Student
 */
public class Test3 {

    public static int rotations(int number, int max) {


        int l = 0;
        int start = number;
        int numdigits = (int) Math.log10((double) number); 
        int multiplier = (int) Math.pow(10.0, (double) numdigits);
        while (true) {
            int q = number / 10;
            int r = number % 10;
            number = number / 10;
            number = number + multiplier * r;
            if (number > start && Integer.toString(number).length() == numdigits + 1 && number <= max) {
                l++;
            }
            if (number == start) {
                break;
            }

        }
        return l;
    }
    
    public static int possibilities(int A, int B){
        int K = 0;
        for (int i = A; i <= B; i++) {
            K += rotations(i,B);
        }
        return K;
    }

    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        
        int i=1;
        int max = 0;
        Scanner ss=new Scanner(new File("C-small-attempt1.in.txt"));
        PrintWriter x=new PrintWriter(new File("C-small-attempt1.out.txt"));
        if(ss.hasNext()) max=Integer.parseInt(ss.next());
        while(ss.hasNextLine()&&i<=max){
            int A = 0;
            if(ss.hasNext()) A=Integer.parseInt(ss.next());
            int B = 0;
            if(ss.hasNext()) B=Integer.parseInt(ss.next());
            x.println("Case #"+i+": "+possibilities(A, B));
            i++;
        }
        x.close();
        }
    }
