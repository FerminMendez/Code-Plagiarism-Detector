/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g.jam_3;

import java.io.*;
import java.util.ArrayList;

//<editor-fold defaultstate="collapsed" desc="files">

/**
 *
 * @author toshiba
 */
public class Gjam_3 {

    static String input = "c:\\Gjam\\3\\small.in";
    static String output = "c:\\Gjam\\3\\output.out";

    public static void main(String[] args) throws FileNotFoundException, IOException {
        output o = new output(output);
        ArrayList<String> input_arr = new input().ReadInput(input);
        for (int j = 0; j < input_arr.size(); j++) {
            String[] t = input_arr.get(j).split(" ");
            int a = Integer.parseInt(t[0]);
            int b = Integer.parseInt(t[1]);
            int result = 0;
            for (int n = a; n <= b; n++) {
                String tmp = String.valueOf(n);
                for (int k = tmp.length()-1; k > 0; k--) {
                    tmp = String.valueOf(n).substring(k, String.valueOf(n).length()) +String.valueOf(n).substring(0, k);
                    int m = Integer.parseInt(tmp);
                    if(m==1111)
                        System.out.print(m);
                    if(m>n&&m<=b&&m!=n)
                        result++;
                }
            }
            o.write("Case #" + (j+1) + ": " + result + "\n");
        }
        o.close();
    }
}
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
