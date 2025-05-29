/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package googlejam2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Nomeir
 */
public class GoogleJam2 {

    private String inputFile = "B-small-attempt0.in";
            //              ".\\A-small-attempt0.in";
            //            ".\\A-small-practice.in";
            ////    ".\\A-large-practice.in";
//            ".\\test2.in";
    private String outputFile = ".\\out.txt";
    private String line = "start";
    private FileReader reader;
    private BufferedReader buffer;
    private FileWriter writer;
    private BufferedWriter printer;

    public GoogleJam2() {
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
    int googlersSize, surprisings, leastBest;
    int totalPossibi, expectedSurp, totalWithoutSurp, leastSurp;
    int S;
    ArrayList<Integer> googlers;

    private void readInfoLines() {
        try {
            for (int i = 0; i < lines;) {
                line = buffer.readLine();
                googlers = new ArrayList<Integer>();
                recurser(line, googlers);
                googlersSize = googlers.get(0);
                surprisings = googlers.get(1);
                leastBest = googlers.get(2);
                totalPossibi = 0;
                expectedSurp = 0;
                totalWithoutSurp = 0;
                S = 0;
                if (googlersSize > 0) {
                    leastSurp = (3 * leastBest) - 4;
                    for (int g = 3; g < googlers.size(); g++) {
                        if (leastSurp > 0) {
                            if (googlers.get(g) >= leastSurp) {
                                totalPossibi++;
                            }
                            if (googlers.get(g) >= leastSurp + 2) {
                                totalWithoutSurp++;
                            }
                            if (googlers.get(g) == leastSurp || googlers.get(g) == leastSurp + 1) {
                                expectedSurp++;
                            }
                        } else {
                            if (googlers.get(g) >= leastBest) {
                                totalPossibi++;
                            }
                        }
                    }
                }
                if (expectedSurp > surprisings) {
                    S = totalWithoutSurp + surprisings;
                } else {
                    S = totalPossibi;
                }
                printer.write("Case #" + ++i + ": " + S);
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

//    public void printTestCases() {
//        try {
//            printer.write("Case #" + " " + ": " + " ");
//            printer.newLine();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long t = System.currentTimeMillis();
        GoogleJam2 obj = new GoogleJam2();
        obj.readInfo();
        obj.readInfoLines();
//        obj.printTestCases();
        obj.endOperations();
        t = System.currentTimeMillis() - t;
        System.out.println("Time elapsed  " + t);
    }
}
