package googlecodejam;

import java.util.LinkedList;

/**
 *
 * @author Matej
 */
public class ProblemC {

    int lower;
    int upper;

    public ProblemC(int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
    }

    public int solve() {
        int result = 0;
        String number, newNumber;
        int nn;
        LinkedList<String> numbers=new LinkedList<>();
        
        for (int i = lower; i <= upper; i++) {
            number = Integer.toString(i);
            numbers.clear();
            for (int j = 1; j < number.length(); j++) {
                newNumber = (String) number.subSequence(j, number.length());
                newNumber += (String) number.subSequence(0, j);                
                if (!newNumber.startsWith("0") && !newNumber.equals(number) && !numbers.contains(newNumber)) {
                    nn = Integer.parseInt(newNumber);
                    numbers.add(newNumber);
                    if (nn >= lower && nn <= upper && nn>i) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
