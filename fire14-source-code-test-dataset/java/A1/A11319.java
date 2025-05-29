
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author Anuj
 */
public class DanceWithGoogle {

    int cases;
    String temp[];
    int magic, judges, surp;
    int num;

    public DanceWithGoogle() {
        cases = 0;
        magic = 2;
        judges = 3;
        surp =0;
    }

    public void go() {
        try {
            int z;
            BufferedReader br = new BufferedReader(new FileReader("B-small-attempt2.in"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("out.txt"));

            cases = Integer.parseInt(br.readLine());
//            System.out.println("Case : " + cases);

            for (z = 0; z < cases; z++) {

                int i, j;
                temp = br.readLine().split(" ");


                int players = Integer.parseInt(temp[0]);
                surp = Integer.parseInt(temp[1]);
                int thresh = Integer.parseInt(temp[2]);
                int count = 0;
//                System.out.println("Case : " + n);
                //m = Integer.parseInt(temp[1]);
                //System.out.println("Case : " + (z+1) + "thres : "+thresh);

                for (i = 0; i < players; i++) {

                    int score = Integer.parseInt(temp[i + 3]);
                    if (check(score, thresh)) {
                        count++;
                    }
                }

                //System.out.println("Case #" + (z + 1) + ": " + count);
                bw.write("Case #" + (z + 1) + ": " + count);
                bw.newLine();
            }

            br.close();
            bw.close();
        } catch (java.io.FileNotFoundException e) {
        } catch (java.io.IOException e) {
        }
    }

    private boolean check(int sc, int th) {

        int non = 0;
        int sur = 0;
        if (sc != 0) {
            non = (sc + 2) / 3;
            sur = (sc + 4) / 3;
        }
        if (non >= th) {
            return true;
        } else if (surp > 0) {

            if (sur >= th) {
                //System.out.println("surp:" + sur + "su:" + surp + " for sc:" + sc + "thres:" + th);
                surp--;
                return true;
            }
            return false;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        DanceWithGoogle codeJam = new DanceWithGoogle();
        codeJam.go();
    }
}
