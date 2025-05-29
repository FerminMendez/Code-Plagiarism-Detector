/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package codejam;

/**
 *
 * @author Suarabh Agarwal
 */
import java.io.*;
import java.util.Scanner;

public class Main3
{
 public static void main(String args[])
  {
  try{
  Scanner scan1 = new Scanner(new FileReader("src//codejam///input"));
    //    Scanner  scan1 = new Scanner(new FileReader("input"));
  //Scanner  scan2 = new Scanner(new FileReader("output"));
  //Scanner  scan3 = new Scanner(new FileReader("test.in"));
  PrintWriter out = new PrintWriter("output1.txt");
  String T = scan1.nextLine();
  int test_case = Integer.parseInt(T);
  int count = test_case;
  //int answer = 0;
  while(count>0)
  {
      int A = scan1.nextInt();
      int B = scan1.nextInt();
      int temp[] = new int[3];
      int temp1[] = new int[3];
      int temp2[] = new int[3];
      //System.out.print(a[0]);
      //System.out.print(a[1]);
      //System.out.println(a[2]);
      int answer = 0;
      int count1 = B-A;
      int num = A;
      while(count1>=0)
      {
        // System.out.println(num);

          temp[0]=num/100;
          temp[1]=(num%100)/10;
          temp[2]=(num%100)%10;

           // System.out.print(temp[0]);
           // System.out.print(temp[1]);
           // System.out.println(temp[2]);
          if(temp[0]!=0)
          {
            temp1[0]=temp[2];
            temp1[1]=temp[0];
            temp1[2]=temp[1];
            int num1= temp1[0]*100+temp1[1]*10+temp1[2];
            if(num1>num && num1<=B)
            {
             answer++;
            }
             temp2[1]=temp[2];
             temp2[2]=temp[0];
             temp2[0]=temp[1];
            int num2= temp2[0]*100+temp2[1]*10+temp2[2];
             if(num2>num && num2<=B)
            {
              answer++;
            }
          }
          else if(temp[1]!=0)
          {
            // temp1[0]=temp[2];
            temp1[1]=temp[2];
            temp1[2]=temp[1];
            int num1= temp1[1]*10+temp1[2];
            if(num1>num && num1<=B)
            {
             answer++;
            }
          }
          num++;
          count1--;
      }
      out.println("Case #"+(test_case-count+1)+": "+ answer);
      count--;
  }
  out.close();

  }
  catch(Exception e)
      {
      System.err.println("Error: " + e.getMessage());
      }
  }
  }