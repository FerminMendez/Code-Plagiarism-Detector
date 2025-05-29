import java.util.*;

public class RecycledNumbers {
    private final int A;
    private final int B;
    private final boolean[] allNumbers;

    public RecycledNumbers(int A, int B) {
        this.A = A;
        this.B = B;
        //numbers are A + i, where i is the array index
        allNumbers = new boolean[B - A + 1];
    }

    public int getDistinctPairsCount() {
        int distinctPairs = 0;
        for (int i = 0; i < allNumbers.length; i++) {
            if (!allNumbers[i]) {
                int number = indexToNumber(i);
                Set<String> recyclings = (number > 9) ? getRecyclings(number) : Collections.<String>emptySet();
                if (!recyclings.isEmpty()) ignore(recyclings);
                int numberOfDistinctPairs = recyclings.isEmpty() ? 0 : getNumberOfDistinctPairs(recyclings);
                distinctPairs += numberOfDistinctPairs;
            }
        }
        return distinctPairs;
    }

    private int getNumberOfDistinctPairs(Set<String> recyclings) {
        int recyclingsThatCount = 0;
        for (String s : recyclings) {
            int number = Integer.parseInt(s);
            if (withinBounds(number) && doesntStartWithZero(s))
                recyclingsThatCount++;
        }

        int pairs = recyclingsThatCount * (recyclingsThatCount - 1) / 2;
        return pairs;
    }

    private boolean doesntStartWithZero(String s) {
        boolean result = s.charAt(0) != '0';
        return result;
    }

    private boolean withinBounds(int number) {
        boolean result = number >= A && number <= B;
        return result;
    }

    private void ignore(Set<String> recyclings) {
        //set them to true in the array
        for (String s : recyclings) {
            int number = Integer.parseInt(s);
            if (withinBounds(number))
                allNumbers[numberToIndex(number)] = true;
        }
    }

    private int numberToIndex(int number) {
        return number - A;
    }

    private int indexToNumber(int i) {
        return i + A;
    }

    private Set<String> getRecyclings(int number) {
        String numberAsString = Integer.toString(number);
        int totalDigits = numberAsString.length();
        Set recyclings = new HashSet<String>();
        for (int i = totalDigits - 1; i >= 0; i--) {
            recyclings.add(numberAsString.substring(i, totalDigits) + numberAsString.substring(0, i));
        }
        return recyclings;
    }


}
