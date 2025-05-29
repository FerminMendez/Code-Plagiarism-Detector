/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package problem.c.recycled.numbers;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 * @author Park
 */
public class ProblemCRecycledNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        PrintStream out = new PrintStream(new File("/Users/Park/Desktop/output.txt"));
        Scanner in = new Scanner(new File("/Users/Park/Desktop/C-small-attempt0.in"));
        int testCase = Integer.parseInt(in.next());
        for (int n = 0; n < testCase; n++) {
            int count = 0;
            //
            int start = Integer.parseInt(in.next());
            int end = Integer.parseInt(in.next());
            //boolean[] chk = new boolean[end - start + 1];
            for (int i = start; i <= end; i++) {
             //   if (!chk[i - start]) {
                    boolean chk=true;
                    String num = i + "";
                    int numLength = num.length();
                    int[] alreadySearch=new int[numLength-1];
                    for (int j = 1; j < numLength; j++) {
                        String f = num.substring(0, j);
                        String b = num.substring(j);
                        int search = Integer.parseInt(b + f);
                        for(int k=0;k<j-1;k++){
                            if(search==alreadySearch[k]){
                                chk=false;
                                break;
                            }
                            chk =true;
                        }
                        alreadySearch[j-1]=search;
                        if (chk&&(search+"").length()==numLength&&search != i && search >= start && search <= end) {
                    //        System.out.println(i+">>"+search);
                            count++;
                    //        chk[search - start] = true;
                        }
                 //   }
                }
            }
            out.println("Case #" + (n + 1) + ": " + count/2);
            System.out.println("Case #" + (n + 1) + ": " + count/2);
        }
        in.close();
        out.close();
    }
}
