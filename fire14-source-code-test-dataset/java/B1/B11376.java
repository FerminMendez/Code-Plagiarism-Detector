/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recyclednumbers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;

/**
 *
 * @author PARIMAL
 */
public class RecycledNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String inputFile = "E:\\C-small-attempt0.in";
        String outputFile = "E:\\C-small-attempt0.out";

        File f = new File(inputFile);
        FileInputStream fis = null;
        BufferedReader reader = null;

        try {
            fis = new FileInputStream(f);
            reader = new BufferedReader(new InputStreamReader(fis));
            String line = reader.readLine();
            //ret=line.split(" ");

            int loopCount = Integer.parseInt(line);

            int i;
            int a, b;
            long A, B;
            int RecycledPairs[] = new int[loopCount];
            for (int j = 0; j < RecycledPairs.length; j++) {
                RecycledPairs[j] = 0;
            }
            //System.out.println("loop"+loopCount);
            String out[] = new String[loopCount];
            String bounds[] = new String[2];

            for (i = 0; i < loopCount; i++) {

                String t = reader.readLine();
                bounds = t.split(" ");
                a = Integer.parseInt(bounds[0]);
                b = Integer.parseInt(bounds[1]);

                int lengthA = bounds[0].length();

                if (lengthA == 1) {
                    RecycledPairs[i] = 0;
                    out[i] = String.valueOf(RecycledPairs[i]);
                } else {
                    String tempA, lastA, firstA, finalA;
                    int finalAns;

                    for (int j = a; j <= b; j++) {

                        tempA = String.valueOf(j);
                        //System.out.println("tempA " + tempA);


                        for (int k = 1; k < lengthA; k++) {
                            lastA = tempA.substring(lengthA - k);    //12345 ==> 45

                            //System.out.println("lastA "+lastA);
                            //System.out.println("firstA "+firstA);

                            if (Integer.parseInt(lastA) == 0) {
                                //System.out.println("Encountered zeros with " + k + " times");
                            } else {

                                firstA = tempA.substring(0, lengthA - k);

                                finalA = lastA + firstA;

                                finalAns = Integer.parseInt(finalA);
                                if (j < finalAns && finalAns <=b) {
                                    RecycledPairs[i]++;
                                    //System.out.println("Re: " + RecycledPairs[i]);
                                }
                            }

                        }
                        out[i] = String.valueOf(RecycledPairs[i]);
                    }
                }

            }



            for (int j = 0; j < loopCount; j++) {
                String o = " ";
                StringBuffer sB = new StringBuffer(100);
                sB.append("Case #" + (j + 1) + ": ");

                o=sB.append(out[j]).toString();

                out[j] = o;
            }



            FileOutputStream fileOutputStream = null;
            try {
                File fOut = new File(outputFile);
                fileOutputStream = new FileOutputStream(fOut);

                for (int m = 0; m < out.length; m++) {

                    out[m] += "\n";
                    byte[] bytes = out[m].getBytes();
                    fileOutputStream.write(bytes);
                }


                fileOutputStream.flush();
                fileOutputStream.close();

                fis.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
