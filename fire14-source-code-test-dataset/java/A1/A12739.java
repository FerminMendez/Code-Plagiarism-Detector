import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class Puzzle2 {

    
    public static int countGooglersByTarget(int target, int numberOfSurprising, List<Integer> googlerScores) {
        int count = 0;
        
        int totalTarget = 3*target;

        for (int i = 0; i < googlerScores.size(); i++) {
            int totalGooglerSum = googlerScores.get(i);
            if(totalGooglerSum >= totalTarget -2) {
                count ++;    
            } else if(totalGooglerSum >0 && totalGooglerSum +2 >= totalTarget -2 && numberOfSurprising >0) {
                count ++; 
                numberOfSurprising--;   
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
    
        String input = "100\n" +
                "3 1 5 15 13 11\n" +
                "3 0 8 23 22 21\n" +
                "1 0 1 18\n" +
                "3 0 5 3 16 11\n" +
                "2 2 6 15 28\n" +
                "1 0 7 30\n" +
                "2 1 3 24 1\n" +
                "2 1 7 10 21\n" +
                "1 0 10 30\n" +
                "1 0 7 18\n" +
                "1 0 3 6\n" +
                "2 2 2 6 5\n" +
                "3 3 8 26 22 19\n" +
                "1 0 3 6\n" +
                "3 0 2 4 23 24\n" +
                "1 0 10 17\n" +
                "2 2 9 10 24\n" +
                "3 0 0 0 0 0\n" +
                "1 0 1 7\n" +
                "2 1 9 18 30\n" +
                "2 2 0 22 23\n" +
                "3 1 3 6 5 29\n" +
                "2 0 3 16 2\n" +
                "1 0 8 17\n" +
                "1 1 7 5\n" +
                "2 0 7 18 30\n" +
                "3 0 10 3 4 18\n" +
                "3 3 9 2 7 7\n" +
                "1 0 3 6\n" +
                "2 0 6 15 14\n" +
                "3 2 9 17 26 22\n" +
                "2 0 7 5 11\n" +
                "2 1 3 5 5\n" +
                "3 0 8 30 24 1\n" +
                "1 0 0 17\n" +
                "2 1 9 18 24\n" +
                "3 0 8 27 16 17\n" +
                "1 0 2 3\n" +
                "3 0 7 18 24 19\n" +
                "3 0 7 5 15 17\n" +
                "3 0 8 16 12 4\n" +
                "1 0 8 28\n" +
                "1 1 10 12\n" +
                "2 2 4 18 23\n" +
                "2 0 3 25 6\n" +
                "2 1 4 11 2\n" +
                "3 2 5 12 11 11\n" +
                "3 3 7 21 22 14\n" +
                "3 2 1 12 16 0\n" +
                "3 0 0 30 30 30\n" +
                "2 0 3 8 30\n" +
                "1 1 1 21\n" +
                "3 0 4 21 24 2\n" +
                "3 3 3 27 23 8\n" +
                "1 0 8 7\n" +
                "1 0 7 17\n" +
                "3 1 3 24 12 28\n" +
                "3 0 1 14 26 11\n" +
                "3 0 9 8 23 1\n" +
                "2 0 8 12 20\n" +
                "2 2 8 8 25\n" +
                "1 0 5 6\n" +
                "1 0 8 20\n" +
                "1 0 5 12\n" +
                "2 1 0 17 25\n" +
                "3 1 4 1 30 5\n" +
                "2 1 7 17 17\n" +
                "1 0 7 11\n" +
                "3 0 1 5 23 10\n" +
                "2 0 10 27 15\n" +
                "1 0 8 1\n" +
                "3 0 8 30 28 30\n" +
                "2 1 9 4 9\n" +
                "3 3 6 6 10 9\n" +
                "2 2 3 9 13\n" +
                "1 0 2 1\n" +
                "2 0 4 8 9\n" +
                "1 1 10 17\n" +
                "1 0 3 5\n" +
                "2 2 1 13 4\n" +
                "1 1 1 18\n" +
                "2 0 6 15 14\n" +
                "2 1 5 12 11\n" +
                "1 1 2 19\n" +
                "2 1 1 26 22\n" +
                "3 3 2 24 19 20\n" +
                "2 1 10 16 12\n" +
                "3 0 3 5 6 6\n" +
                "2 0 2 2 5\n" +
                "1 0 8 0\n" +
                "1 0 7 18\n" +
                "2 2 3 18 18\n" +
                "3 1 9 24 23 24\n" +
                "2 0 1 0 0\n" +
                "1 1 0 18\n" +
                "2 1 8 20 20\n" +
                "3 3 4 23 14 12\n" +
                "1 1 7 9\n" +
                "1 1 6 6\n" +
                "2 2 6 8 5\n";

        System.out.println(executeTestCase(input));

        

    }

    private static String executeTestCase(String input) {

        String strOutput = "";
        BufferedReader in = new BufferedReader(new StringReader(input));
        int testCases = 0;
        try {
            testCases = Integer.valueOf(in.readLine());
        } catch (IOException e) {
            return "Invalid test case input at line 1";
        }

        try {
            if (testCases > 0) {
                for (int i = 1; i <= testCases; i++) {
                    String lines[] = in.readLine().split(" ");
                    int numberOfGooglers = Integer.valueOf(lines[0]);
                    int numberOfSurprising = Integer.valueOf(lines[1]);
                    int target = Integer.valueOf(lines[2]);
                    List<Integer> lst = new ArrayList<Integer>();
                    if(numberOfGooglers > 0) {
                        for(int j=0; j< numberOfGooglers; j++) {
                            lst.add(Integer.valueOf(lines[j+3]));
                        }
                    }
                    strOutput+="Case #" + i + ": " + countGooglersByTarget(target, numberOfSurprising, lst) + "\n";
                }
            }
        } catch (Exception e) {
            return "Invalid test case input";
        }

        return strOutput.toString();

    }

}
