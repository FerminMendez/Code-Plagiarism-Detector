import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SolutionDance {
    static DataInputStream in = new DataInputStream(new BufferedInputStream(System.in));
    static BufferedReader din = new BufferedReader( new InputStreamReader(in));
    public static void main(String args[]){
        int t = parseInt(getLine());
        String[] g = new String[t];
        int n, s, p; int [] part; String out = "Case #";

        for(int i = 0;i<t;i++){
            g[i] = getLine();
        }
        for(int i = 0;i<t;i++){
            int count = 0;  out = "Case #";
            String[] spl =  g[i].split(" ");
            n =  parseInt(spl[0]);
            s =  parseInt(spl[1]);
            p =  parseInt(spl[2]);
            part = getPart(spl, n, p);
            for(int q = 0;q<n;q++){
                if(part[q]>=0){
                    if(2*p-part[q] <=2){
                        count++;
                    }else{
                        if(2*p-part[q] <=4){
                            if(s>0){
                                s--;
                                count++;
                            }
                        }
                    }
                }
            }
            out = out+(i+1)+": " +count;
            soutln(out);
        }
    }

    private static int[] getPart(String[] spl, int n, int p) {
        int [] part = new int [n];
        for(int i = 0;i<n;i++){
            part[i] =  parseInt(spl[i+3]) - p;
        }
        return part;
    }


    public static String getLine(){
        String input = "";
        try {
            input = din.readLine();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return input;
    }

    public static int parseInt(String s){
        return Integer.parseInt(s);
    }
    
    public static void sout(Object n){
        System.out.print(n);
    }
    public static void soutln(Object n){
        System.out.println(n);
    }
}

