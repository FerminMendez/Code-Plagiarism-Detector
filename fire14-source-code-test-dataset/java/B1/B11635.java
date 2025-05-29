/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 3mara
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    static int testCases = 0;
    static int a = 0, b = 0;
    static int numDigits;
    static HashMap<Integer, HashMap<Integer, Integer>> table = new HashMap<Integer, HashMap<Integer, Integer>>();

    public static void read() {
        try {
            int index = 1;
            BufferedReader br = new BufferedReader(new FileReader("C-small-attempt0.in"));
            int result = 0;
            testCases = Integer.parseInt(br.readLine());
            while (index <= testCases) {
                String array = (br.readLine());
                a = Integer.parseInt((array.split(" "))[0]);
                b = Integer.parseInt((array.split(" "))[1]);
                numDigits = (array.split(" ")[0]).length();
                if (a == (b) || a < 9) {
                    System.out.println("Case #" + index + ": 0");
                } else {
                    result = 0;
                    table.clear();
                    String temp = "";
                    for (int i = a; i <= b; i++) {
                        for (int j = numDigits - 1; j >= 1; j--) {
                            temp = i + "";
                            int tempint = Integer.parseInt(temp.substring(j) + temp.substring(0, j));
                            if ((tempint <= b) && tempint > i) {
                                if (table.get(i) != null && !table.get(i).containsKey(tempint)) {
//                                System.out.println(temp + "====" + temp.substring(j) + temp.substring(0, j));
                                    result++;
                                } else if (table.get(i) == null) {
                                    table.put(i, new HashMap<Integer, Integer>());
                                    table.get(i).put(tempint, 1);
                                    result++;
                                }
                            }
                        }
                    }
                    System.out.println("Case #" + index + ": " + result);
                }


                index++;
            }
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
//        try {
//            BufferedReader br = new BufferedReader(new FileReader("a.txt"));
//            String[] array = new String[288];
//            String line = "";
//            int i = 0;
//            while ((line = br.readLine()) != null) {
//                array[i] = line;
//                i++;
//            }
//            Arrays.sort(array);
//            for (int j = 0; j < 288; j++) {
//                System.out.println(array[j]);
//            }
//            //        System.out.println();
//            //        System.out.println();
        read();
//            //        System.out.println();
//        } catch (IOException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}
