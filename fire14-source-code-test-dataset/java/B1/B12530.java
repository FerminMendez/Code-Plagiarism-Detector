/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RecycledNumbers;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Himeshi
 */
public class RecycledNumbers {

    public static void main(String[] args) {

        int A, B, N, pairs;
        String strLine, integers;

        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream("D:/Academic Work/Semester 5/Code Jam/C-small.in"))));

            while ((strLine = br.readLine()) != null) {

                N = Integer.parseInt(strLine);

                for (int i = 0; i < N; i++) {
                    integers = br.readLine();
                    String[] tokens = integers.split(" ");
                    A = Integer.parseInt(tokens[0]);
                    B = Integer.parseInt(tokens[1]);
                    pairs = calculate(A, B, i);
                    writeToFile(pairs, i);
                }

            }


        } catch (Exception e) {
            System.out.println("here is the exception"+e);
        }

    }

    private static int calculate(int A, int B, int i) {
        int pairs = 0;

        for (int index = A; index <= B; index++) {
            ArrayList<Integer> list = getPairs(index);

            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) <= B && list.get(j)>index) {
                   //System.out.println(""+index+" "+list.get(j));
                    pairs++;
                }
            }
        }

        return pairs;
    }

    private static ArrayList<Integer> getPairs(int index) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        String temp = Integer.toString(index);
        int length = temp.length();

        char[] buffer = temp.toCharArray();

        if (index < 10) {
            return list;
        } else {


            for (int numbers = 1; numbers < length; numbers++) {
              
                char c=buffer[length-1];
                
                for(int k=buffer.length-1;k>0;k--)
                {
                    buffer[k]=buffer[k-1];                    
                }
                
                buffer[0]=c;
                String s=new String(buffer);
                int number=Integer.parseInt(s);
                
                if(!list.contains(number))
                    list.add(number);
            }
            return list;
        }
    }
    
     private static void writeToFile(int a,int N) {
        try {
            // Create file 
            FileWriter fstream = new FileWriter(new File("D:/Academic Work/Semester 5/Code Jam/out.txt"),true);
            BufferedWriter out = new BufferedWriter(fstream);
           String str="Case #"+(N+1)+": "+a+"\r\n";
           out.append(str);
            //Close the output stream
            out.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }
}
