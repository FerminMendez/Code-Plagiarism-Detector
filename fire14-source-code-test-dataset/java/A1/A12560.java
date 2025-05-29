
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author UDDAMA
 */
public class Dance {

    private int danceManager(String inputLine) {

        int count = 0;

        String[] info = inputLine.split(" ");
        int players = Integer.parseInt(info[0]);
        int suprise = Integer.parseInt(info[1]);
        int p = Integer.parseInt(info[2]);

        for (int i = 3; i < info.length; i++) {

            int thisscore = Integer.parseInt(info[i]);
            int tobe = info.length - i;

            if (tobe > suprise) {

                if (hasacount(withoutsuprise(thisscore), p)) {
                    count++;
                } else if (hasacount(withsuprise(thisscore), p) && thisscore > 1 && thisscore < 29 && suprise > 0) {
                    count++;
                    suprise--;
                }

            } else if (tobe <= suprise) {

                if (hasacount(withsuprise(thisscore), p) && thisscore > 1 && thisscore < 29 && suprise > 0) {
                    count++;
                    suprise--;
                }

            }


        }

        return count;
    }

    private boolean hasacount(int[] inputset, int pval) {

        for (int j = 0; j < inputset.length; j++) {
            if (inputset[j] >= pval) {
                return true;
            }
        }
        return false;
    }

    private int[] withsuprise(int input) {
        int[] out = new int[3];
        int n = input / 3;

        if (input % 3 == 0) {
            out[0] = n - 1;
            out[0] = n;
            out[0] = n + 1;
        } else if (input % 3 == 1) {
            out[0] = n - 1;
            out[0] = n + 1;
            out[0] = n + 1;
        } else if (input % 3 == 2) {
            out[0] = n;
            out[0] = n;
            out[0] = n + 2;
        }
        return out;
    }

    private int[] withoutsuprise(int input) {

        int[] out = new int[3];
        int n = input / 3;

        if (input % 3 == 0) {
            out[0] = n;
            out[0] = n;
            out[0] = n;
        } else if (input % 3 == 1) {
            out[0] = n;
            out[0] = n;
            out[0] = n + 1;
        } else if (input % 3 == 2) {
            out[0] = n;
            out[0] = n + 1;
            out[0] = n + 1;
        }
        return out;
    }

    public static void main(String[] args) throws IOException {


        BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = is.readLine();
        Dance d = new Dance();

        int cases = Integer.parseInt(inputLine);

        for (int i = 0; i < cases; i++) {

            inputLine = is.readLine();
            System.out.println("Case #" + (i + 1) + ": " + d.danceManager(inputLine));


        }

    }
}
