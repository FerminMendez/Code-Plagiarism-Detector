/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recyclednumber;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import javax.swing.JFileChooser;

/**
 *
 * @author pos
 */
public class RecycledNumbers {

    static Numbers[] TestCases;

    public static void main(String args[]) {
        readFile();
        for (int i = 0; i < TestCases.length; i++) {
            TestCases[i].Calculate();
        }
        WriteToFile();
    }

    private static void readFile() {
        try {
            JFileChooser FC = new JFileChooser();
            String Path = null;
            if (FC.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                Path = FC.getSelectedFile().getPath();

                StringBuffer Text = new StringBuffer();
                FileInputStream FIS = null;
                DataInputStream DIS;
                BufferedReader BR;

                FIS = new FileInputStream(Path);
                DIS = new DataInputStream(FIS);
                BR = new BufferedReader(new InputStreamReader(DIS));
                int TestCasesCount = Integer.valueOf(BR.readLine());

                TestCases = new Numbers[TestCasesCount];
                for (int i = 0; i < TestCasesCount; i++) {
                    String[] AB = BR.readLine().split(" ");
                    TestCases[i] = new Numbers(Integer.valueOf(AB[0]), Integer.valueOf(AB[1]));
                }
                FIS.close();
                DIS.close();
                BR.close();

            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void WriteToFile() {
        FileOutputStream FOS = null;
        DataOutputStream DOS;
        BufferedWriter BW;
        try {
            FOS = new FileOutputStream(new File("Recycled"));
        } catch (FileNotFoundException ex) {
        }
        DOS = new DataOutputStream(FOS);
        BW = new BufferedWriter(new OutputStreamWriter(DOS));

        for (int i = 0; i < TestCases.length; i++) {
            String Line = "Case #" + (i + 1) + ": " + TestCases[i].Result+"\n";
            try {
                BW.write(Line);
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }
        try {
            BW.close();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }

    }
}
