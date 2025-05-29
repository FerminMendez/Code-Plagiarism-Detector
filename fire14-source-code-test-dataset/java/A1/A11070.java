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
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 *
 * @author 144key (tux_daemon)
 */
public class Main {
    // Problem 2 : B. Dancing With the Googlers
    public static Hashtable surpriseCombination = null;
    public static int nbCombinationPosition = 0;
    public static void comb(int[] items) {
        Arrays.sort(items);
        for (int k = 1; k <= items.length; k++) {
            kcomb(items, 0, k, new int[k]);
        }
    }
    public static void kcomb(int[] items, int n, int k, int[] arr) {
        if (k == 0) {            
            if (surpriseCombination != null && arr.length == nbCombinationPosition) {                
                int[] ret = new int[nbCombinationPosition];
                for (int ii = 0; ii < nbCombinationPosition; ii++) {
                    ret[ii] = arr[ii];
                }
                // System.out.println("COMBI : "+Arrays.toString(ret));
                surpriseCombination.put(Arrays.toString(ret), ret);
            }
        } else {
            for (int i = n; i <= items.length - k; i++) {
                arr[arr.length - k] = items[i];
                kcomb(items, i + 1, k - 1, arr);
            }
        }
    }    
    public static boolean inArray(int val, int[] set) {
        int nbElmt = set.length;
        for (int i = 0; i < nbElmt; i++)
            if (set[i] == val) return true;
        return false;
    }
    public static void dancingWithGooglers(String fileIn, String fileOut) {
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
                    String[] tmp = tmpStrLine.toString().split("\\s");
                    int nbGooglers = Integer.parseInt(tmp[0]);
                    int nbSurpriseResult = Integer.parseInt(tmp[1]);
                    int minPoint = Integer.parseInt(tmp[2]);
                    int[] googlerTotalPoints = new int[nbGooglers];
                    for (int i = 3; i < (nbGooglers+3); i++) {
                        googlerTotalPoints[i-3] = Integer.parseInt(tmp[i]);
                    }
                    // process
                    int[][] googlerPoints = new int[nbGooglers][3];
                    int numberOfQualifiedMinResult = 0; // ====================================
                    if (nbSurpriseResult > 0) {
                        surpriseCombination = new Hashtable();
                        nbCombinationPosition = nbSurpriseResult;
                        int[] googlers = new int[nbGooglers];
                        for (int i = 0; i < nbGooglers; i++) {
                            googlers[i] = i;
                        }
                        comb(googlers);
                        if (surpriseCombination != null) {
                            Enumeration e = surpriseCombination.elements();
                            int tmpNumberOfQualifiedMinResult = 0;
                            int[] surprisePosition = null;
                            int nbCombiProcess = 0;
                            while (e.hasMoreElements()) {                                
                                tmpNumberOfQualifiedMinResult = 0;
                                surprisePosition = (int[]) e.nextElement();
                                for (int i = 0; i < nbGooglers; i++) {
                                    // init point
                                    int basePoint = googlerTotalPoints[i] / 3;
                                    int sharedPoint = googlerTotalPoints[i] % 3;                                    
                                    for (int j = 0; j < 3; j++) {
                                        googlerPoints[i][j] = basePoint + (sharedPoint > 0 ? 1 : 0);
                                        sharedPoint--;
                                    }
                                    // surprisezation
                                    if (inArray(i, surprisePosition)) {
                                        if (googlerPoints[i][0] == googlerPoints[i][1] && googlerPoints[i][0] > 0 && googlerPoints[i][0] < 10) {
                                            googlerPoints[i][0]++;
                                            googlerPoints[i][1]--;
                                        } else if (googlerPoints[i][1] == googlerPoints[i][2] && googlerPoints[i][1] > 0 && googlerPoints[i][1] < 10) {
                                            googlerPoints[i][1]++;
                                            googlerPoints[i][2]--;
                                        } else if (googlerPoints[i][0] == googlerPoints[i][2] && googlerPoints[i][0] > 0 && googlerPoints[i][0] < 10) {
                                            googlerPoints[i][0]++;
                                            googlerPoints[i][2]--;
                                        } 
                                    }
                                    // check
                                    boolean checked = false;
                                    for (int j = 0; j < 3; j++) {
                                        if (googlerPoints[i][j] >= minPoint && !checked) {
                                            tmpNumberOfQualifiedMinResult++;
                                            checked = true;
                                        }
                                    }
                                    // System.out.println("HADSURPRISE :: " + nbCombiProcess + " : " + Arrays.toString(surprisePosition) + " : " + Arrays.toString(googlerPoints[i]));
                                }
                                if (tmpNumberOfQualifiedMinResult > numberOfQualifiedMinResult) {
                                    numberOfQualifiedMinResult = tmpNumberOfQualifiedMinResult;
                                }
                                nbCombiProcess++;
                            }
                        }
                    } else {                        
                        for (int i = 0; i < nbGooglers; i++) {
                            // init point and check
                            int basePoint = googlerTotalPoints[i] / 3;
                            int sharedPoint = googlerTotalPoints[i] % 3;
                            boolean checked = false;
                            for (int j = 0; j < 3; j++) {
                                googlerPoints[i][j] = basePoint + (sharedPoint > 0 ? 1 : 0);
                                sharedPoint--;
                                if (googlerPoints[i][j] >= minPoint && !checked) {
                                    numberOfQualifiedMinResult++;
                                    checked = true;
                                }                                
                            }
                            // System.out.println("NOSURPRISE : " + Arrays.toString(googlerPoints[i]));
                        }
                    }
                    // output result
                    fos.write(("Case #"+processedCase+": "+numberOfQualifiedMinResult+"\n").getBytes());
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
        dancingWithGooglers("B-small-attempt0.in", "B-small-attempt0.out");
    }
}
