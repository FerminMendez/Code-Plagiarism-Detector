import java.io.*;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Manish
 * Date: 4/14/12
 * Time: 2:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class CodeJamProblemC {
    CodeJamProblemC() {

    }

    public static void main(String args[]) throws Exception {
        String inputPath = "C:\\Users\\Manish\\IdeaProjects\\Codejam\\src\\C-small-attempt0.in";
        String outputPath = "C:\\Users\\Manish\\IdeaProjects\\Codejam\\src\\C-small.out";

        CodeJamProblemC rw = new CodeJamProblemC();
        String[] str = rw.readFromFile(inputPath);
        String[] solution = getSolution(str);
        //Logic to change
        for (String solstr : solution)
            //System.out.println("rotaion logic is working::" + solstr);
        rw.writeToFile(outputPath, solution);
    }

    private static String[] getSolution(String[] str) {
        int noOftestCases = Integer.parseInt(str[0]);
        String[] output = new String[noOftestCases];
        //Logic-try for only one
        for (int i = 1; i <= noOftestCases; i++) {
            String[] arr = str[i].split(" ");
            int lowerLimit = Integer.parseInt(arr[0]);
            int upperLimit = Integer.parseInt(arr[1]);
            int count = 0;
            while (upperLimit > lowerLimit) {
                for (int j = 0; j < upperLimit - lowerLimit; j++) {
                    //System.out.println("pair::(" +String.valueOf(lowerLimit+j)+","+ String.valueOf(upperLimit)+")");
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
                   // System.out.println("good :) found the number::" + rotate(a, j) + "," + b + " pair::(" + a + "," + b + ")");
                    countInRecycledPossible++;
                    break;
                }
            }
            if(countInRecycledPossible>0){
             break;
            }
        }
        if (countInRecycledPossible > 0) {
            //System.out.print("countInRecycledPossible::" + countInRecycledPossible + " ----");

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
