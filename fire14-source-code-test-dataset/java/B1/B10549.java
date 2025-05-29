
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashSet;

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
        Integer.parseInt("00001");
        BufferedReader in = new BufferedReader(new FileReader("input.txt"));
        PrintStream out = new PrintStream("output.txt");
        int n = Integer.parseInt(in.readLine());
        for(int i = 1; i<=n; i++){
            out.println("Case #" + i + ": " + getRes(in.readLine()));
        }
    }
    static int getRes(String str){
        String[] m = str.split(" ");
        int a = Integer.parseInt(m[0]);
        int b = Integer.parseInt(m[1]);
        int res = 0;
        for(int i = a; i<=b; i++){
            res += count(i, b);
        }
        return res;
    }

    static int count(int i, int b){
        HashSet<Integer> k = new HashSet<Integer>();
        String s = i + "";
        int len = s.length();
        int t = i;
        for(int  j = 1; j< len; j++){
            k.add(Integer.parseInt((s.substring(j) + s.substring(0,j))));
        }
        int res = 0;
        for(int j: k){
            if((j+"").length()==len && j>i && j<=b)
                res++;
        }
        return res;
        
    }
}
