
package problems;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author sergeiw
 */
public class B {

    public static String FILE_SEPARATOR = System.getProperty("file.separator");
    public static String FILE_INPUT_DIR = System.getProperty("user.dir") + FILE_SEPARATOR + "files" + FILE_SEPARATOR;
    public static String FILE_OUTPUT_DIR = System.getProperty("user.dir") + FILE_SEPARATOR + "files" + FILE_SEPARATOR;

    public static void main(String[] args) throws FileNotFoundException, IOException {
        //String filename = "B-example.in";
        //String filename = "B-small-attempt0.in";
        //String filename = "B-small-attempt1.in";
        //String filename = "B-small-attempt2.in";
        //String filename = "B-small-attempt3.in";
        //String filename = "B-small-attempt4.in";
        //String filename = "B-small-attempt5.in";
        String filename = "B-small-attempt6.in";
        //String filename = "B-large.in";
        File fileOut = new File(FILE_INPUT_DIR + filename.replace(".in", ".out"));
        FileWriter fw = new FileWriter(fileOut);
        File file = new File(FILE_INPUT_DIR + filename);
        Scanner scanner = new Scanner(file);
        try {
            int cases = scanner.nextInt();
            scanner.nextLine();
            int casenum = 1;
            

            while (scanner.hasNextLine()) {

                int solution = 0;
                
                
                int N = scanner.nextInt();
                int S = scanner.nextInt();
                int p = scanner.nextInt();
                
                int minScore = (p * 3) - 4;
                if (minScore < 0)
                    minScore = p;
                
                for (int i = 0; i < N; i++) {
                    int score = scanner.nextInt();
                    
                    for (int q = p; q >= 0; q--) {
                        if (score > q*3) {
                            solution++;
                            print(String.format("%d %d %d +", q, q, q ));
                            break;
                        }
                        if (score >= ((q*3-2)) && score <= (q*3)) {
                            if (q >= p)
                                solution++;                                                                
                            
                            if (score == (q*3)-1) 
                                print(String.format("%d %d %d", q, q, q-1 ));
                            else if (score == (q*3)-2) 
                                print(String.format("%d %d %d", q, q-1, q-1 ));
                            else
                                print(String.format("%d %d %d", q, q, q ));
                            break;
                        }
                        if ( score == ((q*3)-4) || score == ((q*3)-3) ) {
                            print(String.format("score: %d q: %d", score, q));                            
                            if (S-1 >= 0 && q >= p && q > 1) {                                
                                S--;
                                if (score == (q*3)-4) 
                                    print(String.format("%d %d %d (*)", q, q-2, q-2 ));
                                else 
                                    print(String.format("%d %d %d (*)", q, q-1, q-2 ));
                                solution++;
                                break;
                            }
                            
                            
                        }                     
                    }
                    print(String.format("score: %d, min: %d, sol: %d, S: %d", score, p, solution, S));    
                    
                    /*if (score >= minScore) {
                        if (score == 0 && minScore == 0) {
                            solution++;
                        } else {
                            if ((score == minScore || score == (minScore + 1))) {
                                print(String.format("s: %d min: %d", score, minScore));                            
                                S--;
                                if (S >= 0) {                                
                                    solution++;
                                }

                            } else {
                                solution++;
                            }
                        }
                    } else {
                        //print("LOWER");                        
                        for (int q = p - 1; q >= 2; q--) {
                            if ( score == ((q*3)-4) || score == ((q*3)-3) ) {
                                S--;
                                print(String.format("LOWER: S: %d", S));                                
                                break;
                                * 
                            }                            
                        }
                        
                    }                    
                    print(String.format("score: %d, min: %d, sol: %d, S: %d", score, minScore, solution, S));    
                    */
                    
                }
                //if (S < 0) solution = 0;
                
                print(String.format("Case #%d: [%s]", casenum, solution));
                fw.write(String.format("Case #%d: %s\n", casenum, solution));
                casenum++;
                print("");

            }
        } finally {
            scanner.close();
            fw.close();
        }

    }

    private static void print(String line) { System.out.println(line); };
    private static void print(int num) { print(String.valueOf(num)); };

    private static void print(int[] arr) {
        for(int i=0;i<arr.length;i++)
            System.out.print(String.valueOf(arr[i])+" ");
        System.out.println();
    };
    private static void print(String[] arr) {
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    };

}
