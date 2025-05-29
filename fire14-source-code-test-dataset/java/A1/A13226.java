package ru.bobukh.problems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author anton.bobukh
 */
public class ProblemB_DancingWithTheGooglers {
    
    public static void main(String[] args) throws IOException {
        Map<Character, Character> mapping = ProblemA_SpeakingInTongues.GetMapping();
        
        try (Scanner input = new Scanner(new BufferedReader(new FileReader("C:\\Users\\maggot\\Desktop\\B-small-attempt0.in")))) {
            int T = input.nextInt();
            input.nextLine();
            
            try(PrintWriter output = new PrintWriter("C:\\Users\\maggot\\Desktop\\output.txt")) {
                for(int k = 0; k < T; ++k) {
                    output.println(String.format("Case #%d: %d", k + 1, processLine(input.nextLine())));
                }
            }
        }
    }
    
    public static int processLine(final String line) {
        int counter = 0;
        try (Scanner lineReader = new Scanner(line)) {
            lineReader.useDelimiter(" ");
            int N = lineReader.nextInt();
            int S = lineReader.nextInt();
            int P = lineReader.nextInt();

            for (int i = 0; i < N; ++i) {
                int value = lineReader.nextInt();

                if(value >= P && value - P >= 2 * (P - 1)) {
                    ++counter;
                } else if(value >= P && value - P >= 2 * (P - 2) && S > 0) {
                    ++counter;
                    --S;
                }
            }
        }
        
        return counter;
    }
    
}
