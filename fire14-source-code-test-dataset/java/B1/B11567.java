/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recyclednumbers;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;

/**
 *
 * @author arjun
 */
public class RecycledNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
        System.setOut(out);
        parseAndTranslate();
    }

    private static void parseAndTranslate() {
        try {
            // Open the file that is the first 
            // command line parameter
            FileInputStream fstream = new FileInputStream("C-small-attempt2.in");
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine = br.readLine();
            if (null != strLine) {
                int count = new Integer(strLine);
                //Read File Line By Line
                int lineNo = 0;
                while ((strLine = br.readLine()) != null) {
                    lineNo++;
                    doOp(strLine, lineNo);
                }
                //Close the input stream
            }
            in.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void doOp(String strLine, int lineNo) {
        StringTokenizer st = new StringTokenizer(strLine);
        System.out.print("Case #" + lineNo + ": ");
        String no = st.nextElement().toString();
        Integer numberA = new Integer(no);

        no = st.nextElement().toString();
        Integer numberB = new Integer(no);
        Integer count = 0;
        for (Integer i = numberA; i < numberB - 1; i++) {
            for (Integer j = i + 1; j <= numberB; j++) {

                boolean isRecycled = isNumberRecycleable(i, j);
                if (isRecycled) {
                    count++;
                    //System.out.println("A: "+ i + " B:" + j);
                }
            }

        }
        System.out.println(count);
    }

    private static boolean isNumberRecycleable(Integer noA, Integer noB) {
        String tmp = noA.toString();
        char[] no1 = tmp.toCharArray();
        String tmp2 = noB.toString();
        char[] no2 = tmp2.toCharArray();
        //System.out.println("\n\nNo 1: " + tmp + " No 2: " + tmp2);
        if (no1.length != no2.length) {
            return false;
        } else {
            for (int i = 1; i < no1.length; i++) {
                //System.out.println("Diff: " + i);
                boolean isRecy = isRecycleable(no1, no2, i);
                if(isRecy){
                    return isRecy;
                }
            }
        }
        return false;
    }

    private static boolean isRecycleable(char[] no1, char[] no2, int add) {
            for (int j = 0; j < no2.length; j++) {                
                int k = (j + add) % no2.length;
                //System.out.println("Cmp: no1[" + j +"] = " + no1[j] + " & no2["+ k + "] = " + no2[k]);
                if(no1[j] != no2[k]){
                    return false;
                }
        }
        return true;
    }
}
