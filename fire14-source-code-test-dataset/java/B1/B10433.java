package codejam2012;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

/**
 *
 * @author devashish
 */
public class ProblemC {

    private static Set<PairedNumber> pairedNumbers = new HashSet<PairedNumber>();
    private static Map<PairedNumber, Integer> pairedNumbersMap = new HashMap<PairedNumber, Integer>();

    public static void main(String[] args) {
        StringTokenizer st = null;
        BufferedReader in;
        PrintWriter out = null;

        try {
            in = new BufferedReader(new FileReader(new File("E:/c.in")));
            out = new PrintWriter(new FileWriter(new File("E:/c.out")));

            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(in.readLine());
            }

            int t = Integer.parseInt(st.nextToken());

            for (int i = 1; i <= t; i++) {
                while (st == null || !st.hasMoreTokens()) {
                    st = new StringTokenizer(in.readLine());
                }

                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                int outputLine = new ProblemC().getNumberOfRecycledPairs(A, B);

                out.print("Case #" + i + ": " + outputLine + "\n");
            }
        } catch (IOException e) {
        }
        out.flush();
    }

    private int getNumberOfRecycledPairs(int A, int B) {
        pairedNumbers = new HashSet<PairedNumber>();
        pairedNumbersMap = new HashMap<PairedNumber, Integer>();

        String strB = B + "";
        //System.out.println("Count from " + A + " to " + B);

        if (strB.length() == 1) {
            return 0;
        }

        for (int i = A; i <= B; i++) {
            if (isPalindrome(i)) {
                continue;
            }
            if (isSameDigits(i)) {
                continue;
            }

            PairedNumber pairedNumber = new PairedNumber(i);
            boolean added = pairedNumbers.add(pairedNumber);
            //System.out.println("i = " + i + ", added: " + added);
            if (!added) {
                int occurence = 2;
                if (pairedNumbersMap.containsKey(pairedNumber)) {
                    occurence = pairedNumbersMap.get(pairedNumber) + 1;
                }
                pairedNumbersMap.put(pairedNumber, occurence);
            }
        }

        int finalCount = 0;
        Iterator it = pairedNumbersMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry) it.next();
            //    System.out.println(pairs.getKey() + " = " + pairs.getValue());
            it.remove();
            int val = (Integer) pairs.getValue();
            finalCount += (val * (val - 1)) / 2;
        }

        return finalCount;
    }

    private boolean isPalindrome(int number) {
        int reversedNumber = 0;
        while (number > 0) {
            int temp = number % 10;
            number = number / 10;
            reversedNumber = reversedNumber * 10 + temp;
        }

        if (number == reversedNumber) {
            return true;
        }

        return false;
    }

    private boolean isSameDigits(int num) {
        String str = num + "";
        char ch = str.charAt(0);
        String check = "";
        for (int i = 0; i < str.length(); i++) {
            check += ch;
        }
        if (str.equals(check)) {
            return true;
        }

        return false;
    }

    public Set<Integer> getPermutations(Integer num, int A, int B) {
        Set<Integer> perms = new HashSet<Integer>();
        int length = (num == 0) ? 1 : (int) Math.log10(num) + 1;
        String numString = num + "";
        for (int i = 1; i < length; i++) {
            String str = numString.substring(i) + numString.substring(0, i);
            //System.out.println(str);
            perms.add(Integer.parseInt(str));
        }
        //perms.add(num);

        return perms;
    }

    class PairedNumber {

        private String pairedNumber = "";

        public PairedNumber(int number) {
            this.pairedNumber = number + "";
        }

        public Set<Integer> getPermutations(Integer num) {
            Set<Integer> perms = new HashSet<Integer>();
            int length = (num == 0) ? 1 : (int) Math.log10(num) + 1;
            String numString = num + "";
            for (int i = 1; i < length; i++) {
                String str = numString.substring(i) + numString.substring(0, i);
                perms.add(Integer.parseInt(str));
            }

            return perms;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final PairedNumber other = (PairedNumber) obj;

            Set<Integer> perms = getPermutations(Integer.parseInt(this.pairedNumber));
            if (perms.contains(Integer.parseInt(other.pairedNumber))) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 13 * hash + (this.pairedNumber != null ? this.pairedNumber.length() : 0);
            return hash;
        }

        @Override
        public String toString() {
            return "PairedNumber{" + "pairedNumber=" + pairedNumber + '}';
        }
    }
}
