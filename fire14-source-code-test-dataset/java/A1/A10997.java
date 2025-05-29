
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class Dancing {
    
    static int[][] bestScores = {
            {0, 0},
            {1, 1},
            {1, 2},
            {1, 2},
            {2, 2},
            {2, 3},
            {2, 3},
            {3, 3},
            {3, 4},
            {3, 4},
            {4, 4},
            {4, 5},
            {4, 5},
            {5, 5},
            {5, 6},
            {5, 6},
            {6, 6},
            {6, 7},
            {6, 7},
            {7, 7},
            {7, 8},
            {7, 8},
            {8, 8},
            {8, 9},
            {8, 9},
            {9, 9},
            {9, 10},
            {9, 10},
            {10, 10},
            {10, 10},
            {10, 10}
        };
    
    public static void main(String[] args) throws IOException {
        //createMatrix();
        
        String inFileName = "B-small-attempt0.in";
        Scanner in = new Scanner(new File(inFileName));
        String outFileName = inFileName.substring(0, inFileName.lastIndexOf('.')) + ".out";
        PrintWriter out = new PrintWriter(outFileName);
        int numSets = in.nextInt();
        in.nextLine();
        for(int probSet = 1; probSet <= numSets; probSet++) {
            int numDancers = in.nextInt();
            int surp = in.nextInt();
            int minScore = in.nextInt();
            ArrayList<Integer> scores = new ArrayList<Integer>();
            for(int i = 0; i < numDancers; i++) {
                int score = in.nextInt();
                if(bestScores[score][1] < minScore) continue;
                scores.add(score);
            }
            int answer = recurse(scores, 0, 0, minScore, surp);
            out.println("Case #" + probSet + ": " + answer);
        }
        in.close();
        out.close();
    }
    
    public static int recurse(ArrayList<Integer> scores, int index, int soFar, 
            int minScore, int surp) {
        if(index == scores.size()) return soFar;
        int isSurp = 0;
        if(surp > 0) isSurp = recurse(scores, index + 1, soFar + 1, minScore, surp - 1);
        int notSurp = 0;
        if(scores.size() > surp) {
            int score = scores.get(index);
            int bestScore = bestScores[score][0]; //highest possible number in unsurprising score
            int newSoFar = bestScore >= minScore ? soFar + 1 : soFar;
            notSurp = recurse(scores, index + 1, newSoFar, minScore, surp);
        }
        return Math.max(isSurp, notSurp);
    }
    
    public static void createMatrix() {
        int[][] grid = new int[31][2];
        for(int i = 0; i <= 30; i++) {
            grid[i][0] = (i + 2) / 3;
            for(int j = 10; j >= 0; j--) {
                int temp = i - j;
                if(j - 2 > 0) temp -= 2 * (j - 2);
                if(temp >= 0) {
                    grid[i][1] = j;
                    break;
                }
            }
        }
        
        //print out grid to hard code
        System.out.println("int[][] bestScores = {");
        for(int i = 0; i < grid.length; i++) {
            System.out.print("    {" + grid[i][0] + ", " + grid[i][1] + "}");
            if(i != grid.length - 1) System.out.print(",");
            System.out.println();
        }
        System.out.println("};");
    }
}
