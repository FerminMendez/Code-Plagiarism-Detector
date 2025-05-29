package code_jam_quali;

import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author sansarun
 */
public class Recycled {

    public static void main(String[] args) {        
        Scanner sc = new Scanner(System.in);
        int caseNumber = sc.nextInt();

        for(int currentCase=1; currentCase<=caseNumber; currentCase++) {
            HashSet<NumberPair> recycledPairSet = new HashSet<NumberPair>();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int digit = (""+a).length();

            for(int n=a; n<b; n++) {
                StringBuilder nString = new StringBuilder(""+n);

                for(int j=0; j<digit; j++) {
                    rotate(nString);
                    int m = Integer.valueOf(nString.toString());
                    
                    if(m > n && m <= b) {
                        recycledPairSet.add(new NumberPair(n, m));
                    }
                }
            }           

            System.out.println(String.format("Case #%d: %d", currentCase, recycledPairSet.size()));
        }    

    }

    private static StringBuilder rotate(StringBuilder s) {
        if(s.length() == 0)
            return s;

        s.insert(0, s.charAt(s.length() - 1));
        s.deleteCharAt(s.length() - 1);
        return s;
    }
}

class NumberPair {

    private int a;
    private int b;

    public NumberPair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof NumberPair)) {
            return false;
        }

        NumberPair n = (NumberPair) obj;
        if (n.a == a && n.b == b) {
            return true;
        } else if (n.a == b && n.b == a) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return a+b;
    }
}
