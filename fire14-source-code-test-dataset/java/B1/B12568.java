
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author JOSE
 */
public class RecycledNumbers {

    public void process() {
        ArrayList<String> inputList = readFile("C-small-attempt0.in");
        String output = "";
        int testCase = 0;
        for (int i = 0; i < inputList.size(); i++) {
            String input = inputList.get(i);
            if (i == 0) {
                testCase = Integer.parseInt(input);
            } else {
                int recycledNo=findRecycledNO(input);
                output = output + "Case #" + i + ": "+recycledNo;
                if (i != (inputList.size() - 1)) {
                    output = output + '\n';
                }
            }
        }
        writeFile(output);
    }

    public int findRecycledNO(String input) {
        String spliInput[] = input.split("\\s");
        int A = Integer.parseInt(spliInput[0]);
        int B = Integer.parseInt(spliInput[1]);
        int n = 0;
        int m = 0;
        int resultCount = 0;
        String[] ab = new String[(B - A) + 1];
        for (int i = 0; i < ab.length; i++) {
            ab[i] = "" + (A + i);
        }
        for (String t : ab) {
            n = Integer.parseInt(t);
            for (int i = 0; i < t.length() - 1; i++) {
                t = t.substring(t.length() - 1) + t.substring(0, t.length() - 1);
                m = Integer.parseInt(t);
                if ((A <= n) && (n < m) && (m <= B)) {
                    //    System.out.println(A + " < " + n + " < " + m + " < " + B);
                    resultCount++;
                }

            }
            //  System.out.println(t);
        }

        return resultCount;
    }

    private ArrayList<String> readFile(String fileName) {

        BufferedReader br = null;
        ArrayList<String> inputList = null;
        try {
            File file = new File(fileName);
            br = new BufferedReader(new FileReader(file));
            String message = null;
            inputList = new ArrayList<String>();
            while ((message = br.readLine()) != null) {
                inputList.add(message);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return inputList;
        }
    }

    private void writeFile(String message) {
        BufferedWriter bw = null;
        try {
            File file = new File("Output.txt");
            bw = new BufferedWriter(new FileWriter(file));
            bw.write(message);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        RecycledNumbers rn = new RecycledNumbers();
        rn.process();
    }
}
