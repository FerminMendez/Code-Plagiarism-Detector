/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package codejam;

import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Suarabh Agarwal
 */
public class Main2 {

    public static void main(String args[])
  {
  try{
        Scanner  scan1 = new Scanner(new FileReader("input1"));
        PrintWriter out = new PrintWriter("output1.txt");
        String T = scan1.nextLine();
        int test_case = Integer.parseInt(T);
        int test = test_case;
        while(test_case>0)
        {
        int Num = scan1.nextInt();
        int Sur_num = scan1.nextInt();
        int high_num = scan1.nextInt();
        int scores[] = new int[Num];
        int i=0;
        int count =Num;
        while(count>0)
        {
            scores[i] = scan1.nextInt();
            i++;
            count--;
        }
        int temp = 3*high_num;
        count = 0;
        int answer = 0;
        while(count<Num)
        {
            if(scores[count]==0)
            {
               if(temp==0)
               {
                   answer++;
               }
            }
            else if(scores[count] > (temp - 3))
            {
                answer++;
            }
            else if(scores[count]> (temp-5) )
            {
                if(Sur_num>0)
                {
                    answer++;
                    Sur_num--;
                }
            }
            count++;
        }
        out.println("Case #"+ (test-test_case+1)+": "+ answer);
        test_case--;
       // System.out.println(scores[2]);
        //System.exit(0);
        }
        scan1.close();
        out.close();

     }
  catch(Exception e)
  {
         System.err.println("Error: " + e.getMessage());
  }
  }
}