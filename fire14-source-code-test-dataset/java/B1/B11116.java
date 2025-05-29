/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package solution;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 *
 * @author 144key (tux_daemon)
 */
public class Main {
    // Problem 3 : Problem C. Recycled Numbers
    public static void recycledNumbers(String fileIn, String fileOut) {
        try {
            FileInputStream fis = new FileInputStream(new File(fileIn));
            FileOutputStream fos = new FileOutputStream(new File(fileOut));
            int chars = 0;
            StringBuffer tmpStrLine = null;
            int nbCase = 0;
            int processedCase = 1;
            int guide = 0;
            while ((chars != -1) && ((nbCase == 0) || (processedCase <= nbCase))) {
                tmpStrLine = new StringBuffer();
                while (((chars = fis.read()) != -1) && (((char) chars) != '\n')) {
                    tmpStrLine.append((char) chars);
                }
                if (guide == 0) { // searching for nbCase
                    nbCase = Integer.parseInt(tmpStrLine.toString());
                    guide = 1;
                } else if (guide == 1) { // process
                    // init
                    //System.out.println("IN : " +tmpStrLine.toString());
                    String[] tmp = tmpStrLine.toString().split("\\s");
                    int bottomLimit = Integer.parseInt(tmp[0]);
                    int topLimit = Integer.parseInt(tmp[1]);
                    int nbRecycledPair = 0;
                    for (int processedNumber = bottomLimit; processedNumber <= topLimit; processedNumber++) {
                        char[] numberElmt = (""+processedNumber).toCharArray();
                        int numberElmtLength = numberElmt.length;
                        if (numberElmtLength > 1) {
                            for (int j = 0; j < (numberElmtLength-1); j++) {
                                char lastElmt = numberElmt[numberElmtLength-1];
                                for (int k = (numberElmtLength-1); k > 0; k--) {
                                    numberElmt[k] = numberElmt[k-1];
                                }
                                numberElmt[0] = lastElmt;
                                int tmpRecycle = Integer.parseInt(String.valueOf(numberElmt, 0, numberElmtLength));
                                if (tmpRecycle > processedNumber && tmpRecycle <= topLimit) {
                                    nbRecycledPair++;
                                }
                            }
                        }
                    }
                    // output result
                    fos.write(("Case #"+processedCase+": "+nbRecycledPair+"\n").getBytes());
                    //System.out.println("Case #"+processedCase+": "+nbRecycledPair);
                    // back to search tmpCredit
                    processedCase++;
                }
            }
            fis.close();
            fos.close();
        } catch (FileNotFoundException e) {
            System.err.println("FileNotFound : " + e);
        } catch (IOException e) {
            System.err.println("IOException : " + e);
        } catch (Exception e) {
            System.err.println("Other Exception : " + e);
        }
    }

    /**
     * @param args the command line arguments
     **/
    public static void main(String[] args) {
        // TODO code application logic here
        recycledNumbers("C-small-attempt0.in", "C-small-attempt0.out");
    }
}
