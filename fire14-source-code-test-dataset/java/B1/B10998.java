
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author dewmal
 */
public class QC {

    public static void main(String[] args) throws IOException {
        String[] readFile = readFile("input.in");
        for (int i = 1; i < readFile.length; i++) {

            String value = readFile[i];
            StringTokenizer st = new StringTokenizer(value, " ");
            int numArray[] = new int[st.countTokens()];
            int j = 0;
            while (st.hasMoreTokens()) {
                String nextToken = st.nextToken();
                numArray[j] = Integer.parseInt(nextToken);
                j++;
            }


            int A = numArray[0];
            int B = numArray[1];

            int count = 0;

            for (int n = A; n <= B; n++) {

                String numberOne = n + "";


                for (int m = n + 1; m <= B; m++) {

                    String numberTwo = m + "";

                    char[] numOneCs = numberOne.toCharArray();

                    int[] numOnIs = getInArray(numOneCs);

                    char[] numTwoCs = numberTwo.toCharArray();
                    int[] numTwoIs = getInArray(numTwoCs);
                    boolean numberCoupleOk = true;

                    if (numOnIs.length == numTwoIs.length) {
                        Arrays.sort(numOnIs);
                        Arrays.sort(numTwoIs);
                        numberCoupleOk = (Arrays.equals(numOnIs, numTwoIs));

                        if (numOnIs.length > 2) {
                            //if (numberCoupleOk) {

                            numOnIs = getInArray(numOneCs);
                            numTwoIs = getInArray(numTwoCs);

                            int numNew[] = new int[numOnIs.length];
                            numNew[0] = numTwoIs[1];
                            numNew[1] = numTwoIs[2];
                            numNew[2] = numTwoIs[0];

                            numberCoupleOk = Arrays.equals(numNew, numOnIs);


                            if (!numberCoupleOk) {

                                numNew[0] = numTwoIs[2];
                                numNew[1] = numTwoIs[0];
                                numNew[2] = numTwoIs[1];

                                numberCoupleOk = Arrays.equals(numNew, numOnIs);

                            }
                            // }
                        }
                    }
                    if (numberCoupleOk && n < m) {
                       // System.out.println(n + " " + m);
                        count++;
                    }
                }
                if (n + 1 == B) {
                    break;
                }
            }
            final String outValue = "Case #" + i + ": " + count;
            System.out.println(outValue);
            writeFile(outValue);
        }






    }

    private static int[] getInArray(char[] numOneCs) throws NumberFormatException {
        int[] numOnIs = new int[numOneCs.length];
        for (int i = 0; i < numOneCs.length; i++) {
            numOnIs[i] = Integer.parseInt(numOneCs[i] + "");
        }
        return numOnIs;
    }

    private static String[] readFile(String trainEngin) throws IOException, FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader(trainEngin));
        String line = br.readLine();

        List<String> arraList = new ArrayList<>();
        while (line != null) {
            arraList.add(line);
            line = br.readLine();

        }
        String[] toArray = {};
        toArray = arraList.toArray(toArray);
        return toArray;
    }
    private static BufferedWriter bw;

    static {
        try {
            bw = new BufferedWriter(new FileWriter("out.in"));
        } catch (IOException ex) {
            Logger.getLogger(QC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void writeFile(String value) throws IOException {
        bw.append(value);
        bw.newLine();
        bw.flush();

    }
}
