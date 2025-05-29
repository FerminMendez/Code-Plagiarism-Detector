/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Codejam2012;

import java.io.*;

/**
 *
 * @author Brian
 */
public class recycled {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        String data;
        int result;
        String printout = "";
        String[] output;

        String inputFileName = "C:/input/recycledIn.txt";
        String outputFileName = "C:/input/recycledOut.txt";

        BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
        FileWriter out = new FileWriter(outputFileName);
        PrintWriter print = new PrintWriter(out);

        data = reader.readLine();
        int size = Integer.parseInt(data);
        output = new String[size];
        data = reader.readLine();
        int k = 0;
        while (data != null) {
            //result=data;
            String[] nums = data.split("\\s");
            int firstNum = Integer.parseInt(nums[0]);
            int secNum = Integer.parseInt(nums[1]);
            boolean res;
            if (secNum < 10) {
                result = 0;
            } else {
                if (String.valueOf(firstNum).length() == String.valueOf(secNum).length()) {
                    result = checkNumOfArrangements(firstNum, secNum);
                } else {
                    result = 0;
                }
            }

            output[k++] = String.valueOf(result);

            data = reader.readLine();
        }

        for (int p = 0; p < output.length; p++) {
            printout += "Case #" + (p + 1) + ": " + output[p] + "\n";
        }
        print.println(printout);
        print.close();
        reader.close();
    }

    public static boolean compareNumChars(int first, int second) {
//        int k = 0;
//        boolean cond = true;
//        String firstNum = String.valueOf(first);
//        String secNum = String.valueOf(second);
//        while (k < firstNum.length()) {
//            if (firstNum.charAt(k) == secNum.charAt(k)) {
//                k++;
//                continue;
//            } else {
//                cond = false;
//                break;
//            }
//        }
//        return cond;
        if(first == second){
            return true;
        }
        else{
            return false;
        }
    }

    public static int checkNumOfArrangements(int first, int second) {
        int control = first;
        int count = 0;
        while (control <= second) {
            int control_alt = control + 1;
            while (control_alt <= second) {
                if (compareNums(control, control_alt)) {
                    count++;
                }
                control_alt++;
            }
            control++;
        }
        return count;
    }

    public static boolean compareNums(int first, int second) {

        String str = String.valueOf(first);
        StringBuffer buf;
        if (compareNumChars(first, second)) {
            return true;
        } else {
            for (int k = 0; k < str.length()-1; k++) {
                buf = new StringBuffer(str);
                for (int p = 0; p < str.length(); p++) {
                    if (p == 0) {
                        buf.setCharAt(p, str.charAt(str.length() - 1));
                    } else {
                        buf.setCharAt(p, str.charAt(p - 1));
                    }
                }
                if (compareNumChars(Integer.parseInt(buf.toString()), second)) {
                    return true;
                } else {
                    str = buf.toString();
                }
            }
            return false;
        }
    }
}
