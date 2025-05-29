import java.io.*;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: Veniversum
 * Date: 4/15/12
 * Time: 1:37 AM
 */
public class Q2 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("in.txt")));
            int cases = Integer.parseInt(br.readLine());
            int out[] = new int[cases];
            for (int i = 0; i < cases; i++) {
                Scanner sc = new Scanner(br.readLine());
                int contestants = sc.nextInt();
                int surprise = sc.nextInt();
                int min = sc.nextInt();
                int max = 0;
                for (int j =0; j<contestants; j++){
                    int score = sc.nextInt();
                    if (score-min < 2*(min-1)){
                        //not more than min
                        if (surprise > 0 && score >= (3*min-4) && score != 0){
                            //use surprise
                            surprise--;
                            max++;
                        }
                    } else {
                        max++;
                    }
                }
                out[i] = max;
            }
            PrintWriter outp = new PrintWriter(new FileOutputStream("out.txt"));
            for (int i = 0; i<cases; i++){
                System.out.print("Case #" + (i+1) + ": " + out[i] + "\n");
                outp.print("Case #" + (i+1) + ": " + out[i] + "\n");
            }
            outp.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
