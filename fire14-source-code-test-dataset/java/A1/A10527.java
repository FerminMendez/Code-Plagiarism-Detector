
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStream;
import java.io.PrintStream;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author bgamlath
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        BufferedReader in = new BufferedReader(new FileReader("input.txt"));
        PrintStream out = new PrintStream("output.txt");
        int n = Integer.parseInt(in.readLine());
        for(int i = 1; i<=n; i++){
            out.println("Case #" + i + ": " + getRes(in.readLine()));
        }
    }
    static int getRes(String str){
        String[] m = str.split(" ");
        int n = Integer.parseInt(m[0]);
        int s = Integer.parseInt(m[1]);
        int p = Integer.parseInt(m[2]);
        int max  = 0; 
        int usedS = 0;
        for(int i = 0; i<n; i++){
            int t = Integer.parseInt(m[3+i]);
            if(NotSurprising(t, p))
                max++;
            else if(usedS < s && Surprising(t, p)){
                usedS++;
                max++;
            }
        }
        return max;
    }

    static boolean NotSurprising(int tot, int p) {
        int k = (tot % 3 == 0) ? tot / 3 : tot / 3 + 1;
        return k>=p;
    }
    static boolean Surprising(int tot, int p){
        if(tot==0)
            return tot>=p;
        int k = (tot % 3 == 2) ? tot/3 + 2 : tot/3 + 1;
        return k>=p;
    }
}
