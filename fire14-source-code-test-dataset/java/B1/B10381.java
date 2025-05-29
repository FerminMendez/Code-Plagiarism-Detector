/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recycle.number;

import dancing.gogglers.Googlers;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author Raveesh
 */
public class Recycler {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String filePath = "C:\\Users\\Raveesh\\Downloads\\C-small-attempt0.in";
        String filePathOutput = filePath + "_out";
        BufferedReader stdin = new BufferedReader(new FileReader(new File(filePath)));
        FileWriter fileWriter = new FileWriter(filePathOutput);
        ArrayList stringList = Recycler.getInputList(stdin);
        int count = 1;
        Iterator iter = stringList.iterator();
        while (iter.hasNext()) {
            String inputStr = (String) iter.next();
            String[] inputStrArr = inputStr.split("\\ ");
            int startNum  = Integer.valueOf(inputStrArr[0]);
            int endNum  = Integer.valueOf(inputStrArr[1]);
            int output = Recycler.performPerm(startNum,endNum);
            String out = "Case #" + count + ": " + output;
            fileWriter.write(out);
            fileWriter.write("\n");
            count++;
        }       
        fileWriter.close();

    }
    
    private static int performPerm(int start,int end ) {
        finalSet = new ArrayList();
        for (int i=start;i<=end;i++) {
//            System.out.println("Running" + i);
            StringBuffer val = new StringBuffer(String.valueOf(i));
//            System.out.println("Running" + val);
            checkVal(start, end, val);
        }
        
//        Iterator iter = finalSet.iterator();
//        while (iter.hasNext()) {
//            System.out.println("Val " + iter.ne);
//        } 
//        System.out.println("=========================COUNT " + finalSet.size()/2);
        return finalSet.size()/2;
        
        
    }
    
    private static ArrayList finalSet = new ArrayList();
    private static boolean checkVal (int start,int end, StringBuffer val) {
        
        
        for (int i =0;i< val.length() ; i++) {
            String temp = val.substring(0,i+1);
            String rem = val.substring(i+1,val.length());
            String val1 = rem + temp;
//            System.out.println("temp" + temp + " rem : " + rem);
//            for (int j = 0;j <= rem.length() ; j++) {
//                StringBuffer val1 = new StringBuffer(rem);
                
                
//                if (j==i) {
//                    continue;
//                    
//                }
//                val1.insert(j, temp);
//                System.out.println("iNPUT :; " + val + " :: Output : " + val1);
//                System.out.println("iNPUT :; " + val + " :: Output : " + val1);
                int t = Integer.valueOf(val1.toString());
                if (t >= start && t <= end && !val.toString().equals(val1.toString())) {
//                    System.out.println("iNPUT :; " + val + " :: Output : " + val1 + " t :: " + t );
                     finalSet.add(t);
////                    System.out.println("dding :: " + t);
//                    String key = val.toString() + ","  + val1.toString();
//                    String key1 = val1.toString() + "," + val.toString();
//                    if(!(finalSet.containsKey(key)|| finalSet.containsKey(key1))) {
                        
//                        finalSet.put(key, t);
//                    }
////                    finalSet.put(Integer.valueOf(val1.toString()));
//                }
//                System.out.println("num :: " + val1);
            }
        }
        return true;
    }
    
    
    private static ArrayList getInputList(BufferedReader stdin) throws IOException {
        ArrayList stringList = new ArrayList<String>();
        String line;
        int inputLineCount = 0;
        Integer testCaseCount = 0;
        while ((line = stdin.readLine()) != null && line.length() != 0 && inputLineCount <= testCaseCount.intValue()) {
//            System.out.println("line ::  " + line);
            if (inputLineCount == 0) {
                try {
                    testCaseCount = Integer.valueOf(line);
                } catch (NumberFormatException pe) {
                    System.out.println("Invalid input for # of test cases");
                    System.exit(0);
                }
                inputLineCount++;
                continue;
            }
            stringList.add(line);
            inputLineCount++;

            if (inputLineCount == testCaseCount + 1) {
                break;
            }

        }
        return stringList;
    }
    
}
