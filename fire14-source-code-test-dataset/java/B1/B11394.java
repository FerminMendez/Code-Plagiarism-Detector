/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Problem3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author Mohammed
 */
public class Pairs {
  
    static int in[][], out[];
    static int found;
    private static void readFile(String fileName) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        int x = Integer.parseInt(br.readLine());

        in = new int[x][2];
        out = new int[x];

        for (int i = 0; i < x; i++) {
            line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int j = 0;
            while (st.hasMoreTokens()) {
                in[i][j++] = Integer.parseInt(st.nextToken());
            }

        }
    }
    public static void main(String[] args) throws FileNotFoundException, IOException {
        readFile("data");
        manipulate();
        writeOutput("output.txt");
    }

    private static void manipulate() {
           for (int i = 0; i < in.length;i++){
               int start = in[i][0];
               int end = in[i][1];
               found = 0;
               for (int j = start; j<=end; j++){
                   String numString = j+"";
                   int numValue = j;
                 //  System.out.println(numString);
                   for(int k = 1; k < numString.length(); k++){
                       if (((char)(numString.charAt(k))) == '0')
                           continue;
                       String firstString = numString.substring(0,k);                   
                       String secondString = numString.substring(k,numString.length());                     
                       String resultString = secondString + firstString;
                       int num = Integer.parseInt(resultString);
                       System.out.println(i + " " +resultString);
                       if ((num>numValue)&&(num>=start)&&(num<=end)){
                           found++;
                           System.out.println("hello");
                       }
                   }
               }
               out[i] = found;
           }
    }
      private static void writeOutput(String string) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(string));
        for (int i = 0; i < out.length; i++) {
            bw.write("Case #" + (i + 1) + ": " + out[i]);
            if (i != out.length - 1) {
                bw.write("\r\n");
            }
        }
        bw.close();
    }
    
}
