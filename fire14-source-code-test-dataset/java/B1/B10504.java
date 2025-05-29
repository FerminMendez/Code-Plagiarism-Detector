import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(new FileReader("in.txt"));
            PrintWriter out = new PrintWriter(new FileWriter("out.txt"), true);

            int N = in.nextInt();
            for (int I = 1; I <= N; I++) {
                int a = in.nextInt();
                int b = in.nextInt();
                int count = 0;
                for (int i = a; i < b; i++) {
                    char m[] = (i + "").toCharArray();
                    //out.println("m: "+ Arrays.toString(m));
                    char[] mm = m.clone();
                    Arrays.sort(mm);
                    for (int j = i + 1; j <= b; j++) {
                        char n[] = (j + "").toCharArray();
                        char[] nn = n.clone();
                        Arrays.sort(nn);

                        if (Arrays.equals(nn, mm)) {
                            for(int k = 1; k < n.length; k++){
                                String s = new String(Arrays.copyOfRange(n.clone(), k, n.length));
                                s += new String(Arrays.copyOf(n.clone(), k));
                                if(s.equals(new String(m))){
                                    count++;
                                    break;
                                }
                            }
                        }

                        //out.println("n: "+ Arrays.toString(n));
                        /*int index = 0;
                        for (int k = n.length - 1; k >= index; k--) {
                            if (m[index] == n[k]) {
                                char c = n[k];
                                for(int kk = k; kk > index; kk--){
                                    n[kk] = n[kk - 1];
                                }
                                n[index] = c;
                                index++;
                            }
                        }
                        if (index == n.length - 1) {
                            count++;
                            out.println("m: "+ Arrays.toString(m));
                            out.println("n: "+ Arrays.toString(n));
                        }      */
                    }
                }
                out.println("Case #" + I + ": " + count);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}