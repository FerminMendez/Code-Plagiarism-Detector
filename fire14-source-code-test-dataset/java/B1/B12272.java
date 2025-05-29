/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author binny
 */
import java.io.*;
import java.util.ArrayList;


public class RecycledNumber {


    public static void main(String args[]) throws Exception {
        String inputPath = "//C-small-attempt0.in";
        String outputPath = "//C-small-attempt0.out";

        RecycledNumber rw = new RecycledNumber();
        String[] str = rw.readFromFile(inputPath);
        String[] solution = getSolution(str);
        rw.writeToFile(outputPath, solution);
    }

    private static String[] getSolution(String[] str) {
        int noOftestCases = Integer.parseInt(str[0]);
        String[] output = new String[noOftestCases];
        for (int i = 1; i <= noOftestCases; i++) {
            String[] arr = str[i].split(" ");
            int lowerLimit = Integer.parseInt(arr[0]);
            int upperLimit = Integer.parseInt(arr[1]);
            int count = 0;
            while (upperLimit > lowerLimit) {
                for (int j = 0; j < upperLimit - lowerLimit; j++) {
                    count = count + isRecycledPossible(String.valueOf(lowerLimit + j), String.valueOf(upperLimit));
                }
                upperLimit--;
            }
            output[i - 1] = "Case #" + i + ": " + count;
        }
        return output;
    }

    public static int isRecycledPossible(String a, String b) {

        int countInRecycledPossible = 0;
        for (int i = 0; i < a.length(); i++) {
            for (int j = i; j < a.length(); j++) {
                if (Integer.parseInt(rotate(a,j)) - Integer.parseInt(b) == 0) {
                    countInRecycledPossible++;
                    break;
                }
            }
            if(countInRecycledPossible>0){
             break;
            }
        }
        return countInRecycledPossible;
    }

    public static String rotate(String a, int i) {
        String substring = a.substring(a.length() - i);
        String rotatedDigit = substring + a.substring(0,a.length() - i);
        return rotatedDigit;
    }

    public String[] readFromFile(String inputPath) throws FileNotFoundException, IOException {
        FileInputStream fis = null;
        DataInputStream dis = null;
        BufferedReader br = null;
        ArrayList<String> strArrList = new ArrayList<String>();
        try {
            fis = new FileInputStream(inputPath);
            dis = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(dis));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                strArrList.add(strLine);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (dis != null) {
                    dis.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();

            }
        }
        return strArrList.toArray(new String[strArrList.size()]);
    }

    public void writeToFile(String outputPath, String[] strArr) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(outputPath));

            for (int i = 0; i < strArr.length; i++) {
                bw.write(strArr[i]);
                bw.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.flush();
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
