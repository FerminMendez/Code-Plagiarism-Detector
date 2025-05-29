/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dancinggooglers;

import java.io.*;

/**
 *
 * @author Ruben
 */
public class DancingGooglers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            if (args.length >= 2) {
                new dance(args[0], args[1]);
            }
        } catch (Exception e) {
            System.out.println("error!\n" + e);
        }
    }

    private static class dance {

        public dance(String input, String output) throws Exception {
            execute(input, output);
        }

        private void execute(String input, String output) throws Exception {
            File inputfile = new File(input);
            File outputfile = new File(output);
            FileReader fr = new FileReader(inputfile);
            BufferedReader reader = new BufferedReader(fr);
            FileWriter fw = new FileWriter(outputfile);
            BufferedWriter bw = new BufferedWriter(fw);
            int lines = Integer.parseInt(reader.readLine());
            for (int i = 0; i < lines; i++) {
                bw.write("Case #" + (i + 1) + ": " + calculate(reader.readLine()));
                bw.newLine();
            }
            bw.close();
            fw.close();
            fr.close();
        }

        private String calculate(String line) {
            String[] split = line.split(" ");
            int[] scores = new int[split.length - 3];
            for (int i = 0; i < scores.length; i++) {
                scores[i] = Integer.parseInt(split[i + 3]);
            }
            return calculate(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), scores);
        }

        private String calculate(int n, int s, int p, int[] scores) {
            int max = 0, remaining_surprises = s;
            insertion_sort(scores);//just to be sure it is sorted
            for (int i = 0; i < scores.length; i++) {
                if (scores[i] >= 2) {
                    if ((scores[i] + 2) / 3 >= p) {
                        max++;
                    } else if (remaining_surprises > 0 && (scores[i] + 4) / 3 >= p) {
                        max++;
                        remaining_surprises--;
                    }
                } else if (scores[i] == 1) {
                    if(p<=1)
                        max++;
                } else { //score = 0
                    if(p==0)
                        max++;
                }
            }
            return "" + max;
        }

        private static void insertion_sort(int array[]) {
            for (int i = 1; i < array.length; i++) {
                int j = i;
                int B = array[i];
                while ((j > 0) && (array[j - 1] > B)) {
                    array[j] = array[j - 1];
                    j--;
                }
                array[j] = B;
            }
        }
    }
}
