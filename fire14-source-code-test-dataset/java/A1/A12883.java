package lk.iit.wall.framework.network;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Amila
 * Date: 4/13/12
 * Time: 10:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class CodeJamOne {

    public static void main(String[] args) {
        File file = new File("D:\\small.txt");
        try {
            //
            // Create a new Scanner object which will read the data
            // from the file passed in. To check if there are more
            // line to read from it we check by calling the
            // scanner.hasNextLine() method. We then read line one
            // by one till all line is read.
            //
            Scanner scanner = new Scanner(file);
            int cases = scanner.nextInt();
            for (int i = 0; i < cases; i++) {
                int googlers = scanner.nextInt();
                int supprise = scanner.nextInt();
                int max = scanner.nextInt();
                int numGoog = 0;
                int[] nums = new int[googlers];
                for (int j = 0; j < googlers; j++) {
                    int score = scanner.nextInt();
                    nums[j] = score;
                }
                Arrays.sort(nums);
                for (int j = googlers - 1; j >= 0; j--) {
                    int score = nums[j];
                    double d = score / 3f;
                    int div = (int) Math.ceil(d);
                    int mod = score % 3;
                    if (div >= max) {
                        numGoog++;
                        continue;
                    }
                    /*if (mod == 2) {
                        if (div + 2 >= max && supprise != 0 && score > 1 && score < 29) {
                            numGoog++;
                            supprise--;
                            continue;
                        }
                    } else */if(mod==0 || mod == 2){
                        if (div + 1 >= max && supprise != 0 && score > 1 && score < 29) {
                            numGoog++;
                            supprise--;
                            continue;
                        }
                    }
                }
                System.out.println("Case #" + (i + 1) + ": " + numGoog);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
