package ch.googlecodejam.qualround;

import java.util.ArrayList;
import java.util.List;

public class RecycledNumbers {

    public static String solve(List<List<String>> values) {

        StringBuilder result = new StringBuilder();

        int numberOfLine = 1;
        for (List<String> line : values) {
            int minValue = Integer.parseInt(line.get(0));
            int maxValue = Integer.parseInt(line.get(1));

            int numberOfRecycledNumbers = getNumberOfRecycledNumbers(minValue,
                    maxValue);

            result.append("Case #" + numberOfLine + ": "
                    + numberOfRecycledNumbers + "\n");
            numberOfLine++;
        }

        return result.toString();
    }

    private static int getNumberOfRecycledNumbers(int minValue, int maxValue) {

        int numberOfRececlyedNumbers = 0;
        for (int numberToTest = minValue; numberToTest < maxValue; numberToTest++) {
            numberOfRececlyedNumbers += hasRecycledNumber(numberToTest,
                    maxValue);
        }
        return numberOfRececlyedNumbers;
    }

    private static int hasRecycledNumber(int number, int maxValue) {

        String originalNumber = String.valueOf(number);
        int numberOfRecycledNumber = 0;
        List<String> alreadyRecycled = new ArrayList<String>();

        for (int i = originalNumber.length() - 1; i > 0; i--) {
            String recycledNumber = getSwapedNumber(i, originalNumber);

            if (recycledNumber.charAt(0) != '0') {
                int valueRecycledNumber = Integer.parseInt(recycledNumber);
                if (valueRecycledNumber > number
                        && valueRecycledNumber <= maxValue && !alreadyRecycled.contains(recycledNumber)) {
                    numberOfRecycledNumber++;
                    alreadyRecycled.add(recycledNumber);
                } 
            }

        }

        return numberOfRecycledNumber;
    }

    public static String getSwapedNumber(int startIndex, String original) {

        StringBuilder swaped = new StringBuilder();
        swaped.append(original.substring(startIndex));
        swaped.append(original.substring(0, startIndex));
        return swaped.toString();
    }
}
