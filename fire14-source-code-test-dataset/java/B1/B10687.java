import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: Abhishek
 * Date: 4/14/12
 * Time: 1:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class RecNum {
    public int recycled(String a, String b){
        int a1 = Integer.parseInt(a);
        int b1 = Integer.parseInt(b);
        int num = a1;
        int count=0;
        while(num<=b1){
            String x = String.valueOf(num);
            ArrayList<String> store = new ArrayList<String>(10);
            for(int i=1; i<x.length(); i++){
                String y = x.substring(x.length()-i, x.length())+x.substring(0, x.length()-i);

                int k = Integer.parseInt(y);
                if(k<=b1 && k>num && !store.contains(y)){
                    count++;
                    store.add(y);
                }
            }
            num++;

        }
        return count;
    }
    public static void main(String[] args) {
        RecNum spk = new RecNum();
        try {
            BufferedReader buff = new BufferedReader(new FileReader("C-small-attempt0.in"));
            FileWriter fstream = new FileWriter("out1.txt");
            BufferedWriter out = new BufferedWriter(fstream);
            int numTest = Integer.parseInt(buff.readLine());
            if (numTest < 1 || numTest > 50)
                System.exit(0);

            for (int k = 0; k < numTest; k++) {
                String[] inp = buff.readLine().split(" ");

                out.write("Case #" + (k + 1) + ": " + spk.recycled(inp[0],inp[1]));
                out.write("\n");
//                System.out.println("Case #" + (k + 1) + ": " + spk.recycled(inp[0],inp[1])+"\n");


            }
            out.close();

        } catch (Exception e) {
            System.out.println("Exception" + e);
        }
    }
}
