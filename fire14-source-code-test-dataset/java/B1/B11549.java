/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package googlejam3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 *
 * @author Nomeir
 */
public class GoogleJam3 {

    private String inputFile =
            //            "C-large.in";
            ".\\C-small-attempt0.in";
//            ".\\test3.in";
    private String outputFile = ".\\out.txt";
    private String line = "start";
    private FileReader reader;
    private BufferedReader buffer;
    private FileWriter writer;
    private BufferedWriter printer;

    public GoogleJam3() {
        try {
            new File(outputFile).createNewFile();
            reader = new FileReader(inputFile);
            buffer = new BufferedReader(reader);
            new File(outputFile).createNewFile();
            writer = new FileWriter(outputFile);
            printer = new BufferedWriter(writer);
        } catch (IOException ex) {
            System.out.println("The file couldn't be created ...");
        }
    }

    public void endOperations() {
        try {
            if (reader != null) {
                reader.close();
            }
            if (buffer != null) {
                buffer.close();
            }
            if (printer != null) {
                printer.flush();
                printer.close();
            }
            if (writer != null) {
                writer.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    int lines;

    public void readInfo() {
        try {
            line = buffer.readLine();
            if (line != null) {
                lines = Integer.valueOf(line);
//                int i = 0, j = 0;
//                L = Integer.valueOf(line.substring(0, i = line.indexOf(" ")));
//                D = Integer.valueOf(line.substring(++i, j = line.indexOf(" ", i)));
//                N = Integer.valueOf(line.substring(++j, line.length()));
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Source file not found .. !");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (StringIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
    int aMinValue, bMaxValue, aMovingValue;
    int nMinValue, mMaxValue;
    String aStr, bStr;
    int t1, t2, searchIndex;
    ArrayList<Integer> keys, values;
    ArrayList<Integer> ab;

    private void readInfoLines() {
        try {
            for (int i = 0; i < lines;) {
                line = buffer.readLine();
                ab = new ArrayList<Integer>();
                recurser(line, ab);
                aMinValue = ab.get(0);
                aMovingValue = aMinValue;
                bMaxValue = ab.get(1);
                bStr = bMaxValue + "";
                keys = new ArrayList<Integer>();
                values = new ArrayList<Integer>();
                if (bStr.length() > 1 && aMinValue < bMaxValue) {
                    for (; aMovingValue <= bMaxValue; aMovingValue++) {
                        aStr = aMovingValue + "";
                        if (aStr.length() > 1) {
                            for (int j = 1; j < aStr.length(); j++) {
                                nMinValue = aMovingValue;
                                mMaxValue = Integer.parseInt(aStr.substring(j, aStr.length()) + aStr.substring(0, j));
                                if (mMaxValue > bMaxValue || mMaxValue < aMinValue) {
                                    continue;
                                }
                                if (nMinValue < mMaxValue) {
                                    searchIndex = Collections.binarySearch(keys, nMinValue);
                                    if (searchIndex >= 0 && values.get(searchIndex) == mMaxValue) {
                                    } else {
                                        keys.add(nMinValue);
                                        values.add(mMaxValue);
                                    }
                                }
                            }
                        }
                    }
                }
                printer.write("Case #" + ++i + ": " + keys.size());
                printer.newLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void recurser(String s, ArrayList<Integer> links) {
        int i = 0, k = 0;
        if (s != null) {
            if ((i = s.indexOf(" ")) >= 0) {
                if (links.size() == 0) {
                    links.add(Integer.valueOf("" + s.substring(0, i)));
                }
                if ((k = s.indexOf(" ", ++i)) >= 0) {
                    links.add(Integer.valueOf("" + s.substring(i, k)));
                    s = s.substring(k);
                    recurser(s, links);
                } else {
                    links.add(Integer.valueOf(s.substring(i, s.length())));
                }
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long t = System.currentTimeMillis();
        GoogleJam3 obj = new GoogleJam3();
        obj.readInfo();
        obj.readInfoLines();
//        obj.printTestCases();
        obj.endOperations();
        t = System.currentTimeMillis() - t;
        System.out.println("Time elapsed  " + t);
    }
}
