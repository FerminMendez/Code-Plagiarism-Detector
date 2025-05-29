
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author aliakbars
 */
public class Googlers {

    public static void main(String[] args) {
        Googlers gr = new Googlers();
        FileInputStream fstream = null;
        FileWriter fwrite;
        int jml;
        int s;
        int p;
        int okay;
        try {
            fstream = new FileInputStream("B-small-attempt7.in");
            fwrite = new FileWriter("B-small-attempt7.out");
            BufferedWriter ofile = new BufferedWriter(fwrite);
            DataInputStream ifile = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(ifile));
            String num = br.readLine();
            for (int i = 0; i < Integer.parseInt(num); i++) {
                String[] input = br.readLine().split(" ");
                jml = Integer.parseInt(input[0]);
                s = Integer.parseInt(input[1]);
                p = Integer.parseInt(input[2]);
                okay = 0;
                for (int j = 0; j < jml; j++) {
                    int x = Integer.parseInt(input[3+j]);
                    if (x / 3 >= p) {
                        okay++;
                    } else {
                        if (x / 3 + 1 >= p && x != 0) {
                            if (x - (x / 3) * 3 + (x / 3) >= p) {
                                okay++;
                            } else {
                                if (s > 0) {
                                    okay++;
                                    s--;
                                }
                            }
                        } else if (x / 3 + 2 >= p && x != 0) {
                            if ((x / 3) * 3 + 2 == x) {
                                if (s > 0) {
                                    okay++;
                                    s--;
                                }
                            }
                        }
                    }
                }
                try {
                    ofile.write("Case #" + (i + 1) + ": " + okay);
                    ofile.newLine();
                } catch (Exception e) {
                    System.err.println("Error: " + e.getMessage());
                }
                System.out.println("Case #" + (i + 1) + ": " + okay);
            }
            ofile.close();
        } catch (IOException ex) {
            Logger.getLogger(Googlerese.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fstream.close();
            } catch (IOException ex) {
                Logger.getLogger(Tutorial.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
