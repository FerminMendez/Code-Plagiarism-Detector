/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dancing.gogglers;

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
import java.util.List;
import java.util.Map;
import java.util.Set;
import speaking.tongues.WordMap;

/**
 *
 * @author Raveesh
 */
public class Googlers {

    private static int inputSurpriseCount = 0;
    private static int inputPointLimit = 0;
    private static int inputGooglerCount = 0;
    private static int surpriseCount = 0;
    private static int outputCount = 0;
    private static HashMap playerMap = new HashMap();

    private static void printMap() {

        Iterator iter = playerMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry e = (Map.Entry) iter.next();
            Integer player = (Integer) e.getKey();
            List comboList = (ArrayList) e.getValue();
            Iterator listIter = comboList.iterator();
            System.out.println("Player combo :: " + player);
            while (listIter.hasNext()) {
                StringBuffer str = (StringBuffer) listIter.next();
                System.out.println("Str : " + str.toString());
            }
        }
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

    public static void main(String[] args) throws FileNotFoundException, IOException {

        String filePath = "C:\\Users\\Raveesh\\Downloads\\B-small-attempt0.in";
        String filePathOutput = filePath + "_out";
        BufferedReader stdin = new BufferedReader(new FileReader(new File(filePath)));
        FileWriter fileWriter = new FileWriter(filePathOutput);
        ArrayList stringList = Googlers.getInputList(stdin);

        inputSurpriseCount = 1;
        inputPointLimit = 1;
        int count = 1;
        Iterator iter = stringList.iterator();
        while (iter.hasNext()) {

            String inputStr = (String) iter.next();
            System.out.println("Str :: " + inputStr);
            String[] inputStrArr = inputStr.split("\\ ");
            inputGooglerCount = Integer.valueOf(inputStrArr[0]);
            inputSurpriseCount = Integer.valueOf(inputStrArr[1]);
            inputPointLimit = Integer.valueOf(inputStrArr[2]);
            surpriseCount = 0;
            outputCount = 0;
            playerMap = new HashMap();
            System.out.println("c : " + inputGooglerCount + "c : " + inputSurpriseCount
                    + "c : " + inputPointLimit);
            for (int i = 0; i < inputGooglerCount; i++) {
                System.out.println("Doing for :: " + (inputStrArr[i + 3]));
                List comboListA = Googlers.getCombibations(Integer.valueOf(inputStrArr[i + 3]));
                playerMap.put(i, comboListA);
            }

            Googlers.printMap();

            /** String[] atrArr = new String[inputGooglerCount];
            for (int i = 0;i < inputGooglerCount ; i++) {
            atrArr[i] = "0";
            }
            
            String a= Integer.toBinaryString(000000);
            String b= Integer.toBinaryString(000001);
            System.out.println("Sum " + Integer.toBinaryString(10+ 1));
            int counter = inputGooglerCount-1;
            for (int i = 0;i < atrArr.length ; i++) {
            String index = atrArr[i];
            String str = new String();
            for (int j = 0;j < inputGooglerCount ; j++) {
            StringBuffer sb = (StringBuffer)
            ((ArrayList)playerMap.get(j)).get(Integer.parseInt(atrArr[j]));
            str = str + sb.toString();
            if (j == counter) {
            atrArr[counter] = "1";
            counter--;
            }
            }
            System.out.println("Str :: " + str);
            }
            
             **/
            
            int maxCount = 0;
            List li1 = (ArrayList) playerMap.get(0);
            for (int i = 0; i < li1.size(); i++) {
                StringBuffer str = (StringBuffer) li1.get(i);
                String newStr = new String();
                List li2 = (ArrayList) playerMap.get(1);
                if (inputGooglerCount > 1) {
                for (int k = 0; k < li2.size(); k++) {
                    StringBuffer str1 = (StringBuffer) li2.get(k);
                    if (inputGooglerCount > 2) {
                        List li3 = (ArrayList) playerMap.get(2);
                        for (int m = 0; m < li3.size(); m++) {
                            StringBuffer str2 = (StringBuffer) li3.get(m);
                            newStr = str.toString() + "," +str1 + "," + str2;
                            String[] arr = newStr.split(",");
                            System.out.println(":: " + newStr);
                            int sur = 0;
                            int out = 0;
                            for ( int p = 0 ; p < arr.length ;p=p+4) {
                                int a = Integer.parseInt(arr[p]);
                                int b = Integer.parseInt(arr[p+1]);
                                int c = Integer.parseInt(arr[p+2]);      
                                
                                if (arr[p+3].equalsIgnoreCase("Y")) {
                                    sur++;
                                }
                                if (Googlers.checkLimit(a, b, c)) {
                                    out++;
                                }
                            }
                            if(sur == inputSurpriseCount && maxCount < out) {
                                maxCount = out;
                            }
                        }
                    } else {
                        newStr = str.toString() + "," + str1;
                        String[] arr = newStr.split(",");
                            System.out.println(":: " + newStr);
                            int sur = 0;
                            int out = 0;
                            for ( int p = 0 ; p < arr.length ;p=p+4) {
                                int a = Integer.parseInt(arr[p]);
                                int b = Integer.parseInt(arr[p+1]);
                                int c = Integer.parseInt(arr[p+2]);      
                                
                                if (arr[p+3].equalsIgnoreCase("Y")) {
                                    sur++;
                                }
                                if (Googlers.checkLimit(a, b, c)) {
                                    out++;
                                }
                            }
                            if(sur == inputSurpriseCount && maxCount < out) {
                                maxCount = out;
                            }
                        System.out.println(":: " + newStr);
                    }
                }
                }
                else {
                           newStr = str.toString();
                        String[] arr = newStr.split(",");
                            System.out.println(":: " + newStr);
                            int sur = 0;
                            int out = 0;
                            for ( int p = 0 ; p < arr.length ;p=p+4) {
                                int a = Integer.parseInt(arr[p]);
                                int b = Integer.parseInt(arr[p+1]);
                                int c = Integer.parseInt(arr[p+2]);      
                                
                                if (arr[p+3].equalsIgnoreCase("Y")) {
                                    sur++;
                                }
                                if (Googlers.checkLimit(a, b, c)) {
                                    out++;
                                }
                            }
                            if(sur == inputSurpriseCount && maxCount < out) {
                                maxCount = out;
                            }
                        System.out.println(":: " + newStr);
                }

            }
            
            outputCount = maxCount;

            /*while (iter2.hasNext()) {
            Map.Entry e2 = (Map.Entry)iter2.next();
            Iterator iter3 = ((ArrayList)e2.getValue()).iterator();
            boolean found = false;
            boolean mul = false;
            int remove = 0;
            while (iter3.hasNext()) {
            
            StringBuffer str = (StringBuffer)iter3.next();
            String[] strArr = str.toString().split(",");
            if(Googlers.checkLimit(Integer.valueOf(strArr[0]), Integer.valueOf(strArr[1])
            , Integer.valueOf(strArr[2]))) {
            if (mul) {
            remove ++;
            }
            mul = true;
            outputCount++;
            if (strArr[3].equalsIgnoreCase("Y") && !found) {
            surpriseCount++;
            found = true;
            }
            else if (strArr[3].equalsIgnoreCase("Y") && found) {
            outputCount--;
            }
            }
            outputCount = outputCount - remove;
            }
            
            } 
            
            
            
            
            
            /**HashMap toBeComparedMap = (HashMap) playerMap.clone();
            Set toBeCamparedSet = toBeComparedMap.keySet();
            while (iter1.hasNext()) {
            Map.Entry e = (Map.Entry) iter1.next();
            Integer player = (Integer) e.getKey();
            toBeCamparedSet.remove(player);
            List comboList = (ArrayList) e.getValue();
            Iterator listIter = comboList.iterator();
            while (listIter.hasNext()) {
            StringBuffer str = (StringBuffer) listIter.next();
            Iterator comparedIter = toBeCamparedSet.iterator();
            while(comparedIter.hasNext()) {
            Integer comparedPlayer = (Integer)comparedIter.next();
            List comStr = (List)toBeComparedMap.get(comparedPlayer);
            Iterator comStrListIter = comStr.iterator();
            while(comStrListIter.hasNext()) {
            str.append(":");
            str.append((StringBuffer)comStrListIter.next());
            comStrListIter.remove();
            continue;
            }
            System.out.println("str ::" + str.toString());
            }
            
            }
            }
             **/
            String out = "Case #" + count + ": " + outputCount;
            fileWriter.write(out);
            fileWriter.write("\n");
            count++;
        }
        fileWriter.close();

//        Googlers.printMap();

        System.out.println("outputCount : " + outputCount);

    }

    private static boolean checkLimit(int a, int b, int c) {
        if (a >= inputPointLimit || b >= inputPointLimit || c >= inputPointLimit) {
//            outputCount++;
            return true;
        }
        return false;
    }

    private static List getCombibations(int num) {
        int n = num / 3;
        int a;
        int b;
        int c;
        int offset = 0;
        List listStr = new ArrayList();
        StringBuffer str = null;
        if (num % 3 == 0) {
            offset = 0;
            str = new StringBuffer();
            a = b = c = n;
            if (a >= 0 && b >= 0 && c >= 0) {
                str.append(a).append(",").append(b).append(",").append(c).append(",").append(Googlers.checkSurprise(a, b, c) ? "Y" : "N");
                listStr.add(str);

            }



            a = n + 1;
            b = n;
            c = n - 1;
            str = new StringBuffer();
            if (a >= 0 && b >= 0 && c >= 0) {

                str.append(a).append(",").append(b).append(",").append(c).append(",").append(Googlers.checkSurprise(a, b, c) ? "Y" : "N");
                listStr.add(str);

            }
        } else if (num % 3 == 1) {
            offset = 1;
            a = n;
            b = n;
            c = n + 1;
            str = new StringBuffer();
            if (a >= 0 && b >= 0 && c >= 0) {
                str.append(a).append(",").append(b).append(",").append(c).append(",").append(Googlers.checkSurprise(a, b, c) ? "Y" : "N");
                listStr.add(str);

            }

            a = n - 1;
            b = n + 1;
            c = n + 1;
            str = new StringBuffer();
            if (a >= 0 && b >= 0 && c >= 0) {
                str.append(a).append(",").append(b).append(",").append(c).append(",").append(Googlers.checkSurprise(a, b, c) ? "Y" : "N");
                listStr.add(str);
            }
        } else if (num % 3 == 2) {
            offset = 2;
            a = n;
            b = n + 1;
            c = n + 1;
            str = new StringBuffer();
            if (a >= 0 && b >= 0 && c >= 0) {

                str.append(a).append(",").append(b).append(",").append(c).append(",").append(Googlers.checkSurprise(a, b, c) ? "Y" : "N");
                listStr.add(str);

            }
            a = n;
            b = n;
            c = n + 2;
            str = new StringBuffer();
            if (a >= 0 && b >= 0 && c >= 0) {

                str.append(a).append(",").append(b).append(",").append(c).append(",").append(Googlers.checkSurprise(a, b, c) ? "Y" : "N");
                listStr.add(str);

            }
        }

        return listStr;
    }

    private static boolean checkSurprise(int a, int b, int c) {
        boolean flag = false;
        if ((a - b) >= 2 || (b - a) >= 2) {
            flag = true;
        } else if ((b - c) >= 2 || (c - b) >= 2) {
            flag = true;
        } else if ((c - a) >= 2 || (a - c) >= 2) {
            flag = true;
        }
        return flag;
    }
}
