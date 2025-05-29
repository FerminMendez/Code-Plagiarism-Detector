
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ale
 */
public class RecycledNumbers {
    public static int[][] parseInput(String path) throws FileNotFoundException, IOException{
        BufferedReader reader = new BufferedReader(new FileReader(path));
        int size = Integer.parseInt(reader.readLine());
        int[][] result = new int[size][2];
        for (int i = 0; i < size; i++){
            String[] nums = reader.readLine().split(" ");
            result[i][0] = Integer.parseInt(nums[0]);
            result[i][1] = Integer.parseInt(nums[1]);
        }
        return result;
    }

// somebody has to explain me why it doesn't work
//    public static int solveInstance(int N, int M){
//        boolean[] done = new boolean[M+1];
//        int total = 0;
//        int D = (""+N).length() -1;
//        int divisor = (int) Math.round(Math.pow(10, D));
//        for (int i = 0; i < N; i++){
//            done[i] = true;
//        }
//        for (int i = N; i <= M; i++){
//            done[i] = false;
//        }
//        for (int i = N; i <= M; i++){
//            if (!done[i]){
//                done[i] = true;
//                int rotation = i;
//                int accepted = 1;
//                for (int j = 0; j < D; j++){
//                    int msd = rotation/divisor;
//                    rotation = (rotation - divisor*msd)*10 + msd;
//                    if (N <= rotation && rotation <= M && !done[rotation]){
////                        if (accepted == 1){System.out.print("\n@@@@@@@@@@\n"+i + " ");}
////                        System.out.print(rotation+" ");
//                        done[rotation] = true;
//                        accepted ++;
//                    }
//
//                }
//                total += accepted*(accepted-1)/2;
//            }
//        }
//        return total;
//    }

    // somebody has to explain me why it doesn't work
    public static int solveInstance(int N, int M){
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        int total = 0;
        int D = (""+N).length() -1;
        int divisor = (int) Math.round(Math.pow(10, D));

        for (int i = N; i <= M; i++){
            int rotation = i;
            int minimum = i;
            for (int j = 0; j < D; j++){
                int msd = rotation/divisor;
                rotation = (rotation - divisor*msd)*10 + msd;
                if (rotation < minimum){
//                        if (accepted == 1){System.out.print("\n@@@@@@@@@@\n"+i + " ");}
//                        System.out.print(rotation+" ");

                    minimum = rotation;
                }
            }
            Integer previous = map.put(minimum, 1);
            if (previous != null){
                map.put(minimum, (previous + 1));
            }
        }
        for (Integer i : map.values()){
            total += (i*(i-1))/2;
        }
        return total;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException{
        String dir = "C:/Users/ale/Desktop/GoogleCodeJam/";
        String[] files = new File(dir).list();
        int[][] instances = parseInput(dir+files[0]);
        //parseInput("C:/Users/ale/Desktop/GoogleCodeJam/C-small-attempt0.in");
        PrintStream writer = new PrintStream(new File("C:/Users/ale/workspace/GoogleCodeJam/src/output.out"));


        for (int i = 0; i < instances.length; i++){
            int sol = solveInstance(instances[i][0], instances[i][1]);
            writer.println("Case #"+(i+1)+": "+sol);
        }
        writer.close();
    }

}
