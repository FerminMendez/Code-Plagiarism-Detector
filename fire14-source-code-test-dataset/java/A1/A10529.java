/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g.jam_2;

import java.io.*;
import java.util.ArrayList;


public class Gjam_2 {

    static String input = "c:\\Gjam\\2\\small.in";
    static String output = "c:\\Gjam\\2\\output.out";

    public static void main(String[] args) throws FileNotFoundException, IOException {
        output o = new output(output);
        ArrayList<String> input_arr = new input().ReadInput(input);
        for (int j = 0; j < input_arr.size(); j++) {
            String[] t = input_arr.get(j).split(" ");
            int s = Integer.parseInt(t[1]);
            int max = Integer.parseInt(t[2]);
            int result = 0;
            for (int i = 3; i < t.length; i++) {
                int x = Integer.parseInt(t[i]);
                int y = x / 3;
                int z = x % 3;
                if (y >= 0) {
                    if (z == 0) {
                        if (y >= max) {
                            result++;
                        } else if (y + 1 >= max && s > 0) {
                            result++;
                            s--;
                        }
                    } else if (z == 1) {
                        if (y + 1 >= max) {
                            result++;
                        } else if (y + 2 >= max && s > 0) {
                            result++;
                            s--;
                        }
                    } else if (z == 2) {
                        if (y + 1 >= max) {
                            result++;
                        } else if (y + 2 >= max && s > 0) {
                            result++;
                            s--;
                        }
                    }
                }
            }
            o.write("Case #" + (j+1) + ": " + result + "\n");
        }
        o.close();
    }
}

//<editor-fold defaultstate="collapsed" desc="files">
class input {
    
    public ArrayList<String> ReadInput(String input) throws FileNotFoundException, IOException {
        ArrayList a = new ArrayList();
        BufferedReader str = new BufferedReader(new InputStreamReader(new FileInputStream(input)));
        String s = "";
        str.readLine();
        int x = 0;
        while ((s = str.readLine()) != null) {
            x++;
            a.add(s);
        }
        return a;
    }
}
//<editor-fold defaultstate="collapsed" desc="output">
class output {
    
    FileWriter fstream;
    BufferedWriter bw;
    
    public output(String output) throws IOException {
        fstream = new FileWriter(output);
        bw = new BufferedWriter(fstream);
    }
    
    public void write(String result) throws IOException {
        bw.write(result);
    }
    
    public void close() throws IOException {
        bw.close();
    }
}
//</editor-fold>
//</editor-fold>
