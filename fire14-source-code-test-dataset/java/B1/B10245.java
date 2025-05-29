/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recyclednumbers;

import java.util.HashSet;

/**
 *
 * @author vandit
 */
public class RecycleNumbers {

    private HashSet<String> numbers = new HashSet<String>();
    private HashSet<String> initialTempNumbers = new HashSet<String>();
    private HashSet<String> finalTempNumbers = new HashSet<String>();

    HashSet<Pair> numberPairs = new HashSet<Pair>();


    private void findRecycledNumbers(int start, int end, int places) {


        for (int i = start; i <= end; i++) {
            String initialNumber = Integer.toString(i);
            //if (!(numbers.contains(initialNumber) || finalTempNumbers.contains(initialNumber))) {

                StringBuffer tempNumber = new StringBuffer(initialNumber);
                int len = tempNumber.length();
                int startIndexToMove = len - places;
                String tempString = tempNumber.substring(startIndexToMove);
                if ((places == 1 && tempString.equals("0")) || tempString.charAt(0) == '0') {
                    continue;
                }
                tempNumber.delete(startIndexToMove, len);
                String finalTempNumber = tempString + tempNumber.toString();

                if (! (finalTempNumber.equals(initialNumber) || Integer.parseInt(finalTempNumber) > end || Integer.parseInt(finalTempNumber) < Integer.parseInt(initialNumber))) {
                    numbers.add(initialNumber);
                    finalTempNumbers.add(finalTempNumber);
                    Pair pair = new Pair(finalTempNumber,initialNumber);
                    numberPairs.add(pair);
                }
            }

        

    }

    public HashSet<Pair> findAllRecycledNumbers(int start, int end) {
        int length = Integer.toString(start).length();
        for (int i = 1; i < length; i++) {
            findRecycledNumbers(start, end, i);
        }
        return numberPairs;
    }
}
