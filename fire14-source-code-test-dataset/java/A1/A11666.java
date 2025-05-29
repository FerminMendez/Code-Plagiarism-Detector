/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dancinggooglers;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 *
 * @author Alfred
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    try {
            FileInputStream fstream = new FileInputStream("B-small-attempt3.in");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            FileWriter outFile = new FileWriter("out.txt");
            PrintWriter out = new PrintWriter(outFile);
            String line;
            HashMap<Integer,Integer[]> map = new HashMap<Integer,Integer[]>();
            map.put(0, new Integer[] {0, 0, 0});
            map.put(1, new Integer[] {1, 0, 0});
            map.put(2, new Integer[] {1, 1, 0});
            map.put(3, new Integer[] {1, 1, 1});
            map.put(4, new Integer[] {2, 1, 1});
            map.put(5, new Integer[] {2, 2, 1});
            map.put(6, new Integer[] {2, 2, 2});
            map.put(7, new Integer[] {3, 2, 2});
            map.put(8, new Integer[] {3, 3, 2});
            map.put(9, new Integer[] {3, 3, 3});
            map.put(10, new Integer[] {4, 3, 3});
            map.put(11, new Integer[] {4, 4, 3});
            map.put(12, new Integer[] {4, 4, 4});
            map.put(13, new Integer[] {5, 4, 4});
            map.put(14, new Integer[] {5, 5, 4});
            map.put(15, new Integer[] {5, 5, 5});
            map.put(16, new Integer[] {6, 5, 5});
            map.put(17, new Integer[] {6, 6, 5});
            map.put(18, new Integer[] {6, 6, 6});
            map.put(19, new Integer[] {7, 6, 6});
            map.put(20, new Integer[] {7, 7, 6});
            map.put(21, new Integer[] {7, 7, 7});
            map.put(22, new Integer[] {8, 7, 7});
            map.put(23, new Integer[] {8, 8, 7});
            map.put(24, new Integer[] {8, 8, 8});
            map.put(25, new Integer[] {9, 8, 8});
            map.put(26, new Integer[] {9, 9, 8});
            map.put(27, new Integer[] {9, 9, 9});
            map.put(28, new Integer[] {10, 9, 9});
            map.put(29, new Integer[] {10, 10, 9});
            map.put(30, new Integer[] {10, 10, 10});
            line = br.readLine();
            int cases = Integer.parseInt(line);
            for (int i=1; i<=cases;i++){
                line = br.readLine();
                String[] values = line.split(" ");
                int N = Integer.parseInt(values[0]);
                int S = Integer.parseInt(values[1]);
                int p = Integer.parseInt(values[2]);
                Integer[] scores = new Integer[N];
                for (int j = 0; j< N; j++){
                    scores[j] = Integer.parseInt(values[3+j]);
                }
                Arrays.sort(scores, Collections.reverseOrder());
                int total=0;
                for (int j = 0; j< N; j++){
                    Integer[] triplet = map.get(scores[j]).clone();
                    if(triplet[0]>=p){
                        total++;
                    }
                    else{
                        if (S > 0){
                            if(surprising(triplet,scores[j])){
                                if(triplet[0]>=p){
                                    S--;
                                    total++;
                                }
                            }
                        }
                    }
                }
                out.println("Case #"+i+": "+total);
                
            }
            in.close();
            out.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static boolean surprising(Integer[] triplet, int score) {
        if(score < 2 || score> 27)
            return false;
        else{
            if(triplet[0]==triplet[1]){
                triplet[0]++;
                triplet[1]--;
                Arrays.sort(triplet,Collections.reverseOrder());
                return true;
            }
            else{
                triplet[1]++;
                triplet[2]--;
                Arrays.sort(triplet,Collections.reverseOrder());
                return true;
            }
        }
    }

}