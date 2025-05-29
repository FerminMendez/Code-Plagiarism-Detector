package org.ryan.jam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * user: ryan.moore
 * date: 4/14/12
 */
public class CodeJamUtil {

    public static List<String> parseInputToList(String inputString) {

        String numLines = inputString.substring(0, inputString.indexOf("\n"));

        String remainingString = inputString.substring(inputString.indexOf("\n")+1);

        List<String> linesList = new ArrayList<String>();

        for (int i = 0; i < Integer.valueOf(numLines); i++) {
            if (i < Integer.valueOf(numLines) -1) {
                linesList.add(remainingString.substring(0, remainingString.indexOf("\n") + 1).trim());
                remainingString = remainingString.substring(remainingString.indexOf("\n")+1);
            } else {
                linesList.add(remainingString);
            }
        }

        return linesList;
    }

    public static List<Integer> getDistinctRecycledPairs(List<String> linesList) {

        //each iteration is a testcase
        List<Integer> resultMatchesList = new ArrayList<Integer>();
        for (String line : linesList) {

            Integer numberA = Integer.valueOf(line.substring(0, line.indexOf(" ")));
            Integer numberB = Integer.valueOf(line.substring(line.indexOf(" ") + 1).trim());

            Integer numberMatches = 0;

            for(int i=numberA; i<numberB - 1; i++) {

                for(int j=numberA + 1; j<=numberB; j++) {

                    //ok now we're iterating correctly, lets call a method to get permutations + check matches
                    Integer result = permuteAndCompare(i,j);
                    numberMatches = numberMatches + result;
                }

                numberA++;
            }
            resultMatchesList.add(numberMatches);
        }

        return resultMatchesList;
    }

    public static String readFileAsString(String filePath) throws java.io.IOException {

        StringBuffer fileData = new StringBuffer(1000);
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        char[] buf = new char[1024];
        int numRead=0;
        while((numRead=reader.read(buf)) != -1){

            fileData.append(buf, 0, numRead);
        }
        reader.close();
        return fileData.toString();
    }

    private static Integer permuteAndCompare(Integer numberA, Integer numberB) {

        int numberMatches = 0;

        List<Integer> validPermutes = getValidRecycledPermutations(numberB);

        for (Integer current : validPermutes) {
            if(current.equals(numberA)) {
                numberMatches++;

                System.out.println("Found match = "+ numberA + " and " + current);
            }
        }

        return numberMatches;
    }

    private static List<Integer> getValidRecycledPermutations(Integer number) {

        String numberString = Integer.toString(number);

        Integer numDigits = numberString.length();

        List<Integer> resultList= new ArrayList<Integer>();
        for (int i =numDigits-1; i>0; i-- ) {

            char ch4r = numberString.charAt(i);
            if (!(ch4r == '0')) {

                String concatStringResult = numberString.substring(i, numDigits) + numberString.substring(0, i);
                Integer result = Integer.valueOf(concatStringResult.trim());
                resultList.add(result);
            } //else dont do anything

        }

        return resultList;
    }
}
