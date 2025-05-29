/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codajam2012;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author dectroo
 */
public class Recycled {

    public static Vector<Long> tabl;

    static long[] RotationList(String N) {

        long result[] = new long[N.length() - 1];
        long n = Long.parseLong(N);
        long number = n;
        long start = number;
        int i = 0;
        int numdigits = (int) Math.log10((double) number); // would return numdigits - 1
        int multiplier = (int) Math.pow(10.0, (double) numdigits);


        while (true) {
            long q = number / 10;
            long r = number % 10;

            number = number / 10;
            number = number + multiplier * r;




            if (number == start) {
                break;
            } else {
                result[i] = number;
                i++;
            }
        }



        return result;

    }

    static void ComputePair(long A, long B) {

        long index = A;
        int numbrPair = 0;
        tabl = new Vector<Long>();
        String indexString;
        while (index < B) {

            if (index != 0) {
                indexString = String.valueOf(index);
                long result[] = RotationList(indexString);
                for (int i = 0; i < result.length; i++) {
                    /*
                     * if(tabl.contains(new Long(result[i]))){
                     *
                     * }
                     */
                    if (index < result[i] && result[i] <= B) {
                        tabl.add(new Long(result[i]));
                        //System.out.println(result[i]);
                    }
                }
            }
            index++;
        }


    }

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(new File("test.in"));
        PrintWriter out = new PrintWriter("recycled.out");



        /*
         * for(int i=0;i<result.length;i++){ System.out.println(result[i]);
        }
         */



        int n = in.nextInt();
        int A = 0;
        int B = 0;
        in.nextLine();
        for (int i = 0; i < n; i++) {
            A = in.nextInt();
            B = in.nextInt();
            ComputePair(A, B);
            Object result[] = tabl.toArray();
            out.print("Case #"+(i+1)+": ");
            out.println(result.length);
        }
        in.close();
        out.close();
    }
}
