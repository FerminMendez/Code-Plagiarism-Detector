import java.io.*;
import java.util.*;

class q2 {
    public static void main(String args[]) {
        Scanner obj = new Scanner(System.in);
        int T = obj.nextInt();
        try {
            FileOutputStream out = new FileOutputStream("myfile.txt");
            PrintStream p = new PrintStream(out);

            for (int i = 0; i < T; i++) {
                int N = obj.nextInt();
                int S = obj.nextInt();
                int pp = obj.nextInt();
                int count2 = 0;
                int count4 = 0;
                for (int j = 0; j < N; j++) {
                    int num = obj.nextInt();
                    
                    if (num >= (3 * pp - 2)) {
                        count2++;}
                    else if(num ==0){
                        count2=count2;
                    } else if (num >= (3 * pp - 4)) {
                        count4++;
                    }
                }
                System.out.println(count4);
                if (count4 > S) {
                    count2 = count2 + S;
                } else {
                    count2 = count2 + count4;
                }
                p.print("Case #" + (i+1) + ": " + count2);
                p.println();
            }
            p.close();
        } catch (Exception e) {
            System.err.println("Error writing to file");
        }
    }
}