package ru.bobukh.problems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author anton.bobukh
 */
public class ProblemC_RecycledNumbers {
    
    public static class Pair {
        public final int n;
        public final int m;
        
        public Pair(int n, int m) {
            this.n = n;
            this.m = m;       
        }
    }
    
    public static class PairComparator implements Comparator<Pair> {

        @Override
        public int compare(Pair o1, Pair o2) {
            if(o1.m - o2.m != 0)
                return o1.m - o2.m;
            else
                return o1.n - o2.n;
        }
        
    }
    
    public static void main(String[] args) throws IOException {
        
        try (Scanner input = new Scanner(new BufferedReader(new FileReader("C:\\Users\\maggot\\Desktop\\C-small-attempt0.in")))) {
            int T = input.nextInt();
            input.nextLine();
            
            try(PrintWriter output = new PrintWriter("C:\\Users\\maggot\\Desktop\\output.txt")) {
                for(int k = 0; k < T; ++k) {
                    Set<Pair> pairs = new TreeSet<>(new PairComparator());
                    int A = input.nextInt();
                    int B = input.nextInt();
                    
                    int numberOfDigits = 1;
                    int value = A;
                    while((value = value / 10) > 0)
                        ++numberOfDigits;
                    
                    for(int n = A; n <= B; ++n) {
                        for(int power = 0; power < numberOfDigits; ++power) {
                            int m = n % (int)Math.pow(10, power + 1) * (int)Math.pow(10, numberOfDigits - power - 1) + n / (int)Math.pow(10, power + 1);
                            if(n < m && m <= B)
                                pairs.add(new Pair(n, m));
                        }
                    }
                    
                    output.println(String.format("Case #%d: %d", k + 1, pairs.size()));
                }
            }
        }
    }
    
}
